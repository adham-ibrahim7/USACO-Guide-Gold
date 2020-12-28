import java.util.*;
import java.io.*;

public class Lasers {
    public static void main(String[] args) throws IOException {
        setIO("lasers");

        st = nl();
        int N = ni(st), a = ni(st), b = ni(st), c = ni(st), d = ni(st);

        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = nl();
            int x = ni(st), y = ni(st);
            xMap.putIfAbsent(x, new LinkedList<>());
            yMap.putIfAbsent(y, new LinkedList<>());
            xMap.get(x).add(y);
            yMap.get(y).add(x);
        }

        Queue<State> q = new LinkedList<>();
        Map<State, Integer> visited = new HashMap<>();
        State s1 = new State(a, false);
        State s2 = new State(b, true);
        q.add(s1);
        q.add(s2);
        visited.put(s1, 0);
        visited.put(s2, 0);

        int ans = -1;
        while (!q.isEmpty()) {
            State curr = q.poll();

            if (curr.horiz && curr.coord == d ||
                !curr.horiz && curr.coord == c) {
                ans = visited.get(curr);
                break;
            }

            List<Integer> neighbors = !curr.horiz ? xMap.get(curr.coord) : yMap.get(curr.coord);

            if (neighbors != null) {
                for (int neigh : neighbors) {
                    State next = new State(neigh, !curr.horiz);
                    if (visited.containsKey(next)) continue;
                    visited.put(next, visited.get(curr) + 1);
                    q.add(next);
                }
            }
        }

        //out.println(visited);

        out.println(ans);

        f.close();
        out.close();
    }

    static class State {
        int coord;
        boolean horiz;

        State(int coord, boolean horiz) {
            this.coord = coord;
            this.horiz = horiz;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (horiz ? 1231 : 1237);
            result = prime * result + coord;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null)
                return false;
            if (getClass() != o.getClass())
                return false;
            State s = (State) o;
            return horiz == s.horiz && coord == s.coord;
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