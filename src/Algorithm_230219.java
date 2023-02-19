import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class Algorithm_230219 {
    public static void main(String[] args) {
        int[] queue1 = {10, 1, 1, 2};
        int[] queue2 = {1, 1, 1, 1};

        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] q1, int[] q2) {
        int sum1 = 0;
        int sum2 = 0;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < q1.length; i++) {
            sum1 += q1[i];
            sum2 += q2[i];
            queue1.add(q1[i]);
            queue2.add(q2[i]);
        }

        // 초기값부터 동일하면 종료
        if (sum1 == sum2) {
            return 0;
        }

        // 합이 홀수면 같은 값 둘로 나눌 수 없음
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int cnt = 0; // queue poll 횟수
        int element = 0;

        int idx = 0;
        while (true) {
            idx++;
            if (queue1.isEmpty() || queue2.isEmpty()) { // 같아질 수 없는
                return -1;
            }

            if (sum1 > sum2) { // 1번 배열이 더 크면 1번에서 빼서 2번에 넣기
                element = queue1.poll();

                sum1 -= element;
                sum2 += element;
                queue2.add(element);

                cnt++; // 횟수 증가

            } else if (sum1 < sum2) { // 2번 배열이 더 크면 2번에서 빼서 1번에 넣기
                element = queue2.poll();

                sum1 += element;
                sum2 -= element;
                queue1.add(element);

                cnt++; // 횟수 증가

            } else { // 1번과 2번이 같다면 종료
                return cnt;
            }
            System.out.println("sum1 : " + sum1 + ", sum2 : " + sum2);
        }
//        return -1;
    }
}
