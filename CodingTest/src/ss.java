import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ss {
    public static void main(String[] args) {
        int M,N;
        double aver;
        Scanner S = new Scanner(System.in);
        M=S.nextInt();
        N=S.nextInt();
        aver = (double)M/N;
        System.out.println(aver);
    }
}
