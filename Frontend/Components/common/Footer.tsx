import { Box, Modal, Typography } from '@mui/material';
import * as React from 'react';
import styles from './Footer.module.scss';

const Footer = () => {

    return (
        <footer className={styles.footer}>
            <div className={styles.contents}>
                <h5>Copyright 2022. BucketList. All rights reservesd.</h5>
            </div>
        </footer>
    );
};
export default Footer;