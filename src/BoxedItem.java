public class BoxedItem implements Sellable, Transportable {
    private String descript;
    private int price;
    private boolean haz;
    private int height = 0;
    private int weight = 0;
    private int depth = 0;

    public BoxedItem(String descript, int price, int weight, int height) {
        this.descript = descript;
        this.price = price;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String description() {
        return descript;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price/2;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return haz;
    }
}
