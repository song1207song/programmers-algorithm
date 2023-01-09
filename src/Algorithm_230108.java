import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Algorithm_230108 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[][] jobs = {
                {0, 3},
                {1, 9},
                {2, 6}};


        System.out.println(solution(jobs));
    }


//    public static int solution(int[][] jobs) {
//        Arrays.sort(jobs, (o1, o2) -> o1[1] - o2[1]);
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
//
//        queue.offer(jobs[0]);
//        int end = jobs[0][0];
//        int sum = 0;
//        int idx = 1;
//
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            end += cur[1];
//            sum += end - cur[0];
//        }
//
//        while (idx < jobs.length && jobs[idx][0] <= end) {
//            queue.offer(jobs[idx++]);
//        }
//
//        if (idx < jobs.length && queue.isEmpty()) {
//            end = jobs[idx][0];
//            queue.offer(jobs[idx++]);
//        }
//
//        return sum / jobs.length;
//
//    }


    public static int solution(int[][] jobs) {
        int answer = 0;

        // 배열을 요청 우선순위대로 정렬한 다음에
        // sfj 알고리즘을 적용하여
        // 수행시간이 짧은 순서대로 요청을 처리해야한다


        // 작업이 요청되는 시점 기준으로 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0]));

        for (int i = 0; i < jobs.length; i++) {
            for (int j = 0; j < jobs[0].length; j++) {
                System.out.print(jobs[i][j] + " ");
            }
            System.out.println();
        }


        // 작업의 소요시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[0]));

        int jobs_index = 0; // 작업 배열 인덱스
        int finish_job = 0; // 처리 완료된 작업 개수
        int end_time = 0; // 작업 처리 완료 시간

        while (true) {
            if (finish_job == jobs.length) break; // 모든 작업을 처리했다면 종료

            // 이전 작업 처리 중 요청된 작업 add
            while (jobs_index < jobs.length && jobs[jobs_index][0] <= end_time) {
                pq.add(jobs[jobs_index++]);
            }

            if (!pq.isEmpty()) { // 이전 작업 처리 중 요청된 작업이 있는 경우
                int[] job = pq.poll();
                answer += end_time - job[0] + job[1]; // 작업 요청부터 종료까지 걸린 시간 추가
                end_time += job[1]; // 작업 처리 완료 시간 갱신
                finish_job++; // 처리 완료된 작업 개수 1 증가
            } else { // 이전 작업 처리 중 요청된 작업이 없는 경우
                end_time = jobs[jobs_index][0]; // 다음 작업 요청 시점으로 갱신
            }
        }

        return answer / jobs.length;
    }
}
