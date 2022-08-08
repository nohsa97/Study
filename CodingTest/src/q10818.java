import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
//        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(s);
        int min = 0;
        int max = 0;
        int com = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 0; i < N ; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        if(arr.size() == 1){
            min = arr.get(0);
            max = arr.get(0);
        }

        else {
            min = arr.get(0);
            max = arr.get(0);
            for(Integer item : arr){
                com = item;
                if(min > com)
                    min = com;
                if(max < com)
                    max = com;
            }

        }

        System.out.println(min+" "+max);

    }
}
