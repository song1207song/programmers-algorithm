import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제요약 : 같은 문자 사이 가장 큰 substring 사이즈르 구하시오
 */
public class MyRealTrip_Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // System.out.println("Hello Goorm! Your input is " + input);

        int length = callYourFucntion(input);
        // 아래 출력으로 채점을 하니 제출전 다른 부분에서 출력은 제거해 주세요.
        System.out.println(length);

    }

    private static int callYourFucntion(String input) {
        // 이 부분을 구현하시오.

        int inputLength = input.length();
        int max = -1;
        int subLength = 0;

        for (int i = 0; i < inputLength; i++) {
            char p = input.charAt(i);

            for (int j = inputLength - 1; j > i; j--) {
                if (p == input.charAt(j)) {
                    subLength = j - i - 1;

                    if (max < subLength) {
                        max = subLength;
                        break;
                    }
                }
            }
        }

        return max;

    }
}
