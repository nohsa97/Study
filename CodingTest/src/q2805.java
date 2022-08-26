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

        int [] arr = new int[N];

        s = bf.readLine();
        st = new StringTokenizer(s);



        for(int i=0; i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            if(arrMax<arr[i])
                arrMax=arr[i];
        }

        MAX = getMid(0,arrMax,arr,M);

        System.out.println(MAX);

    }


    public static int getMid(int low,int high,int[] arr,int M) {
        while(low<=high){
            int mid = (low+high)/2;
            long sum=0;
            for(int item : arr)
                if(item-mid>0)
                    sum += (item-mid);
            if(sum>=M)
                low=mid+1;
            else
                high=mid-1;
        }
        return high;
    }
}

// 20 15 10 17
// 10    10  5 0 7  22 >

//    public static int getMid(int low,int high,int[] arr,int M) {
//        int mid = 0;
////        if(getResult(arr,mid)>M){
////           return getMid(mid+1,high,arr,M);
////        }
////        else if (getResult(arr,mid)<M){
////           return getMid(low,mid,arr,M);
////        }
////        else if(getResult(arr,mid)==M)
////            return mid;
////        return -1;
//        while(low<=high){
//            int sum  = 0;
//            for(Integer item : arr)
//                if(item-mid > 0)
//                    sum += item-mid;
//            if(sum>=M){
//                low = mid+1;
//            }
//            else {
//                high = mid-1;
//            }
//            mid = (high+low)/2;
//        }
//        return mid;
//
//    }
//}