import java.util.ArrayList;
import java.util.List;

public class _0051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> pathCols = new ArrayList<>();
            dfs(i, result, pathCols, n);
        }

        List<List<String>> stringResults = new ArrayList<>();
        for (List<Integer> list : result) {
            stringResults.add(toList(list));
        }
        return stringResults;
    }

    private List<String> toList(List<Integer> array) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < array.size(); j++) {
                sb.append(array.get(i) == j ? 'Q' : '.');
            }
            list.add(sb.toString());
        }
        return list;
    }


    private void dfs(int col, List<List<Integer>> result, List<Integer> pathCols, int n) {
        //1. op at node
        pathCols.add(col);

        if (pathCols.size() == n) {
            result.add(new ArrayList<>(pathCols));
        }

        //2 go down to children
        int childRow = pathCols.size();
        for (int childCol = 0; childCol < n; childCol++) {
            for (int prevRow = 0; prevRow < pathCols.size(); prevRow++) {
                int prevCol = pathCols.get(prevRow);
                if (prevCol != childCol
                        && prevRow - childRow != prevCol - childCol
                        && prevRow - childRow != childCol - prevCol) {
                    dfs(childCol, result, pathCols, n);
                }
            }
        }
        pathCols.remove(pathCols.size() - 1);
    }

}

