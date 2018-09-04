

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TestFrame extends TestCase {
    public TestFrame(String name) {
        super(name);
    }

    public void testNotThrowing() {
        Frame f = new Frame();
        assertEquals(0, f.getScore());
        assert (!f.isCompleted());
    }

    public void testOneThrowing() {
        Frame f = new Frame();
        f.addScore(5);
        assertEquals(5, f.getScore());
    }

    public void testCommon() {
        Frame f = new Frame();
        f.addScore(5);
        f.addScore(3);
        f.addScore(5);
        assertEquals(8, f.getScore());
        assertEquals(true, f.isCompleted());
    }

    public void testSpare() {
        Frame f = new Frame();
        f.addScore(4);
        f.addScore(6);
        f.addScore(10);
        assertEquals(20, f.getScore());
    }

    public void testStrike() {
        Frame f = new Frame();
        f.addScore(10);
        f.addScore(10);
        f.addScore(10);
        assertEquals(30, f.getScore());
    }
}