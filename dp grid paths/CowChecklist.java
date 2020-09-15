import java.util.*;
import java.io.*;

public class CowChecklist {
	public static void main(String[] args) throws IOException {
		setIO("checklist");
		
		st = nl();
		int H = ni(st), G = ni(st);
		int[] XH = new int[H];
		int[] YH = new int[H];
		int[] XG = new int[G];
		int[] YG = new int[G];
		
		//XH[0] = YH[0] = XG[0] = YG[0] = -1;
		
		for (int i = 0; i < H; i++) {
			st = nl();
			XH[i] = ni(st);
			YH[i] = ni(st);
		}
		
		for (int i = 0; i < G; i++) {
			st = nl();
			XG[i] = ni(st);
			YG[i] = ni(st);
		}
		
		long[][][] dp = new long[H+1][G+1][2];
		long INF = 1l << 60;
		for (int i = 0; i <= H; i++)
			for (int j = 0; j <= G; j++)
				for (int t = 0; t < 2; t++)
					dp[i][j][t] = INF;

		dp[1][0][0] = 0;
		
		for (int i = 0; i <= H; i++) {
			for (int j = 0; j <= G; j++) {
				for (int t = 0; t < 2; t++) {
					if(t == 0 && i == 0) continue;
					if(t == 1 && j == 0) continue;
					
					int x1 = t == 0 ? XH[i-1] : XG[j-1];
					int y1 = t == 0 ? YH[i-1] : YG[j-1];
					
					if (i < H) {
						dp[i+1][j][0] = Math.min(dp[i+1][j][0], dp[i][j][t] + cost(x1, y1, XH[i], YH[i]));
					}
					
					if (j < G) {
						dp[i][j+1][1] = Math.min(dp[i][j+1][1], dp[i][j][t] + cost(x1, y1, XG[j], YG[j]));
					}
				}
				
				//out.print((dp[i][j][0] == INF ? "INF" : dp[i][j][0]) + "/" + (dp[i][j][1] == INF ? "INF" : dp[i][j][1]) + " ");
			}
			//out.println();
		}
		
		out.println(dp[H][G][0]);

		f.close();
		out.close();
	}
	
	static int cost(int x1, int y1, int x2, int y2) {
		return (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2);
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
