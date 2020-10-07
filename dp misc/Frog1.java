import java.util.*;
import java.io.*;

public class Frog1 {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		int[] A = nia(N);
		int[] dp = new int[N];
		Arrays.fill(dp, 1000000000);
		dp[0] = 0;
		for (int i = 0; i < N-1; i++) {
			dp[i+1] = Math.min(dp[i+1], dp[i] + Math.abs(A[i+1] - A[i]));
			if (i < N-2)
				dp[i+2] = Math.min(dp[i+2], dp[i] + Math.abs(A[i+2] - A[i]));
		}
		out.println(dp[N-1]);
		
		f.close();
		out.close();
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static String rl() throws IOException {
		return f.readLine();
	}

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static long nlg(StringTokenizer st) {
		return Long.parseLong(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(rl());
	}

	static long nlg() throws IOException {
		return Long.parseLong(rl());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(rl());
	}

	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}

	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}

	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}

	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}

	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}

	static void setIO() {
		setIn();
		setOut();
	}
}
