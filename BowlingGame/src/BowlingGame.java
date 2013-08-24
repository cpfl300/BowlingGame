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
		board.add(new Frame(1));
		board.add(new Frame(2));
		board.add(new Frame(3));
		board.add(new Frame(4));
		board.add(new Frame(5));
		board.add(new Frame(6));
		board.add(new Frame(7));
		board.add(new Frame(8));
		board.add(new Frame(9));
		board.add(new TenFrame(10));
	}

	public void getCurrentTry() {
		System.out.printf("%d Frame, %d차 시기 입니다.\n", currentFrame, currentTry);
	}

	public void roll(int point) throws GameOverException {
		
		if(currentFrame == 10 && currentTry == 4){
			throw new GameOverException("Game Over!!! 더이상 공을 던질 수 없습니다.");
		}
		
		System.out.printf("%d개의 핀을 쓰러뜨렸습니다.\n", point);
		currentTry++;
		
		if (currentFrame!= 10) {
			if (currentTry == 3 || point == 10) {
				currentFrame++;
				currentTry = 1;
			}
		}
		if (currentFrame == 10 && currentTry == 4) {
			throw new GameOverException("Game Over~");
		}
	}
}
