
public class BowlingGame {
	
	int currnetFrame = 1;
	int currentTry = 1;
	
	public void getCurrentTry() {
		System.out.printf("%d Frame, %d차 시기 입니다.\n", currnetFrame, currentTry);
	}

	public void roll(int point) {
		currentTry++;
		if(currentTry == 3 || point == 10){
			currnetFrame++;
			currentTry = 1;
		}
	}
}
