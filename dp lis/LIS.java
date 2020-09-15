import java.util.*;
import java.io.*;

public class LIS {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		int[] A = nia(N);
		
		int[] d = new int[N+1];
		int INF = (int) 1e9;
		Arrays.fill(d, INF);
		d[0] = -INF;
		
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (int b = (N+1)/2; b >= 1; b /= 2) {
				while (j+b <= N && d[j+b] < A[i]) j += b;
			}
			d[j+1] = A[i];
		}
		
		int ans = 0;
		while (ans < N && d[ans+1] < INF) ans++;
		
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
