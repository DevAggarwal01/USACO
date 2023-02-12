import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static String[] ans;
    static int N;
    static int K;
    static int count;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        for(int i =0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count=N;
            st = new StringTokenizer(br.readLine());
            ans = new String[N];
            str = st.nextToken();
            calculate();
            pw.println(count);
            for(String x: ans) {
                pw.print(x);
            }
            pw.println();
        }
        pw.close();
    }
    public static void calculate() {
        boolean[] visited = new boolean[N];
        ArrayList<String> patches = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            visited[i]=true;
            int max = i;
            for(int x = i+1; x <= 2*K+i && x<N; x++) {
                if(str.charAt(i)==str.charAt(x)&&visited[x]==false) {
                    visited[x]=true;
                    count--;
                    max = x;
                }
            }
            patches.add(str.substring(i,i+1));
            int x = (int) Math.round((i+max)/2.0);
            if(ans[x]==null)
                ans[x] = str.substring(i,i+1);
            else if(ans[x-1]==null)
                ans[x-1] = str.substring(i,i+1);
            else {
                ans[x+1] = str.substring(i,i+1);
            }
        }
        for(int y = 0; y < N; y++) {
            if(ans[y]==null)
                ans[y]=".";
        }

    }
}
