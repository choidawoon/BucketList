import * as React from 'react';
import styles from './Navibar.module.scss';

const Navibar = () => {

    return (
        <header className={styles.header}>
            <div className={styles.contents}>
                <div >
                    <img className={styles.logo} src='/img/bucketlist.png'></img>
                </div>

                <div>
                <img className={styles.profile} src='/img/profileimg.png'></img>
                </div>
            </div>
        </header>
    );
};
export default Navibar;