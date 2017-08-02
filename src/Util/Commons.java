package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commons {
    private Commons() {}

    public static List<String> convertStringToList(String s) {
        if (s != null) {
            return Arrays.asList(s.split(" "));
        }
        else {
            return new ArrayList<>();
        }
    }

    public static String convertListToString(List<String> list) {
        String s = new String();
        for (String ele : list) {
            s = s + ele + " ";
        }
        return s;
    }
}
