import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q1546  {
    public static void main(String[] args) throws IOException {
        double N;
        double M;
        double change;
        double cur;
        double aver,sum=0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = new String();
        StringTokenizer st;

        ArrayList<Double> arr = new ArrayList<>();

        N=Integer.parseInt(bf.readLine());
        s=bf.readLine();
        st=new StringTokenizer(s);
        for(int i = 0 ; i < N ; i++)
            arr.add(Double.parseDouble(st.nextToken()));
        M=arr.get(0);


        for (Double item:arr)
            if(item > M)
                M=item;



        for(int i =0 ; i<arr.size() ; i++){
            cur = arr.get(i);
            change = (double) (cur/M)*100;
            arr.set(i,change);
        }

        for (Double item:arr)
            sum+=item;

        aver = sum/arr.size();

        System.out.println(aver);


    }
}
