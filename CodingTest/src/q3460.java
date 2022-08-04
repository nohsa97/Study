import java.util.*;

public class q3460 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
//        ArrayList<Integer> inputList = new ArrayList<>();

        int n = 0 ;
        int T = 0 ;
        int cur = 0;
        int x = 0;

        T = s.nextInt();
        for(int i = 0; i<T;i++){
            n = s.nextInt();
            cur = 0;
            while(true){
                if(n==1 || n==0){
                    queue.add(1);
                    break;
                }
                else {
                    if(n%2==0){
                        n=n/2;
                        queue.add(0);
                    }
                    else {
                        n=n/2;
                        queue.add(1);
                    }
                }
            }
            while(!queue.isEmpty()){
                x=queue.poll();
                if(x==0){
                    cur+=1;
                }
                else {
                    System.out.print(cur+" ");
                    cur+=1;
                }
            }
        }
    }
}
