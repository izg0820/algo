package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

//https://programmers.co.kr/learn/courses/30/lessons/67257
public class MaximizeFormulas {

    public List<Character> operatorKindList;
    public List<Long> numberList;
    public List<Character> operatorList;
    public Long MAX;
    public boolean[] visited;

    public long solution(String expression) {
        operatorKindList = new ArrayList<>();
        numberList = new ArrayList<>();
        operatorList = new ArrayList<>();
        MAX = 0L;
        splitExpression(expression);
        visited = new boolean[operatorKindList.size()];
        permutation(new ArrayList<>());
        return MAX;
    }

    private void splitExpression(String expression) {
        char[] expressionArray = expression.toCharArray();
        Set<Character> operatorKind = new HashSet<>();
        StringBuilder number = new StringBuilder();
        for (char c : expressionArray) {
            if (c == '-' || c == '*' || c == '+') {
                operatorKind.add(c);
                operatorList.add(c);
                numberList.add(Long.valueOf(number.toString()));
                number = new StringBuilder();
            } else {
                number.append(c);
            }
        }
        numberList.add(Long.valueOf(number.toString()));
        operatorKindList = new ArrayList<>(operatorKind);
    }

    private void permutation(List<Character> operatorOrder) {
        if (operatorOrder.size() == operatorKindList.size()) {
            Long result = calculation(operatorOrder);
            if (MAX < result) {
                MAX = result;
                return;
            }
        }

        for (int i = 0; i < operatorKindList.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            operatorOrder.add(operatorKindList.get(i));
            permutation(operatorOrder);
            visited[i] = false;
            operatorOrder.remove(operatorOrder.size() - 1);
        }
    }

    private Long calculation(List<Character> operatorOrder) {
        List<Long> copyNumberList = new ArrayList<>(numberList);
        List<Character> copyOperatorList = new ArrayList<>(operatorList);

        for (char operator : operatorOrder) {
            for (int i = 0; i < copyOperatorList.size(); i++) {
                if (operator == copyOperatorList.get(i)) {
                    copyNumberList.set(i, cal(copyNumberList.get(i), copyNumberList.get(i + 1), operator));
                    copyNumberList.remove(i + 1);
                    copyOperatorList.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(copyNumberList.get(0));
    }

    public Long cal(long a, long b, char opt) {
        if (opt == '+') {
            return a + b;
        }
        if (opt == '-') {
            return a - b;
        }
        if (opt == '*') {
            return a * b;
        }
        return 0L;
    }

    @Test
    public void result() {
        assertThat(solution("100-200*300-500+20")).isEqualTo(60420);
        assertThat(solution("50*6-3*2")).isEqualTo(300);
    }
}
