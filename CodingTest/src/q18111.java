import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st;

        int N,M,B;

        s=bf.readLine();
        st=new StringTokenizer(s);
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        //n.m맵크기 b는 보유한 블록

        for(int i=0;i<N;i++){
            int j=0;
            s=bf.readLine();
            st=new StringTokenizer(s);
            while(st.hasMoreTokens()){
                arr[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        } // 배열생성




        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++){
                System.out.print(arr[i][j]+" ");
            }

        }

    }
}
