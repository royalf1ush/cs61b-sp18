/**
 * A naked recursive list of integers, similar to what we saw in lecture 3, but
 * with a large number of additional methods.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class IntList {
    /**
     * First element of list.
     */
    public int first;
    /**
     * Remaining elements of list.
     */
    public IntList rest;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public IntList(int first0, IntList rest0) {
        first = first0;
        rest = rest0;
    }

    /**
     * A List with null rest, and first = 0.
     */
    public IntList() {
        /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }
    public static IntList square(IntList L)
    {
        /*if(L==null)
        {
            return null;
        }
        return new IntList(L.first*L.first,square(L.rest));*/
        if(L==null)
        {
            return null;
        }
        IntList A=new IntList(L.first*L.first,null);
        IntList B=L.rest;
        IntList C=A;
        while(B!=null)
        {

            C.rest=new IntList(B.first*B.first,null);
            B=B.rest;
            C=C.rest;
        }
        return A;
    }
    public static IntList squareMutative(IntList L)
    {
        /*IntList cur=L;
        while(cur!=null)
        {
            cur.first*=cur.first;
            cur=cur.rest;
        }
        return L;*/
        if(L==null)
        {
            return null;
        }
        L.first*=L.first;
        squareMutative(L.rest);
        return L;
    }
    public static void main(String[] args) {
        // ========== 测试1：空链表 ==========
        System.out.println("=== 测试1：空链表 ===");
        IntList emptyList = null;
        IntList squareEmpty = IntList.square(emptyList);
        IntList squareMutativeEmpty = IntList.squareMutative(emptyList);

        // 手动打印空链表结果
        System.out.println("square(空链表)结果：" + squareEmpty);
        System.out.println("squareMutative(空链表)结果：" + squareMutativeEmpty);

        // ========== 测试2：单元素链表 [5] ==========
        System.out.println("\n=== 测试2：单元素链表 [5] ===");
        IntList singleList = new IntList(5, null);

        // 手动打印原链表
        System.out.print("原链表：");
        IntList cur1 = singleList;
        while (cur1 != null) {
            System.out.print(cur1.first);
            cur1 = cur1.rest;
        }
        System.out.println();

        // 测试square
        IntList squareSingle = IntList.square(singleList);
        System.out.print("square后原链表：");
        IntList cur2 = singleList;
        while (cur2 != null) {
            System.out.print(cur2.first);
            cur2 = cur2.rest;
        }
        System.out.println();
        System.out.print("square返回值：");
        IntList cur3 = squareSingle;
        while (cur3 != null) {
            System.out.print(cur3.first);
            cur3 = cur3.rest;
        }
        System.out.println();

        // 测试squareMutative（重新创建链表）
        IntList singleList2 = new IntList(5, null);
        IntList squareMutativeSingle = IntList.squareMutative(singleList2);
        System.out.print("squareMutative后原链表：");
        IntList cur4 = singleList2;
        while (cur4 != null) {
            System.out.print(cur4.first);
            cur4 = cur4.rest;
        }
        System.out.println();
        System.out.print("squareMutative返回值：");
        IntList cur5 = squareMutativeSingle;
        while (cur5 != null) {
            System.out.print(cur5.first);
            cur5 = cur5.rest;
        }
        System.out.println();

        // ========== 测试3：多元素链表 [1->2->3->4] ==========
        System.out.println("\n=== 测试3：多元素链表 [1->2->3->4] ===");
        IntList list = new IntList(1, new IntList(2, new IntList(3, new IntList(4, null))));

        // 手动打印原链表
        System.out.print("原链表：");
        IntList cur6 = list;
        while (cur6 != null) {
            System.out.print(cur6.first);
            if (cur6.rest != null) System.out.print("->");
            cur6 = cur6.rest;
        }
        System.out.println();

        // 测试square
        IntList squareList = IntList.square(list);
        System.out.print("square后原链表：");
        IntList cur7 = list;
        while (cur7 != null) {
            System.out.print(cur7.first);
            if (cur7.rest != null) System.out.print("->");
            cur7 = cur7.rest;
        }
        System.out.println();
        System.out.print("square返回值：");
        IntList cur8 = squareList;
        while (cur8 != null) {
            System.out.print(cur8.first);
            if (cur8.rest != null) System.out.print("->");
            cur8 = cur8.rest;
        }
        System.out.println();

        // 测试squareMutative（重新创建链表）
        IntList list2 = new IntList(1, new IntList(2, new IntList(3, new IntList(4, null))));
        IntList squareMutativeList = IntList.squareMutative(list2);
        System.out.print("squareMutative后原链表：");
        IntList cur9 = list2;
        while (cur9 != null) {
            System.out.print(cur9.first);
            if (cur9.rest != null) System.out.print("->");
            cur9 = cur9.rest;
        }
        System.out.println();
        System.out.print("squareMutative返回值：");
        IntList cur10 = squareMutativeList;
        while (cur10 != null) {
            System.out.print(cur10.first);
            if (cur10.rest != null) System.out.print("->");
            cur10 = cur10.rest;
        }
        System.out.println();
    }
}