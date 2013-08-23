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
		play.getCurrentTry(); //1F 1R
		play.roll(1);
		
		play.getCurrentTry(); //1F 2R
		play.roll(4);
		
		play.getCurrentTry(); //2F 1R
		
		play.roll(10);
		play.getCurrentTry(); //3F 1R
		
	}

}
