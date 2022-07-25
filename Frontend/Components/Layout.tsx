import react, { ReactNode, FC } from "react";
import { NextPage } from "next";
import Navbar from "./common/Navibar";

interface Props {
  children: ReactNode;
}

const Layout = ({ children }: Props) => {
  return (
    <div>
      <Navbar />
      <main>{children}</main>
    </div>
  );
};

export default Layout;
