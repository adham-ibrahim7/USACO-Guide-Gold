import java.util.*;
import java.io.*;

public class CommonDivisors {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		int MAX = 1000000;
		int[] counts = new int[MAX+1];
		
		st = nl();
		for (int i = 0; i < N; i++) counts[ni(st)]++;
		
		for (int k = MAX; k >= 1; k--) {
			
			int count = 0;
			for (int i = k; i <= MAX; i += k) {
				count += counts[i];
			}
			
			if (count >= 2) {
				out.println(k);
				break;
			}
		}
		
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
