import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 이중우선순위큐
 */
public class Algorithm_230106 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        solution(operations);
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> priorityQueueWithMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueWithMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] splitOther = operation.split(" ");

            if (splitOther[0].equals("I")) {
                priorityQueueWithMax.add(Integer.parseInt(splitOther[1]));
                priorityQueueWithMin.add(Integer.parseInt(splitOther[1]));
            }

            if (splitOther[0].equals("D")) {
                if (!priorityQueueWithMax.isEmpty()) {
                    if (splitOther[1].equals("1")) {
                        int max = priorityQueueWithMax.peek();
                        priorityQueueWithMax.remove(max);
                        priorityQueueWithMin.remove(max);

                    } else {
                        int min = priorityQueueWithMin.peek();
                        priorityQueueWithMax.remove(min);
                        priorityQueueWithMin.remove(min);
                    }
                }
            }

        }
        if (!priorityQueueWithMax.isEmpty()) {
            answer[0] = priorityQueueWithMax.peek();
            answer[1] = priorityQueueWithMin.peek();

        }

        System.out.println(answer[0] + answer[1]);

        return answer;
    }
}
