import java.util.*;
import java.io.*;

/**
 * The line of wines problem is as follows.
 * Given array A of wines, you aim to collect the maximum
 * total wine value. Every year, you take one wine of the left end
 * or the right end of the array, and a wine is only taken exactly once.
 * The value of a wine collected at year Y is Y * A[i].
 * 
 * https://youtu.be/pwpOC1dph6U
 */

public class LineOfWines {
	public static void main(String[] args) throws IOException {
		setIO();

		//int N = ni();
		//int[] A = nia(N);
		
		int N = 10;
		int[] A = new int[N];
		for (int i = 0; i < N; i++) A[i] = (int) (Math.random() * 20);
		out.println(N);
		for (int n : A) out.print(n + " ");
		out.println();
		
		int[][] dp = new int[N][N];
		int[][] prev = new int[N][N];
		
		for (int L = 0; L < N; L++) {
			for (int R = N-1; R >= L; R--) {
				int Y = L + (N-1-R);
				if (L > 0) {
					int left = dp[L-1][R] + A[L-1] * Y;
					if (left > dp[L][R]) {
						prev[L][R] = 0;
						dp[L][R] = left;
					}
				}
				
				if (R < N-1) {
					int right = dp[L][R+1] + A[R+1] * Y;
					if (right > dp[L][R]) {
						prev[L][R] = 1;
						dp[L][R] = right;
					}
				}
			}
		}
		
		/*for (int L = 0; L < N; L++) {
			for (int R = 0; R < N; R++) {
				out.print(dp[L][R] + " ");
			}
			out.println();
		}*/
		
		int ans = 0;
		Stack<Character> method = new Stack<>();
		for (int i = 0; i < N; i++) {
			int temp = dp[i][i] + A[i] * N;
			if (temp > ans) {
				ans = temp;
				
				method.clear();
				method.push('L');
				
				int L = i, R = i;
				while (R - L < N-1) {
					if (prev[L][R] == 0) {
						method.push('L');
						L--;
					} else {
						method.push('R');
						R++;
					}
				}
			}
		}
		
		out.println(ans);
		while (!method.isEmpty()) {
			out.print(method.pop() + " ");
		}
		out.println();
		
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
