package bsa;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

	private final List<BankTransaction> bankTransactions;

	public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	public double calculateTotalAmountInMonth(final Month month) {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public double calculateTotalForCategory(final String category) {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	/**
	 * 은행거래내역_필터를 통해 은행거래내역 찾기
	 *
	 * @param bankTransactionFilter 은행거래내역_필터
	 * @return 은행거래내역
	 */
	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
		final ArrayList<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
}
