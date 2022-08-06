import { combineReducers } from "@reduxjs/toolkit";

import counterReducer from "./counter";

import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

const persistConfig = {
  key: "root",
  // localStorage에 저장
  storage,
  //  localstorage에 저장할 reducer 배열로 넣기
  whitelist: ["counterReducer"],
};

export const rootReducer = combineReducers({
  counterReducer,
  // 모듈 추가시 여기에 추가
});

export const persistedReducer = persistReducer(persistConfig, rootReducer);

export type RootState = ReturnType<typeof rootReducer>;
