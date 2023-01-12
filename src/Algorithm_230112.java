/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
public class Algorithm_230112 {
    public static void main(String[] args) {

        System.out.println(solution(4, 6));
    }

    public static long solution(int k, int d) {
        double dd = Math.pow(d, 2); // d의 2승
        long answer = (int) (d / k) + 1;

        for (int i = k; i <= d; i += k) {
            double base = dd - Math.pow(i, 2);
            int sqrt = (int) Math.sqrt(base); // 제곱근
            answer += (int) (sqrt / k) + 1;
        }

        return answer;
    }
}
