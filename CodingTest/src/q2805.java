import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2805 {

    public static void main(String[] args) throws IOException {
        int M,N;
        int MAX=0;
        int arrMax=0;
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



        for(int i=0; i<N;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            if(arrMax<arr.get(i))
                arrMax=arr.get(i);

        }

//        for(int i=0 ; i<arrMax;i++){
//            if((M==getResult(arr,i)) && MAX<getResult(arr,i)){
//                MAX=i;
//            }
//        }
        MAX = getMid(1,arrMax,arr,M);

        System.out.println(MAX);

    }

    public static int getResult(ArrayList<Integer> arr,int M) {
        int result=0;
        for(Integer item : arr)
            if(item-M > 0)
                result += item-M;
        return result;
    }

    public static int getMid(int low,int high,ArrayList<Integer> arr,int M) {
        int mid = (low+high)/ 2;
        if(getResult(arr,mid)>M){
           return getMid(mid+1,high,arr,M);
        }
        else if (getResult(arr,mid)<M){
           return getMid(low,mid,arr,M);
        }
        else if(getResult(arr,mid)==M)
            return mid;
        return -1;
    }
}

// 20 15 10 17
// 10    10  5 0 7  22 >