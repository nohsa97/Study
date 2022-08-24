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

        arr[1]=true;

        for(int i=2;i<=N;i++){
            for(int j=2*i;j<=N;j+=i)
                if(arr[j]==false)
                    arr[j]=true;
        }

        for(int j=M;j<=N;j++){
            if(arr[j]==false)
                System.out.println(j);
        }


        /*
        1 2 3 4 5 6 7 8 9 10
         */

    }
}


