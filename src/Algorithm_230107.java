/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
public class Algorithm_230107 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        int[][] board = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//
//        int[][] skill = {
//                {1, 1, 1, 2, 2, 4},
//                {1, 0, 0, 1, 1, 2},
//                {2, 2, 0, 2, 0, 100}};

        int[][] board = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}};
        int[][] skill = {
                {1, 0, 0, 3, 4, 4},
                {1, 2, 0, 2, 3, 2},
                {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}};

        solution(board, skill);
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            for (int j = r1; j <= r2; j++) {
                System.out.println("r1 : " + r1 + "/ r2 : " + r2);

                for (int k = c1; k <= c2; k++) {
                    System.out.println("(" + j + ", " + k + ")");

                    if (type == 1) {
                        board[j][k] -= degree;
                    } else {
                        board[j][k] += degree;
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }

        System.out.println(answer);

        return answer;
    }

    class Solution {
        public int solution(int[][] board, int[][] skill) {
            int r = board.length;
            int c = board[0].length;
            int sum[][] = new int[r + 1][c + 1];

            for (int i = 0; i < skill.length; i++) {
                play(sum, skill[i][0], skill[i][1], skill[i][2],
                        skill[i][3], skill[i][4], skill[i][5]);
            }
            return check(board, sum);
        }

        public int check(int[][] board, int[][] sum) {
            int check = 0;


            for (int j = 0; j < board[0].length; j++) {
                for (int i = 1; i < board.length; i++) {
                    sum[i][j] += sum[i - 1][j];
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 1; j < board[i].length; j++) {
                    sum[i][j] += sum[i][j - 1];
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] + sum[i][j] > 0) {
                        check++;
                    }
                }
            }
            return check;
        }

        public void play(int[][] sum, int type, int r1, int c1,
                         int r2, int c2, int degree) {
            degree *= type == 1 ? -1 : 1;
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
    }
}
