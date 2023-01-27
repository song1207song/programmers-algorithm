/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
public class Algorithm_230127 {
    public static void main(String[] args) {

        int[] topping = {1, 3, 4, 6};

        System.out.println(solution(topping));
    }

    public static String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;
    }

}
