import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
public class Algorithm_230228 {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};

        System.out.println(solution(weights));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        // (1,1) (2,3) (2,4) (3,4) (4,3) (4,2) (3,2) 의 경우의 수가 있음
        // 예시 180 * 2 --- 360 * 1
        Map<Integer, List<Integer>> hm = new HashMap<>();
        Set<Integer> mySet = new HashSet<>(); // 몸무게 배열에서 중복 제거

        for (int i = 0; i < weights.length; i++) { // e.g. {100=[0, 3], 180=[1], 360=[2], 270=[4]}
            if (!hm.containsKey(weights[i])) {
                List<Integer> myList = new ArrayList<>();
                myList.add(i);
                hm.put(weights[i], myList);
            } else {
                hm.get(weights[i]).add(i);
            }
            mySet.add(weights[i]);
        }

        for (int key : mySet) { // 중복제거한 몸무게 수 만큼 loop

            int dupli = hm.get(key).size(); // 중복된 몸무게가 있다면 몇개인지

            // 예를 들었을 때 100이 2번 자리에 앉을 경우
            // 건너편 3번 자리에는 100*2/3이 앉아야함
            // 해당 예시는 정수가 아니기 때문에 해당 케이스는 없음으로 결론 내릴 수 있음
            int wX2 = key * 2;
            if (wX2 % 3 == 0) { // 몸무게는 정수여야하기 때문임
                if (hm.containsKey(wX2 / 3)) {
                    answer += (long) hm.get(wX2 / 3).size() * dupli; // map에서 짝에 맞는 몸무게를 찾아 꺼내는 방식, 중복된 갯수만큼 결과값에 더해주기
                }
            }

            if (wX2 % 4 == 0) {
                if (hm.containsKey(wX2 / 4)) {
                    answer += (long) hm.get(wX2 / 4).size() * dupli;
                }
            }

            int wX3 = key * 3;
            if (wX3 % 2 == 0) {
                if (hm.containsKey(wX3 / 2)) {
                    answer += (long) hm.get(wX3 / 2).size() * dupli;
                }
            }

            if (wX3 % 4 == 0) {
                if (hm.containsKey(wX3 / 4)) {
                    answer += (long) hm.get(wX3 / 4).size() * dupli;
                }
            }

            // 180을 예로 들면 4번 자리에 앉았을 때
            // 건너편 2번 자리에는 180*4=x*2, 즉 360을 map에서 찾는다.
            int wX4 = key * 4;
            if (wX4 % 2 == 0) {
                if (hm.containsKey(wX4 / 2)) {
                    answer += (long) hm.get(wX4 / 2).size() * dupli;
                }
            }

            if (wX4 % 3 == 0) {
                if (hm.containsKey(wX4 / 3)) {
                    answer += (long) hm.get(wX4 / 3).size() * dupli;
                }
            }

            // 같은 몸무게가 있다면 세 명 있다면
            // 3*2/2
            if (dupli > 1) {
                answer += (long) dupli * (long) (dupli - 1) / 2;
            }

            hm.remove(key);

        }
        return answer;
    }
}
