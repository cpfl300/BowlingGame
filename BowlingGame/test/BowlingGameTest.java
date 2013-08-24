import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

	BowlingGame play;

	public void setUp() {
		play = new BowlingGame();
	}

	public void testInitialize() throws Exception {
		play.getCurrentTry();
	}
	
	public void testRoll() throws Exception {
		
		try{
		play.getCurrentTry(); //1F 1R
		play.roll(1);
		
		play.getCurrentTry(); //1F 2R
		play.roll(4);
		
		play.getCurrentTry(); //2F 1R
		
		play.roll(10);
		play.getCurrentTry(); //3F 1R
		
		play.roll(10);
		play.getCurrentTry(); //4F 1R

		play.roll(10);
		play.getCurrentTry(); //5F 1R
		
		play.roll(10);
		play.getCurrentTry(); //6F 1R
		
		play.roll(10);
		play.getCurrentTry(); //7F 1R
		
		play.roll(10);
		play.getCurrentTry(); //8F 1R
		
		play.roll(10);
		play.getCurrentTry(); //9F 1R
		
		play.roll(10);
		play.getCurrentTry(); //10F 1R
		
		play.roll(3);
		play.getCurrentTry(); //10F 2R
		play.roll(3);
		play.getCurrentTry(); //10F 3R
		play.roll(3);
		play.getCurrentTry(); //10F 4R -> exception 발생
		
		fail("10 Frame 3roll까지만 투구가 가능하므로 그보다 많이 투구를 하면 exception발생");
		} catch (GameOverException e){
			assertEquals("Game Over!!!", e.getMessage());
		}
		
		
	}

}
