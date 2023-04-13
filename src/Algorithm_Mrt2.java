import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 요약 : 배열과 인덱스가 같은 값 출력
 * 조건 : O(logN) 복잡도로 구현하기
 */
public class Algorithm_Mrt2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // System.out.println("Hello Goorm! Your input is " + input);

        String[] array = input.split(",");
        int[] sortedNum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedNum[i] = Integer.parseInt(array[i].trim());
        }

        int result = callYourFunction(sortedNum);
        // 아래 출력으로 채점을 하니 제출 전 다른 부분에서 출력은 제거해 주세요.
        System.out.println(result);

    }

    private static int callYourFunction(int[] sortedNum) {
        // 이 함수를 구현하시오.

        // 중간 인덱스의 값이 인덱스 수치보다 작으면 그 아래 배열은 버림
        // 중간 인덱스의 값이 인덱스 수치보다 크면 그 위 배열은 버림
        // 이것을 반복

        int i = 0; // 시작 index
        int j = sortedNum.length; // 끝 index
        int mid = 0; // 중간 index
        int result = -1;

        while (i <= j) {
            mid = (i + j) / 2;

            if (mid > sortedNum[mid]) {
                i = mid + 1;
            } else if (mid < sortedNum[mid]) {
                j = mid - 1;
            } else {
                result = mid;
                break;
            }
        }

        return result;
    }
}
