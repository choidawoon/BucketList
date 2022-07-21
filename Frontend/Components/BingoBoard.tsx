import { Box, Typography, Grid, Stack } from "@mui/material";
import { FC, useState, useEffect } from "react";
import styles from "../styles/BingoBoard.module.scss";
import ClearMark from "../public/images/Clear.png";
import Image from "next/image";

const BingoBoard: FC = () => {
  const [hover, setHover] = useState<any>({ cursor: "pointer" });

  return (
    <Box
      className={styles.bingo_box}
      style={hover}
      onMouseOver={() =>
        setHover({
          transform: "translateY(-3px)",
          boxShadow: "0 0 10px #1A8CDF",
          cursor: "pointer",
        })
      }
      onMouseOut={() => setHover({ cursor: "pointer" })}
      bgcolor="#F3F6F9"
      height="90%"
      width="90%"
      sx={{ m: "auto" }}
      borderRadius="10px"
      display="flex"
      alignItems="center"
      justifyContent="center"
      position="relative"
    >
      <Image
        src={ClearMark}
        alt="Bingo Board"
        height="100%"
        width="100%"
      ></Image>

      <Typography
        className={styles.bingo_box_text}
        sx={{ textAlign: "center" }}
      >
        강원도 가서 감자 캐기
      </Typography>
    </Box>
  );
};

export default BingoBoard;
