import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung", "Galaxy S21", 799.99));
        phones.add(new Phone("Samsung", "Galaxy Note20", 1199.99));
        phones.add(new Phone("Apple", "iPhone 12 Pro", 999.00));
        phones.add(new Phone("Apple", "iPhone SE", 399.00));
        phones.add(new Phone("Google", "Pixel 5", 699.00));
        phones.add(new Phone("Google", "Pixel 4a", 349.00));

        List<String> samsungModels = phones.stream()
                .filter(phone -> phone.getManufacturer().equals("Samsung"))
                .map(Phone::getModel)
                .collect(Collectors.toList());

        System.out.println("Модели телефонов Samsung:");
        System.out.println(samsungModels);

        Phone[] phoneArray = {
                new Phone("Samsung", "Galaxy S21", 799.99),
                new Phone("Samsung", "Galaxy Note20", 1199.99),
                new Phone("Apple", "iPhone 12 Pro", 999.00),
                new Phone("Apple", "iPhone SE", 399.00),
                new Phone("Google", "Pixel 5", 699.00),
                new Phone("Google", "Pixel 4a", 349.00)
        };

        System.out.println("Массив телефонов:");
        System.out.println(Arrays.stream(phoneArray).map(Phone::toString).collect(Collectors.joining(", ")));

        Phone[] sortedPhones = Arrays.stream(phoneArray)
                .sorted()
                .toArray(Phone[]::new);

        System.out.println("Отсортированный массив телефонов:");
        System.out.println(Arrays.stream(sortedPhones).map(Phone::toString).collect(Collectors.joining(", ")));
    }
}

class Phone implements Comparable<Phone> {
    private String manufacturer;
    private String model;
    private double price;

    public Phone(String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Phone phone) {
        return Double.compare(this.price, phone.price);
    }

    @Override
    public String toString() {
        return model + " - " + price;
    }
}