package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRenewal {

    static HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    combination(orders[j], new StringBuilder(), 0, 0, course[i]);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private void combination(String order, StringBuilder builder, int idx, int depth, int course) {
        if (depth == course) {
            map.put(builder.toString(), map.getOrDefault(builder.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            builder.append(order.charAt(i));
            combination(order, builder, i + 1, depth + 1, course);
            builder.delete(depth, depth + 1);
        }
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BGCF", "ACDEH"}, new int[]{2, 3, 4})).isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});
        assertThat(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})).isEqualTo(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});
        assertThat(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})).isEqualTo(new String[]{"WX", "XY"});
    }
}
