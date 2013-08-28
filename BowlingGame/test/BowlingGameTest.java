import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

	BowlingGame play;
	

	@Override
	protected void setUp() throws Exception {
		play = new BowlingGame();
	}

	public void testInitialize() throws Exception {
		play.getCurrentTry();
	}

	public void testRoll() throws Exception {

		 try {
//		 play.getCurrentTry(); // 1F 1R
		 play.roll(1);
		
//		 play.getCurrentTry(); // 1F 2R
		 play.roll(4);
		
//		 play.getCurrentTry(); // 2F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 3F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 4F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 5F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 6F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 7F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 8F 1R
		
		 play.roll(10);
//		 play.getCurrentTry(); // 9F 1R
		
		 play.roll(10);
		 play.getCurrentTry(); // 10F 1R

		 play.roll(8);
		 play.getCurrentTry(); // 10F 2R
		
		 play.roll(2);
		 play.getCurrentTry(); // 10F 3R
		
//		 play.roll(8); // 10F 4T로 변수가 바뀜
		
		 fail("10 Frame 3roll까지 모든 투구를 완료 했으므로 GameOver");
		
		 } catch (GameOverException e) {
		 assertEquals("Game Over~", e.getMessage());
		 }
		
		 try {
		 play.roll(4);// 10F 4R -> exception 발생
		
		 fail("10 Frame 3roll까지만 투구가 가능하므로 그보다 많이 투구를 하면 exception발생");
		 } catch (GameOverException e) {
		 assertEquals("Game Over!!! 더이상 공을 던질 수 없습니다.", e.getMessage());
		 }
	}

	public void testPrintFrameNumber() throws Exception {
		for (int i = 0; i < play.board.size(); i++)
			assertEquals(i + 1, play.board.get(i).getFrameNumber());

	}

	public void testGetSymbol() throws Exception {
		play.roll(3);
		play.roll(6);
		play.getCurrentTry(); // 2F 1R
		assertEquals('3', play.board.get(0).frame.get(0).getSymbol());
		assertEquals('6', play.board.get(0).frame.get(1).getSymbol());

		play.roll(10);
		play.getCurrentTry(); // 3F 1R
		assertEquals('X', play.board.get(1).frame.get(0).getSymbol());
		assertEquals(' ', play.board.get(1).frame.get(1).getSymbol());

		play.roll(5);
		play.roll(5);
		play.getCurrentTry(); // 4F 1R
		assertEquals('5', play.board.get(2).frame.get(0).getSymbol());
		assertEquals('/', play.board.get(2).frame.get(1).getSymbol());

	}

}
