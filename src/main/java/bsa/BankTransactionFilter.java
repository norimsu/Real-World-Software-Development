package bsa;

/**
 * 거래_필터
 */
@FunctionalInterface
public interface BankTransactionFilter {

	boolean test(BankTransaction bankTransaction);
}
