import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q2042 {

        public static void main(String[] args) throws IOException {
        int N,M,K; // M숫자변경 K 구간합
        int sum= 0;
        int M_cont = 0;
        int K_cont = 0;
        int firstIn = 0;
        int secIn = 0;
        long thirIn = 0;

        ArrayList<Long> array = new ArrayList<>();
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String input = s.readLine();
        StringTokenizer inputs = new StringTokenizer(input);
            N = Integer.parseInt(inputs.nextToken());
            M = Integer.parseInt(inputs.nextToken());
            K = Integer.parseInt(inputs.nextToken());

        for (int i = 0 ; i<N ; i++)
            array.add(Long.parseLong(s.readLine()));

        while(!(K_cont+M_cont==K+M)){

           input = s.readLine();
           inputs = new StringTokenizer(input);
           firstIn = Integer.parseInt(inputs.nextToken());
           secIn = Integer.parseInt(inputs.nextToken());
           thirIn = Long.parseLong(inputs.nextToken());


            if(firstIn == 1){

                array.remove(secIn-1);

                array.add(secIn-1,thirIn);
                M_cont++;
            }
            if(firstIn==2){
                for(int j=secIn-1; j<thirIn;j++){
                    long cur = array.get(j);
                    sum+=cur;
                }
                System.out.println(sum);
                sum=0;
                K_cont++;
            }

        }
        s.close();
    }
}