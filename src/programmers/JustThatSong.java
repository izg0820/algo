package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/17683
public class JustThatSong {

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        List<Song> songList = new ArrayList<>();

        for (String music : musicinfos) {
            String[] info = music.split(",");
            songList.add(new Song(info[2], info[0], info[1], info[3]));
        }

        int max = 0;

        for (Song song : songList) {
            m = melodyChange(m);
            int t = song.match(m);
            if (max < t) {
                max = t;
                answer = song.getName();
            }
        }

        return answer;
    }

    public class Song {

        private String name;
        private int playTime;
        private String melody;

        public Song(String name, String start, String end, String melody) {
            this.name = name;
            this.playTime = timeCalculate(start, end);
            this.melody = melodyCalculate(melodyChange(melody), this.playTime);
        }

        public int timeCalculate(String start, String end) {
            int e = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
            int s = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            return (e - s);
        }

        public String melodyCalculate(String melody, int playTime) {
            StringBuilder sb = new StringBuilder();
            int repeatTime = playTime / melody.length();
            for (int i = 0; i < repeatTime; i++) {
                sb.append(melody);
            }
            sb.append(melody, 0, playTime % melody.length());
            return sb.toString();
        }

        public int match(String m) {
            if (melody.contains(m)) {
                return melody.length();
            }
            return 0;
        }

        public String getName() {
            return name;
        }
    }

    public String melodyChange(String melody) {
        melody = melody.replace("C#", "H");
        melody = melody.replace("D#", "I");
        melody = melody.replace("F#", "J");
        melody = melody.replace("G#", "K");
        melody = melody.replace("A#", "L");
        return melody;
    }

    @Test
    public void result() {
        assertThat(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"})).isEqualTo("HELLO");
        assertThat(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"})).isEqualTo("FOO");
        assertThat(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})).isEqualTo("WORLD");
    }
}
