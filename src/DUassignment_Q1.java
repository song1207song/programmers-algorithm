import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DUassignment_Q1 {
    private static List<Sentence> sentences = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 1. 입력 문제
        int result = 0;
        for (int i = 0; i < 3; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            result = insert(input);
        }

        System.out.println("last id = " + result);
        sentences.forEach(System.out::println);
        System.out.println("/////////////////////////////////////");


        // 2. 조회 문제
        System.out.println(select(1));
        System.out.println("/////////////////////////////////////");


        // 3. 수정 문제
        update(2, "새 텍스트");
        sentences.forEach(System.out::println);
        System.out.println("/////////////////////////////////////");


        // 4. 삭제 문제
        delete(3);
        sentences.forEach(System.out::println);
        System.out.println("/////////////////////////////////////");


        // 5. 카운팅 문제
        List<Count> resultCounting = counting();
        resultCounting.forEach(System.out::println);
    }

    // 1. String으로 문장 입력 받아서 int 형 id를 리턴한다. 문장은 컬렉션에 저장한다.
    private static int insert(String input) {
        int id;
        if (sentences.isEmpty()) {
            id = 1;
        } else {
            Comparator<Sentence> comparatorByAge = Comparator.comparingInt(Sentence::getId);
            id = sentences.stream().max(comparatorByAge).get().id + 1;
        }

        sentences.add(new Sentence(id, input));

        return id;
    }

    // 2. 등록된 id로 조회
    private static Sentence select(int id) {
        return sentences.stream()
                .filter(sentence -> sentence.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 3. 등록된 id로 수정
    private static Sentence update(int id, String newText) {
        for (int i = 0; i < sentences.size(); i++) {
            if (sentences.get(i).id == id) {
                sentences.get(i).setText(newText);
                return sentences.get(i);
            }
        }
        throw new NoSuchElementException();
    }

    // 4. 등록된 id로 삭제
    private static boolean delete(int id) {
        for (int i = 0; i < sentences.size(); i++) {
            if (sentences.get(i).id == id) {
                return sentences.remove(sentences.get(i));
            }
        }
        throw new NoSuchElementException();
    }

    // 5. 저장된 모든 문장의 단어 추합
    private static List<Count> counting() {
        List<List<String>> wordsMatrix = new ArrayList<>();

        for (int i = 0; i < sentences.size(); i++) {
            String[] wordsArr = sentences.get(i).text.split(" ");
            List<String> words = Arrays.asList(wordsArr);

            wordsMatrix.add(words);
        }

        List<String> flatMapWords = wordsMatrix.stream().flatMap(Collection::stream).toList();

        return flatMapWords.stream().collect(Collectors.groupingBy(s -> s))
                .entrySet().stream().map(e -> new Count(e.getKey(), e.getValue().size()))
                .toList();
    }

    static class Count {
        String word;
        int count;

        public Count(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Count{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    static class Sentence {
        int id;
        String text;

        public Sentence(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "Sentence{" +
                    "id=" + id +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

}
