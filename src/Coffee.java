public class Coffee extends Food implements Nutritious {

    private String typeCoffee;
    public Coffee(String typeCoffee) {

        super("кофе");

        this.typeCoffee = typeCoffee;
    }

    public void consume() {
        System.out.println(this + " выпили");
    }

    public String getSize() {
        return typeCoffee;
    }

    public void setSize(String size) {
        this.typeCoffee = typeCoffee;
    }
    //сравнение
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return typeCoffee.equals(((Apple)arg0).getSize());
        } else
            return false;
    }

    @Override
    public double calculateCalories() {
        switch (typeCoffee.toLowerCase()) {
            case "капучино":
                return 70.0;
            case "латте":
                return 100.0;
            case "раф":
                return 130.0;
            default:
                return 110.0;
        }
    }

    public String toString() {
        return super.toString() + " типа '" + typeCoffee.toUpperCase() + "'";
    }
}