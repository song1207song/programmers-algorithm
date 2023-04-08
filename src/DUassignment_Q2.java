import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DUassignment_Q2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String result = solution(input);

        System.out.println(result);
    }

    // 문제 : 문자열을 입력 받아서 알파벳은 순서대로 정렬하여 출력하고 숫자는 더해서 붙여서 출력
    private static String solution(String input) {
        List<Character> characterList = new ArrayList<>();
        String returnValue = "";

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= '0' && c <= '9') {
                sum += Character.getNumericValue(c);
            } else { // 알파벳 문자
                char upperChar = Character.toUpperCase(c);
                characterList.add(upperChar);
            }
        }

        Collections.sort(characterList);

        for (int i = 0; i < characterList.size(); i++) {
            returnValue += characterList.get(i);
        }

        if (sum != 0) {
            returnValue += sum;
        }

        return returnValue;
    }

}
