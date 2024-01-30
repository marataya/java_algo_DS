public class FibonacciProgression extends Progression {
    protected long prev;
    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first;
    }

    public FibonacciProgression() {
        this(0, 1);
    }

    @Override
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
