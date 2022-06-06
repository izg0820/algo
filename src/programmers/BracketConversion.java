package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/60058
public class BracketConversion {

    public static int idx = 0;

    public String solution(String p) {

        if (p.length() == 0) {
            return "";
        }

        boolean isRightBracket = check(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if(isRightBracket) {
            return u + solution(v);
        }

        StringBuilder emptyString = new StringBuilder();
        emptyString.append("(");
        emptyString.append(solution(v));
        emptyString.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                emptyString.append(")");
            } else {
                emptyString.append("(");
            }
        }

        return emptyString.toString();
    }

    public boolean check(String bracket) {
        boolean isCorrect = true;
        int right = 0, left = 0;
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < bracket.length(); i++) {
            if (bracket.charAt(i) == '(') {
                left++;
                stack.add('(');
            }
            else {
                right++;
                if (!stack.isEmpty() && stack.get(stack.size() - 1) == '(') {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(')');
                    isCorrect = false;
                }
            }
            if (left == right) {
                idx = i + 1;
                break; //최소 균형잡힌 괄호를 반환하기 위해
            }
        }
        return isCorrect;
    }

    @Test
    public void result() {
        assertThat(solution("(()())()")).isEqualTo("(()())()");
        assertThat(solution(")(")).isEqualTo("()");
        assertThat(solution("()))((()")).isEqualTo("()(())()");
    }
}
