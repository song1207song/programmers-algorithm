/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120924
 * 다음에 올 숫자 (Lv.0)
 */

class Algorithm_230104 {
    public int solution(int[] common) {
        int answer = 0;

        int subtract1 = common[1] - common[0];
        int subtract2 = common[2] - common[1];

        if (subtract1 == subtract2) { // 등차
            answer = common[common.length - 1] + subtract1;

        } else { // 등비
            int division1 = common[1] / common[0];
            answer = common[common.length - 1] * division1;
        }

        return answer;
    }
}
