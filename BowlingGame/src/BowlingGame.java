import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	int currentFrame = 1;
	int currentTry = 1;
	
	List<Frame> board = new ArrayList<Frame>();
	
	BowlingGame(){
		makeBoard();
	}

	private void makeBoard() {
		for(int i = 1; i <= 9; i++){
			board.add(new Frame(i));
			board.get(i-1).initializeFrame();
		}
		TenFrame temp = new TenFrame(10);
		temp.initializeTenFrame();
		board.add(temp);
	}

	public void getCurrentTry() {
		System.out.printf("%d Frame, %d차 시기 입니다.\n", currentFrame, currentTry);
	}

	public void roll(int point) throws GameOverException {
		
		board.get(currentFrame-1).setSymbol(point);
		
		currentTry++;
		
		if (currentFrame!= 10) {
			if (currentTry == 3 || point == 10) {
				currentFrame++;
				currentTry = 1;
			}
		}
	}
}
