package ShoppingCart1;
import java.util.Arrays;
import java.util.List;


class Product {
    String name;
    double unitPrice;
    double gst;
    int quantity;

    public Product(String name, double unitPrice, double gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        double totalPrice = unitPrice * quantity;
        return (unitPrice >= 500) ? totalPrice * 0.95 : totalPrice;
    }

    public double getGSTAmount() {
        return unitPrice * quantity * gst / 100;
    }
}

public class ShoppingCart1 {
    public static void main(String[] args) {
        List<Product> basket = Arrays.asList(
            new Product("Leather Wallet", 1100, 18, 1),
            new Product("Umbrella", 900, 12, 4),
            new Product("Cigarette", 200, 28, 3),
            new Product("Honey", 100, 0, 2)
        		  );

        Product maxGSTProduct = basket.stream()
            .max((p1, p2) -> Double.compare(p1.getGSTAmount(), p2.getGSTAmount()))
            .orElse(null);

        double totalAmount = basket.stream().mapToDouble(Product::getTotalPrice).sum();

        System.out.println("Product with maximum GST amount: " + maxGSTProduct.name);
        System.out.println("Total amount to be paid: Rs. " + totalAmount);;
    }
}
