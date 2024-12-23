import java.util.Arrays;

public class MainApplication {
    // Главный метод программы
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;

        // Анализ аргументов командной строки и создание продуктов
        for (String arg : args) {
            // Проверка на специальные параметры
            if (arg.equals("-calories") || arg.equals("-sort")) {
                continue; // Специальные параметры пропускаем
            }

            // Разделение аргумента на имя продукта и параметры
            String[] parts = arg.split("/");
            switch (parts[0]) {
                case "Cheese":
                    breakfast[itemsSoFar] = new Cheese();
                    break;
                case "Apple":
                    breakfast[itemsSoFar] = new Apple(parts[1]);
                    break;
                case "Pie":
                    breakfast[itemsSoFar] = new PIE(parts[1]);
                    break;
                case "Coffee":
                    breakfast[itemsSoFar] = new Coffee(parts[1]);
                    break;
                default:
                    System.out.println("Неизвестный продукт: " + parts[0]);
            }
            itemsSoFar++;
        }

        // Обработка параметра -calories (вычисление общей калорийности)
        double totalCalories = 0.0;
        if (Arrays.asList(args).contains("-calories")) {
            for (Food item : breakfast) {
                if (item != null && item instanceof Nutritious) {
                    totalCalories += ((Nutritious) item).calculateCalories();
                }
            }
            System.out.println("Общая калорийность завтрака: " + totalCalories);
        }

        // Обработка параметра -sort (сортировка по калорийности)
        if (Arrays.asList(args).contains("-sort")) {
            Arrays.sort(breakfast, new FoodComparator());
            System.out.println("Завтрак отсортирован по калорийности.");
        }

        // Перебор всех продуктов в массиве и их употребление
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else {
                break; // Если элемент null, значит список завершён
            }
        }
        for (Food item : breakfast) {
            if (item != null) {
                System.out.println(item);
            } else {
                break;
            }
        }


    }
}
