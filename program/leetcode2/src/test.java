public class test {
    public static void main(String[] args){
        ListNode a = new ListNode(5);
        //a.next = new ListNode(4);
        //a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);

        Solution test = new Solution();
        ListNode sum = test.addTwoNumbers(a,b);
        System.out.println(sum.val);
        System.out.println(sum.next.val);
        System.out.println(sum.next.next);
    }



}
