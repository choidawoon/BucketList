import React from 'react';
import Navibar from '../Components/common/Navibar';

type AppLayoutProps = {
    children: React.ReactNode;
};

function Layout({ children }: AppLayoutProps) {
    return (
        <>
        <Navibar></Navibar>
            {children}
        </>
    );
}

export default Layout;