package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

//https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class PersonalityTypeChecker {

    public String solution(String[] survey, int[] choices) {
        String[][] type = new String[][]{{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        StringBuilder answer = new StringBuilder();
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] >= 4) {
                result.put(survey[i].substring(1), result.getOrDefault(survey[i].substring(1), 0) + choices[i] - 4);
            } else {
                result.put(survey[i].substring(0, 1), result.getOrDefault(survey[i].substring(0, 1), 0) + (choices[i] * -1 + 4));
            }
        }

        for (int i = 0; i < type.length; i++) {
            answer.append(addType(result, type[i][0], type[i][1]));
        }

        return answer.toString();
    }

    public String addType(HashMap<String, Integer> map, String type1, String type2 ) {
        if (map.getOrDefault(type1, 0) < map.getOrDefault(type2, 0)) {
            return type2;
        }
        if (map.getOrDefault(type1, 0) > map.getOrDefault(type2, 0)) {
            return type1;
        }
        if (map.getOrDefault(type1, 0) == map.getOrDefault(type2, 0)) {
            return type1.compareTo(type2) < 0 ? type1 : type2;
        }
        return "";
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})).isEqualTo("TCMA");
        assertThat(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3})).isEqualTo("RCJA");
    }
}
