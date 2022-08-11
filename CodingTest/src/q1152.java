import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1152  {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;
        ArrayList<String> arr = new ArrayList<>();
        int N=0;

        s=bf.readLine();
        st = new StringTokenizer(s);

        while (st.hasMoreTokens())
            arr.add(st.nextToken());


        for (String str: arr
             ) {

            if(str!=null)
                N++;
        }

        System.out.println(N);
    }
}
