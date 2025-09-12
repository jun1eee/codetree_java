import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] move;        // 각 턴의 이동값
    static int[] position;    // 말들의 현재 위치(0 시작)
    static boolean[] finish;  // 각 말의 완주 여부
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        move = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) move[i] = Integer.parseInt(st.nextToken());

        position = new int[K];
        finish = new boolean[K];

        dfs(0);
        System.out.println(answer);
    }

    // turn번째 턴에서 어떤 말을 움직일지 선택
    static void dfs(int turn) {
        if (turn == N) {
            int done = 0;
            for (int i = 0; i < K; i++) if (finish[i]) done++;
            answer = Math.max(answer, done);
            return;
        }

        boolean movedThisTurn = false;
        for (int i = 0; i < K; i++) {
            if (finish[i]) continue;       // 완주한 말은 더 이상 못 움직임
            movedThisTurn = true;

            int prevPos = position[i];
            boolean prevFin = finish[i];

            position[i] += move[turn];
            if (position[i] >= M - 1) {    // 종점(0..M-1 기준)
                position[i] = M - 1;
                finish[i] = true;
            }

            dfs(turn + 1);

            // rollback
            position[i] = prevPos;
            finish[i] = prevFin;
        }

        // 모두 완주해서 움직일 수 있는 말이 없으면 턴만 진행
        if (!movedThisTurn) dfs(turn + 1);
    }
}
