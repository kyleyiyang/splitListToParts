/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans= new ListNode[k];
        ListNode temp = root;
        int n=0;
        while (temp!=null) {
            n++;
            temp=temp.next;
        }
        temp=root;
        int x=0;
        ListNode head=temp,tail=head;
        while (x<k) {
            int p=0;
            int t=0;
            if (x<n%k) t=n/k;
            else t=n/k-1;
            while (p<t && tail!=null) {
                tail=tail.next;
                p++;
            }
            if (tail!=null) {
                temp=tail.next;
                tail.next=null;
            }
            ans[x]=head;
            x++;
            head=temp;
            tail=head;
        }
        return ans;
    }
}
