import java.util.ArrayList;
import java.util.List;


public class TenFrame extends Frame {
	int frameNumber;
	int rollcount = 0;
	
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
		
		if(rollcount == 4){
			throw new GameOverException("Game Over!!! 더이상 공을 던질 수 없습니다.");
		}
		
		if(point == 10){
			frame.set(rollIdx++,Symbol.STRIKE);
		}
		else super.setSymbol(point);
	}
}
