import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //#1
        List<Product> products = List.of(
                new Product("Book", 350),
                new Product("Book", 240),
                new Product("Pencil", 100)
        );
        List<Product> expensiveBooks = Product.filterExpensiveBooks(products);

        System.out.println("Expensive Books:");
        expensiveBooks.forEach(p -> System.out.println("Type: " + p.getType() + ", Price: " + p.getPrice()));


        // Task 2.1: Filter products of type "Book" with discount
        List<Product> discountedBooks = products.stream()
                .filter(p -> p.getType().equals("Book") && p.hasDiscount())
                .collect(Collectors.toList());

        System.out.println("\nDiscounted Books:");
        discountedBooks.forEach(p -> System.out.println("Type: " + p.getType() + ", Price: " + applyDiscount(p.getPrice())));

        // Task 2.2: Apply 10% discount to all products of type "Book"
        List<Product> booksWithDiscount = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .map(p -> new Product(p.getType(), applyDiscount(p.getPrice()), p.hasDiscount()))
                .collect(Collectors.toList());

        System.out.println("\nBooks with 10% discount:");
        booksWithDiscount.forEach(p -> System.out.println("Type: " + p.getType() + ", Price: " + p.getPrice()));
    }

    // Method to apply 10% discount
    private static double applyDiscount(double price) {
        return price * 0.9; // 10% discount
    }


}
