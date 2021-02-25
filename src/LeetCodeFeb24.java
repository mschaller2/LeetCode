import java.util.List;
import java.util.stream.Collectors;

public class LeetCodeFeb24 {
    public String findLongestWord2(String s, List<String> d){
        int maxLength = 0;
        int solutionIndex = -1;
        d = d.stream().sorted().collect(Collectors.toList());
        for (String word : d){
            int currentIndex = 0;
            int currentLength = 0;
            for(int i = 0; i < word.length(); i++){
                int startIndex = i == 0 ? 0 : currentIndex + 1;
                if (s.indexOf(word.charAt(i), startIndex) < currentIndex) {
                    currentLength = 0;
                    break;
                }
                currentIndex = s.indexOf(word.charAt(i), startIndex);
                currentLength++;
            }
            if (currentLength > maxLength){
                maxLength = currentLength;
                solutionIndex = d.indexOf(word);
            }
        }
        return solutionIndex == -1 ? "" : d.get(solutionIndex);
    }
    public static void main(String[] args){
        LeetCodeFeb24 main = new LeetCodeFeb24();
        // test cases
        List<String> testList = List.of("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        System.out.println(main.findLongestWord2("aewfafwafjlwajflwajflwafj", testList));
        testList = List.of("ale","apple","monkey","plea");
        System.out.println(main.findLongestWord2("abpcplea", testList));
    }
}
