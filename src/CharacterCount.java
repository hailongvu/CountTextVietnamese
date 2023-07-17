import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int count = countCharacterGroups(input);
        System.out.println("Number of character groups: " + count);
    }

    private static int countCharacterGroups(String input) {
        Map<String, Integer> characterGroups = new HashMap<>();
        characterGroups.put("aw", 0);
        characterGroups.put("aa", 0);
        characterGroups.put("dd", 0);
        characterGroups.put("ee", 0);
        characterGroups.put("ow", 0);
        characterGroups.put("w", 0);
        characterGroups.put("oo", 0);

        int count = 0;
        int i = 0;
        while (i < input.length()) {
            String group = getCharacterGroup(input, i);
            if (characterGroups.containsKey(group)) {
                characterGroups.put(group, characterGroups.get(group) + 1);
                count++;
            }
            i += group.length();
        }

        return count;
    }

    private static String getCharacterGroup(String input, int startIndex) {
        int endIndex = startIndex + 1;
        if (endIndex < input.length()) {
            String group = input.substring(startIndex, endIndex + 1);
            if (group.equals("aw") || group.equals("aa") || group.equals("dd")
                    || group.equals("ee") || group.equals("ow") || group.equals("oo"))  {
                return group;
            }
        }
        return Character.toString(input.charAt(startIndex));
    }
}