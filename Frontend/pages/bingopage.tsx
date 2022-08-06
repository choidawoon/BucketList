import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import styles from "../styles/index.module.scss";
import * as React from "react";

import { useState } from "react";
import {
  Container,
  Typography,
  Box,
  CssBaseline,
  Grid,
  Paper,
  Stack,
  Button,
  Modal,
  Checkbox,
  RadioGroup,
  FormControlLabel,
  Radio,
} from "@mui/material";

import BingoBoard from "../Components/BingoBoard";
import TodoList from "../Components/TodoList";
import DoneList from "../Components/DoneList";
import TodoBoard from "../public/img/TodoBg.png";
import DoneBoard from "../public/img/DoneBg.png";
import BingoBg from "../public/img/BingoBg.png";

const BingoPage: NextPage = () => {
  const [isLogin, setIsLogin] = useState<boolean>(true);
  const [open, setOpen] = React.useState(false);
  const [record, setRecord] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const recordOpen = () => setRecord(true);
  const recordClose = () => setRecord(false);

  const bingoList = [0, 0, 0, 0, 0, 0, 0, 0, 0];

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
      done: true,
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
      done: true,
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
    {
      title: "마트 가기",
      content: "장보기",
      position: 0,
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
      bingoList[dummyList[i].position - 1] = dummyList[i];
    }
  }

  return (
    <>
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
          // xs={10}
          // md={5.5}
          sx={{
            display: "flex",
          }}
          position="relative"
          // height="100%"
          className={styles.bingoboard}
        >
          <Image src={BingoBg} alt="Bingo Board"></Image>
          <Grid
            sx={gridContainer}
            className={styles.grid_container}
            height="75%"
            width="85%"
          >
            {bingoList.map((item, i) => (
              <BingoBoard bingoList={item} key={i} />
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
          display="flex"
        >
          <div className={styles.tododiv}>
            <Typography
              // textAlign="center"
              variant="h4"
              className={styles.todo}
            >
              To Do
            </Typography>
            <Button className={styles.button} onClick={handleOpen}>
              추가하기
            </Button>
          </div>

          <Grid className={styles.todolist}>
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
            {/* <Button>Primary</Button> */}
          </Grid>
          <Typography
            textAlign="center"
            variant="h4"
            sx={{ fontWeight: "bold" }}
          >
            Done
          </Typography>
          <Grid className={styles.donelist}>
            <Image src={DoneBoard} alt="Bingo Board"></Image>
            <Box className={styles.scroolBar_done} height="70%" width="90%">
              {dummyDoneList.length > 0 ? (
                dummyDoneList.map((item, i) => (
                  <DoneList doneList={item} key={i} />
                ))
              ) : (
                <Typography>Done List가 비어있습니다.</Typography>
              )}
            </Box>
          </Grid>
        </Grid>
      </Grid>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box className={styles.modal}>
          <Grid container spacing={3} className={styles.section}>
            <Grid item xs={3}>
              <p className={styles.title}>제목</p>
            </Grid>
            <Grid item xs={9}>
              <input className={styles.input} placeholder="제목을 입력하세요..."></input>
            </Grid>
          </Grid>

          <Grid container spacing={3} className={styles.section}>
            <Grid item xs={3}>
              <p className={styles.title}>설명</p>
            </Grid>
            <Grid item xs={9}>
              <input className={styles.input} placeholder="설명을 입력하세요..."></input>
            </Grid>
          </Grid>

          <Grid container spacing={3} className={styles.section}>
            <Grid item xs={3}>
              <p className={styles.title}>태그</p>
            </Grid>
            <Grid item xs={9}>
              <input className={styles.input} placeholder="태그을 입력하세요..."></input>
            </Grid>
          </Grid>

          <Grid container spacing={3} className={styles.section}>
            <Grid item xs={3}>
              <p className={styles.title}>유형</p>
            </Grid>
            <Grid item xs={9}>
              <RadioGroup row className={styles.input}>
                <FormControlLabel value="record" control={<Radio />} label="기록형" onClick={recordOpen}/>
                <FormControlLabel value="success" control={<Radio />} label="달성형" onClick={recordClose} />
              </RadioGroup>
            </Grid>
          </Grid>
          
          {
            record === true ?
              (
                <Grid container spacing={3} className={styles.section}>
                  <Grid item xs={3}>
                    <p className={styles.title}>태그</p>
                  </Grid>
                  <Grid item xs={9}>
                    <input className={styles.input} placeholder="태그을 입력하세요..."></input>
                  </Grid>
                </Grid>
              ) : (
                <div style={{height: "18%"}}></div>
              )
          }

          <Grid container spacing={3}>
            <Grid item xs={6} style={{textAlignLast: "right"}}>
              <Button variant="text" className={styles.addButton1}>추가</Button>
            </Grid>
            <Grid item xs={6}>
              <Button variant="text" className={styles.addButton2}>닫기</Button>
            </Grid>
          </Grid>
          
        </Box>
      </Modal>
    </>
  );
};

export default BingoPage;
