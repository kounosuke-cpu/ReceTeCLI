package recete;

public class PurchaseItem {

	private int itemId;
	private String itemName;
	private String category;
	private int quantity;
	private int unitPrice;

	public PurchaseItem(
			int itemId,
			String itemName,
			String category,
			int quantity,
			int unitPrice) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int calculateSubtotal() {
		return quantity * unitPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String getCategory() {
		return category;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void showInfo() {
		System.out.println("商品Id：" + getItemId());
		System.out.println("商品名：" + getItemName());
		System.out.println("カテゴリー：" + getCategory());
		System.out.println("数量：" + getQuantity());
		System.out.println("単価：" + getUnitPrice() + "円");
		System.out.println("小計：" + calculateSubtotal() + "円");
	}
}
