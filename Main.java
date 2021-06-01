import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    public static boolean seive(int n) {
        boolean[] prime = new boolean[n+1] ;
        prime[0] = false ;
        prime[1] = false ;
        for(int i=2 ; i<=n; i++) {
            prime[i] = true ;
        }
        for(int i=2; i*i<=n; i++) {
            if(prime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j] = false ;
                }
                prime[i] = false ;
            }
            
        }
        return prime[n] ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        int n = Integer.parseInt(read.readLine()) ;
        String[] str = read.readLine().trim().split(" ") ;
        int[] arr = new int[n] ;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]) ;
        }
        int count = 0 ;
        for(int i=0; i<n; i++) {
            int temp = arr[i] ;
            if(seive(temp) == false) {
                count++ ;
            }
        }
        System.out.println(count);   
 
    }
}