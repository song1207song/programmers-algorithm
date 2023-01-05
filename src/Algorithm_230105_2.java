import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * 크레인 인형 뽑기(Lv.1)
 */
public class Algorithm_230105_2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[] moves = {1, 4, 2, 2};

        solution(board, moves);
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 배열 가로 길이
        int horizontalSize = board[0].length;

        ArrayList<Integer> popList = new ArrayList<>();

        for (int element : moves) {
            for (int i = 0; i < horizontalSize; i++) {
                int value = board[i][element - 1];
                if (value != 0) {
                    popList.add(value);
                    board[i][element - 1] = 0;
                    break;
                }
            }
        }

        popList.forEach(System.out::println);

        int count = 0;
        boolean loop = true;

        while (loop) {
            if(popList.size() == 0) {
                break;
            }
            for (int i = 0; i < popList.size(); i++) {
                loop = false;

                if (i + 1 > popList.size() - 1) {
                    break;
                }

                if (popList.get(i).equals(popList.get(i + 1))) {
                    popList.remove(i + 1);
                    popList.remove(i);

                    System.out.println("size : " + popList.size());

                    count += 2;
                    loop = true;
                    break;
                }
            }
        }

        System.out.println("count : "+count);

        return answer;
    }
}
