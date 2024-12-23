public class Apple extends Food implements Nutritious {
    // Новое внутреннее поле данных РАЗМЕР
    private String size;
    public Apple(String size) {
// Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
// Инициализировать размер яблока
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    //сравнение
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    @Override
    public double calculateCalories() {
        switch (size.toLowerCase()) {
            case "маленькое":
                return 70.0;
            case "среднее":
                return 100.0;
            case "большое":
                return 130.0;
            default:
                return 110.0;
        }
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}