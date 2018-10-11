public class _9995TrangleForm {
    //三条边是否能组成三角形
    public boolean canForm (int[] a) {
        //a[i - 1] + a[i] > a[i + 1]
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] + a[i] > a[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
