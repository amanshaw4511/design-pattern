type state = string;

type Next = (state: state) => state;

type Middleware = (next: Next) => (state: state) => state;

type ApplyMiddleware = (middlewares: Middleware[]) => (state: state) => state;

const applyMiddleware: ApplyMiddleware = (middlewares) => (initialState) => {
  let index = 0;
  const next: Next = (state) => {
    const middleware = middlewares[index++];
    return typeof middleware === "function" ? middleware(next)(state) : state;
  };
  return next(initialState);
};

/////////////////////////////////////////


const logger: Middleware = (next) => (state) => {
  const finalValue = next(state);
  console.log({ "initial value": state, "final value": finalValue });
  return finalValue;
};

const doubleMiddleware: Middleware = (next) => (state) => next(state + state);

const appendHello: Middleware = (next) => (state) => next(state + " Hello");

const finalValue = applyMiddleware([
  logger,
  doubleMiddleware,
  doubleMiddleware,
  appendHello,
])("a");
// [LOG]: {
//  "initial value": "a",
//  "final value": "aaaa Hello"
// }

console.log({ finalValue });
// [LOG]: {
//   "finalValue": "aaaa Hello"
// }
