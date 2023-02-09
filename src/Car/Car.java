package Car;

public class Car {

    private final String brand;
    private final String model;
    private final String generation;
    private final String color;
    private final int mileage;
    private final int price;

    private Car(CarBuilder carBuilder) {
        this.brand = carBuilder.brand;
        this.model = carBuilder.model;
        this.generation = carBuilder.generation;
        this.color = carBuilder.color;
        this.mileage = carBuilder.mileage;
        this.price = carBuilder.price;
    }

    public String toString() {
        return "brand: " + brand + "\t model: " + model + "\t generation: " + generation + "\t color: " + color + "\t mileage: " + mileage + " km\t price: " + price + "zl";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getGeneration() {
        return generation;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

//    public static CarBuilder builder() {
//        return new CarBuilder();
//    }

    public static class CarBuilder {
        private final String brand;
        private final String model;
        private final String generation;
        private String color = "not selected";
        private int mileage = 300000;
        private int price = 500000;


        public CarBuilder(String brand, String model, String generation) { // tu znajduja sie pola wymagane
            this.brand = brand;
            this.model = model;
            this.generation = generation;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder mileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public CarBuilder price(int price) {
            this.price = price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}
