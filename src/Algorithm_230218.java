import java.util.HashSet;
import java.util.Set;

public class Algorithm_230218 {
    public static void main(String[] args) {

        // Set에 들어갈 값
        // 초기 노드 : 50, 75, 29
        // 뉴 노드 : 100, 54, 79, 58, 33, 87 -> 로 parentNode 초기화해서 다시 루프
        // 뉴뉴 노드 : 104 -> 결과!
        System.out.println(solution(25, 104, 4));
    }

    public static int solution(int x, int y, int n) {
        int result = 1;
        int currentNode = x;
        Set<Integer> nodeSet = new HashSet<>();

        // 처음에 x 가 y랑 같으면 0 리턴
        if (x == y) {
            return 0;
        }

        // 처음 nodeSet 만들기
        // 연산 1
        currentNode = x + n;
        if (currentNode < y) {
            nodeSet.add(currentNode);
        } else if (currentNode == y) {
            return 1;
        }

        // 연산 2
        currentNode = x * 3;
        if (currentNode < y) {
            nodeSet.add(currentNode);
        } else if (currentNode == y) {
            return 1;
        }

        // 연산 3
        currentNode = x * 2;
        if (currentNode < y) {
            nodeSet.add(currentNode);
        } else if (currentNode == y) {
            return 1;
        }

        // Set에 초기 노드 3가지를 넣고
        // while 돌리면서 3가지 연산 기능 한번씩 돌려보면서
        // 값이 목표수치보다 커지면 답이 아니니까 다음 연산으로 패스하고
        // 값이 작으면 노드에 추가하고
        // 값이 목표수치면 리턴

        // nodeSet에서 node확장
        mainLoop:
        while (true) {
            result += 1;

            Set<Integer> newNodeSet = new HashSet<>();

            nodeSetLoop:
            for (int parentNode : nodeSet) {

                // 연산 1
                currentNode = parentNode + n;

                if (currentNode < y) {
                    newNodeSet.add(currentNode);
                } else if (currentNode == y) {
                    break mainLoop;
                }

                // 연산 2
                currentNode = parentNode * 3;

                if (currentNode < y) {
                    newNodeSet.add(currentNode);
                } else if (currentNode == y) {
                    break mainLoop;
                }

                // 연산 3
                currentNode = parentNode * 2;

                if (currentNode < y) {
                    newNodeSet.add(currentNode);
                } else if (currentNode == y) {
                    break mainLoop;
                }

            }

            // 새로 생긴 노드가 없다면 -1을 리턴
            if (newNodeSet.size() == 0) {
                return -1;
            }

            // nodeSet 최신화
            nodeSet = newNodeSet;
        }

        return result;
    }
}
