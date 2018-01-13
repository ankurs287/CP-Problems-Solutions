import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class J 
{
    public static long ncr(int n, int r, long[][] dp) 
    {
        if (dp[n - 1][r - 1] != -1) {
            return dp[n - 1][r - 1];
        }
        else if (n == r) {
            return 1;
        }
        else if (r == 1) {
            return n;
        }
        else {
            dp[n - 2][r - 1] = ncr(n - 1, r, dp);
            dp[n - 2][r - 2] = ncr(n - 1, r - 1, dp);
            dp[n - 1][r - 1] = (dp[n - 2][r - 1] + dp[n - 2][r - 2]) % 1000000007;
            return dp[n - 1][r - 1];
        }
    }

    public static long calc(int[] arr, int i, long[][] dp) {
        int l = i;
        int r = arr.length - i - 1;
        int min = Math.min(l, r);

        long cnt = 0;
        for (int j = 1; j <= min; j++) {
            cnt += arr[i] * ((ncr(l, j, dp) * ncr(r, j, dp)) % 1000000007);
            cnt %= 1000000007;
        }
        return cnt;
    }

	public static void main(String[] args) throws IOException {
	    Reader.init(System.in);

	    int t = Reader.nextInt();
	    while (t-- > 0) {
	    	int n = Reader.nextInt();
	    	int[] arr = new int[n];

	    	long cnt = 0;
	    	for (int i = 0; i < n; i++) {
	    		arr[i] = Reader.nextInt();
	    		cnt += arr[i];
	    	}
            cnt %= 1000000007;
	    	Arrays.sort(arr);
            long[][] dp = new long[2000][2000];
            for (int i = 0; i < 2000; i++) {
                for (int j = 0; j < 2000; j++) {
                    dp[i][j] = -1;
                }
            }

	    	for (int i = 1; i < n - 1; i++) {
                cnt += calc(arr, i, dp);
	    	}
            cnt %= 1000000007;

	    	System.out.println(cnt);
	    }
	}
}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
} 	
