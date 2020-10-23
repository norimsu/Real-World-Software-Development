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
	 * 특정_금액 이상의 은행거래내역 찾기
	 *
	 * @param amount 특정_금액
	 * @return 은행거래내역
	 */
	public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
		final ArrayList<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getAmount() >= amount) {
				result.add(bankTransaction);
			}
		}
		return result;
	}

	/**
	 * 특정_월의 은행거래내역 찾기
	 *
	 * @param month 특정_월
	 * @return 은행거래내역
	 */
	public List<BankTransaction> findTransactionsInMonth(final Month month) {
		final ArrayList<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				result.add(bankTransaction);
			}
		}
		return result;
	}

	/**
	 * 특정_월 이나 특정_금액 으로 은행거래내역 찾기
	 *
	 * @param month  특정_월
	 * @param amount 특정_금액
	 * @return 은행거래내역
	 */
	public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
		final ArrayList<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
}
