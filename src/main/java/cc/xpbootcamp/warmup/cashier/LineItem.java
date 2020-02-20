package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.util.Util.formatMoney;

public class LineItem {
	private String description;
	private double price;
	private int quantity;
	private static final double RATE = .10d;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    public double totalAmount() {
        return price * quantity;
    }

    public double salesTax() {
		return totalAmount() * RATE;
	}

	public double total() {
		return totalAmount() + salesTax();
	}

    public String print() {
		return getDescription() +
				", " +
				formatMoney(getPrice()) +
				" * " +
				getQuantity() +
				", " +
				formatMoney(totalAmount()) +
				'\n';
	}
}
