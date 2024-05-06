import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class MainLaptop {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 512, "Windows", "Black"));
        laptops.add(new Laptop(16, 1024, "MacOS", "White"));
        laptops.add(new Laptop(8, 512, "Linux", "Silver"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерий ноутбука:");
        System.out.println("1 - RAM");
        System.out.println("2 - Объем жесткого диска");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int choice = scanner.nextInt();

        Object filterValue;
        switch (choice) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                filterValue = scanner.nextInt();
                break;
            case 2:
                System.out.println("Введите минимальный объем жесткого диска:");
                filterValue = scanner.nextInt();
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                filterValue = scanner.next();
                break;
            case 4:
                System.out.println("Введите цвет:");
                filterValue = scanner.next();
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        for (Laptop laptop : laptops) {
            if (laptop.passesCriteria(choice, filterValue)) {
                System.out.println(laptop);
            }
        }
    }
}

class Laptop {
    private int RAM;
    private int hardDiskSize;
    private String operatingSystem;
    private String color;

    public Laptop(int RAM, int hardDiskSize, String operatingSystem, String color) {
        this.RAM = RAM;
        this.hardDiskSize = hardDiskSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public boolean passesCriteria(int choice, Object filterValue) {
        switch (choice) {
            case 1:
                return this.RAM >= (int) filterValue;
            case 2:
                return this.hardDiskSize >= (int) filterValue;
            case 3:
                return this.operatingSystem.equalsIgnoreCase((String) filterValue);
            case 4:
                return this.color.equalsIgnoreCase((String) filterValue);
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "Laptop{" + "ОЗУ = " + RAM + ", объем жесткого диска=" + hardDiskSize + ", операционная система ='" + operatingSystem + '\'' + ", цвет = '" + color + '\'' + '}';
    }
}