import Image from "next/image";
import { Grid } from "@mui/material";
import type { NextPage } from "next";
import styles from "./styles/index.module.scss";

import MainImg from "../public/img/MainImg.png";

const Home: NextPage = () => {
  const moveBucket = () => {
    document.location.href = "/bingopage"
  }

  return (
    <div>
      <Grid className={styles.mainGrid} container sx={{ mt: 15, mx: "auto" }}>
        <div className={styles.maindiv}>
          <img className={styles.mainimg} src='/img/MainImg.png' />
          <div className={styles.content}>
            <div className={styles.mylist} onClick={moveBucket}>
              나의 버킷리스트 보기
            </div>
            <div className={styles.otherlist}>
              다른 사람의 버킷리스트 보기
            </div>
          </div>
        </div>
      </Grid>
    </div>
  );
};

export default Home;
