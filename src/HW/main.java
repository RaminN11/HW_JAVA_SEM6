package HW;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Acer", 32, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Apple", 16, 512, "MacOS", "White"));
        notebooks.add(new Notebook("Lenovo", 16, 256, "Linux", "Grey"));
        notebooks.add(new Notebook("HP", 8, 256, "Windows", "Grey"));
        notebooks.add(new Notebook("Apple", 16, 512, "MacOS", "Pink"));
        notebooks.add(new Notebook("Acer", 8, 128, "Linux", "Black"));


        Scanner iscanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        Map<String, Object> filter = new HashMap<>();

        while (true) {
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Поиск");
            System.out.print("Введите значение: ");
            String input = iscanner.nextLine();

            if (input.equals("stop")) {
                break;
            }
            int criterion = Integer.parseInt(input);

            if (criterion == 5) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите критерий для поиска: ");
                String searchString = scanner.nextLine();
                filter.put("brand", searchString);
                continue;
            }
            String nameField;
            switch (criterion) {
                case 1:
                    nameField = "ram";
                    System.out.print("Введите минимальное значение: ");
                    int minRam = Integer.parseInt(iscanner.nextLine());
                    filter.put(nameField, minRam);
                    break;
                case 2:
                    nameField = "storage";
                    System.out.println("Введите минимальный объем ЖД: ");
                    int minStorage = Integer.parseInt(iscanner.nextLine());
                    filter.put("storage", minStorage);
                    break;
                case 3:
                    System.out.println("Введите операционную систему: ");
                    String os = iscanner.nextLine();
                    filter.put("os", os);
                    break;
                case 4:
                    System.out.println("Введите цвет: ");
                    String color = iscanner.nextLine();
                    filter.put("color", color);
                    break;
//                default:
//                    continue;
            }
        }
        System.out.println("Результаты фильтрации:");

        for (Notebook notebook : notebooks) {
            if (notebook.matchFilter(filter)) {
                System.out.println(notebook);
            }
        }

    }
}


