package s58;

public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        if (m == 1 && n == 1) {
            ans[0][0] = img[0][0];
            return ans;
        }
        if (m == 1) {
            int[] row = img[0];
            ans[0][0] = (row[0] + row[1]) / 2;
            ans[0][n - 1] = (row[n - 1] + row[n - 2]) / 2;
            for(int i = 1; i < n - 1; i++) {
                ans[0][i] = (row[i - 1] + row[i] + row[i + 1]) / 3;
            }
            return ans;
        }
        if (n == 1) {
            ans[0][0] = (img[0][0] + img[1][0]) / 2;
            ans[m - 1][0] = (img[m - 1][0] + img[m - 2][0]) / 2;
            for(int i = 1; i < m - 1; i++) {
                ans[i][0] = (img[i][0] + img[i + 1][0] + img[i - 1][0]) / 3;
            }
            return ans;
        }
        // 四角
        ans[0][0] = (img[0][0] + img[0][1]  + img[1][0] + img[1][1]) / 4;
        ans[m - 1][0] = (img[m - 1][0] + img[m - 1][1]  + img[m - 2][0] + img[m - 2][1]) / 4;
        ans[0][n - 1] = (img[0][n - 1] + img[0][n - 2]  + img[1][n - 1] + img[1][n - 2]) / 4;
        ans[m - 1][n - 1] = (img[m - 1][n - 1] + img[m - 1][n - 2]  + img[m - 2][n - 1] + img[m - 2][n - 2]) / 4;
        // 其余边
        for (int i = 1; i < n - 1; i++)
            ans[0][i] = (img[0][i] + img[0][i - 1] + img[0][i + 1] + img[1][i - 1] + img[1][i] + img[1][i + 1]) / 6;
        for (int i = 1; i < n - 1; i++)
            ans[m - 1][i] = (img[m - 1][i] + img[m - 1][i - 1] + img[m - 1][i + 1] + img[m - 2][i - 1] + img[m - 2][i] + img[m - 2][i + 1]) / 6;
        for (int i = 1; i < m - 1; i++)
            ans[i][0] = (img[i][0] + img[i - 1][0] + img[i + 1][0] + img[i][1] + img[i - 1][1] + img[i + 1][1]) / 6;
        for (int i = 1; i < m - 1; i++)
            ans[i][n - 1] = (img[i][n - 1] + img[i - 1][n - 1] + img[i + 1][n - 1] + img[i][n - 2] + img[i - 1][n - 2] + img[i + 1][n - 2]) / 6;
        // 内部
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[i][j] = (img[i][j] + img[i - 1][j] + img[i + 1][j] +
                        img[i][j - 1] + img[i][j + 1] +
                        img[i + 1][j + 1] + img[i + 1][j - 1] + img[i - 1][j + 1] + img[i - 1][j - 1]) / 9;
            }
        }
        return ans;
    }

}
