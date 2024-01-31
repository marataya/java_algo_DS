package ozon_contest;

import java.util.Iterator;

public class NumberRange implements Iterable<Integer> {
    private final int start;
    private final int end;

    public NumberRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int current = start - 1;

            @Override
            public boolean hasNext() {
                return current < end;
            }

            @Override
            public Integer next() {
                current++;
                return current;
            }
        };
    }
}

