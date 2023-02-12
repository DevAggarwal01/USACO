import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] orig;
    static int[] goal;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        orig = new int[N];
        goal = new int[N];
        for(int i = 0; i < N;i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N;i++) {
            orig[i] = Integer.parseInt(st.nextToken());
        }

    }

}
