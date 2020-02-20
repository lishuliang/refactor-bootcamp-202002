package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static cc.xpbootcamp.warmup.util.Util.getCurrentWeek;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private Date date;
    private static final double DISCOUNT = 0.98d;
    private static final int DISCOUNT_DAY = Calendar.WEDNESDAY;

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

    public double totalTax() {
        double totalTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.salesTax();
            totalTax += salesTax;
        }
        return totalTax;
    }

    public double totalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            totalAmount += lineItem.total();
        }

        return totalAmount;
    }

    public double total() {
        if (isDiscount()) {
            return totalAmount() * DISCOUNT;
        }
        return totalAmount();
    }

    public String getLineItem() {
        StringBuilder result = new StringBuilder();

        for (LineItem lineItem : getLineItems()) {
            result.append(lineItem.print());
        }

        return result.toString();
    }

    public double discountMoney() {
        return totalAmount() * (1 - DISCOUNT);
    }

    public boolean isDiscount() {
        return DISCOUNT_DAY == getCurrentWeek(getDate());
    }
}
