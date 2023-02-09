package Browser;

import Car.Car;

import java.util.Scanner;

public class BrowserMenu {

    private final static Scanner scanner = new Scanner(System.in);
    private static Car car;
    private static Car.CarBuilder carBuilder;

    private static int sprawdz_input(int min, int max) {
        int input;

        while (!scanner.hasNextInt()) {
            System.out.print("Nieprawidlowe dane! Podaj ponownie... ");
            scanner.next();
        }
        input = Integer.parseInt(scanner.next());
        input = sprawdz_przedzial(input, min, max);
        return input;
    }

    private static int sprawdz_przedzial(int input, int min, int max) {
        if (!(input >= min && input <= max)) {
            System.out.print("Nieprawidlowy przedzial liczbowy! Podaj wartosc ponownie... ");
            //scanner.reset();
            input = sprawdz_input(min, max);
        }
        return input;
    }

    private static void initialSelect() {
        System.out.println("Welcome to our car finder!\n\nSelect required options:");
        System.out.print("brand... ");
        String brand = scanner.next();
        System.out.print("model... ");
        String model = scanner.next();
        System.out.print("generation... ");
        String generation = scanner.next();

        carBuilder = new Car.CarBuilder(brand, model, generation);
    }

    private static void results() {

        Browser browser = new Browser(car);

        System.out.print("Searched car: " + car);
        System.out.println(" (mileage and price are the maximal searched values)");
        System.out.println("Results of searching:");

        System.out.println("Available: " + browser.isAvailable());
        if(!browser.isAvailable()) return;

        System.out.println("Amount: " + browser.amountForSale());

        System.out.println("Specific cars:");
        for (Car car : browser.availableCars())
            System.out.println(car);
    }


    public static void main(String[] args) {

        int input = 0;

        initialSelect();

        while (input != 6) {

            System.out.println("\n\nMENU:");
            System.out.println("Select optional filters:\n1 : color\n2 : max_mileage\n3 : max_price\n4 : Search\n5 : clear filters\n6 : exit browser");

            input = sprawdz_input(1, 6);

            switch (input) {

                case 1 -> {
                    System.out.print("Enter color... ");
                    carBuilder.color(scanner.next());
                }

                case 2 -> {
                    System.out.print("Enter max mileage... ");
                    carBuilder.mileage(scanner.nextInt());
                }

                case 3 -> {
                    System.out.print("Enter max price... ");
                    carBuilder.price(scanner.nextInt());
                }

                case 4 -> {
                    car = carBuilder.build();
                    results();
                    System.out.println("print \"ok\" to continue");
                    scanner.next();
                }

                case 5 -> {
                    System.out.println("Filters cleared");
                    initialSelect();
                }

            }
        }

        System.out.println("Exiting browser...");
    }

}
