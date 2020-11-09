package bsa;

import java.io.IOException;

/**
 * 3. SRP
 */
public class MainApplication {

	/**
	 * don't use by instance
	 */
	private MainApplication() {
	}

	public static void main(String[] args) throws IOException {

		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

		final BankStatementParser bankStatementParser = new BankStatementCSVParser();

		bankStatementAnalyzer.analyzer("bank-data-simple.csv", bankStatementParser);
	}
}
