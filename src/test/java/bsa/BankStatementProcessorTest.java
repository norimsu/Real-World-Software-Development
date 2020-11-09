package bsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class BankStatementProcessorTest {

	@Test
	void whenFilterTransactionInFebruary() {
		// given
		final BankTransaction februarySalary = new BankTransaction(LocalDate.of(2019, Month.FEBRUARY, 14), 2_000, "Salary");
		final BankTransaction marchRoyalties = new BankTransaction(LocalDate.of(2019, Month.MARCH, 20), 500, "Royalties");

		final List<BankTransaction> bankTransactions = Collections.unmodifiableList(Arrays.asList(februarySalary, marchRoyalties));

		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		// when
		final List<BankTransaction> transactions =
				bankStatementProcessor.findTransactions(bankTransaction ->
						bankTransaction.getDate().getMonth() == Month.FEBRUARY
								&& bankTransaction.getAmount() >= 1_000);

		//then
		assertTrue(transactions.contains(februarySalary));
		assertEquals(1, transactions.size());
	}
}