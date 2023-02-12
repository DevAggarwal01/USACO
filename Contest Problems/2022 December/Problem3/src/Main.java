import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] input;
    static int[] output;
    static boolean[] visited;
    static int N;
    static int M;
    static PrintWriter pw;
    static boolean done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        for(int z = 0; z < testCases; z++) {
            br.readLine(); // at since test cases are separated by newlines
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            input = new int[M][N];
            visited = new boolean[N];
            done = false;
            output = new int[M];
            // store values in 2d array
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String x = st.nextToken();
                for(int y = 0; y < N; y++) {
                    input[i][y] = Integer.parseInt(x.substring(y,y+1));
                }
                output[i] = Integer.parseInt(st.nextToken());
            }
            HashSet<Integer> corr = new HashSet<>();
            for(int i = 0; i < N; i++) {
                visited[i]=true;
                find(N, i, corr);
                visited[i]=false;
            }
            if(z==1)
                pw.println("OK");
            else if(!done)
                pw.println("LIE");
        }

        pw.close();
    }
    public static void find(int count, int column, HashSet<Integer> correct) {
        if(!done) {
            if(count == 0) {
                correct.clear();
                return;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            boolean x = true;
            for(int i = 0; i < M; i++) {
                if(correct.contains(i))
                    continue;
                int y = input[i][column];
                if(!map.containsKey(y)) {
                    map.put(y,output[i]);
                }
                else if(map.get(y)!=output[i])
                    x = false;
                else {
                    correct.add(i);
                }
            }
            if(x == true) {
                done = true;
                pw.println("OK");
                return;
            }
            else {
                for(int i = 0; i < N; i++) { // permutation
                    if(!visited[i]) {
                        visited[i]=true;
                        find(count-1, i, correct);
                        visited[i]=false;
                    }
                    else if(count==1) {
                        find(0, i, correct);
                    }
                }
            }
        }

    }
}
