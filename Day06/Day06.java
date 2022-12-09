import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day06 {


    public static void part1(int numChars) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));;
        String dataStream = in.nextLine();

        outerLoop:
        for(int i = 0; i < dataStream.length()-3; i++){
            String numWeAreChecking = dataStream.substring(i, i+numChars);
            char[] chars = numWeAreChecking.toCharArray();
            for(int p = 0; p < chars.length; p++) {
                for(int q = p+1; q < chars.length; q++) {
                    if (chars[p] == chars[q]) {
                        continue outerLoop;
                    }
                
                }
            }
            System.out.println(i+numChars);
            break;
        }
    }

    public static void part2() {

    }

    public static void main(String...args) {
        try {
            part1(14);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}