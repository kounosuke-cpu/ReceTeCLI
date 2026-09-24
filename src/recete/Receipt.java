package recete;

import java.time.LocalDate;
import java.util.ArrayList;

public class Receipt {
	private int receiptId;
	private LocalDate purchaseDate;
	private String storeName;
	private String paymentMethod;
	private ArrayList<PurchaseItem> items;

	public Receipt(
			int receiptId,
			LocalDate purchaseDate,
			String storeName,
			String paymentMethod) {

		this.receiptId = receiptId;
		this.purchaseDate = purchaseDate;
		this.storeName = storeName;
		this.paymentMethod = paymentMethod;
		this.items = new ArrayList<>();
	}

	public void addItem(PurchaseItem item) {
		items.add(item);
	}

	public int calculateTotal() {

		int total = 0;

		for (PurchaseItem item : items) {
			total = total + item.calculateSubtotal();
		}

		return total;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public ArrayList<PurchaseItem> getItems() {
		return items;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void showDetails() {

		System.out.println("===== レシート詳細 =====");
		System.out.println("レシートID：" + getReceiptId());
		System.out.println("購入日：" + getPurchaseDate());
		System.out.println("店舗名：" + getStoreName());
		System.out.println("支払い方法：" + getPaymentMethod());

		System.out.println("--- 購入商品 ---");

		if (items.isEmpty()) {

			System.out.println("購入商品は登録されていません");

		} else {

			for (PurchaseItem item : items) {

				item.showInfo();

			}
		}
		System.out.println("合計金額" + calculateTotal() + "円");
	}
}
