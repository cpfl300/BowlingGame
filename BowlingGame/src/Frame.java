import java.util.ArrayList;
import java.util.List;


public class Frame {
	private int frameNumber;
	protected int rollIdx = 0;
	protected int scoresIdx = 0;
	private int point = 0;
	
	public List<Symbol> frame;
	public List<Integer> scores;
	
	Frame(int frameNumber){
		this.frameNumber = frameNumber;
	}
	
	int getFrameNumber(){
		return frameNumber;
	}

	public void initializeFrame(){
		frame = new ArrayList<Symbol>();
		
		frame.add(Symbol.BLANK);
		frame.add(Symbol.BLANK);
		
		scores = new ArrayList<Integer>();
		scores.add(0);
		scores.add(0);
	}	
	
	public void setSymbol(int point) throws GameOverException {
		
		scores.set(scoresIdx++, point);
		
		if(point == 10) {
			System.out.println("STRIKE!!!");
			
			frame.set(rollIdx++, Symbol.STRIKE);
			frame.set(rollIdx, Symbol.BLANK);
			this.point = point;
		}
		
		if(this.point != 10 && this.point + point == 10){
			System.out.println("SPARE!!!");
			
			frame.set(rollIdx, Symbol.SPARE);
			return;
		}

		this.point = point;
		
		System.out.printf("%d개의 핀을 쓰러뜨렸습니다.\n", point);
		
		switch (point) {
		case 9: 
			frame.set(rollIdx++, Symbol.NINE_POINT);
			break;
		case 8: 
			frame.set(rollIdx++, Symbol.EIGHT_POINT);
			break;
		case 7: 
			frame.set(rollIdx++, Symbol.SEVEN_POINT);
			break;
		case 6: 
			frame.set(rollIdx++, Symbol.SIX_POINT);
			break;
		case 5: 
			frame.set(rollIdx++, Symbol.FIVE_POINT);
			break;
		case 4: 
			frame.set(rollIdx++, Symbol.FOUR_POINT);
			break;
		case 3: 
			frame.set(rollIdx++, Symbol.THREE_POINT);
			break;
		case 2: 
			frame.set(rollIdx++, Symbol.TWO_POINT);
			break;
		case 1: 
			frame.set(rollIdx++, Symbol.ONE_POINT);
			break;
		case 0: 
			frame.set(rollIdx++, Symbol.GUTTER);
			break;
		}		
	}

	
	public List<Symbol> getFrame() {
		return frame;
	}
	
}
