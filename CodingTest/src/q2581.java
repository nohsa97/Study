import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2581 {
    public static void main(String[] args)throws IOException {
        int M,N;
        int sum = 0;
        int min=0;
        int con = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        M=Integer.parseInt(bf.readLine());
        N=Integer.parseInt(bf.readLine());


           for(int i=M;i<=N;i++){
               for(int j=2;j<=i;j++){
                   if(i%j==0 && i!=2){
//                       System.out.println(j+"빼기실행");
                       break;
                   }
                   else if(j==(i-1) || i==2){
                       sum+=i;

                       if(con==0)
                           min=i;
                       con++;
                   }
               }
           }

        if(con==0){
            System.out.println(-1);
        }

        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
