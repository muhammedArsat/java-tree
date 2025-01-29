import java.util.*;
public class SubArrayZerosOnes{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            int one = 0;
            int zero = 0;

            if(arr[i] == 0) zero++;
            else one++;

            for(int j = i+1; j < n;j++){
                if(arr[j] == 0) zero++;
                else one++;

                if(one == zero) ans++;
            }
        }

        System.out.print(ans);


    }
}
