import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Xiaomi", "Redmi 6", 9999.99));
        phones.add(new Phone("Xiaomi", "A3", 19999.99));
        phones.add(new Phone("Apple", "iPhone 12 Pro", 500000.00));
        phones.add(new Phone("Apple", "iPhone 4", 30000.00));
        phones.add(new Phone("Honor", "20 pro", 35000.00));
        phones.add(new Phone("Honor", "9X", 45000.00));

        List<String> samsungModels = phones.stream()
                .filter(phone -> phone.getManufacturer().equals("Honor"))
                .map(Phone::getModel)
                .collect(Collectors.toList());

        System.out.println("Модели телефонов Honor:");
        System.out.println(samsungModels);

        Phone[] phoneArray = {
                new Phone("Xiaomi", "Redmi 6", 9999.99),
                new Phone("Xiaomi", "A3", 19999.99),
                new Phone("Apple", "iPhone 12 Pro", 500000.00),
                new Phone("Apple", "iPhone 4", 30000.00),
                new Phone("Honor", "20 pro", 35000.00),
                new Phone("Honor", "9X", 45000.00),
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
