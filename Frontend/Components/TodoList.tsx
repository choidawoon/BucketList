import { FC } from "react";
import { Box, Typography, Grid, Stack, Checkbox } from "@mui/material";
import styles from "../styles/TodoList.module.scss";

interface ITodoList {
  todoList: Array<string>;
}

const TodoList: FC<ITodoList> = ({ todoList }) => {
  return (
    <>
      <Stack direction="row" alignItems="center">
        <Checkbox style={{ color: "#CA9F09" }} />
        <Typography>{todoList.title}</Typography>
      </Stack>
    </>
  );
};

export default TodoList;
