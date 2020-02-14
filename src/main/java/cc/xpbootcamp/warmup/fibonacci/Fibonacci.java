package cc.xpbootcamp.warmup.fibonacci;

import java.util.ArrayList;

public class Fibonacci {
    private final int position;
    private ArrayList<Integer> resultList;

    public Fibonacci(int position) {
        this.position = position;
        resultList = new ArrayList<Integer>(){{
            add(0);
            add(1);
            add(1);
        }};
    }

    public void calculate() {

        for (int i = 3; i <= position; i++) {
            resultList.add(resultList.get(i - 2) + resultList.get(i - 1));
        }
    }

    public int getFibonacci() {
        return resultList.get(position);
    }
}
