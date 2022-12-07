import java.util.*;
import java.io.*;

/*0. read in lines
*1. if line[1] != "1",
        push crate values onto stacks
    else
        done reading stacks
*2. read instructions
*    read next and throw away
    read nextInt -> number to move
    read next and throw away
    read nextInt -> move from
    read nextInt -> move to
3. carry out instruction
4. read top of stack and print result
*/

public class Day05 {
    
    public static void putStuffInStacks(String stuff, ArrayList<Stack<String>> stacks) {
        // stacks has the correct number of stacks
        int numStacks = stacks.size();
        for(int i =0; i < numStacks; i++){
            String box = stuff.substring(1+i*4,2+i*4);
            if(!box.equals(" ")){
                stacks.get(i).push(box);
            }
            
        }
    }

    public static void part1() throws IOException {
        ArrayList<Stack<String>> stacks = new ArrayList<Stack<String>>();
        Scanner in = new Scanner(new File("input.txt"));
        String line = in.nextLine();
        int numStacks = line.length() /4 + 1;

        for(int i = 0; i < numStacks; i++){
            stacks.add(new Stack<String>());
        }
        putStuffInStacks(line, stacks);
        System.out.println(stacks);
        boolean done = false;
        while(in.hasNext() && !done){
            line = in.nextLine();
            if(!line.substring(1,2).equals("1"))
                putStuffInStacks(line, stacks);
            else
                done = true;
        }

        for(Stack stack : stacks){
            Collections.reverse(stack);
        }

        in.nextLine();
        while(in.hasNext()) {
            System.out.println(stacks);
            in.next();
            int numToMove = in.nextInt();
            in.next();
            int moveFrom = in.nextInt()-1;
            in.next();
            int moveTo = in.nextInt()-1;

            Stack<String> boxes = new Stack<String>();
            for(int i = 0; i < numToMove; i++){
                String box = stacks.get(moveFrom).pop();
                stacks.get(moveTo).push(box);

            }

            while(!boxes.isEmpty()) {
                stacks.get(moveTo).push(boxes.pop());
            }

        }
        String result = "";
        for(Stack<String> stack : stacks) {
            result += stack.pop();
        }
        System.out.println(result);
    }
    

    public static void part2() throws IOException {
        ArrayList<Stack<String>> stacks = new ArrayList<Stack<String>>();
        Scanner in = new Scanner(new File("input.txt"));
        String line = in.nextLine();
        int numStacks = line.length() /4 + 1;

        for(int i = 0; i < numStacks; i++){
            stacks.add(new Stack<String>());
        }
        putStuffInStacks(line, stacks);
        System.out.println(stacks);
        boolean done = false;
        while(in.hasNext() && !done){
            line = in.nextLine();
            if(!line.substring(1,2).equals("1"))
                putStuffInStacks(line, stacks);
            else
                done = true;
        }

        for(Stack stack : stacks){
            Collections.reverse(stack);
        }

        in.nextLine();
        while(in.hasNext()) {
            System.out.println(stacks);
            in.next();
            int numToMove = in.nextInt();
            in.next();
            int moveFrom = in.nextInt()-1;
            in.next();
            int moveTo = in.nextInt()-1;

            Stack<String> boxes = new Stack<String>();
            for(int i = 0; i < numToMove; i++){
                String box = stacks.get(moveFrom).pop();
                stacks.get(moveTo).push(box);

            }

            while(!boxes.isEmpty()) {
                stacks.get(moveTo).push(boxes.pop());
            }

        }
        String result = "";
        for(Stack<String> stack : stacks) {
            result += stack.pop();
        }
        System.out.println(result);

    }

    public static void main(String...args) {
        try {
            part2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}