import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mixing_Milk {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int cap1 = Integer.valueOf(st.nextToken());
        int milk1 = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int cap2 = Integer.valueOf(st.nextToken());
        int milk2 = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int cap3 = Integer.valueOf(st.nextToken());
        int milk3 = Integer.valueOf(st.nextToken());
        for(int i = 1; i<=100; i++) {
            if(i%3==1) {
                milk2+=milk1;
                if(milk2>cap2) {
                    milk1=milk2-cap2;
                    milk2-=milk1;
                }
                else
                    milk1=0;
            }
            else if(i%3==2) {
                milk3+=milk2;
                if(milk3>cap3) {
                    milk2=milk3-cap3;
                    milk3-=milk2;
                }
                else
                    milk2=0;
            }
            else {
                milk1+=milk3;
                if(milk1>cap1) {
                    milk3=milk1-cap1;
                    milk1-=milk3;
                }
                else
                    milk3=0;
            }
        }
        pw.println(milk1);
        pw.println(milk2);
        pw.println(milk3);
        pw.close();
    }
}
