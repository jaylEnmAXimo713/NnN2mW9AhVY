// 代码生成时间: 2025-09-06 00:27:21
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Inventory Management System Bean
 */
@ManagedBean(name = "inventoryBean")
@SessionScoped
public class InventoryManagementSystem {

    private List<Item> inventory;
    private Item newItem;

    // Constructor
    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
        newItem = new Item();
        populateSampleData();
    }

    // Adds sample data to inventory for demonstration purposes
    private void populateSampleData() {
        inventory.add(new Item("001\, "Apple", 100));
        inventory.add(new Item("002", "Banana", 150));
        inventory.add(new Item("003", "Orange", 200));
    }

    // Getters and Setters
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    // Adds a new item to the inventory
    public String addItem() {
        try {
            inventory.add(newItem);
            newItem = new Item();
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    // Removes an item from the inventory
    public String removeItem(String id) {
        try {
            inventory.removeIf(item -> item.getId().equals(id));
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    // Inner class representing an item in the inventory
    public static class Item {
        private String id;
        private String name;
        private int quantity;

        public Item() {
            // Default constructor
        }

        public Item(String id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        @Override
        public String toString() {
            return "Item{"id":"" + id + "", "name":"" + name + "", "quantity":" + quantity + "}";
        }
    }
}