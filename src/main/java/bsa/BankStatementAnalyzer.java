package bsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

	public static final String RESOURCE = "src/main/resources/";

	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}

	public void analyzer(final String filename, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCE + filename);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}
}
