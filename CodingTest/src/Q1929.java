import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1929 {

    public static void main(String[] args) throws IOException {
        int M,N;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;


        boolean [] arr ;

        s = bf.readLine();
        st = new StringTokenizer(s);

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1];
// 1 번방법
//        for(int i = M ; i<=N ; i++){
//            for(int j=2;j<i;j++){
//                if(i%j==0){
//                    break;
//                }
//                else if(j==(i-1)){
//                    arr.add(i);
//                    break;
//                }
//
//            }
//        }

  

        for(int i=2;i<N;i++){
//            if(arr.contains(i))
//                continue;
//            else
                for(int j=2*i;j<=N;j+=i)
                    if(arr.contains(j)){
                        int index = arr.indexOf(j);
                        arr.remove(index);
                    }
        }
        for(Integer item : arr)
            System.out.println(item); 2번에 쓰임
        arr[1]=true;
//
//        for(int i = 2 ; i<=N;i++){
//          for(int j=2;i*j<=N;j++){
//              arr[i*j] = true;
//          }
//        }
//        for(int i=M;i<=N;i++){
//            if(arr[i]==false)
//                System.out.println(i);
//        }
    }
}


