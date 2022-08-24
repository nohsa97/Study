import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2805 {

    public static void main(String[] args) throws IOException {
        int M,N;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;

        s = bf.readLine();
        st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        s = bf.readLine();
        st = new StringTokenizer(s);

        for(int i=0;i<N;i++)
            arr.add(Integer.parseInt(st.nextToken()));

//        int result = get(arr,15);
//        System.out.println(result);


    }

    public static int get(ArrayList<Integer> arr,int M) {
        int result=0;
        for(Integer item : arr)
            if(item-M > 0)
                result += item-M;
        return result;
    }
    public static void arrget(ArrayList<Integer> arr,int M) {


    }
}
