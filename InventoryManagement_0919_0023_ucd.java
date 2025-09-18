// 代码生成时间: 2025-09-19 00:23:12
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * InventoryManagement.java
 *
 * This class represents the inventory management system, providing functionality to manage stock items.
 */
@ManagedBean
@SessionScoped
public class InventoryManagement {

    // List to store the stock items
    private List<StockItem> stockItems;

    // Constructor to initialize the stock items list
    public InventoryManagement() {
        stockItems = new ArrayList<>();
    }

    /**
     * Adds a new stock item to the inventory.
     *
     * @param item The stock item to be added.
     */
    public void addStockItem(StockItem item) {
        try {
            if (item != null && item.getName() != null && !item.getName().isEmpty()) {
                stockItems.add(item);
            } else {
                throw new IllegalArgumentException("Item name cannot be null or empty.");
            }
        } catch (Exception e) {
            // Handle the error, possibly by showing a message to the user
            System.out.println("Error adding stock item: " + e.getMessage());
        }
    }

    /**
     * Removes a stock item from the inventory.
     *
     * @param item The stock item to be removed.
     */
    public void removeStockItem(StockItem item) {
        try {
            if (item != null) {
                stockItems.remove(item);
            } else {
                throw new IllegalArgumentException("Item cannot be null.");
            }
        } catch (Exception e) {
            // Handle the error
            System.out.println("Error removing stock item: " + e.getMessage());
        }
    }

    /**
     * Updates an existing stock item in the inventory.
     *
     * @param item The stock item to be updated.
     */
    public void updateStockItem(StockItem item) {
        try {
            if (item != null && item.getId() != null) {
                for (int i = 0; i < stockItems.size(); i++) {
                    if (stockItems.get(i).getId().equals(item.getId())) {
                        stockItems.set(i, item);
                        break;
                    }
                }
            } else {
                throw new IllegalArgumentException("Item or item ID cannot be null.");
            }
        } catch (Exception e) {
            // Handle the error
            System.out.println("Error updating stock item: " + e.getMessage());
        }
    }

    /**
     * Retrieves the list of all stock items.
     *
     * @return A list of stock items.
     */
    public List<StockItem> getStockItems() {
        return stockItems;
    }

    /**
     * Represents a stock item with ID, name, and quantity.
     */
    public static class StockItem {
        private Integer id;
        private String name;
        private int quantity;

        public StockItem() {
            // Default constructor
        }

        public StockItem(Integer id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
