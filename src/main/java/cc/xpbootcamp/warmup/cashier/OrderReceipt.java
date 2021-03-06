package cc.xpbootcamp.warmup.cashier;

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

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        printOrderInfo(output);

        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalTax());

        // print total amount
        output.append("Total Amount").append('\t').append(totalTax() + totalGoodsMoney());
        return output.toString();
    }

    private double totalGoodsMoney() {
        double totalGoodsMoney = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalGoodsMoney += lineItem.totalAmount();
        }
        return totalGoodsMoney;
    }

    private double totalTax() {
        double totalTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalTax += salesTax;
        }
        return totalTax;
    }

    private void printOrderInfo(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
        }
    }
}
