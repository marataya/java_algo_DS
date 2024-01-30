public abstract class Progression {
    protected long current;

    /* Constructs progression with given start value */
    public Progression(long start) {
        this.current = start;
    }

    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }

    protected abstract void advance();

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int i = 0; i < n; i++) {
            System.out.print("\t"+nextValue());
        }
        System.out.println();
    }
}

