//public class _999716Childtree {
//    public T func(TreeNode root) {
//            // 将 2叉树 转为 16叉树
//            // 原 2叉树的左孩子，随机分配到16叉树 0-->7 某一个孩子上
//            // 原 2叉树的右孩子，随机分配到16叉树 8-->15 某一个孩子上
//            MyTreeNode myRoot = copy(root, new Random());
//
//            // 求16叉树的最大深度
//        return func(myRoot);
//    }
//
//    private T func(MyTreeNode myRoot) {
//
//    }
//
//    private MyTreeNode copy(TreeNode root, Random random) {
//            if (root == null) {
//                return null;
//            }
//
//            MyTreeNode myRoot = new MyTreeNode(root.val);
//            myRoot.children[random.nextInt(8)] = copy(root.left, random);
//            myRoot.children[random.nextInt(8) + 8] = copy(root.right, random);
//            return myRoot;
//        }
//        private class MyTreeNode {
//            int val;
//            MyTreeNode[] children = new MyTreeNode[16];
//            MyTreeNode(int x) {
//                val = x;
//            }
//        }
//    }
//}
