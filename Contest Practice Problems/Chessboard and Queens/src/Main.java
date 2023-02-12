// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[8][8];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        for(int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            board[i] = st.nextToken().toCharArray();
        }
        find(0, new int[] {1,1,1,1,1,1,1,1}, new int[8]);
        pw.println(count);
        pw.close();
    }

    public static void find(int row, int[] arr, int[] values) {


        if(row == 7) {
            if(check(values))
                count++;
            return;
        }

        for(int i = 0; i < 8;i++) {
            if(arr[i]>0) {
                arr[i]--;
                values[row]=i;
                if(row==6)
                    values[7]=28-values[0]-values[1]-values[2]-values[3]-values[4]-values[5]-values[6];
                find(row+1, arr,values);
                arr[i]++;
            }

        }
    }

    public static boolean check(int[] arr) {
        for(int i = 0; i < 8; i++) {
            if(board[i][arr[i]]=='*')
                return false;
            for(int x=0;x<8;x++) {
                if(x==i)
                    continue;
                if(Math.abs(i-x)==Math.abs(arr[i]-arr[x])) {
                    return false;
                }
            }
        }
        return true;
    }
}
