import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class Algorithm_230117 {
    public static void main(String[] args) {

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int[] one = new int[topping.length];
        int[] two = new int[topping.length];

        Set<Integer> oneTopping = new HashSet<>();
        Set<Integer> twoTopping = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            int twoIdx = topping.length - i - 1;
            oneTopping.add(topping[i]);
            twoTopping.add(topping[twoIdx]);
            one[i] = oneTopping.size();
            two[twoIdx] = twoTopping.size();
        }

        return (int) IntStream.range(0, topping.length - 1).filter(i -> one[i] == two[i + 1]).count();
    }

}
