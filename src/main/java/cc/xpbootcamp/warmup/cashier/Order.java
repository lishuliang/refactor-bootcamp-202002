package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private Date date;
    private static final double discount = 0.98d;
    private static final double tax = 0.10d;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
        this.date = new Date();
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

    public Date getDate() {
        return this.date;
    }

    public String amountInfo() {
        StringBuilder result = new StringBuilder();

        result.append("Sales Tax: ").append(totalTax()).append('\n');

        if(isDiscount()) {
            result.append("Discount: ").append(discountMoney()).append('\n');
            result.append("Total Amount: ").append(totalTax() + totalGoodsMoney() - discountMoney()).append('\n');

        } else {
            result.append("Total Amount: ").append(totalTax() + totalGoodsMoney()).append('\n');
        }

        return result.toString();
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

    public String getFormatDate() {
        String dateFormat = "yyyy年MM月dd日, EEE";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        return simpleDateFormat.format(this.getDate()) + "\n\r";
    }

    public boolean isDiscount() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE");

        return "Wed".equals(simpleDateFormat.format(this.getDate()));
    }
}
