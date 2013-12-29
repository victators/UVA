import java.io.*;
import java.util.*;

class EventPlanning {
    void run() throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader f = new BufferedReader(new FileReader(
        // "EventPlanning.in"));
        // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
        // "EventPlanning.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int minCost = Integer.MAX_VALUE;
            int[] prices = new int[h];
            int[][] beds = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(f.readLine());
                prices[i] = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(f.readLine());
                for (int j = 0; j < w; j++) {
                    int size = Integer.parseInt(st.nextToken());
                    beds[i][j] = size;
                    if (size >= n) {
                        if (minCost > prices[i] * n) {
                            minCost = prices[i] * n;
                        }
                    }
                }
            }
            if (minCost > b) {
                System.out.println("stay home");
            } else {
                System.out.println(minCost);
            }
            String s = f.readLine();
            if (s != null) {
                st = new StringTokenizer(s);
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        EventPlanning prog = new EventPlanning();
        prog.run();
    }
}
