import Image from "next/image";
import { Grid } from "@mui/material";
import type { NextPage } from "next";
import styles from "./styles/index.module.scss";

import MainImg from "../public/img/MainImg.png";

const Home: NextPage = () => {
  return (
    <div>
      <Grid className={styles.mainGrid} container sx={{ mt: 15, mx: "auto" }}>
        <div className={styles.maindiv}>
            <img className={styles.mainimg} src='/img/MainImg.png' />
            <div className={styles.content}>
              안녕하세요
            </div>
        </div>
      </Grid>
    </div>
  );
};

export default Home;
