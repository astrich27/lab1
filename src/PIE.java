public class PIE extends Food implements Nutritious {
    // начинка
    private String filling;


    public PIE(String filling) {
        super("Пирог");
        this.filling = filling;
    }


    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    public String getFilling() {
        return filling;
    }


    public void setFilling(String filling) {
        this.filling = filling;
    }

    //сравнение
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {  // Проверяем общее поле name
            if (!(obj instanceof PIE)) return false;  // Проверка типа
            return filling.equals(((PIE) obj).filling);  // Проверяем начинки
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return super.toString() + " с начинкой " + filling.toUpperCase() ;
    }

    @Override
    public double calculateCalories() {
        switch (filling.toLowerCase()) {
            case "вишневая":
                return 250.0;
            case "клубничная":
                return 200.0;
            case "яблочная":
                return 220.0;
            default:
                return 150.0;
        }
    }
}