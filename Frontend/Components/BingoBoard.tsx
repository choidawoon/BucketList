import { Box, Typography, Grid, Stack } from "@mui/material";
import { FC, useState, useEffect } from "react";

const BingoBoard: FC = () => {
  const dummy = [
    {
      content: "잠 자기",
    },
  ];

  return (
    <Box
      bgcolor="#E4F2FD"
      height="80%"
      width="80%"
      sx={{ m: "auto" }}
      borderRadius="10px"
      display="flex"
      alignItems="center"
      justifyContent="center"
    >
      <Typography sx={{ textAlign: "center" }}>제주도 가기</Typography>
    </Box>
  );
};

export default BingoBoard;
