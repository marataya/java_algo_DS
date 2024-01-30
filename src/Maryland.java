public class Maryland extends State {
    public Maryland() {}

    @Override
    public void printMe() {
        System.out.println("Read it");
    }

    public static void main(String[] args) {
        Region east = new State();
        State md = new Maryland();
        Object obj = new Place();
        Place usa = new Region();

        md.printMe();
        east.printMe();
        ((Place) obj).printMe();
        obj = md;
        ((Maryland) obj).printMe();
        obj = usa;
        ((Region) obj).printMe();
        usa = md;
        ((Maryland) usa).printMe();

    }
}

class State extends Region {

    public State() {
    }

    @Override
    public void printMe() {
        System.out.println("Ship it");
    }
}

class Region extends Place {

    public Region() {
    }

    @Override
    public void printMe() {
        System.out.println("Box it");
    }
}

class Place extends Object {
    Place() {}

    public void printMe() {
        System.out.println("Buy It");
    }
}
