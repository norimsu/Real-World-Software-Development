package bsa;

/**
 * 거래_요약
 */
@FunctionalInterface
public interface BankTransactionSummarizer {

	double summarize(double accumulator, BankTransaction bankTransaction);
}
