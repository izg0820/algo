package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenChat {

    final String leave = "님이 나갔습니다.";
    final String enter = "님이 들어왔습니다.";

    public String[] solution(String[] record) {
        Ids ids = new Ids();
        List<Log> logs = new ArrayList<>();

        for (String r : record) {
            String[] temp = r.split(" ");
            String action = temp[0], uid = temp[1];

            if ("Enter".equals(action)) {
                if (ids.isExists(uid)) {
                    logs.stream().forEach(p -> p.changeName(uid, ids.getName(uid), temp[2]));
                    ids.changeName(uid, temp[2]);
                } else {
                    ids.add(uid, temp[2]);
                }
                logs.add(new Log(uid, temp[2] + enter));
            } else if ("Leave".equals(action)) {
                logs.add(new Log(uid ,ids.getName(uid) + leave));
            } else if ("Change".equals(action)) {
                logs.stream().forEach(p -> p.changeName(uid, ids.getName(uid), temp[2]));
                ids.changeName(uid, temp[2]);
            }
        }
        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            answer[i] = logs.get(i).getContext();
        }
        return answer;
    }


    public class Log {

        private String id;
        private String context;

        public void changeName(String id, String before, String after) {
            if (this.id.equals(id)) {
                context = context.replace(before, after);
            }
        }

        public Log(String id, String context) {
            this.id = id;
            this.context = context;
        }

        public String getContext() {
            return context;
        }
    }

    public class Ids {

        private HashMap<String, String> info = new HashMap<>();

        public void add(String id, String name) {
            info.put(id, name);
        }

        public boolean isExists(String id) {
            return info.containsKey(id);
        }

        public void changeName(String id, String name) {
            info.put(id, name);
        }

        public String getName(String id) {
            return info.get(id);
        }
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))
                .isEqualTo(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
    }
}
