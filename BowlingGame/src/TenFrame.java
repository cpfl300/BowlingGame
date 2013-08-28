import java.util.ArrayList;
import java.util.List;


public class TenFrame extends Frame {
	int frameNumber;
	int rollcount = 0;
	int tenFrameRoll = 0;
	protected int score = 0;
	
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
		}
		else super.setSymbol(point);
		
		this.score += point;
		
		if(rollcount == 3) {
			throw new GameOverException("Game Over~");
		}
	}
	
	public int getScore(){
		return this.score;
	}
}
