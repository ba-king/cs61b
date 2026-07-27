package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaxArrayDequeTest {

    /** 按整数正常大小比较。 */
    private static class IntegerComparator
            implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return Integer.compare(a, b);
        }
    }

    /** 按字符串字典序比较。 */
    private static class StringComparator
            implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    @Test
    public void testIntegerMax() {
        Comparator<Integer> integerComparator =
                new IntegerComparator();

        MaxArrayDeque<Integer> deque =
                new MaxArrayDeque<>(integerComparator);

        deque.addLast(5);
        deque.addLast(12);
        deque.addLast(8);
        deque.addFirst(3);

        assertEquals(Integer.valueOf(12), deque.max());
    }

    @Test
    public void testStringMax() {
        Comparator<String> stringComparator =
                new StringComparator();

        MaxArrayDeque<String> deque =
                new MaxArrayDeque<>(stringComparator);

        deque.addLast("apple");
        deque.addLast("banana");
        deque.addLast("orange");
        deque.addFirst("grape");

        assertEquals("orange", deque.max());
    }

    @Test
    public void testIntegerSingleItem() {
        MaxArrayDeque<Integer> deque =
                new MaxArrayDeque<>(new IntegerComparator());

        deque.addLast(7);

        assertEquals(Integer.valueOf(7), deque.max());
    }

    @Test
    public void testStringSingleItem() {
        MaxArrayDeque<String> deque =
                new MaxArrayDeque<>(new StringComparator());

        deque.addLast("hello");

        assertEquals("hello", deque.max());
    }

    @Test
    public void testIntegerEmptyDeque() {
        MaxArrayDeque<Integer> deque =
                new MaxArrayDeque<>(new IntegerComparator());

        assertNull(deque.max());
    }

    @Test
    public void testStringEmptyDeque() {
        MaxArrayDeque<String> deque =
                new MaxArrayDeque<>(new StringComparator());

        assertNull(deque.max());
    }

    @Test
    public void testDuplicateIntegerMaximum() {
        MaxArrayDeque<Integer> deque =
                new MaxArrayDeque<>(new IntegerComparator());

        deque.addLast(12);
        deque.addLast(5);
        deque.addLast(12);
        deque.addLast(8);

        assertEquals(Integer.valueOf(12), deque.max());
    }

    @Test
    public void testDuplicateStringMaximum() {
        MaxArrayDeque<String> deque =
                new MaxArrayDeque<>(new StringComparator());

        deque.addLast("zebra");
        deque.addLast("apple");
        deque.addLast("zebra");

        assertEquals("zebra", deque.max());
    }
}