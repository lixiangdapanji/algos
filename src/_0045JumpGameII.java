public class _0045JumpGameII {
    public int jump(int[] a) {
        int[] minSteps = new int[a.length];
        //minSteps[0] init 0
        int gun = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = gun + 1; j <= Math.min(a.length - 1, i + a[i]); j++) {
                minSteps[j] = minSteps[i] + 1;
            }
            gun = Math.max(gun, i + a[i]);
        }
        return minSteps[a.length - 1];
    }
}
