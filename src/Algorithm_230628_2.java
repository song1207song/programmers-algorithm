import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class Algorithm_230628_2 {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int last = -1;
        for (int[] target : targets) {
            if (last == -1) {
                answer++;
                last = target[1] - 1;
                continue;
            }

            if (last >= target[0] && last <= target[1]) continue;

            answer++;
            last = target[1] - 1;
        }

        return answer;
    }

    /*
    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]); // endPoint 기준으로 정렬

        int len = targets.length;

        int i = len - 1;
        int j = i - 1;

        while (true) { // i>=0 && j>=0

            int sPoint = targets[i][0];

            int nextEndPoint = targets[j][1];

            System.out.println(sPoint + " " + nextEndPoint);

            if (sPoint >= nextEndPoint) { // 요격 한 세트 완료
                answer++;
                i = j;
                j--;

                System.out.println("!!!");

            } else {
                j--;
            }

            if (i < 0 || j < 0) {
                System.out.println(sPoint + " " + nextEndPoint);
                answer++;
                break;
            }

        }

        return answer;
    }
    */
}
