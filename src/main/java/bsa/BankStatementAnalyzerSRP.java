package bsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementAnalyzerSRP {

	private static final String RESOURCES = "src/main/resources/";

	private BankStatementAnalyzerSRP() {
	}

	public static void main(String[] args) throws IOException {

		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
	}

	private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
	}

	private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
			final Month month) {
		return bankTransactions
				.stream()
				.filter(bankStatement -> month.equals(bankStatement.getDate().getMonth()))
				.collect(Collectors.toList());
	}
}
