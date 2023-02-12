import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.FieldPosition;
import java.util.StringTokenizer;

public class Blocked_Billboard {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a_bl_x = Integer.valueOf(st.nextToken());
        int a_bl_y = Integer.valueOf(st.nextToken());
        int a_tr_x = Integer.valueOf(st.nextToken());
        int a_tr_y = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b_bl_x = Integer.valueOf(st.nextToken());
        int b_bl_y = Integer.valueOf(st.nextToken());
        int b_tr_x = Integer.valueOf(st.nextToken());
        int b_tr_y = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c_bl_x = Integer.valueOf(st.nextToken());
        int c_bl_y = Integer.valueOf(st.nextToken());
        int c_tr_x = Integer.valueOf(st.nextToken());
        int c_tr_y = Integer.valueOf(st.nextToken());


        int intersected_area = 0;

        if(!(a_tr_x<=c_bl_x || c_tr_x<=a_bl_x || a_bl_y>=c_tr_y||c_bl_y>=a_tr_y)) {
            int length = Math.min(a_tr_y, c_tr_y) - Math.max(a_bl_y,c_bl_y);
            int width = Math.min(a_tr_x, c_tr_x) - Math.max(a_bl_x, c_bl_x);
            intersected_area += length*width;
        }
        if(!(b_tr_x<=c_bl_x || c_tr_x<=b_bl_x || b_bl_y>=c_tr_y||c_bl_y>=b_tr_y)) {
            int length = Math.min(b_tr_y, c_tr_y) - Math.max(b_bl_y,c_bl_y);
            int width = Math.min(b_tr_x, c_tr_x)- Math.max(b_bl_x, c_bl_x);
            intersected_area += length*width;
        }
        int area = (a_tr_x-a_bl_x)*(a_tr_y-a_bl_y) + (b_tr_x-b_bl_x)*(b_tr_y-b_bl_y);
        pw.print(area-intersected_area);
        pw.close();
    }
}
