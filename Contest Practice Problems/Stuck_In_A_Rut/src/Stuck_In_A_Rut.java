import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stuck_In_A_Rut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cowNum = Integer.parseInt(st.nextToken());
        ArrayList<Cow> cows = new ArrayList<>();
        for(int i=0;i<cowNum;i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Cow(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        for(Cow first: cows) {
            int moves = Integer.MAX_VALUE;
            for(Cow second: cows) {
                if(first.x==second.x&&first.y==second.y) {
                    continue;
                }
                if(first.direction == second.direction) { // same direction, only matters if in same column or row
                    if(first.direction == 'E') { // east direction
                        if(first.y == second.y && first.x < second.x) {
                            moves = Math.min(moves, second.x- first.x);
                        }
                    }
                    else { // north direction
                        if(first.x == second.x && first.y < second.y) {
                            moves = Math.min(moves, second.y- first.y);
                        }
                    }
                }
                else { // diff directions
                    if(first.direction=='E'&&(first.y<second.y || first.x>second.x) )
                        continue;
                    else if(first.direction=='N'&&(first.x<second.x||first.y>second.y))
                        continue;
                    // discard if it doesn't intersect, has to be in right quadrant
                    int xDiff = Math.abs(second.x-first.x);
                    int yDiff = Math.abs(first.y- second.y);
                    if(first.direction=='E'&&xDiff>yDiff) {
                        moves = Math.min(moves,xDiff);
                    }
                    if(first.direction=='N'&&yDiff>xDiff) {
                        moves = Math.min(moves,yDiff);
                    }

                }
            }
            pw.println(moves);
        }
        pw.close();
    }
    public static class Cow {
        public char direction;
        public int x;
        public int y;
        public final int origX;
        public final int origY;

        public Cow (char a, int b, int c) {
            direction = a;
            x = b;
            origX=b;
            y=c;
            origY=c;
        }
    }
}
