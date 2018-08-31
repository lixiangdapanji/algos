public class _1000TrangleForm {
    //三条边是否能组成三角形
    public boolean canForm (int[] a) {
        //a[i - 1] + a[i] > a[i + 1]
        for (int i = 0; i < a.length; i++) {
            if (a[i - 1] + a[i] > a[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
