import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Measurement {
    public static int[] b = new int[100];

    public static int[] e = new int[100];
    public static int[] m = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        int b = 7;
        int e = 7;
        int m = 7;
        int count = 0;
        String[][] days = new String[100][2];

        for(int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            days[x][0] = st.nextToken();
            days[x][1] = st.nextToken();
        }
        String winner = "bem";
        for (int i = 0; i < days.length; i++) {
            if(days[i][0] == null)
                continue;
            if(days[i][0].equals("Bessie")) {
                if(days[i][1].charAt(0) == '+')
                    b += Integer.parseInt(days[i][1].substring(1));
                else if(days[i][1].charAt(0) == '-')
                    b -= Integer.parseInt(days[i][1].substring(1));
            }
            if(days[i][0].equals("Elsie")) {
                if(days[i][1].charAt(0) == '+')
                    e += Integer.parseInt(days[i][1].substring(1));
                else if(days[i][1].charAt(0) == '-')
                    e -= Integer.parseInt(days[i][1].substring(1));
            }
            if(days[i][0].equals("Mildred")) {
                if(days[i][1].charAt(0) == '+')
                    m += Integer.parseInt(days[i][1].substring(1));
                else if(days[i][1].charAt(0) == '-')
                    m -= Integer.parseInt(days[i][1].substring(1));
            }

            String poster = greatest(b,e,m);
            if (!poster.equals(winner)) {
                count += 1;
                winner = poster;
            }
        }
        pw.print(count);
        pw.close();
    }
    public static String greatest(int b, int e, int m) {
        String poster = "";
        if(b == Math.max(b, Math.max(e, m)))
            poster += "b";
        if(e == Math.max(b, Math.max(e, m)))
            poster += "e";
        if(m == Math.max(b, Math.max(e, m)))
            poster += "m";
        return poster;
    }
}
