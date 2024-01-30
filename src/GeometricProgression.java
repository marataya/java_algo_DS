public class GeometricProgression extends Progression {
    protected long base;
    public GeometricProgression() {
        this(2,1);
    }

    public GeometricProgression(long base) {
        this(base, 1);
    }

    @Override
    protected void advance() {
        current *= base;
    }

    public GeometricProgression(long base, long start) {
        super(start);
        this.base = base;
    }
}
