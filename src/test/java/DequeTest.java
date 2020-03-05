import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void addTail() {
        Deque<Integer> deque = new Deque<>();
        deque.addTail(4);
        deque.addTail(15);
        Assert.assertEquals(deque.size(), 2);
    }

    @Test
    public void removeFront() {
        Deque<Integer> deque = new Deque<>();
        Assert.assertEquals(deque.size(), 0);
        Assert.assertEquals(deque.removeFront(), null);
        deque.addTail(4);
        Assert.assertEquals((int)deque.removeFront(), 4);
        Assert.assertEquals(deque.size(), 0);
        deque.addTail(15);
        deque.addTail(1);
        deque.addTail(5);
        Assert.assertEquals(deque.size(), 3);
        Assert.assertEquals((int)deque.removeFront(), 15);
        Assert.assertEquals(deque.size(), 2);
    }


    @Test
    public void addFront() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(4);
        deque.addFront(15);
        Assert.assertEquals(deque.size(), 2);
    }

    @Test
    public void removeTail() {
        Deque<Integer> deque = new Deque<>();
        Assert.assertEquals(deque.size(), 0);
        Assert.assertEquals(deque.removeTail(), null);
        deque.addFront(4);
        Assert.assertEquals((int)deque.removeTail(), 4);
        Assert.assertEquals(deque.size(), 0);
        deque.addFront(15);
        deque.addTail(1);
        deque.addFront(5);
        Assert.assertEquals(deque.size(), 3);
        Assert.assertEquals((int)deque.removeFront(), 5);
        Assert.assertEquals((int)deque.removeTail(), 1);
        Assert.assertEquals(deque.size(), 1);
    }
}