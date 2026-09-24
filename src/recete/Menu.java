package recete;

import java.time.LocalDate;

public class Menu {

	private ReceiptService receiptService;
	private InputUtil inputUtil;

	public Menu() {
		this.receiptService = new ReceiptService();
		this.inputUtil = new InputUtil();
	}

	public void showMenu() {

		while (true) {

			System.out.println("===== Rece-te =====");
			System.out.println("1. レシート登録");
			System.out.println("2. レシート一覧");
			System.out.println("3. ID検索");
			System.out.println("4. レシート更新");
			System.out.println("5. レシート削除");
			System.out.println("6. 合計金額表示");
			System.out.println("0. 終了");

			int choice = inputUtil.inputInt("番号を入力してください：");

			switch (choice) {

			case 1:
				registerReceipt();
				break;

			case 2:
				receiptService.displayReceipts();
				break;

			case 3:
				searchReceipt();
				break;

			case 4:
				updateReceipt();
				break;

			case 5:
				deleteReceipt();
				break;

			case 6:
				int total = receiptService.calculateAllExpenses();
				System.out.println("合計金額：" + total + "円");
				break;

			case 0:
				System.out.println("アプリを終了します");
				return;

			default:
				System.out.println("0から6の番号を入力してください");
				break;
			}

		}

	}

	private void registerReceipt() {

		int receiptId = inputUtil.inputInt("レシートID：");

		if (receiptService.findReceiptById(receiptId) != null) {
			System.out.println("同じIDのレシートが登録されています");
			return;
		}

		LocalDate purchaseDate = inputUtil.inputDate("購入日（例：2026-09-24）：");

		String storeName = inputUtil.inputString("店舗名：");

		String paymentMethod = inputUtil.inputString("支払い方法：");

		Receipt receipt = new Receipt(
				receiptId,
				purchaseDate,
				storeName,
				paymentMethod);

		int itemCount = inputUtil.inputInt("購入した商品の数：");

		for (int i = 0; i < itemCount; i++) {

			System.out.println("【" + (i + 1) + "件目の商品】");

			int itemId = inputUtil.inputInt("商品ID：");
			String itemName = inputUtil.inputString("商品名：");
			String category = inputUtil.inputString("カテゴリー：");
			int quantity = inputUtil.inputInt("数量：");
			int unitPrice = inputUtil.inputInt("単価：");

			PurchaseItem item = new PurchaseItem(
					itemId,
					itemName,
					category,
					quantity,
					unitPrice);

			receipt.addItem(item);
		}

		receiptService.addReceipt(receipt);
		System.out.println("レシートを登録しました");
	}

	private void searchReceipt() {

		int receiptId = inputUtil.inputInt("検索するレシートID：");

		Receipt receipt = receiptService.findReceiptById(receiptId);

		if (receipt == null) {
			System.out.println("指定されたレシートは見つかりません");
			return;
		}

		receipt.showDetails();
	}

	private void updateReceipt() {

		int receiptId = inputUtil.inputInt("更新するレシートID：");

		Receipt receipt = receiptService.findReceiptById(receiptId);

		if (receipt == null) {
			System.out.println("指定されたレシートは見つかりません");
			return;
		}

		LocalDate newPurchaseDate = inputUtil.inputDate("新しい購入日（例：2026-09-24）：");

		String newStoreName = inputUtil.inputString("新しい店舗名：");

		String newPaymentMethod = inputUtil.inputString("新しい支払い方法：");

		receiptService.updateReceipt(
				receiptId,
				newPurchaseDate,
				newStoreName,
				newPaymentMethod);
	}

	private void deleteReceipt() {

		int receiptId = inputUtil.inputInt("削除するレシートID：");

		receiptService.deleteReceipt(receiptId);
	}
}