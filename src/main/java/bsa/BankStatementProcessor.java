package bsa;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * 은행_명세서_프로세서
 */
public class BankStatementProcessor {

	private final List<BankTransaction> bankTransactions;

	public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	/**
	 * 거래_요약을 통해 거래내역 총_금액 계산하기
	 *
	 * @param bankTransactionSummarizer 거래_요약
	 * @return 총_금액
	 */
	public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for (BankTransaction bankTransaction : bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}

	/**
	 * 거래내역 총_금액 계산하기
	 *
	 * @return 총_금액
	 */
	public double calculateTotalAmount() {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	/**
	 * 특정_월의 거래내역 총_금액 계산하기
	 *
	 * @param month 특정_월
	 * @return 총_금액
	 */
	public double calculateTotalAmountInMonth(final Month month) {
		return summarizeTransactions((acc, bankTransaction) ->
				bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
	}

	/**
	 * 특정_범주의 거래내역 총_금액 얻기
	 * @param category 특정_범주
	 * @return 총_금액
	 */
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
	 * 거래_필터를 통해 거래내역 찾기
	 *
	 * @param bankTransactionFilter 거래_필터
	 * @return 거래내역
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

	/**
	 * 특정_금액 이상의 거래내역 찾기
	 *
	 * @param amount 특정_금액
	 * @return 거래내역
	 */
	public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
		return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
	}
}
