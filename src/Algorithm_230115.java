import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */
public class Algorithm_230115 {
    public static void main(String[] args) {

        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

        System.out.println(solution(arrayA, arrayB));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int aMin = getMin(arrayA);
        int aGcd = getArraysGcd(arrayA, aMin);

        int bMin = getMin(arrayB);
        int bGcd = getArraysGcd(arrayB, bMin);

        answer = getAnswer(aGcd, arrayB, answer);
        answer = getAnswer(bGcd, arrayA, answer);

        return answer;
    }

    private static int getAnswer(int gcd, int[] array, int answer) {
        for (int num : array) {
            if (num % gcd == 0) {
                return Math.max(answer, 0);
            }
        }
        return Math.max(answer, gcd);
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array)
                .reduce(Math::min)
                .getAsInt();
    }

    private static int getArraysGcd(int[] array, int min) {
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (isGcd(array, i)) {
                gcd = i;
            }
        }
        return gcd;
    }

    private static boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
}
