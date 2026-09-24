package recete;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

	private Scanner scanner;

	public InputUtil() {
		this.scanner = new Scanner(System.in);
	}

	public String inputString(String message) {

		System.out.print(message);
		return scanner.nextLine();

	}

	public int inputInt(String message) {

		while (true) {

			System.out.print(message);
			String input = scanner.nextLine();

			try {
				return Integer.parseInt(input);

			} catch (NumberFormatException e) {
				System.out.println("整数を入力してください");
			}
		}
	}

	public LocalDate inputDate(String message) {

		while (true) {

			System.out.print(message);
			String input = scanner.nextLine();

			try {
				return LocalDate.parse(input);

			} catch (DateTimeParseException e) {
				System.out.println("日付は2026-09-24の形式で入力してください");
			}
		}
	}
}