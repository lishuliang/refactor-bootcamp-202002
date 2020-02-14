package cc.xpbootcamp.warmup.fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    private final int position;
    private ArrayList<Long> resultList;

    public Fibonacci(int position) {
        this.position = position;
        resultList = new ArrayList<Long>(){{
            add((long) 0);
            add((long) 1);
            add((long) 1);
        }};
    }

    public void calculate() {

        for (int i = 3; i <= position; i++) {
            resultList.add(resultList.get(i - 2) + resultList.get(i - 1));
        }
    }

    public long getFibonacci() {
        return resultList.get(position);
    }
}
