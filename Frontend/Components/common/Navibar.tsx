import { Box, Modal, Typography } from '@mui/material';
import * as React from 'react';
import styles from './Navibar.module.scss';

const Navibar = () => {
    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);
    const moveHome = () => {
        document.location.href = "/"
    }

    return (
        <header className={styles.header}>
            <div className={styles.contents}>
                <div >
                    <img className={styles.logo} src='/img/bucketlist.png' onClick={moveHome}></img>
                </div>

                <div>
                <img className={styles.profile} src='/img/profileimg.png' onClick={handleOpen}></img>
                </div>
            </div>

            <div>
                <Modal
                    open={open}
                    onClose={handleClose}
                    aria-labelledby="modal-modal-title"
                    aria-describedby="modal-modal-description"
                    className={styles.modal_back}
                >
                    <Box className={styles.modal}>
                    <h1>로그인</h1>
                        <p className={styles.p}>아이디</p>
                        <input className={styles.input} placeholder="아이디를 입력하세요..."/>
                        <p className={styles.p}>비밀번호</p>
                        <input className={styles.input} placeholder="비밀번호를 입력하세요..."/>
                    </Box>
                </Modal>
            </div>
        </header>
    );
};
export default Navibar;