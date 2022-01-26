import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        dfs(chessboard, 0);
        return ans;
    }

    void dfs(char[][] chessboard,int row){  
        if(row == chessboard.length){
            ans.add(array2List(chessboard));
            return;
        }
      

        for(int col = 0; col< chessboard.length; col++){
            if(isVailed(chessboard,row,col)){
                chessboard[row][col] = 'Q';
                dfs(chessboard, row+1);
                chessboard[row][col] = '.';
            }
        }
    }
    List<String> array2List(char[][]chessboard){
        List<String> list = new ArrayList<>();
        for(char[] c : chessboard){
            list.add(String.copyValueOf(c));
        }

        return list;
    }

    boolean isVailed(char[][] chessborad, int row, int col){
        //col
        for(int i = 0; i <row; i++){
            if(chessborad[i][col] == 'Q') return false;
        }
        //row
        for(int i =0; i < col; i++){
            if(chessborad[row][i] == 'Q') return false;
        }
        //45
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chessborad[i][j] == 'Q') return false;
        }
        //135
        for(int i = row -1, j = col+1;i>=0&&j<=chessborad.length-1;i--,j++){
            if(chessborad[i][j] == 'Q') return false;
        }
        
        return true;
    }
}
// @lc code=end
