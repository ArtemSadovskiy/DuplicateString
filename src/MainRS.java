import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRS {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String str = console.nextLine();

        System.out.println(stringTransformation(str));

    }

    public static String repeatString(String substr) {
        String[] words = substr.split("(\\[)|(\\])");
        int i = Integer.parseInt(words[0]);
        String result = "";
        for (int u = 0; u < i; u++) {
            result = result + words[1];
        }
        return result;
    }

    public static String stringTransformation(String str) {
        String regex = "\\d+\\[[a-zA-Z]+\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        String strResult = str;
        while (matcher.find()) {
            strResult = strResult.replaceFirst(regex, repeatString(matcher.group()));
            matcher = pattern.matcher(strResult);
        }

        if (strResult.matches("^[a-zA-Z]+$")) {
            return strResult;
        } else {
            return "invalid string";
        }
    }
}
