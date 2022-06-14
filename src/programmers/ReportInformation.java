package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/92334
public class ReportInformation {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        List<User> users = new ArrayList<>();

        for (String id : id_list) {
            users.add(new User(id));
        }

        for (String r : report) {
            String[] splitResult = r.split(" ");//0 신고한 사람, 1 신고당한 사람
            for (User user : users) {
                if (user.sameId(splitResult[1])) {
                    user.addReportedCnt();
                    user.addReportedId(splitResult[0]);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            for (User user : users) {
                if (user.idWhoReport.contains(id_list[i]) && user.idWhoReport.size() >= k) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public class User {
        private String id;
        private Set<String> idWhoReport;

        private int reportedCnt;

        public User(String id) {
            this.id = id;
            this.idWhoReport = new HashSet<>();
            this.reportedCnt = 0;
        }

        public void addReportedCnt() {
            this.reportedCnt++;
        }

        public void addReportedId(String id) {
            this.idWhoReport.add(id);
        }

        public boolean sameId(String id) {
            return this.id.equals(id);
        }

    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2 )).isEqualTo(new int[]{2,1,1,0});
        assertThat(solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3 )).isEqualTo(new int[]{0,0});
    }
}
