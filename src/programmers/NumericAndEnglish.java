package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/81301
public class NumericAndEnglish {
    public int solution(String s) {
        HashMap<String, Integer> numberMap = new HashMap<String, Integer>(){
            {
                put("zero", 0);
                put("one", 1);
                put("two", 2);
                put("three", 3);
                put("four", 4);
                put("five", 5);
                put("six", 6);
                put("seven", 7);
                put("eight", 8);
                put("nine", 9);
            }
        };
        StringBuilder sb = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 48 && temp <= 57) {
                sb.append(temp);
            } else {
                number.append(temp);
                if (numberMap.containsKey(number.toString())) {
                    sb.append(numberMap.get(number.toString()));
                    number = new StringBuilder();
                }
            }
        }

        return Integer.valueOf(sb.toString());
    }

    @Test
    public void result() {
        assertThat(solution("one4seveneight")).isEqualTo(1478);
        assertThat(solution("23four5six7")).isEqualTo(234567);
        assertThat(solution("2three45sixseven")).isEqualTo(234567);
        assertThat(solution("123")).isEqualTo(123);
    }
}
