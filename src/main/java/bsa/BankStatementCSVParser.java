package bsa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV형식의 은행_명세서_파서
 */
public class BankStatementCSVParser implements BankStatementParser {

	public static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");

		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];

		return new BankTransaction(date, amount, description);
	}

	public List<BankTransaction> parseLinesFrom(final List<String> lines) {
		final ArrayList<BankTransaction> bankTransactions = new ArrayList<>();
		for (final String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
	}

}
