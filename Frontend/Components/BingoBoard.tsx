import { Box, Typography, Grid, Stack, Modal, Button } from "@mui/material";
import { FC, useState, useEffect } from "react";
import styles from "../styles/BingoBoard.module.scss";
import ClearMark from "../public/img/Clear.png";
import Image from "next/image";

interface IBingoList {
  bingoList: Array<string>;
}

const style = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "#e9e1d3",
  // border: "2px solid #000",
  borderRadius: 2,
  // boxShadow: 24,
  p: 2,
};

const BingoBoard: FC<IBingoList> = ({ bingoList }) => {
  // 모달
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <>
      <Box className={styles.bingo_box} onClick={handleOpen}>
        {bingoList.done === true ? (
          <Image
            src={ClearMark}
            alt="Bingo Board"
            height="100%"
            width="100%"
          ></Image>
        ) : null}

        <Typography
          className={styles.bingo_box_text}
          sx={{ textAlign: "center" }}
        >
          {bingoList.title}
        </Typography>
      </Box>
      <Modal open={open} onClose={handleClose}>
        <Box sx={style}>
          <Stack justifyContent="center" alignItems="center">
            <Typography textAlign="center" sx={{ my: 1 }} fontWeight="bold">
              "{bingoList.title}"를 완료 상태로 변경하시겠습니까?
            </Typography>
            <Stack direction="row" spacing={3} sx={{ mt: 1 }}>
              <Button className={styles.button_yellow} onClick={handleClose}>
                취소
              </Button>
              <Button className={styles.button_green}>확인</Button>
            </Stack>
            <Button sx={{ mt: 2 }} className={styles.button_blue}>
              빙고판에서 제거하기
            </Button>
          </Stack>
        </Box>
      </Modal>
    </>
  );
};

export default BingoBoard;
