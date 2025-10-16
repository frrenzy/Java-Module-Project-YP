import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            Car car = createCarFromUserInput(i);
            race.add(car);
        }

        System.out.println(race.getResult());
        scanner.close();
    }

    private static Car createCarFromUserInput(int position) {
        String name = getCarNameFromUserInput(position);
        int speed = getCarSpeedFromUserInput(position);

        return new Car(speed, name);
    }

    private static String getCarNameFromUserInput(int position) {
        System.out.println("— Введите название машины №" + position + ":");
        while (true) {
            String name = scanner.next();
            if (isNameValid(name)) {
                return name;
            }
            System.out.println("— Неправильное имя");
        }
    }

    private static boolean isNameValid(String name) {
        return !name.isEmpty();
    }

    private static int getCarSpeedFromUserInput(int position) {
        System.out.println("— Введите скорость машины №" + position + ":");
        while (true) {
            try {
                int speed = scanner.nextInt();
                if (isSpeedValid(speed)) {
                    return speed;
                }
                System.out.println("— Неправильная скорость");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("— Неправильная скорость");
            }
        }
    }

    private static boolean isSpeedValid(int speed) {
        return speed > 0 && speed <= 250;
    }
}