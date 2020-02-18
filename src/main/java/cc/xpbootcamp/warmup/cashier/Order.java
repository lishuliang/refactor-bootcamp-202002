package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private static final double discount = 0.98d;
    private static final double tax = 0.10d;

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
            double salesTax = lineItem.totalAmount() * tax;
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

    public double discountMoney() {
        return totalGoodsMoney() * (1 - discount);
    }

    public String formatMoney(double money) {
        DecimalFormat moneyFormat = new DecimalFormat("#.00");
        return moneyFormat.format(money);
    }

//    public String getDate() {
//        Date date = new Date();
//        return "";
//    }
}
