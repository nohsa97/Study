import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        Stack<Integer> arr = new Stack();

        int K,input;
        int sum=0;
        K=Integer.parseInt(bf.readLine());

        for(int i=0 ; i<K ;i++){
            input = Integer.parseInt(bf.readLine());
            if(input!=0)
                arr.push(input);
            else
                arr.pop();
        }

        while(!arr.isEmpty()){
            sum+=arr.pop();
        }
        System.out.println(sum);
    }
}
