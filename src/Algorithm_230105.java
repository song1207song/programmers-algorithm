import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
 * 과일 장수
 */
public class Algorithm_230105 {

    class Solution1 {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);

            for (int i = score.length; i >= m; i -= m) {
                answer += score[i - m] * m;
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            // 내림차순 정렬
            // for (int i = 0; i < score.length; i++) {
            //     for (int j = i + 1; j < score.length; j++) {
            //         if (score[i] < score[j]) {
            //             int tmp = score[i];
            //             score[i] = score[j];
            //             score[j] = tmp;
            //         }
            //     }
            // }

            // mergeSort(0, score.length-1, score);

            Arrays.sort(score);

            int sum = 0;

            int boxCount = score.length / m; // 박스갯수

            for (int n = 0; n < boxCount; n++) { // 박수 수 만큼 for
                int min = 10; // 최대값 초과하는 값으로 초기화

                for (int o = n * m; o < n * m + m; o++) { // m번 만큼만 돌 것이다.
                    if (score[o] < min) {
                        min = score[o]; // 한 박스에서의 최소값 찾고
                    }
                }
                sum += min * m;
            }

            answer = sum;

            return answer;
        }

        public void mergeSort(int start, int end, int[] score) {
            int[] tmp = new int[score.length];

            if (start < end) {
                int mid = (start + end) / 2;
                mergeSort(start, mid, score);
                mergeSort(mid + 1, end, score);

                int p = start;
                int q = mid + 1;
                int idx = p;

                while (p <= mid || q <= end) {
                    if (q > end || (p <= mid && score[p] > score[q])) {
                        tmp[idx++] = score[p++];
                    } else {
                        tmp[idx++] = score[q++];
                    }
                }

                for (int i = start; i <= end; i++) {
                    score[i] = tmp[i];
                }
            }
        }
    }
}
