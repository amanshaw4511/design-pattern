package com.batonsystems.settlement.constant;


import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class Store {
    private final List<Middleware> middlewares;
    private int index = 0;

    public Store(List<Middleware> middlewares) {
        this.middlewares = middlewares;
    }

    String next(String state) {
        if (index == middlewares.size()) {
            return state;
        }
        return middlewares.get(index++).apply(this::next, state);
    }

    String applyMiddleware(String inititalState) {
        this.index = 0;  // reset index
        return next(inititalState);
    }

    public static void main(String... args) {
        Middleware doubleIt = (nxt, state) -> nxt.apply(state + state);
        Middleware appendHello = (nxt, state) -> nxt.apply(state + " Hello");

        String finalValue = new Store(List.of(new StoreLogger(), doubleIt, doubleIt, appendHello))
                .applyMiddleware("a");
        // {initialValue=a, finalValue=aaaa Hello}

        System.out.println(Map.of("finalValue", finalValue));
        // {finalValue=aaaa Hello}
    }
}

@FunctionalInterface
interface Middleware {
    String apply(UnaryOperator<String> next, String state);
}

class StoreLogger implements Middleware {
    @Override
    public String apply(UnaryOperator<String> next, String state) {
        String finalValue = next.apply(state);
        System.out.println(Map.of(
                "initialValue", state,
                "finalValue", finalValue
        ));
        return finalValue;
    }
}
