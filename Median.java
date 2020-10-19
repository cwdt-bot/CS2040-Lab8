/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Median {
    //minHeap represents the half with larger elements
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //maxHeap represents the half with smaller elements
    PriorityQueue<Integer> maxHeap = new
    PriorityQueue<>(Comparator.reverseOrder());

    private void run() {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        while(queries-- > 0){
            if(sc.nextInt() == 1) this.insert(sc.nextInt());
            else this.median();
        }
        sc.close();
    }

    private void insert(int n) {
        //if both heaps are empty, add to larger size
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            minHeap.add(n);
            return;
        }
        //if we reach this point,minHeap has at least one element
        if (n < minHeap.peek()) maxHeap.add(n); //add to smaller
        else minHeap.add(n); //add to larger
        
        //resize the trees if sizes vary by >1
        //take the root of the larger heap and move it to the other heap
        int diff = minHeap.size() - maxHeap.size();
        if (diff < -1) {
            //smaller half is larger
            minHeap.add(maxHeap.poll());
        } else if (diff > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    //the middle elements of the list are the roots of the two heaps
    //if both heaps are same size, both roots are medians
    //if a heap is larger, than its root is the median
    public void median() {
        if (minHeap.size() + maxHeap.size() == 0) {
            System.out.println("None");
            return;
        }
        int diff = minHeap.size() - maxHeap.size();
        if (diff <= 0) System.out.print(maxHeap.peek());
        if (diff == 0) System.out.print(" ");
        if (diff >= 0) System.out.print(minHeap.peek());
        System.out.println();
    }

    public static void main(String args[]) {
        Median runner = new Median();
        runner.run();
    }
}
