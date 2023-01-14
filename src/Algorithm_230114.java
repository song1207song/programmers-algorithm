/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */
public class Algorithm_230114 {
    public static void main(String[] args) {

        System.out.println(solution(16));
    }

    public static int solution(int storey) {
        if (storey == 0)
            return 0;

        if (storey % 10 == 0)
            return solution(storey / 10);

        if (storey < 10)
            return Math.min(storey, 11 - storey);

        int mod = storey % 10;

        int wayUp = 10 - mod + solution(storey + 10 - mod);
        int wayDown = mod + solution(storey - mod);

        return Math.min(wayUp, wayDown);
    }
}
