import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Product {
    private String type;
    private double price;
    private boolean discount;

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    //#1
    public static List<Product> filterExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250)
                .collect(Collectors.toList());
    }
    //#3

    private static Product findCheapestBook(List<Product> products) {
        Optional<Product> cheapestBook = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        return cheapestBook.orElseThrow(() -> new IllegalArgumentException("Продукт [категорія: Book] не знайдено"));

        try {
            Product cheapestBook = findCheapestBook(products);
            System.out.println("Cheapest Book: Type - " + cheapestBook.getType() + ", Price - " + cheapestBook.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}