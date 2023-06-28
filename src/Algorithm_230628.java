import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870/solution_groups?language=java
 */
class Algorithm_230628 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};

        System.out.println(solution(sequence, 7));
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int len = sequence.length;

        int sum = sequence[0], startIdx = 0, endIdx = 0;

        List<Storage> storage = new ArrayList<>();


        while (true) {
            if (startIdx >= len && endIdx >= len) break;

            if (sum == k) { // 합이 같으면 저장소에 저장
                storage.add(new Storage(startIdx, endIdx));
            }

            if (sum <= k && endIdx < len) { // 같거나 작으면 endIdx를 늘리는 방향으로
                endIdx++;

                if (endIdx < len) sum += sequence[endIdx];

            } else { // 값이 커지면 startIdx를 옮김
                if (startIdx < len) {
                    sum -= sequence[startIdx];
                }
                startIdx++;
            }

        }

        storage.sort(Storage::compareTo);

        answer[0] = storage.get(0).startIdx;
        answer[1] = storage.get(0).endIdx;

        return answer;
    }


    static class Storage implements Comparable<Storage> {
        int startIdx;
        int endIdx;
        int size;

        Storage(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.size = endIdx - startIdx + 1;
        }

        @Override
        public int compareTo(Storage o) { // 배열의 길이를 우선으로 보되, 같은 사이즈라면 startIdx가 빠른 순서로
            if (this.size == o.size) {
                return this.startIdx - o.startIdx;
            }
            return this.size - o.size;
        }
    }


}