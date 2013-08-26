
public enum Symbol {
	STRIKE('X'), SPARE('/'), GUTTER('-'), 
	ONE_POINT('1'), TWO_POINT('2'), THREE_POINT('3'), 
	FOUR_POINT('4'), FIVE_POINT('5'), SIX_POINT('6'), 
	SEVEN_POINT('7'), EIGHT_POINT('8'), NINE_POINT('9'), 
	BLANK(' ');

	private char symbol;

	Symbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;

	}

}
