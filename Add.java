/**
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Add {
    PriorityQueue<Long> heap = new PriorityQueue<>();
    long counter = 0L;

    private void run() {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        while(queries-- > 0) {
            long q = sc.nextLong();
            if (q == 1) this.insertHeap(sc.nextLong());
            else if (q == 2) this.addAll(sc.nextLong());
            else this.min();
        }
        sc.close();
    }

    private void insertHeap(long n) {
        n = n-counter;
        heap.add(n);
    }

    private void addAll(long n) {
        counter += n;
    }

    private void min() {
        if (heap.isEmpty()) System.out.println("None");
        else {
            long curr = heap.poll();
            long val = curr += counter;
            System.out.println(val);
        }
    }

    public static void main(String args[]) {
        Add runner = new Add();
        runner.run();
    }
}
