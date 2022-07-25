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
              <button onClick={moveBucket}>버킷리스트 이동</button>
            </div>
        </div>
      </Grid>
    </div>
  );
};

export default Home;
