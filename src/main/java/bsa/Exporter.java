package bsa;

public interface Exporter {

	/*
	- void 반환 형식은 아무 도움이 되지 않고, 기능을 파악하기도 어렵다.
	- void 를 반환하면 어서션으로 결과를 테스트하기도 매우 어렵다. 예상한 값과 실제 결과값을 어떻게 비교할까?
	 */
//	void export(SummaryStatistics summaryStatistics);
	String export(SummaryStatistics summaryStatistics);
}
