import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Monsters {
    public static void main(String[] args) throws IOException {
        setIO();

        st = nl();
        int N = ni(st);
        int M = ni(st);

        boolean[][] blocked = new boolean[N][M];

        int starti = 0, startj = 0;
        Queue<State> q = new LinkedList<>();
        int[][] minMonsterTime = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minMonsterTime[i], Integer.MAX_VALUE);

            String line = rl();
            for (int j = 0; j < M; j++) {
                blocked[i][j] = line.charAt(j) == '#';
                if (line.charAt(j) == 'M') {
                    q.add(new State(i, j, 0, 'X', null));
                    minMonsterTime[i][j] = 0;
                } else if (line.charAt(j) == 'A') {
                    starti = i;
                    startj = j;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.i < 0 || curr.i == N || curr.j < 0 || curr.j == M || visited[curr.i][curr.j] || blocked[curr.i][curr.j])
                continue;
            minMonsterTime[curr.i][curr.j] = Math.min(minMonsterTime[curr.i][curr.j], curr.t);
            visited[curr.i][curr.j] = true;
            q.addAll(curr.neighbors());
        }

        q.add(new State(starti, startj, 0, 'X', null));
        visited = new boolean[N][M];

        boolean found = false;
        while (!q.isEmpty()) {
            State curr = q.poll();
            if (visited[curr.i][curr.j] || blocked[curr.i][curr.j] || curr.t >= minMonsterTime[curr.i][curr.j])
                continue;
            if (curr.i == 0 || curr.i == N-1 || curr.j == 0 || curr.j == M-1) {
                out.println("YES\n" + curr.t);
                Stack<Character> s = new Stack<>();
                while (curr.prevDir != 'X') {
                    s.add(curr.prevDir);
                    curr = curr.prev;
                }
                while (!s.isEmpty()) out.print(s.pop());
                out.println();
                found = true;
                break;
            }
            visited[curr.i][curr.j] = true;
            q.addAll(curr.neighbors());
        }

        if (!found) out.println("NO");

        f.close();
        out.close();
    }

    static class State {
        int i, j, t;
        char prevDir;
        State prev;

        State(int i, int j, int t, char prevDir, State prev) {
            this.i = i;
            this.j = j;
            this.t = t;
            this.prevDir = prevDir;
            this.prev = prev;
        }

        List<State> neighbors() {
            List<State> neighbors = new ArrayList<>();
            neighbors.add(new State(i+1, j, t+1, 'D', this));
            neighbors.add(new State(i-1, j, t+1, 'U', this));
            neighbors.add(new State(i, j+1, t+1, 'R', this));
            neighbors.add(new State(i, j-1, t+1, 'L', this));
            return neighbors;
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