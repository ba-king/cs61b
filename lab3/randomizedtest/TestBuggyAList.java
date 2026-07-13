package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();

        for (int i = 0; i < 3; i++) {
            buggyAList.addLast(i + 4);
            aListNoResizing.addLast(i + 4);
        }

        for (int j = 0; j < 3; j++) {
            Integer expected = aListNoResizing.removeLast();
            Integer actual = buggyAList.removeLast();

            assertEquals(expected, actual);
            assertEquals(aListNoResizing.size(), buggyAList.size());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LB = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
//                System.out.println("addLast(" + randVal + ") for L");
                LB.addLast(randVal);
//                System.out.println("addLast(" + randVal + ") for LB");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
//                System.out.println("L size: " + size);

                int LB_size = LB.size();
//                System.out.println("LB size: " + LB_size);

                assertEquals(size, LB_size);
            } else if (operationNumber == 2) {
                // getlast
                if (L.size() > 0) {
                    int last = L.getLast();
//                    System.out.println("L getlast: " + last);

                    int LB_last = LB.getLast();
//                    System.out.println("LB getlast: " + LB_last);
                    assertEquals(last, LB_last);
                }
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() > 0) {
                    int rLast = L.removeLast();
//                    System.out.println("L removeLast: " + rLast);

                    int LB_rLast = LB.removeLast();
//                    System.out.println("LB removeLast: " + LB_rLast);
                }
            }
        }
    }
}
