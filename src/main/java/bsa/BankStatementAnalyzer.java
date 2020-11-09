package bsa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * 은행_명세서_분석기
 */
public class BankStatementAnalyzer {

	public static final String RESOURCE = "src/main/resources/";

	/**
	 * 분석 요약
	 *
	 * @param bankStatementProcessor 은행_명세서_프로세서
	 */
	private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
		System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalAmountInMonth(Month.FEBRUARY));
		System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}

	/**
	 * 분석
	 *
	 * @param filename 파일이름
	 * @param bankStatementParser 은행_명세서_파서
	 * @throws IOException 입출력예외
	 */
	public void analyzer(final String filename, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCE + filename);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}
}
