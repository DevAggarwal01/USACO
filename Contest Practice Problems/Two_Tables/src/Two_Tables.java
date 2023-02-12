import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/blog/entry/7018
public class Two_Tables {
    public static int[] room;
    public static int[] table2;
    public static int[] posTable1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int caseNum = Integer.valueOf(st.nextToken());
        for(int i = 0; i<caseNum; i++) {
            st=new StringTokenizer(br.readLine());
            room = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
            st=new StringTokenizer(br.readLine());
            posTable1 = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
            st=new StringTokenizer(br.readLine());
            table2 = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
            move(posTable1[0], posTable1[1]);
        }


    }

    public int[] move(int x, int y) {
        int[] down;
        int[] left;
        int[] right;
        int[] up;
        if(y>0) {
            down = move(x, y - 1);
        }
        if(x>0)
            left = move(x-1, y);
        if(x<room[0])
            right = move(x+1, y);
        if(y<room[1])
            up = move(x, y+1);
        boolean downIntersect = calc(down);
    }
    public boolean calc(int[] table1) {
        int b_tr_x = room[0]-table2[0];
        int b_bl_x = 0;
    }
}
