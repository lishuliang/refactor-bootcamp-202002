package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

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

    public String getLineItemInfo() {
		StringBuilder result = new StringBuilder();

		result.append(getDescription());
		result.append('\t');
		result.append(getPrice());
		result.append('\t');
		result.append(getQuantity());
		result.append('\t');
		result.append(totalAmount());
		result.append('\n');

		return result.toString();
	}
}
