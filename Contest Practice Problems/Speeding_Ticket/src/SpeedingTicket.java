import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpeedingTicket {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int roadSegments = Integer.valueOf(st.nextToken());
        int speedSegments = Integer.valueOf(st.nextToken());
        int[] road = new int[100];
        int initDistance = 0;
        for(int i =0; i < roadSegments; i++) {
            st = new StringTokenizer(br.readLine());
            int dist = initDistance + Integer.valueOf(st.nextToken());
            int speedL = Integer.valueOf(st.nextToken());
            int x = initDistance;
            while (x < dist) {
                road[x] = speedL;
                x++;
            }
            initDistance=dist;
        }
        int maxSpeed = 0;
        // speed limits in
        // check mph every mile
        initDistance=0;
        for(int i = 0; i < speedSegments;i++) {
            st = new StringTokenizer(br.readLine());
            int dist = initDistance + Integer.valueOf(st.nextToken());
            int speed = Integer.valueOf(st.nextToken());
            int x = initDistance;
            while(x < dist) {
                maxSpeed = Math.max(speed-road[x], maxSpeed);
                x++;
            }
            initDistance=dist;
        }
        pw.println(maxSpeed);
        pw.close();
    }
}
