package nav.cerner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ques3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StackArray myStack;
        StringBuilder result = new StringBuilder();
        while ((s = in.readLine()) != null) {
            result.setLength(0);
            myStack = new StackArray<>();
            String[] inputArr = s.split(" ");
            for(String ip : inputArr) {
                myStack.push(Integer.parseInt(ip.trim()));
            }
            while(myStack.getSize() > 0) {
                result = result.append(myStack.pop() + " ");
                if(myStack.getSize() > 0) {
                    myStack.pop();
                }
            }
            System.out.println(result.toString().trim());
        }
    }

    interface Stack<Integer> {
        void push(int element);
        int pop();
        int getSize();
    }

    static class StackArray<Integer> implements Stack<Integer> {

        private List<java.lang.Integer> arr;

        public StackArray() {
            arr = new ArrayList<>();
        }

        public void push(int element) {
            arr.add(element);
        }

        public int getSize() {
            return arr.size();
        }

        public int pop() {
            if(arr.size() > 0) {
                int value = (int) arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                return value;
            }
            return -1;
        }
    }
}
