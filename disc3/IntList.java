//public class IntList {
//    public int first;
//    public IntList rest;
//    public boolean equals(Object o) {
//        // 同一对象直接返回true
//        if (this == o) return true;
//        // 类型不匹配返回false
//        if (o == null || getClass() != o.getClass()) return false;
//        IntList other = (IntList) o;
//        // 递归判断：当前值相等 + 剩余链表相等
//        return this.first == other.first && (this.rest == null ? other.rest == null : this.rest.equals(other.rest));
//    }
//    public static IntList list(int... args) {
//        if (args == null || args.length == 0) {
//            return null;
//        }
//        // 头节点
//        IntList head = new IntList();
//        head.first = args[0];
//        IntList current = head;
//        // 遍历剩余参数，串联链表
//        for (int i = 1; i < args.length; i++) {
//            current.rest = new IntList();
//            current.rest.first = args[i];
//            current = current.rest;
//        }
//        return head;
//    }
//    public void skippify() {
//        IntList p = this;
//        int n = 1;
//
//        while (p != null) {
//            IntList next = p.rest;
//            for (int i = 0; i < n; i++) {
//                if (next == null) {
//                    return;
//                }
//                next = next.rest;
//            }
//            p.rest = next;
//            p = next;
//            n++;
//        }
//    }
//    public static void testSkippify() {
//        IntList A = IntList.list(1,2,3,4,5,6,7,8,9,10);
//        A.skippify();
//        IntList expectA = IntList.list(1,3,6,10);
//        System.out.println("A测试: " + (A.equals(expectA) ? "成功✅" : "失败❌"));
//
//        IntList B = IntList.list(9,8,7,6,5,4,3,2,1);
//        B.skippify();
//        IntList expectB = IntList.list(9,7,4);
//        System.out.println("B测试: " + (B.equals(expectB) ? "成功✅" : "失败❌"));
//    }
//
//    // main 方法运行测试
//    public static void main(String[] args) {
//        testSkippify();
//    }
//}
public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }
    /**
     * Given a sorted linked list of items- remove duplicates.
     * For example given 1-> 2-> 2-> 2-> 3,
     * Mutate it to become 1-> 2-> 3 (destructively)
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }
        IntList current = p.rest;
        IntList previous = p;
        while (current != null) {
            if (current.first == previous.first) {
                previous.rest = current.rest;
            } else {
                previous = previous.rest;
            }
            current = current.rest;
        }
    }
    public static void printList(IntList p) {
        while (p != null) {
            System.out.print(p.first);
            if (p.rest != null) {
                System.out.print(" -> ");
            }
            p = p.rest;
        }
        System.out.println();
    }

    /** 测试主方法 */
    public static void main(String[] args) {
        // 测试用例1：题目示例 1->2->2->2->3
        IntList list1 = new IntList(1,
                new IntList(2,
                        new IntList(2,
                                new IntList(2,
                                        new IntList(3, null)))));
        System.out.println("去重前：");
        printList(list1);
        removeDuplicates(list1);
        System.out.println("去重后：");
        printList(list1);
        System.out.println("------------------------");

        // 测试用例2：全重复 5->5->5
        IntList list2 = new IntList(5, new IntList(5, new IntList(5, null)));
        System.out.println("去重前：");
        printList(list2);
        removeDuplicates(list2);
        System.out.println("去重后：");
        printList(list2);
        System.out.println("------------------------");

        // 测试用例3：空链表
        System.out.println("空链表测试：");
        removeDuplicates(null);
        System.out.println("无异常");
        System.out.println("------------------------");

        // 测试用例4：无重复 1->3->5->7
        IntList list4 = new IntList(1, new IntList(3, new IntList(5, new IntList(7, null))));
        System.out.println("去重前：");
        printList(list4);
        removeDuplicates(list4);
        System.out.println("去重后：");
        printList(list4);
    }
}
