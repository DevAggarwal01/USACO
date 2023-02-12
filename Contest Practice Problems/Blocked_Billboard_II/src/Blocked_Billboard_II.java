import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Blocked_Billboard_II {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b_bl_x = Integer.valueOf(st.nextToken());
        int b_bl_y = Integer.valueOf(st.nextToken());
        int b_tr_x = Integer.valueOf(st.nextToken());
        int b_tr_y = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a_bl_x = Integer.valueOf(st.nextToken());
        int a_bl_y = Integer.valueOf(st.nextToken());
        int a_tr_x = Integer.valueOf(st.nextToken());
        int a_tr_y = Integer.valueOf(st.nextToken());

        int intersection = 0;
        if(a_tr_x<=b_bl_x||a_bl_x>=b_tr_x||a_tr_y<=b_bl_y||a_bl_y>=b_tr_y){ // intersection is false

        } else { // intersection is true
            if((a_bl_x<=b_bl_x&&a_tr_x>=b_tr_x) || (a_bl_y<=b_bl_y&&a_tr_y>=b_tr_y)) {
                int width = Math.min(a_tr_x, b_tr_x)-Math.max(a_bl_x, b_bl_x);
                int length = Math.min(a_tr_y, b_tr_y) - Math.max(a_bl_y, b_bl_y);
                intersection = width*length;
            }
        }
        int b_area = (b_tr_x-b_bl_x)*(b_tr_y-b_bl_y);
        pw.print(b_area-intersection);
        pw.close();
    }
}
