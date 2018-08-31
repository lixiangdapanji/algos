import java.util.List;

public class _0023MergekSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }

        return mergeHelper(lists, 0, lists.size() - 1);

    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end){
        if(start == end){
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);

        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;


        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }else{
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            head.next = list1;
        }else{
            head.next = list2;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
      }
  }

}
