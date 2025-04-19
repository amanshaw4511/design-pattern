package org.example.behavioral.chain.of.responsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler l2Support = new Level2SupportHandler();
        SupportHandler l1Support = new Level1SupportHandler();
        l1Support.setNextHandler(l2Support);

        System.out.println(l1Support.handleRequest("EASY"));
        System.out.println("...........");
        System.out.println(l1Support.handleRequest("SOLVABLE"));
    }
}

interface SupportHandler {
    String handleRequest(String request);

    void setNextHandler(SupportHandler nextHandler);
}

class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public String handleRequest(String request) {
        String footer = "\nThanks you";
        if (request.equals("EASY")) {
            return "Resolved by Level 1" + footer;
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(request) + footer;
        }
        throw new RuntimeException("Can't handle the request");
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public String handleRequest(String request) {
        if (request.equals("SOLVABLE")) {
            return "Resolved by Level 2";
        }
        if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        }
        throw new RuntimeException("Can't handle the request");
    }


    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}