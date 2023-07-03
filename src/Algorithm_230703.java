import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
public class Algorithm_230703 {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int[][] scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int totalPicks = Arrays.stream(picks).sum();
        List<Mineral> list = new ArrayList<>();

        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPicks == 0) break; // 곡괭이의 갯수만큼 list에 묶을 것이기 때문에 그 외 나머지 광물은 list에 포함하지 않음

            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5; j++) { // 5개씩 한뭉치로 볼 것
                if (j == minerals.length) break;

                String mineral = minerals[j];
                int val = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0; // 다이아는 0 철은 1 돌은 2 index를 나타냄

                // 한묶음의 광물을 각각의 곡괭이로 캣을 경우의 점수를 각 변수에 더함
                dia += scoreBoard[0][val]; // 다이아곡괭이로 한묶음을 캣을 경우
                iron += scoreBoard[1][val]; // 철곡괭이로 한묶음을 캣을 경우
                stone += scoreBoard[2][val]; // 돌곡괭이로 한묶음을 캣을 경우
            }

            list.add(new Mineral(dia, iron, stone)); // 한묶음에 각 곡괭이로 소모되는 피로도
            totalPicks--; // 여기까지 하나의 곡괭이를 사용하는 한묶음
        }

        // 각 묶음을 돌곡괭이로 캣을 경우의 내림차순으로 정렬
        // 피로도 소모 비용이 비싼 광물 묶음 순으로 좋은 곡괭이로 소모하기 위함
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));

        for (Mineral m : list) { // 광물 5개가 한뭉치로 list로 묶여있음
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if (picks[0] > 0) { // 다이아 곡괭이로 먼저 피로도 정산
                answer += dia;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) { // 다이아 곡괭이가 0개면 철곡괭이 순서
                answer += iron;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }

    static class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

}
