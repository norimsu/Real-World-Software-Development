package bsa;

/**
 * 은행거래내역_필터
 */
@FunctionalInterface
public interface BankTransactionFilter {

	boolean test(BankTransaction bankTransaction);
}
