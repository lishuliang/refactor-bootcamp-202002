package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.util.Util.formatMoney;
import static cc.xpbootcamp.warmup.util.Util.getFormatDate;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(receiptHeader());

        output.append(order.getLineItem());

        output.append(receiptFooter());

        return output.toString();
    }

    public String receiptHeader() {
        StringBuilder result = new StringBuilder();

        result.append("======老王超市，值得信赖======\n\r");

        result.append(getFormatDate(order.getDate()));

        return result.toString();
    }

    public String receiptFooter() {
        StringBuilder result = new StringBuilder();

        result.append("--------------------------\n");

        result.append("税额: ").append(formatMoney(order.totalTax())).append('\n');

        if(order.isDiscount()) {
            result.append("折扣: ").append(formatMoney(order.discountMoney())).append('\n');

        }

        result.append("总价: ").append(formatMoney(order.total())).append('\n');

        return result.toString();
    }

}
