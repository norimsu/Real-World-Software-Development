package bsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;


class BankStatementCSVParserTest {

	private BankStatementParser statementParser = new BankStatementCSVParser();

	@Test
	void shouldParseOneCorrectLine() {
		//given
		String line = "30-01-2017,-50,Tesco";

		//when
		BankTransaction result = statementParser.parseFrom(line);

		//then
		BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		assertEquals(expected.getDate(), result.getDate());
		assertEquals(expected.getAmount(), result.getAmount());
		assertEquals(expected.getDescription(), result.getDescription());
	}
}