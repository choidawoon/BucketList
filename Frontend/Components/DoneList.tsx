import { FC } from "react";
import { Box, Typography, Grid, Stack, Checkbox } from "@mui/material";
import styles from "../styles/DoneList.module.scss";

interface IDoneList {
  doneList: Array<string>;
}

const DoneList: FC<IDoneList> = ({ doneList }) => {
  return (
    <>
      <Stack direction="row" alignItems="center">
        <Checkbox defaultChecked style={{ color: "#189F25" }} />
        <Typography>{doneList.title}</Typography>
      </Stack>
    </>
  );
};

export default DoneList;
