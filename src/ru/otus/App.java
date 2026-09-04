package ru.otus;

import ru.otus.animals.Animal;
import ru.otus.animals.Color;
import ru.otus.animals.birds.Flying;
import ru.otus.factory.AnimalFactory;
import ru.otus.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        AnimalFactory factory = new AnimalFactory();

        Command currentCommand;
        do {
            currentCommand = askForCommand();
            if (currentCommand == Command.LIST) {
                if (animals.isEmpty()) {
                    System.out.println("Список пуст");
                }
                for (Animal animal : animals) {
                    System.out.println(animal);
                }
            } else if (currentCommand == Command.ADD) {
                AnimalType animalType = askForAnimalType();
                Animal animal = factory.create(animalType);
                animal.setName(askForAnimalName());
                animal.setAge(askForAge());
                animal.setWeight(askForWeight());
                animal.setColor(askForColor());
                animals.add(animal);
                animal.say();
                tryToFly(animal);
            }
        } while (currentCommand != Command.EXIT);
    }

    private static Command askForCommand() {
        String input = null;
        do {
            if (input != null) {
                System.out.println("Введена неверная команда, попробуйте ещё раз");
            }
            System.out.printf("Введите одну из команд: (%s): ", String.join("/", Command.VALUES));
            input = scanner.next();
        } while (Command.doesNotContain(input));
        return Command.fromString(input);
    }

    private static AnimalType askForAnimalType() {
        String input = null;
        do {
            if (input != null) {
                System.out.println("Введен неверный тип, попробуйте ещё раз");
            }
            System.out.printf("Введите тип животного: (%s): ", String.join("/", AnimalType.VALUES));
            input = scanner.next();
        } while (AnimalType.doesNotContain(input));
        return AnimalType.fromString(input);
    }

    private static int askForAge() {
        int input = 0;
        do {
            System.out.print("Введите возраст животного: ");
            try {
                input = Integer.parseInt(scanner.next());
                if (input <= 0) {
                    System.out.println("Введен неверный возраст, попробуйте ещё раз");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ввод не является числом, попробуйте еще раз");
            }
        } while (input <= 0);
        return input;
    }

    private static String askForAnimalName() {
        String input;
        do {
            System.out.print("Введите имя животного: ");
            input = scanner.next().trim();
            if (input.isEmpty()) {
                System.out.println("Введено пустое значение, попробуйте ещё раз");
            }
        } while (input.isEmpty());
        return input;
    }

    private static double askForWeight() {
        double input = 0;
        do {
            System.out.print("Введите вес животного (кг): ");
            try {
                input = Double.parseDouble(scanner.next());
                if (input <= 0) {
                    System.out.println("Вес должен быть положительным числом, попробуйте ещё раз");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ввод не является числом, попробуйте еще раз");
            }
        } while (input <= 0);
        return input;
    }

    private static Color askForColor() {
        String input = null;
        do {
            if (input != null) {
                System.out.println("Введен неверный цвет, попробуйте ещё раз");
            }
            System.out.printf("Введите цвет животного: (%s): ", String.join("/", Color.VALUES));
            input = scanner.next();
        } while (Color.doesNotContain(input));
        return Color.fromString(input);
    }

    private static void tryToFly(Animal animal) {
        if (animal instanceof Flying flyable) {
            System.out.println("Я лечу");
            flyable.fly();
        }
    }
}
