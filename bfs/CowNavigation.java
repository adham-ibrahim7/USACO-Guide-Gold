import java.util.*;
import java.io.*;

public class CowNavigation {
	public static void main(String[] args) throws IOException {
		setIO();

		N = ni();
		blocked = new boolean[20][20];
		for (int i = 0; i < N; i++) {
			char[] s = rl().toCharArray();
			for (int j = 0; j < N; j++) {
				blocked[i][j] = s[j] == 'H';
			}
		}
		
		Queue<State> q = new LinkedList<>();
		q.add(new State(N-1, 0, 0, N-1, 0, 1));
		int[][][][][][] dp = new int[20][20][4][20][20][4];
		
		while (!q.isEmpty()) {
			State u = q.poll();
			//out.println(u);
			for (State v : new State[] {u.left(), u.right(), u.forward()}) {
				if (v.ai == 0 && v.bi == 0 && v.aj == N-1 && v.bj == N-1) {
					out.println(dp[v.ai][v.aj][v.ad][v.bi][v.bj][v.bd]);
					break;
				}
				
				if (dp[v.ai][v.aj][v.ad][v.bi][v.bj][v.bd] == 0) {
					q.add(v);
					dp[v.ai][v.aj][v.ad][v.bi][v.bj][v.bd] = dp[u.ai][u.aj][u.ad][u.bi][u.bj][u.bd] + 1;
				}
			}
		}
		
		f.close();
		out.close();
	}
	
	static int N;
	static boolean[][] blocked;
	
	static class State {
		int ai, aj, ad;
		int bi, bj, bd;
		
		State(int ax, int ay, int ad,
				int bx, int by, int bd) {
			this.ai = ax;
			this.aj = ay;
			this.ad = ad;
			this.bi = bx;
			this.bj = by;
			this.bd = bd;
		}
		
		State left() {
			return new State(ai, aj, (ad+1) % 4, bi, bj, (bd+1) % 4);
		}
		
		State right() {
			int nad = ad-1;
			if (nad == -1) nad += 4;
			int nbd = bd-1;
			if (nbd == -1) nbd += 4;
			return new State(ai, aj, nad, bi, bj, nbd);
		}
		
		//  1
		//2   0
		//  3
		static int[] di = {0, -1, 0, 1};
		static int[] dj = {1, 0, -1, 0};
		
		static boolean valid(int k) {
			return k >= 0 && k < N;
		}
		
		State forward() {
			int nai = ai;
		    int naj = aj;
		    if(nai != 0 || naj != N - 1){
		        if(nai + di[ad] >= 0 && naj + dj[ad] < N) {
		            nai += di[ad];
		        }
		        if(naj + dj[ad] >= 0 && naj + dj[ad] < N) {
		            naj += dj[ad];
		        }
		        if(blocked[nai][naj]){
		            nai = ai;
		            naj = aj;
		        }
		    }
		    int nbi = bi;
		    int nbj = bj;
		    if(nbi != 0 || nbj != N - 1){
		        if(nbi + di[bd] >= 0 && nbi + di[bd] < N) {
		            nbi += di[bd];
		        }
		        if(nbj + dj[bd] >= 0 && nbj + dj[bd] < N) {
		            nbj += dj[bd];
		        }
		        if(blocked[nbi][nbj]){
		            nbi = bi;
		            nbj = bj;
		        }
		    }
		    return new State(nai, naj, ad, nbi, nbj, bd);
		}
		
		public String toString() {
			return ai + " " + aj + " " + ad + " " + bi + " " + bj + " " + bd;
		}
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
