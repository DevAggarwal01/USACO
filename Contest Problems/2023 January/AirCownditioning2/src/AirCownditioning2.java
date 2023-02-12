import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AirCownditioning2 {
    static int N;
    static int M;
    static int countMoney = Integer.MAX_VALUE;
    static int[][] cows;
    static int[][] AC;
    static int[] stalls;
    static boolean[] usedACs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());
        cows = new int[N][3];
        AC = new int[M][4];
        stalls = new int[100];
        usedACs = new boolean[M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken())-1; // start index of range
            cows[i][1] = Integer.parseInt(st.nextToken())-1; // end index of range
            cows[i][2] = Integer.parseInt(st.nextToken()); // least amount of cool down in all stalls of range
            for(int x = cows[i][0]; x <= cows[i][1]; x++) { // NOT SURE IF NEEDED, TIME COULD BE IMPROVED IF STOP CALLING ARRAY EACH TIME
                stalls[x] = cows[i][2];
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            AC[i][0] = Integer.parseInt(st.nextToken())-1; // start of index of range it cools
            AC[i][1] = Integer.parseInt(st.nextToken())-1; // end index of range
            AC[i][2] = Integer.parseInt(st.nextToken()); // amount of cool down
            AC[i][3] = Integer.parseInt(st.nextToken()); // price
        }
        for(int i = 0; i < M; i++) {
            int[] x = stalls.clone();
            usedACs[i]=true;
            countMoney = Math.min(countMoney, apply(i, 0, x));
            usedACs[i]=false;
        }
        pw.println(countMoney);
        pw.close();
    }
    public static int apply(int indexAC, int spent, int[] stallsArr) {
        if(done(stallsArr)) {
            return spent;
        }
        int[] aC = AC[indexAC];
        spent+=aC[3];
        int endIndex = aC[1];
        int cool = aC[2];
        for(int i = aC[0]; i <= endIndex; i++) {
            stallsArr[i] -= cool;
        }
        int minSpent = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            if(usedACs[i]==false) {
                usedACs[i]=true;
                int[] stallsArr2 = stallsArr.clone();
                minSpent = Math.min(minSpent, apply(i, spent, stallsArr2));
                usedACs[i]=false;
            }
        }
        return minSpent;
    }
    public static boolean done(int[] stallsArr) {
        for(int x : stallsArr) {
            if(x>0)
                return false;
        }
        return true;
    }
}
