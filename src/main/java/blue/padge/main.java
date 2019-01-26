package blue.padge;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class main {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }

    }
}
