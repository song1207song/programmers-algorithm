import java.util.*;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class Algorithm_230109 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }

//    public static int solution(int k, int[] tangerine) {
//        List<Integer> list = Arrays.stream(tangerine).boxed().toList();
//
//        Collection<Long> values = list.stream()
//                .collect(Collectors.groupingBy(arg -> arg, HashMap::new, Collectors.counting())).values();
//
//        List<Long> result = values.stream().sorted(Comparator.reverseOrder()).toList();
//
//        int count = 0;
//        int sum = 0;
//
//        while (result.iterator().hasNext()) {
//            if (sum >= k) {
//                break;
//            }
//            sum += result.iterator().next();
//            count++;
//        }
//
//        return count;
//    }
}
