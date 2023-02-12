import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {
    public static void main(String[] args) throws IOException {
        File file = new File("censor.out");
        FileWriter writer = new FileWriter(file);
        Scanner sc = new Scanner(new File("censor.in"));
        String line = sc.next();
        String remove = sc.next();
        String newLine = ""; // use StringBuilder instead

        for(int i = 0; i < line.length(); i++) {
            newLine += line.substring(i,i+1);
            if (newLine.length() > remove.length()) {
                if(newLine.substring(newLine.length()-remove.length()).equals(remove))
                    newLine = newLine.substring(0, newLine.length() - remove.length());
            }
        }


        writer.write(newLine);
        writer.close();

    }
}
