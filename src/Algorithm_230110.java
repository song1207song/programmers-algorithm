import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
public class Algorithm_230110 {
    public static void main(String[] args) {

        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        System.out.println(solution(7, 3, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) { // 순차적으로 적군 배열 돌면서
            queue.add(e); // 역순 queue에 enemy 수 삽입
            answer++; // 클리어 횟수 증가
            n -= e; // 적군 무찌른 만큼 아군 수 감소
            if (n < 0) { // 아군 수가 0이하가 되면 무적권 사용
                if (k == 0) { // 무적권이 없으면
                    return answer - 1; // 클리어 횟수 롤백하고 리턴
                }
                n = n + queue.poll(); // 무적권을 사용하면 소모되었던 아군 수 롤백
                k--; // 무적권 사용
            }
        }

        return enemy.length; // 모두 무찔렀으면 전체 길이 리턴
    }
}
