package bsa;

import java.io.IOException;

public class MainApplication {

	private MainApplication() {
	}

	public static void main(String[] args) throws IOException {

		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

		final BankStatementParser bankStatementParser = new BankStatementCSVParser();

		bankStatementAnalyzer.analyzer("bank-data-simple.csv", bankStatementParser);
	}
}
