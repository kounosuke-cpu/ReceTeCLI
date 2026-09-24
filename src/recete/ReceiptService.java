package recete;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReceiptService {

	private ArrayList<Receipt> receipts;

	public ReceiptService() {

		this.receipts = new ArrayList<>();

	}

	public void addReceipt(Receipt receipt) {

		receipts.add(receipt);

	}

	public void displayReceipts() {

		if (receipts.isEmpty()) {

			System.out.println("登録されているレシートはありません");

			return;

		}

		for (Receipt receipt : receipts) {

			receipt.showDetails();

		}
	}

	public Receipt findReceiptById(int receiptId) {

		for (Receipt receipt : receipts) {

			if (receipt.getReceiptId() == receiptId) {

				return receipt;

			}
		}
		return null;
	}

	public void updateReceipt(
			int receiptId,
			LocalDate newPurchaseDate,
			String newStoreName,
			String newPaymentMethod) {

		Receipt receipt = findReceiptById(receiptId);

		if (receipt == null) {
			System.out.println("指定されたレシートは見つかりません");
			return;
		}

		receipt.setPurchaseDate(newPurchaseDate);
		receipt.setStoreName(newStoreName);
		receipt.setPaymentMethod(newPaymentMethod);

		System.out.println("レシート情報を更新しました");
	}

	public void deleteReceipt(int receiptId) {

		Receipt receipt = findReceiptById(receiptId);

		if (receipt == null) {
			System.out.println("指定されたレシートは見つかりません");
			return;
		}

		receipts.remove(receipt);

		System.out.println("レシートを削除しました");
	}

	public int calculateAllExpenses() {

		int total = 0;

		for (Receipt receipt : receipts) {
			total = total + receipt.calculateTotal();
		}

		return total;
	}
}
