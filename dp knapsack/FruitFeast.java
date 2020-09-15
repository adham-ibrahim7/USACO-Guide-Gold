import java.util.*;
import java.io.*;

public class FruitFeast {
	public static void main(String[] args) throws IOException {
		setIO("feast");

		st = nl();
		int S = ni(st), A = ni(st), B = ni(st);
		boolean[] dp = new boolean[S+1];
		dp[0] = true;
		
		for (int s = 1; s <= S; s++) {
			if (s-A >= 0) dp[s] |= dp[s-A];
			if (s-B >= 0) dp[s] |= dp[s-B];
		}
		
		for (int s = 1; s <= S; s++) {
			if (dp[s]) dp[s / 2] = true;
		}
		
		int ans = 0;
		for (int s = 1; s <= S; s++) {
			if (s-A >= 0) dp[s] |= dp[s-A];
			if (s-B >= 0) dp[s] |= dp[s-B];
			if (dp[s]) ans = s;
		}
		
		out.println(ans);
		
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
