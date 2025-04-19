package org.example.behavioral.iterator;

import java.util.List;
import java.util.stream.IntStream;

public class Iterator {
    public static void main(String[] args) {
        var list = IntStream.rangeClosed(1, 10).boxed().toList();

        ListIterator forwardIterator = new ForwardIterator(list);
        while (forwardIterator.hasNext()) {
            System.out.print(forwardIterator.next() + " ");
        }

        System.out.println();

        ListIterator reverseIterator = new ReverseIterator(list);
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }

        System.out.println();

        ListIterator evenIterator = new StepIterator(list, 1, list.size()-1, 2);
        while (evenIterator.hasNext()) {
            System.out.print(evenIterator.next() + " ");
        }

    }
}

interface ListIterator {
    Integer next();
    boolean hasNext();
}

class ForwardIterator implements ListIterator {
    private final StepIterator stepIterator;

    ForwardIterator(List<Integer> list) {
        this.stepIterator = new StepIterator(list, 0, list.size()-1, 1);
    }

    @Override
    public Integer next() {
        return stepIterator.next();
    }

    @Override
    public boolean hasNext() {
        return stepIterator.hasNext();
    }
}

class ReverseIterator implements ListIterator {
    private final List<Integer> list;
    private int index ;

    ReverseIterator(List<Integer> list) {
        this.list = list;
        index = list.size() -1;
    }

    @Override
    public Integer next() {
        return list.get(index--);
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }
}

class StepIterator implements ListIterator {
    private final List<Integer> list;
    private int index;
    private final int endIndex;
    private final int step;

    StepIterator(List<Integer> list, int startIndex, int endIndex, int step) {
        this.list = list;
        this.endIndex = endIndex;
        this.step = step;
        this.index = startIndex;
    }

    @Override
    public Integer next() {
        var value =  list.get(index);
        index += step;
        return value;
    }

    @Override
    public boolean hasNext() {
        return index <= endIndex;
    }
}
