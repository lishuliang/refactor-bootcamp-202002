package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static cc.xpbootcamp.warmup.util.Util.formatMoney;
import static cc.xpbootcamp.warmup.util.Util.getCurrentWeek;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private Date date;
    private static final double discount = 0.98d;
    private static final int discountDay = Calendar.WEDNESDAY;
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

        result.append("税额: ").append(formatMoney(totalTax())).append('\n');

        if(isDiscount()) {
            result.append("折扣: ").append(formatMoney(discountMoney())).append('\n');
            result.append("总价: ").append(formatMoney(totalTax() + totalGoodsMoney() - discountMoney())).append('\n');

        } else {
            result.append("总价: ").append(formatMoney(totalTax() + totalGoodsMoney())).append('\n');
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
        return (totalGoodsMoney() + totalTax()) * (1 - discount);
    }

    public boolean isDiscount() {
        return discountDay == getCurrentWeek(getDate());
    }
}
