import React from 'react';
import Footer from '../Components/common/Footer';
import Navibar from '../Components/common/Navibar';

type AppLayoutProps = {
    children: React.ReactNode;
};

function Layout({ children }: AppLayoutProps) {
    return (
        <>
            <Navibar></Navibar>
            {children}
            <Footer></Footer>
        </>
    );
}

export default Layout;