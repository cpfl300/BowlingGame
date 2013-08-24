public class BowlingGame {

	int currentFrame = 1;
	int currentTry = 1;

	public void getCurrentTry() {
		System.out.printf("%d Frame, %d차 시기 입니다.\n", currentFrame, currentTry);
	}

	public void roll(int point) throws GameOverException {
		currentTry++;
		
		if(currentTry == 4){
			throw new GameOverException("Game Over!!!");
		}
		
		if (currentFrame!= 10) {
			if (currentTry == 3 || point == 10) {
				currentFrame++;
				currentTry = 1;
			}
		}
	}
}
