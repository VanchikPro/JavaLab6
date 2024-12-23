import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        boolean exit = false;

        // Динамический список объектов
        ArrayList<PhysicalObject> objects = new ArrayList<>();

        while (!exit) {
            try {
                menu.displayMenu();
                int choice = menu.Choice();

                switch (choice) {
                    case 1:
                        try {
                            double mass = menu.ValidMass();
                            double speed = menu.ValidSpeed();
                            KineticEnergy object = new KineticEnergy(mass, speed);
                            objects.add(object); // Добавление объекта в список
                            System.out.printf("Кинетическая энергия объекта: %.2f Джоулей\n", object.calculateEnergy());
                        } catch (exclusion e) { //перехват исключения
                            System.out.println("Ошибка создания объекта: " + e.getMessage()); //обработка исключения
                        }
                        break;
                    case 2:
                        menu.displayProgramInfo();
                        break;
                    case 3:
                        menu.displayDeveloperInfo();
                        break;
                    case 4:
                        System.out.println("Выход из программы...");
                        exit = true;
                        break;
                }
            } catch (Exception e) { //перехват исключения
                System.out.println("Произошла ошибка: " + e.getMessage()); //обработка исключения
            }
        }

        // Обработка списка объектов с использованием полиморфизма
        System.out.println("\nРезультаты работы программы:");
        for (int i = 0; i < objects.size(); i++) {
            PhysicalObject obj = objects.get(i);
            System.out.println("Расчет " + (i + 1));
            System.out.println(obj.toString());
        }

        scanner.close();
    }
}
