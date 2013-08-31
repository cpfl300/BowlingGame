import java.util.ArrayList;
import java.util.List;

public class Board {

	List<Frame> board = new ArrayList<Frame>();
	List<String> calculatedScore = new ArrayList<String>();

	int score;

	Board() {
		initializeCalculatedScore();
	}

	private void initializeCalculatedScore() {
		for (int i = 0; i < 10; i++) {
			calculatedScore.add(" ");
		}
	}

	protected void printScoreBoard() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%dFrame |", board.get(i).getFrameNumber());
		}
		System.out.println("");

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < board.get(i).frame.size(); j++) {
				System.out
						.printf("%2c ", board.get(i).frame.get(j).getSymbol());
			}
			System.out.print(" |");
		}

		System.out.println("");
		for (int i = 0; i < calculatedScore.size(); i++) {
			System.out.printf("%7s|", calculatedScore.get(i));
		}
	}

	protected void calculator(Frame fr){
		score = fr.getFramePoint();
		int frameNumber = fr.getFrameNumber();
		Frame nextFrame = null;
		
		
		if(frameNumber != 1 ) {
//			Frame preFrame = board.get(frameNumber-2);
			score += Integer.parseInt(calculatedScore.get(frameNumber-2));
		}
		if(frameNumber != 10){
			nextFrame = board.get(frameNumber);
		}
		// 스트라이크 일 때 점수계산
		if(fr.frame.get(0).getSymbol() == 'X' && frameNumber != 10){
			score += nextFrame.scores.get(0);
			if(nextFrame.frame.get(0).getSymbol() == 'X' && frameNumber != 9){
				score += board.get(frameNumber+1).scores.get(0);
			}
			else{
				score += nextFrame.scores.get(1);
			}
		}
		
		// 스페어 일 때 점수계산
		if(fr.frame.get(1).getSymbol() == '/' && frameNumber != 10) score += nextFrame.scores.get(0);
		
		calculatedScore.set(frameNumber-1, Integer.toString(score));
	}
}
