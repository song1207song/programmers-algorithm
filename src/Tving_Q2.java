/**
 * 문제 요약 : 3의 제곱수 조합으로 만들 수 있는 수치를 오름차순 정렬했을 때 n 번째 숫자는 무엇인가
 */
public class Tving_Q2 {
    public static void main(String[] args) {

        System.out.println(solution(4));
    }

    public static long solution(long n) {
        long answer = 0;

        // 1, 1개
        // 3,(1+3=4), 1+1개
        // 9,(1+9=10),(3+9=12),(1+3+9=13),  -> 1+2+1개
        //
        // 27,(1+27=28),(3+27=30),(1+3+27),(9+27),(1+9+27),(3+9+27),(1+3+9+27) -> 1+1+2+4개
        //
        // 1 ~ 3 ~ (1개) ~ 3*3 ~ (3개) ~ 3*3*3 ~ (1+1+1+1+3) ~ 3*3*3*3 ~ (1 +1 +1 +1 +3 +1+ 1+1+1+1+3)

        long m = 0;
        long i = n + 1;

        while (i >= 2) {
            i = i / 2;
            m = m + 1;
        }
        m = m + 1;

        long sum = 0;

        int k = 0;

        while (true) {
            if ((Math.pow(2, k) <= n + 1) && (Math.pow(2, k + 1) >= n + 1))
                break;
            else k++;
        }

        int r = (int) (n - ((int) Math.pow(2, k) - 1));

        sum = 0;
        i = 0;

        while (r > 1) {
            if (r % 2 == 1) {
                sum += Math.pow(3, i);
            }
            i++;
            r = (r - (r % 2)) / 2;
        }

        if (r == 1) {
            sum += Math.pow(3, i);
            System.out.println("sum = " + sum);
        }

        long result = (long) sum + (long) Math.pow(3, k) - 1;

        return result;
    }

}
