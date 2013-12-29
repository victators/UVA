import java.io.*;
import java.util.*;

class subrec {
    void run() throws IOException {
        // BufferedReader f = new BufferedReader(new
        // InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("subrec.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                "subrec.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n * n][n * n];
        int max = 0;
        for (int i = 0; i < n * n; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(f.readLine());
            }
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= i; j++) {
                if (j % n > i % n) {
                    continue;
                }
                if (i == 0 || i == j) {
                    sum[j][i] = temp;
                } else if (i == n) {
                    sum[j][i] = sum[j][0] + temp;
                } else if (j / n == i / n) {
                    sum[j][i] = sum[j][i - 1] + temp;
                } else if (j % n == i % n) {
                    sum[j][i] = sum[j][i - n] + temp;
                } else {
                    sum[j][i] = sum[j][i - 1] + sum[j][i - n]
                            - sum[j][i - n - 1] + temp;
                }
                if (max < sum[j][i]) {
                    max = sum[j][i];
                }
            }
        }
        System.out.println(max);
        out.close();
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        subrec prog = new subrec();
        prog.run();
    }
}
