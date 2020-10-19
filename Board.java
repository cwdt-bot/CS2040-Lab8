/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
 */

import java.util.*;

public class Board {
    private List<PriorityQueue<Cell>> rows = new ArrayList<>();
    private List<PriorityQueue<Cell>> cols = new ArrayList<>();
    private boolean[][] check;

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        check = new boolean[n][n];
        for (boolean[] row: check) {
            Arrays.fill(row, false);
        }
        for (int a = 0; a < n; a++) {
            rows.add(new PriorityQueue<Cell>());
            cols.add(new PriorityQueue<Cell>());
        }
        for(int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Cell  toAdd = new Cell(x,y,sc.nextInt());
                rows.get(x).add(toAdd);
                cols.get(y).add(toAdd);
            }
        }
        int q = sc.nextInt();
        while(q-->0) {
            String s = sc.next();
            int z = sc.nextInt()-1;
            this.query(s,z);
        }
    }

    public static void main(String args[]) {
        Board runner = new Board();
        runner.run();
    }

    private boolean isDeleted(Cell cell) {
        int row = cell.row();
        int col = cell.col();
        return check[row][col];
    }

    private void delete(Cell c) {
        check[c.row()][c.col()] = true;
    }

    //n is in zero indexing
    private void query(String s, int n) {
        PriorityQueue<Cell> curr = s.equals("R") ? rows.get(n) :
            cols.get(n);
        while (!curr.isEmpty()) {
            Cell cell = curr.poll();
            if (!this.isDeleted(cell)) {
                System.out.println(cell.val());
                this.delete(cell);
                return;
            }
        }
        System.out.println("None");
    }

    class Cell implements Comparable<Cell> {
        private final int x;
        private final int y;
        private final int val;

        public Cell(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.val = v;
        }

        //since we want largest at the top of heap, if larger, we want
        //a smaller return val for compareTo()
        public int compareTo(Cell other) {
            return other.val - this.val;
        }

        public int row() {
            return this.x;
        }

        public int col() {
            return this.y;
        }

        public int val() {
            return this.val;
        }
    }

}
