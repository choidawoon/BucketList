import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import styles from "../styles/index.module.scss";

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
import TodoList from "../Components/TodoList";
import TodoBoard from "../public/images/TodoBg.png";
import DoneBoard from "../public/images/DoneBg.png";
import BingoBg from "../public/images/BingoBg.png";

const Home: NextPage = () => {
  const [isLogin, setIsLogin] = useState<boolean>(true);

  const Bingo = [0, 0, 0, 0, 0, 0, 0, 0, 0];

  const dummyTodoList = [];
  const dummyDoneList = [];
  const dummyBingoList = [];

  const gridContainer = {
    display: "grid",
    gridTemplateColumns: "repeat(3, 1fr)",
  };

  const dummyList = [
    {
      title: "잠만 자기",
      content: "하루 종일 자기",
      position: 1,
      done: true,
    },
    {
      title: "감자 캐기",
      content: "강원도 가서 감자 캐기",
      position: 2,
      done: false,
    },
    {
      title: "우영우 보기",
      content: "기러기토마토스위스인도인별똥별",
      position: 3,
      done: false,
    },
    {
      title: "요리하기",
      content: "된장찌개",
      position: 4,
      done: true,
    },
    {
      title: "샤워하기",
      content: "매일 밤",
      position: 5,
      done: false,
    },
    {
      title: "청소",
      content: "청소",
      position: 6,
      done: true,
    },
    {
      title: "코딩하기",
      content: "ㅠㅠ",
      position: 7,
      done: false,
    },
    {
      title: "운동하기",
      content: "운동",
      position: 8,
      done: true,
    },
    {
      title: "영양제 먹기",
      content: "하루 영양",
      position: 9,
      done: false,
    },
    {
      title: "마트 가기",
      content: "장보기",
      position: 0,
      done: false,
    },
  ];

  for (let i = 0; i < dummyList.length; i++) {
    if (dummyList[i].done === true) {
      dummyDoneList.push(dummyList[i]);
    } else {
      dummyTodoList.push(dummyList[i]);
    }
    if (dummyList[i].position !== 0) {
      dummyBingoList.push(dummyList[i]);
    }
  }

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
            className={styles.grid_container}
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
            <Box className={styles.scroolBar} height="70%" width="90%">
              {dummyTodoList.length > 0 ? (
                dummyTodoList.map((item, i) => (
                  <TodoList todoList={item} key={i} />
                ))
              ) : (
                <Typography>Todo List가 비어있습니다.</Typography>
              )}
            </Box>
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
          </Grid>
        </Grid>
      </Grid>
    </>
  );
};

export default Home;
