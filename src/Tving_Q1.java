/**
 * 문제 요약 : 2차원배열로 주어진 자리 배열에서 온풍기를 설치 했을 때 가장 사람이 많이 따뜻해지는 사람 수
 */
public class Tving_Q1 {
    public static void main(String[] args) {
        int[][] office = {};

        System.out.println(solution(office, 4));
    }

    public static long solution(int[][] office, int k) {
        int max = 0;
        int n = office.length;

        // 0부터 ~ N-1-k 만큼 가로길이로 서치
        // 0부터 ~ N-1-k 만큼 세로길이로 서치
        // 이중for 돌면서 사람 수 체크
        // 가장 큰 수가 나오면 교체 (max)

        for (int i = 0; i <= n - k; i++) { // 가로
            for (int j = 0; j <= n - k; j++) { // 세로
                int val = counting(i, j, k, office);
                if (max < val) {
                    max = val;
                }
            }
        }
        return max;
    }

    private static int counting(int i, int j, int k, int[][] office) {
        int sum = 0;

        for (int m = 0; m < k; m++) { // 온풍기 가로
            for (int l = 0; l < k; l++) { // 온풍기 세로
                sum += office[i + m][j + l];
            }
        }
        return sum;
    }
}
