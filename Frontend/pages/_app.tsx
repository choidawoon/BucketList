/* eslint-disable */
import React, { useState, useEffect } from "react";
import "../styles/globals.css";
import type { AppProps } from "next/app";
import wrapper from "../store/configureStore";

const MyApp = ({ Component, pageProps }: AppProps) => {
  return <Component {...pageProps} />;
};

// export default MyApp;
export default wrapper.withRedux(MyApp);
