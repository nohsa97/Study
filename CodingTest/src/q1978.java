import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1978 {
    public static void main(String[] args) throws IOException {
        int N;
        int count=0;
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());


        s=bf.readLine();
        st = new StringTokenizer(s);

        for(int i = 0 ; i<N ; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        for(Integer item : arr){
            for(int i=2;i<=item;i++){
                if(item!=2 && item%i==0){
                    break;
                }
                else if(item==2 || i==(item-1)) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }
}
