import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n,count=0;
        int input = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();


        n=Integer.parseInt(bf.readLine());
//        int[] arr = new int[n];


//        for(int i=0;i<n;i++)
//            arr[i]=Integer.parseInt(bf.readLine());
//
//    for(int i=0 ; i<n; i++){
//        for(;count<=n;count++){
//            if(!stack.isEmpty() && (stack.peek()==arr[i])){
//                stack.pop();
//                result = result.concat(minus);
////                if(stack.peek()==arr[i+1]){
////                    stack.pop();
////                    result = result.concat(minus);
////                    break;
////                }
//                break;
//            }
//            else {
//                stack.push(count);
//                result = result.concat(plus);
//            }
//
//
//        }
//        if(!stack.isEmpty() && stack.peek() > arr[i]){
//            result = "NO";
//            break;
//        }
//    }

        for(int i = 0 ; i<n ; i++){
            input = Integer.parseInt(bf.readLine());
            if(input > count){
                for(int j = count+1;j<=input;j++){
                    stack.push(j);
                    result.append("+"+"\n");
                }
                count = input;
            }
            else {
                if(stack.peek() != input){
                    System.out.println("NO");
                    return;
                }
            }
            stack.pop();
            result.append("-"+"\n");
        }

        System.out.println(result);

    }
}
