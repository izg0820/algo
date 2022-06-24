package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/72412
public class RankingSearch {

    Map<String, List<Integer>> infoCaseMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String i : info) {
            makeCombination("", 0, i.split(" "));
        }

        for (String key : infoCaseMap.keySet()) {
            List<Integer> list = infoCaseMap.get(key);
            Collections.sort(list);
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = infoCaseMap.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    private int binarySearch(String key, int score) {
        List<Integer> list = infoCaseMap.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }

    public void makeCombination(String str, int depth, String[] info) {
        if (depth == 4) {
            if(!infoCaseMap.containsKey(str)) {
                infoCaseMap.put(str, new ArrayList<>());
            }
            infoCaseMap.get(str).add(Integer.parseInt(info[4]));
            return;
        }

        makeCombination(str + "-", depth + 1, info);
        makeCombination(str + info[depth], depth + 1, info);
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}))
                .isEqualTo(new int[]{1, 1, 1, 1, 2, 4});
    }
}
