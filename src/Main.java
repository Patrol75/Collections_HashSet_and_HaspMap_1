import java.util.HashMap;
import java.util.Map;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if (map.containsKey(text.charAt(i))) {
                    map.replace(text.charAt(i), map.get(text.charAt(i)) + 1);
                } else {
                    map.put(text.charAt(i), 1);
                }
            }
        }
        int max = -1;
        char maxKey = ' ';
        int min = Integer.MAX_VALUE;
        char minKey = ' ';
        for (Character key : map.keySet()) {
            if (map.get(key) < min) {
                min = map.get(key);
                minKey = key;
            }
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }
        System.out.println("Максимум сиволов в тексте: " + ANSI_RED + maxKey + ANSI_RESET + " в колличестве " + ANSI_GREEN + max + ANSI_RESET);
        System.out.println("Минимум сиволов в тексте: " + ANSI_RED + minKey + ANSI_RESET + " в колличестве " + ANSI_GREEN + min + ANSI_RESET);
    }

}
