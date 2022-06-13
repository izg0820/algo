package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChat {

    final String leave = "님이 나갔습니다.";
    final String enter = "님이 들어왔습니다.";

    public String[] solution(String[] record) {
        HashMap<String, String> ids = new HashMap<>();
        List<String> logs = new ArrayList<>();

        for (String r : record) {
            String[] temp = r.split(" ");

            if ("Enter".equals(temp[0])) {
                ids.put(temp[1], temp[2]);
                logs.add(temp[1] + enter);
            } else if ("Leave".equals(temp[0])) {
                logs.add(temp[1] + leave);
            } else if ("Change".equals(temp[0])) {
                ids.put(temp[1], temp[2]);
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String context = logs.get(i);
            int idx = context.indexOf("님");
            String id = context.substring(0, idx);
            answer[i] = ids.get(id) + "님이 " +context.split(" ")[1];
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))
                .isEqualTo(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }
}
