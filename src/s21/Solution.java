package s21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int[] ints : matrix) {
            rows.add(Arrays.stream(ints).min().getAsInt());
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[i]);
            }
            cols.add(max);
        }
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int row = rows.get(i);
            for (int j = 0; j < n; j++) {
                if (row == cols.get(j)) {
                    answers.add(row);
                    break;
                }
            }
        }
        return answers;
    }
}
