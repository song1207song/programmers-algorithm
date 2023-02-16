import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class Algorithm_230216 {
    public static void main(String[] args) {

        int[] elements = {7, 9, 1, 1, 4};

        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int start = 1;
        while (start < elements.length) {
            for (int i = 0; i < elements.length; i++) { // 2중for문 돌면서 인접한 값 더하기
                int value = 0;
                for (int j = i; j < i + start; j++) {
                    value += elements[j % elements.length]; // 5 % 5 의 나머지는 0이니까 마지막 항목과 첫번째 인덱스를 찾을 수 있음
                }
                set.add(value);
            }
            start++; // 인접한 2개 다 돌렸으면 인접한 3개 돌리기
        }

        int sum = 0;
        for (int i = 0; i < elements.length; i++) { // 1개 짜리 여기서 추가함
            sum += elements[i];
        }

        set.add(sum);

        return set.size();

    }
}
