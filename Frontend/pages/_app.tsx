/* eslint-disable */
import React, { useState, useEffect } from "react";
import "../styles/globals.css";
import Head from "next/head";
import type { AppProps } from "next/app";
import wrapper from "../store/configureStore";

import { useSelector } from "react-redux";
import { RootState } from "../store/modules";

const MyApp = ({ Component, pageProps }: AppProps) => {
  return <Component {...pageProps} />;
};

// export default MyApp;
export default wrapper.withRedux(MyApp);
