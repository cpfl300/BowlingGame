import java.util.ArrayList;

public class TenFrame extends Frame {
	int frameNumber;
	public int rollcount = 0;
	int tenFrameRoll = 0;
	
	TenFrame(int frameNumber){
		super(frameNumber);
		this.frameNumber = frameNumber;
		initializeTenFrame();
	}
	
	int getFrameNumber(){
		return frameNumber;
	}
	
	public void initializeTenFrame(){
		frame = new ArrayList<Symbol>();
		frame.add(Symbol.BLANK);
		frame.add(Symbol.BLANK);
		frame.add(Symbol.BLANK);
		
		scores = new ArrayList<Integer>();
		scores.add(0);
		scores.add(0);
		scores.add(0);
	}	

	public void setSymbol(int point) throws GameOverException {
		rollcount++;
		tenFrameRoll++;
		
		if(tenFrameRoll == 1 && point != 10){ // 첫 Roll에 스트라이크가 나오지 않음 
			rollcount++;
		}
		
		if(rollcount == 4){
			throw new GameOverException("Game Over!!! 더이상 공을 던질 수 없습니다.");
		}
		
		if(point == 10){ // 스트라이크 일 때 
			frame.set(rollIdx++,Symbol.STRIKE);
			scores.set(scoresIdx++, point);
			
			System.out.println("STRIKE!!!");
		}
		else super.setSymbol(point);
		
		if(rollcount == 3) {
			throw new GameOverException("Game Over~");
		}
	}
	
}
