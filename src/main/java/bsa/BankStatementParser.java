package bsa;

import java.util.List;

/**
 * 은행_명세서_파서
 */
public interface BankStatementParser {

	BankTransaction parseFrom(String line);

	List<BankTransaction> parseLinesFrom(List<String> lines);
}
