class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode p = null ;
        int xfactor = 0;
        boolean time =true;
        while(l1!=null || l2!=null || xfactor ==1){
            int val1 = 0;
            int val2 = 0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = xfactor + val1 + val2;
            if(sum>=10)
                xfactor = 1;
            else
                xfactor = 0;
            if(time){
                result = new ListNode(sum % 10);
                p=result;
                time = false;
            }
            else {p.next = new ListNode(sum % 10);
            p = p.next;}

        }
        return result;
    }
}