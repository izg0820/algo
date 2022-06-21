package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/42579
public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> playTimeByGenre = new HashMap<>();
        HashMap<Integer, String> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            playTimeByGenre.put(genres[i], playTimeByGenre.getOrDefault(genres[i], 0) + plays[i]);
            genreMap.put(i, genres[i]);
        }

        List<String> genreList = new ArrayList<>(playTimeByGenre.keySet());
        Collections.sort(genreList, (o1, o2) -> playTimeByGenre.get(o2).compareTo(playTimeByGenre.get(o1)));

        for (String genre : genreList) {
            HashMap<Integer, Integer> playTimeMap = new HashMap<>();
            for (int id : genreMap.keySet()) {
                if (genreMap.get(id).equals(genre)) {
                    playTimeMap.put(id, plays[id]);
                }
            }
            List<Integer> idList = new ArrayList<>(playTimeMap.keySet());
            Collections.sort(idList, (o1, o2) -> playTimeMap.get(o2).compareTo(playTimeMap.get(o1)));
            int size = idList.size() > 1 ? 2 : idList.size();
            for (int i = 0; i < size; i++) {
                answer.add(idList.get(i));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void result() {
        assertThat(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}))
                .isEqualTo(new int[]{4, 1, 3, 0});
        assertThat(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 600}))
                .isEqualTo(new int[]{3, 0, 1, 4});
        assertThat(solution(new String[]{"classic", "Newage", "pop", "classic", "classic", "pop", "Newage"}, new int[]{500, 1700, 600, 150, 800, 2500, 1500}))
                .isEqualTo(new int[]{1, 6, 5, 2, 4, 0});
        assertThat(solution(new String[]{"A", "B", "A", "B", "A", "C"}, new int[]{500, 600, 150, 800, 2500, 5000}))
                .isEqualTo(new int[]{5, 4, 0, 3, 1});
        assertThat(solution(new String[]{"A", "A", "B", "A"}, new int[]{5, 5, 6, 5}))
                .isEqualTo(new int[]{0, 1, 2});
    }

}
