/* eslint-disable */
import React, { useState, useEffect } from "react";
import "../styles/globals.css";
import type { AppProps } from "next/app";
import wrapper from "../store/configureStore";
import Head from "next/head";
import Layout from "./Layout";

const MyApp = ({ Component, pageProps }: AppProps) => {
  return (
    <>
      <Head>
        <base href="/"/>
        <meta charSet="UTF-8" />
        <title>BucketList</title>
        <link rel="shortcut icon" href="/favicon.ico" />
      </Head>
      <Layout>
        <Component {...pageProps} />
      </Layout>
    </>
    );
};

// export default MyApp;
export default wrapper.withRedux(MyApp);
