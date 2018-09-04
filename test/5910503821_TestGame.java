

import junit.framework.TestCase;

import static org.junit.Assert.*;

public class TestGame extends TestCase {
    public TestGame(String name) {
        super(name);
    }

    public void testOneThrow() {
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.getScore());
    }

    public void testTwoThrowNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.getScore());
    }

    public void testFourThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.getScore());
        assertEquals(9, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
    }

    public void testSimpleSpare() {
        Game g = new Game();
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.getScoreForFrame(1));
    }

    public void testSimpleGameAfterSpare() {
        Game g = new Game();
        int[] input = { 3, 7, 3, 2 };
        for (int i = 0; i < input.length; i++) {
            g.add(input[i]);
        }
        assertEquals(13, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
        assertEquals(18, g.getScore());
    }

    public void testSimpleStrike() {
        Game g = new Game();
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19, g.getScoreForFrame(1));
        assertEquals(28, g.getScore());
    }

    public void testPerfectGame() {
        Game g = new Game();
        for (int i = 0; i < 12; i++) {
            g.add(10);
        }
        assertEquals(300, g.getScore());
        assertEquals(300, g.getScoreForFrame(10));
    }

    public void testEndOfArray() {
        Game g = new Game();
        for (int i = 0; i < 9; i++) {
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);
        assertEquals(20, g.getScore());
    }

    public void testSampleGame() {
        Game g = new Game();
        int[] input = { 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6 };
        for (int i = 0; i < input.length; i++) {
            g.add(input[i]);
        }
        assertEquals(133, g.getScore());
    }

    public void testHeartBreak() {
        Game g = new Game();
        for (int i = 0; i < 11; i++) {
            g.add(10);
        }
        g.add(9);
        assertEquals(299, g.getScore());
    }

    public void testTenthFrameSpare() {
        Game g = new Game();
        for (int i = 0; i < 9; i++) {
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);
        assertEquals(270, g.getScore());
    }

    public void testReal1() {
        Game g = new Game();
        int[] input = { 10, 10, 10, 10, 10, 10, 10, 10, 6, 4, 10, 10, 10 };
        for (int i = 0; i < input.length; i++) {
            g.add(input[i]);
        }
        assertEquals(276, g.getScore());
    }

    public void testReal2() {
        Game g = new Game();
        int[] input = { 0, 3, 8, 2, 7, 2, 0, 9, 9, 0, 10, 9, 1, 10, 0, 3, 0, 7 };
        for (int i = 0; i < input.length; i++) {
            g.add(input[i]);
        }
        assertEquals(110, g.getScore());
    }
}