import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import styles from "../styles/Home.module.css";

import Navibar from "../pages/common/Navibar";
import { useState } from "react";
import {
  Container,
  Typography,
  Box,
  CssBaseline,
  Grid,
  Paper,
  Stack,
} from "@mui/material";

import BingoBoard from "../Components/BingoBoard";
import TodoBoard from "../public/images/TodoBg.png";
import DoneBoard from "../public/images/DoneBg.png";
import BingoBg from "../public/images/BingoBg.png";

const Home: NextPage = () => {
  const [isLogin, setIsLogin] = useState<boolean>(true);

  const Bingo = [0, 0, 0, 0, 0, 0, 0, 0, 0];

  const gridContainer = {
    display: "grid",
    gridTemplateColumns: "repeat(3, 1fr)",
  };

  return (
    <>
      <Navibar />
      <Grid
        container
        sx={{ mt: 15, mx: "auto" }}
        maxWidth="lg"
        direction="row"
        alignContent="center"
        justifyContent="center"
      >
        <Grid
          item
          xs={10}
          md={5}
          sx={{
            display: "flex",
          }}
          position="relative"
          height="100%"
        >
          <Image src={BingoBg} alt="Bingo Board"></Image>
          <Grid
            sx={gridContainer}
            className={styles.test}
            height="75%"
            width="85%"
          >
            {Bingo.map((item, i) => (
              <BingoBoard key={i} />
            ))}
          </Grid>
        </Grid>
        <Grid
          container
          direction="column"
          item
          xs={10}
          md={5}
          alignContent="center"
          justifyContent="center"
          height="100%"
        >
          <Typography
            textAlign="center"
            variant="h4"
            sx={{ fontWeight: "bold" }}
          >
            To Do
          </Typography>
          <Grid position="relative" height="70%" width="70%">
            <Image src={TodoBoard} alt="Bingo Board"></Image>
            <Typography className={styles.test2}>잠 자기</Typography>
          </Grid>
          <Typography
            textAlign="center"
            variant="h4"
            sx={{ fontWeight: "bold", mt: 3 }}
          >
            Done
          </Typography>
          <Grid position="relative" height="70%" width="70%">
            <Image src={DoneBoard} alt="Bingo Board"></Image>
            <Typography className={styles.test2}>잠 자기</Typography>
          </Grid>
        </Grid>
      </Grid>
    </>
  );
};

export default Home;
