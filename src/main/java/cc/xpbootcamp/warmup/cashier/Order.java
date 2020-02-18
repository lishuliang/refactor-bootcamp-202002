package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public double totalTax() {
        double totalTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalTax += salesTax;
        }

        return totalTax;
    }

    public double totalGoodsMoney() {
        double totalGoodsMoney = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalGoodsMoney += lineItem.totalAmount();
        }

        return totalGoodsMoney;
    }

    public String getLineItem() {
        StringBuilder result = new StringBuilder();

        for (LineItem lineItem : getLineItems()) {
            result.append(lineItem.getLineItemInfo());
        }

        return result.toString();
    }
}
