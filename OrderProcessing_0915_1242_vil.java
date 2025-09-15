// 代码生成时间: 2025-09-15 12:42:06
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

// 订单类表示一个订单
class Order {
    private String orderId;
    private List<String> items;
    private double totalCost;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.totalCost = 0;
    }

    // getter 和 setter 方法
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // 添加订单项
    public void addItem(String item) {
        items.add(item);
    }

    // 计算总成本
    public void calculateTotalCost() {
        totalCost = items.stream().mapToDouble(item -> item.length()).sum();
    }
}

// 订单处理类
@ManagedBean
@RequestScoped
public class OrderProcessing {

    private Order order;
    private String newOrderItem;

    // 构造函数
    public OrderProcessing() {
        this.order = new Order("ORDER123");
    }

    // getter 和 setter 方法
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public String getNewOrderItem() {
        return newOrderItem;
    }
    public void setNewOrderItem(String newOrderItem) {
        this.newOrderItem = newOrderItem;
    }

    // 添加新订单项
    public void addOrderItem() {
        try {
            if (newOrderItem != null && !newOrderItem.isEmpty()) {
                order.addItem(newOrderItem);
                order.calculateTotalCost();
                newOrderItem = ""; // 清空输入
            } else {
                throw new IllegalArgumentException("Order item cannot be empty.");
            }
        } catch (IllegalArgumentException e) {
            // 错误处理
            System.out.println(e.getMessage());
        }
    }

    // 显示订单项
    public List<String> getOrderItems() {
        return order.getItems();
    }

    // 获取订单总成本
    public double getOrderTotalCost() {
        return order.getTotalCost();
    }
}
