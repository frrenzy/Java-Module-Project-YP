import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 250;
    private final int CARS_IN_RACE = 3;

    public void run() {
        Race race = new Race();

        for (int i = 1; i <= CARS_IN_RACE; i++) {
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
        return speed >= MIN_SPEED && speed <= MAX_SPEED;
    }
}
