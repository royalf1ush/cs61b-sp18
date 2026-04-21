
public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (position == 0 || first == null){
            this.addFirst(item);
            return;
        }
        IntNode p = first;
        IntNode rest = first.next;
        while (position > 1 && rest !=null){
            p = p.next;
            rest = rest.next;
            position -= 1;
        }
        p.next = new IntNode(item, rest);
    }
//  public void reverse() {
//        if (first == null){
//            return;
//        }
//        IntNode prev = null;
//        IntNode p = first;
//        IntNode rest = first.next;
//        while(rest != null){
//            p.next = prev;
//            prev = p;
//            p = rest;
//            rest = rest.next;
//        }
//        p.next = prev;
//        first=p;
//    }
    public void reverse(){
        first = helper (first);
    }
    private IntNode helper(IntNode p){
        if (p == null || p.next == null){
            return p;
        } else {
            IntNode reversed = helper(p.next);
            p.next.next = p;
            p.next = null;
            return reversed;
        }
    }

        public static void main(String[] args) {
//        SLList list = new SLList();
//
//        // 构造链表：5 → 6 → 2（用 addFirst 倒着加）
//        list.addFirst(2);
//        list.addFirst(6);
//        list.addFirst(5);
//
//        // 测试：在位置 1 插入 10
//        list.insert(10, 1);
//
//        // 打印结果验证：5 → 10 → 6 → 2
//        IntNode cur = list.first;
//        while (cur != null) {
//            System.out.print(cur.item + " → ");
//            cur = cur.next;
//        }
//        System.out.println("null");
        SLList list = new SLList();

        list.addFirst(2);
        list.addFirst(6);
        list.addFirst(5);

        System.out.println("反转前：");
        IntNode cur = list.first;
        while (cur != null) {
            System.out.print(cur.item + " → ");
            cur = cur.next;
        }
        System.out.println("null");

        // 调用反转方法
        list.reverse();

        System.out.println("反转后：");
        cur = list.first;
        while (cur != null) {
            System.out.print(cur.item + " → ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}