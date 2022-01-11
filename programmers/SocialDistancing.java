package programmers;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/81302#fn1
public class SocialDistancing {
    // P = 사람
    // O = 빈 테이블
    // X = 파티션
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int tc = 0; tc < 5; ++tc) {
            String[] place = places[tc];
            boolean error = false;
            for (int r = 0; r < 5 && !error; ++r)
                for (int c = 0; c < 5; ++c)
                    if (place[r].charAt(c) == 'P')
                        if (!check(r, c, place)) {
                            error = true;
                            break;
                        }
            answer[tc] = error ? 0 : 1;
        }
        return answer;
    }

    private boolean check(int x, int y, String[] place) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;

                char c = place[nx].charAt(ny);
                int dist = Math.abs(x - nx) + Math.abs(y - ny);
                System.out.printf("nx %d x %d ny %d y %d d %d\n", nx, x, ny, y, dist);

                if (c == 'P' && dist <= 2)
                    return false;
                if (c == 'O' && dist < 2)
                    q.offer(new Pair(nx, ny));
            }
        }
        return true;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String[][] places = {
                {
                        "POOOP",
                        "OXXOX",
                        "OPXPX",
                        "OOXOX",
                        "POXXP"
                }, // 1
                {
                        "POOPX",
                        "OXPXP",
                        "PXXXO",
                        "OXXXO",
                        "OOOPP"
                }, // 0
                {
                        "PXOPX",
                        "OXOXP",
                        "OXPOX",
                        "OXXOP",
                        "PXPOX"
                }, // 1
                {
                        "OOOXX",
                        "XOOOX",
                        "OOOXX",
                        "OXOOX",
                        "OOOOO"
                }, // 1
                {
                        "PXPXP",
                        "XPXPX",
                        "PXPXP",
                        "XPXPX",
                        "PXPXP"
                } // 1
        };
        System.out.println(Arrays.toString(new SocialDistancing().solution(places)));
    }
}
