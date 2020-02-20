package cc.xpbootcamp.warmup.cashier;

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

        output.append("======老王超市，值得信赖======\n\r");

        output.append(getFormatDate(order.getDate()));

        output.append(order.getLineItem());

        output.append("--------------------------\n");

        output.append(order.amountInfo());

        return output.toString();
    }

}
