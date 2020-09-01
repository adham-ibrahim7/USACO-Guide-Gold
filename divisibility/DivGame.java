import java.util.*;
import java.io.*;

public class DivGame {
	public static void main(String[] args) throws IOException {
		setIO();

		long N = nlg();
		
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				add(i);
				N /= i;
			}
		}
		
		if (N > 1) add(N);
		
		int ans = 0;
		for (long k : ms.keySet()) {
			int count = ms.get(k);
			int x = 1;
			while (count >= x) {
				ans++;
				count -= x;
				x++;
			}
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static TreeMap<Long, Integer> ms = new TreeMap<>();

	static void add(long x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}

	static long delete(long x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0)
			ms.remove(x);
		return x;
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
