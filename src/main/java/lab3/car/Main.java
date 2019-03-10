package lab3.car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        final Car car = new Car();
        while (running) {
            final Scanner scanner = new Scanner(System.in);
            final String command = scanner.next();
            switch (command) {
                case "Info":
                    System.out.print("engine state: ");
                    if (car.engineState) {
                        System.out.println("on");
                    } else {
                        System.out.println("off");
                    }
                    System.out.println("direction: " + car.direction);
                    System.out.println("speed: " + car.speed);
                    System.out.println("gear: " + car.gear);
                    break;
                case "EngineOn":
                    car.TurnOnEngine();
                    break;
                case "EngineOff":
                    car.TurnOffEngine();
                    break;
                case "SetGear":
                    final int gear = scanner.nextInt();
                    car.SetGear(gear);
                    break;
                case "SetSpeed":
                    final int speed = scanner.nextInt();
                    car.SetSpeed(speed);
                    break;
                case "Exit":
                    running = false;
                    break;
                default:
                    System.out.println("Enter correctly");
                    break;
            }
        }
    }
}
