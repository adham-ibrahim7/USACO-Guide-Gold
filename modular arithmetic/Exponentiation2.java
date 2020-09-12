import java.util.*;
import java.io.*;

public class Exponentiation2 {
	public static void main(String[] args) throws IOException {
		setIO();

		int T = ni();
		while (T-- > 0) {
			st = nl();
			int a = ni(st), b = ni(st), c = ni(st);
			out.println(modpow(a, modpow(b, c, 1000000006), 1000000007));
		}
		
		f.close();
		out.close();
	}
	
	static long modpow(long a, long b, long MOD) {
		a %= MOD;
		if (b == 0) return 1;
		long temp = modpow(a, b / 2, MOD);
		temp = temp * temp % MOD;
		if (b % 2 == 1) temp = temp * a % MOD;
		return temp;
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
