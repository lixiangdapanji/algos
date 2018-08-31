//public class _0404SumofLeftLeaves {
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//        int sum = 0;
//        helper(root, false, sum);
//        return sum;
//    }
//    private void helper(TreeNode root, boolean isLeft, int sum) {
//        //if (root == null) return;
//        if (root.left == null && root.right == null) {
//            if (isLeft) {
//                sum += root.val;
//            }
//            return;
//        }
//        helper(root.left, true, sum);
//        helper(root.right, false, sum);
//    }
//}
