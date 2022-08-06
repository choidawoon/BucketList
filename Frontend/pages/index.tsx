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
          <div>
            <div className={styles.imgdiv}>
              <img className={styles.myimg} src='/img/My.png' onClick={moveBucket}></img>
              <a className={styles.text}>나의 버킷리스트 보기</a>
            </div>
            <div className={styles.imgdiv}>
              <img className={styles.otherimg} src='/img/Together.png' onClick={moveBucket}></img>
              <a className={styles.text}>친구의 버킷리스트 보기</a>
            </div>
          </div>
        </div>
      </Grid>
    </div>
  );
};

export default Home;
