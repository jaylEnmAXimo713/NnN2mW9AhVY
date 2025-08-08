// 代码生成时间: 2025-08-08 23:11:18
// ShoppingCart.java
/**
 * A class representing a shopping cart.
 * It allows adding and removing items, checking out and
 * maintaining the cart's current state.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    /**
     * Adds an item to the cart.
     * @param item The item to be added.
     */
    public void addItem(CartItem item) {
        items.add(item);
    }

    /**
     * Removes an item from the cart.
     * @param item The item to be removed.
     */
    public void removeItem(CartItem item) {
        items.remove(item);
    }

    /**
     * Checks out the cart and clears it.
     * @return A message indicating the checkout was successful.
     */
    public String checkout() {
        String checkoutMessage = "Checkout successful.";
        // Logic to process checkout goes here.
        // For simplicity, we're just clearing the cart.
        items.clear();
        return checkoutMessage;
    }

    /**
     * Returns the list of items in the cart.
     * @return List of CartItem objects.
     */
    public List<CartItem> getItems() {
        return items;
    }
}

/**
 * A class representing an item in the cart.
 */
public class CartItem {
    private String id;
    private String name;
    private double price;

    public CartItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
