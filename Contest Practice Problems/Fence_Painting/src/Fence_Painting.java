import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fence_Painting {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());
        int e = 0;
        if(b<c)
            e=c-b;
        else if(d < a)
            e = a-d;
        pw.print(Math.max(a, Math.max(b, Math.max(c,d)))-Math.min(a, Math.min(b, Math.min(c, d)))-e);
        pw.close();
    }
}
