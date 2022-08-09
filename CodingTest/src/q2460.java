import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2460 {

    public static void main(String[] args) throws IOException {
        int max = 0;
        int cur = 0;
        int in,out;
        String input = new String();
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i =0 ; i < 10 ; i ++){
            input = bf.readLine();
            st = new StringTokenizer(input);
            out = Integer.parseInt(st.nextToken());
            in = Integer.parseInt(st.nextToken());
            cur += in;
            cur -= out;
            if(max < cur)
                max = cur;
//            System.out.println(cur);
        }
        System.out.println(max);

    }
}
