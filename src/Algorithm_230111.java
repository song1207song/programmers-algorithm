import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
public class Algorithm_230111 {
    public static void main(String[] args) {

        int[] order = {4, 3, 1, 2, 5};

        System.out.println(solution(order));
    }


    public static int solution(int[] order) {
        int index = 0;
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        boolean find = true;
        while (find) {
            find = false;
            if (!st.isEmpty() && st.peek() == order[answer]) {
                find = true;
                answer++;
                st.pop();
            } else if (index < order.length && order[answer] == index + 1) {
                find = true;
                answer++;
                index++;
            } else if (index < order.length) {
                find = true;
                index++;
                st.add(index);
            }
            if (answer == order.length) {
                break;
            }

        }
        return answer;
    }

//    public static int solution(int[] order) {
//        int answer = 0;
//
//        Stack<Integer> stack = new Stack<>();
//        int box = 1;
//        int boxIndex = 0;
//
//        while (true) {
//            if (order[boxIndex] == box) {
//                box++;
//                boxIndex++;
//                answer++;
//                continue;
//            }
//
//            if ((!stack.empty()) && stack.peek() == box) {
//                box++;
//                stack.pop();
//                boxIndex++;
//                answer++;
//                continue;
//            }
//
//            stack.push(box++);
//
//            if(stack.peek() > order[boxIndex]) {
//                break;
//            }
//
//            if(box > order[boxIndex]) {
//                break;
//            }
//
//            if(boxIndex > (order.length - 1)) {
//                break;
//            }
//        }
//
//        return answer;
//    }
}
