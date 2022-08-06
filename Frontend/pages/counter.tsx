import { useEffect, useState } from "react";
import { connect } from "react-redux";
import {
  increment,
  decrement,
  reset,
  resetUser,
  fetchUser,
  CounterState,
} from "../store/modules/counter";
import { FC } from "react";

interface ICounter extends CounterState {
  plus: any;
  minus: any;
  reset: any;
  resetUser: any;
  getUser: any;
}

const mapStateToProps = (state: any) => {
  return {
    value: state.counterReducer.value,
    users: state.counterReducer.users,
  };
};

const mapDispatchToProps = (dispatch: any) => {
  return {
    plus: () => dispatch(increment()),
    minus: () => dispatch(decrement()),
    reset: () => dispatch(reset()),
    resetUser: () => dispatch(resetUser()),
    getUser: (obj: any) => dispatch(fetchUser(obj)),
  };
};

const Counter: FC<ICounter> = ({
  value,
  minus,
  plus,
  reset,
  resetUser,
  getUser,
  users,
}) => {
  const [people, setPeople] = useState([] as any);

  const params = {
    user: "users",
  };

  const onClickFunc = () => {
    getUser(params);
  };

  useEffect(() => {
    setPeople(users);
  }, [users]);

  return (
    <div style={{ marginTop: "50px" }} className="container">
      <h1>Counter</h1>
      <button onClick={() => minus()}>-</button>
      <span>{value}</span>
      <button onClick={() => plus()}>+</button>
      <button onClick={() => reset()}>reset</button>
      <br></br>
      <button onClick={onClickFunc}>get user</button>
      <button onClick={() => resetUser()}>reset user</button>
      <div>
        {people &&
          people.map((person: any) => <p key={person.id}>{person.name}</p>)}
      </div>
    </div>
  );
};

export default connect(mapStateToProps, mapDispatchToProps)(Counter);
