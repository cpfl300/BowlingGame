import java.util.ArrayList;

public class TenFrame extends Frame {
	int frameNumber;
	int rollcount = 0;
	int tenFrameRoll = 0;
	
	TenFrame(int frameNumber){
		super(frameNumber);
		this.frameNumber = frameNumber;
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
		
		if(tenFrameRoll == 1 && point != 10){
			rollcount++;
		}
		
		if(rollcount == 4){
			throw new GameOverException("Game Over!!! 더이상 공을 던질 수 없습니다.");
		}
		
		if(point == 10){
			System.out.println("STRIKE!!!");
			
			frame.set(rollIdx++,Symbol.STRIKE);
			scores.set(scoresIdx++, point);
			
		}
		else super.setSymbol(point);
		
		
		if(rollcount == 3) {
			throw new GameOverException("Game Over~");
		}
	}
	
}
