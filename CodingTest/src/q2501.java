import java.util.ArrayList;
import java.util.Scanner;

public class q2501 {

     public static void main(String[] args) {
        int p = 0;
        int q = 0;

         ArrayList<Integer> Array = new ArrayList<Integer>();

        int count = 0;

         Scanner s = new Scanner(System.in);
         p = s.nextInt();
         q = s.nextInt();
         for(int i = 1 ; i<=p ; i++){
             if(p%i==0)
                 Array.add(i);
         }
         if(q>Array.size()){
             System.out.println(0);
         }
         else
             System.out.println(Array.get(q-1));
    }
}
