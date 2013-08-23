import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

	BowlingGame play;

	public void setUp() {
		play = new BowlingGame();
	}

	public void testInitialize() throws Exception {
		play.getCurrentTry();
	}

}
