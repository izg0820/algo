package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class Tuple {
    public int[] solution(String s) {

        List<String> nums = new ArrayList<>();
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(s.substring(1, s.length() - 1));
        while (m.find()) {
            nums.add(m.group(1));
        }
        nums.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int[] answer = new int[nums.size()];
        Set<Integer> set = new HashSet<>();
        for (int i =0; i< nums.size(); i++) {
            String[] num = nums.get(i).split(",");
            for (String temp : num) {
                int n = Integer.valueOf(temp);
                if (!set.contains(n)) {
                    set.add(n);
                    answer[i] = n;
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")).isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")).isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(solution("{{20,111},{111}}")).isEqualTo(new int[]{111, 20});
        assertThat(solution("{{123}}")).isEqualTo(new int[]{123});
        assertThat(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")).isEqualTo(new int[]{3, 2, 4, 1});
    }
}
