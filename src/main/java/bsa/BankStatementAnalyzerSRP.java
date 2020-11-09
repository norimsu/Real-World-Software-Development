package bsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2. SRP
 * 2-1. 입력 읽기
 * 2-2. 주어진 형식의 입력 파싱
 * 2-3. 결과 처리
 * 2-4. 결과 요약 리포트
 */
public class BankStatementAnalyzerSRP {

	private static final String RESOURCES = "src/main/resources/";

	private BankStatementAnalyzerSRP() {
	}

	public static void main(String[] args) throws IOException {

		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

		// 2-1. 입력 읽기
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);

		// 2-2. 주어진 형식의 입력 파싱
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

		// 2-4. 결과 요약 리포트
		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY));
	}

	// 2-3. 결과 처리
	private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
	}

	// 2-3. 결과 처리
	private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions,
			final Month month) {
		return bankTransactions
				.stream()
				.filter(bankStatement -> month.equals(bankStatement.getDate().getMonth()))
				.collect(Collectors.toList());
	}
}
