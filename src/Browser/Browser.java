package Browser;

import Car.Car;

import java.util.ArrayList;
import java.util.Random;

public class Browser {

    Random random = new Random();

    private final String brand;
    private final String model;
    private final String generation;
    private String color;
    private final int max_mileage;
    private final int max_price;
    private final boolean available;
    private int available_nb;
    private final String[] colors = new String[]{"Black", "Silver", "Red  ", "Green", "Yellow", "White"};

    public Browser(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.generation = car.getGeneration();
        this.color = car.getColor();
        this.max_mileage = car.getMileage();
        this.max_price = car.getPrice();

        available = random.nextDouble() > 0.2;
    }

    public boolean isAvailable() {
        return available;
    }

    public int amountForSale() {
        if (!available)
            available_nb = 0;
        else
            available_nb = random.nextInt(1, 23);
        return available_nb;
    }

    public ArrayList<Car> availableCars() { //do "zgadywania" : kolor, przebieg <= max, cena <= max;

        ArrayList<Car> carArrayList = new ArrayList<>();
        boolean random_color = color.equals("not selected");
        double CONSTANT_A = -0.000002;

        for (int i = 0; i < available_nb; i++) {
            if (random_color)
                color = colors[random.nextInt(0, colors.length-1)];
            int mileage = random.nextInt((int) (max_mileage*0.7), max_mileage);
            int price = (int) (random.nextInt((int) (max_price*0.7), max_price) * (CONSTANT_A *mileage + 1));
            carArrayList.add(new Car.CarBuilder(brand, model, generation).color(color).mileage(mileage).price(price).build());
        }
        return carArrayList;
    }

}
