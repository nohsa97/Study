import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        int M,N;
        int BC=0,WC=0;
        s=bf.readLine();
        st=new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String [][] arr = new String[N][M];


        for(int i=0; i<N;i++){
            s=bf.readLine();
            arr[i] = s.split("");
        }


        for(int i=0; i<N;i++){
            for(String item:arr[i]){
                if(item.equals("B"))
                    BC++;
                else
                    WC++;
            }
        }
        System.out.println(BC+"&"+WC);
    }
}
