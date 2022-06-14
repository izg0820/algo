package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/17681
public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            str = String.format("%" + n + "s", str);
            str = str.replace("1", "#");
            str = str.replace("0", " ");
            answer[i] = str;
        }

        return answer;
    }

    @Test
    public void result() {
        assertThat(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))
                .isEqualTo(new String[]{"#####","# # #", "### #", "#  ##", "#####"});
        assertThat(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}))
                .isEqualTo(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "});
    }
}
