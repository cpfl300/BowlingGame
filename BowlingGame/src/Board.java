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
				System.out.printf("%2c ", board.get(i).frame.get(j).getSymbol());
			}
			System.out.print(" |");
		}

		System.out.println("");
		for (int i = 0; i < calculatedScore.size(); i++) {
			System.out.printf("%7s|", calculatedScore.get(i));
		}
		System.out.println("");
		
	}

	protected void calculator(Frame fr){
		if(fr.frame.get(0).getSymbol() != 'X' &&
				fr.frame.get(1).getSymbol() == ' ') return;
		
		score = fr.getFramePoint();
		int frameNumber = fr.getFrameNumber();
		Frame nextFrame = null;
		
		
		if(frameNumber != 1 ) {
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
	
	public void callCalculator(){
		for(int i =0; i < 10; i++){
			Frame currentFrame = board.get(i);
			int curFrameNumber = currentFrame.getFrameNumber();
			int nextFrameNumber = curFrameNumber + 1;
			
			if(curFrameNumber != 10 && currentFrame.frame.get(0).getSymbol() == 'X'){ //스트라이크가 나옴 
				if(board.get(curFrameNumber).frame.get(0).getSymbol() == 'X' && board.get(nextFrameNumber).frame.get(0).getSymbol() != ' ') calculator(currentFrame);  //다음 프레임도 스트라이크 
					
				if(board.get(curFrameNumber).frame.get(1).getSymbol() != ' ') calculator(currentFrame); //다음프레임은 스트라이크가 아님 
			}
			if(curFrameNumber != 10 && currentFrame.frame.get(1).getSymbol() == '/'){ //스페어가 나왔다 
				if(board.get(curFrameNumber).frame.get(0).getSymbol() != ' ') calculator(currentFrame);
			}
			
			if(curFrameNumber == 10) { //10프레임 
				if(currentFrame.frame.get(2).getSymbol() != ' ') calculator(currentFrame); // 3번째 roll을 던졌으면 계산 
				if(currentFrame.frame.get(0).getSymbol() != 'X' && currentFrame.frame.get(1).getSymbol() != ' ') calculator(currentFrame);
			}
			
			
			if(currentFrame.frame.get(0).getSymbol() != 'X' && currentFrame.frame.get(1).getSymbol() != '/') calculator(currentFrame);
		}
	}
}
