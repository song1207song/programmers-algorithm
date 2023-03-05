import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class Algorithm_230305 {
    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        String new_s = s;
        for (int i = 0; i < s.length(); i++) {
            if (checkString(new_s)) answer++;

            new_s = new_s.substring(1, s.length()) + new_s.charAt(0); // 왼쪽으로 회전 시켜서 다음 문자열로 만듦
        }

        return answer;
    }

    private static boolean checkString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) { // 문자열 길이만큼 loop
            try {
                switch (s.charAt(i)) {
                    case '[' -> stack.add('['); // 여는 괄호 스타일은 stack에 add
                    case ']' -> { // 닫는 괄호 스타일이 나오면 stack의 최상단이 한쌍일 경우 한쌍을 stack에서 꺼냄
                        if (stack.peek() != '[') return false;
                        stack.pop();
                    }
                    case '{' -> stack.add('{');
                    case '}' -> {
                        if (stack.peek() != '{') return false;
                        stack.pop();
                    }
                    case '(' -> stack.add('(');
                    case ')' -> {
                        if (stack.peek() != '(') return false;
                        stack.pop();
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return stack.isEmpty(); // stack을 모두 비워내면 쌍이 맞으므로 true
    }
}
