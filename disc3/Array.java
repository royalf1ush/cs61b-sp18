public class Array {
    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length+1];
        position = Math.min(position,arr.length);
        for (int i = 0; i < position; i++){
            result[i] = arr[i];
        }
        result[position] = item;
        for (int i = position; i < arr.length; i++){
            result[i+1] = arr[i];
        }
        return result;
    }
    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static int[] replicate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        int [] result = new int[sum];
        int cur=0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i]; j++){
                result[cur+j] = arr[i];
            }
            cur += arr[i];
        }
        return result;
    }
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }
        int[] a = new int[totalLength];
        int aIndex = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++){
                a[aIndex] = x[i][j];
                aIndex ++;
            }
        }
        return a;
    }
//    public static void main(String[] args) {
//
//        // 测试用例1：题目示例 中间插入
//        int[] arr1 = {5, 9, 14, 15};
//        int[] result1 = insert(arr1, 6, 2);
//        System.out.println("测试1 - 中间插入:");
//        printArray(result1); // 预期：[5, 9, 6, 14, 15]
//
//        // 测试用例2：插入到数组开头
//        int[] arr2 = {1, 2, 3};
//        int[] result2 = insert(arr2, 0, 0);
//        System.out.println("\n测试2 - 插入开头:");
//        printArray(result2); // 预期：[0, 1, 2, 3]
//
//        // 测试用例3：插入到数组末尾（position = 数组长度）
//        int[] arr3 = {10, 20, 30};
//        int[] result3 = insert(arr3, 40, 3);
//        System.out.println("\n测试3 - 插入末尾:");
//        printArray(result3); // 预期：[10, 20, 30, 40]
//
//        // 测试用例4：position超过数组长度，自动插末尾
//        int[] arr4 = {7, 8};
//        int[] result4 = insert(arr4, 9, 10);
//        System.out.println("\n测试4 - 位置超长度:");
//        printArray(result4); // 预期：[7, 8, 9]
//    }
//
//    // 辅助方法：打印数组
//    public static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            if (i < arr.length - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");
//    }
        // 测试1：偶数长度数组
//        int[] arr1 = {1, 2, 3, 4};
//        System.out.print("原数组1: ");
//        printArray(arr1);
//        reverse(arr1);
//        System.out.print("反转后1: ");
//        printArray(arr1);
//        System.out.println();
//
//        // 测试2：奇数长度数组
//        int[] arr2 = {10, 20, 30};
//        System.out.print("原数组2: ");
//        printArray(arr2);
//        reverse(arr2);
//        System.out.print("反转后2: ");
//        printArray(arr2);
//        System.out.println();
//
//        // 测试3：单个元素
//        int[] arr3 = {99};
//        System.out.print("原数组3: ");
//        printArray(arr3);
//        reverse(arr3);
//        System.out.print("反转后3: ");
//        printArray(arr3);
//        System.out.println();
//
//        // 测试4：空数组
//        int[] arr4 = {};
//        System.out.print("原数组4: ");
//        printArray(arr4);
//        reverse(arr4);
//        System.out.print("反转后4: ");
//        printArray(arr4);
//    }
//
//    // 辅助打印数组
//    public static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            if (i < arr.length - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");
//    }
        // 测试用例1：题目示例
//        int[] a1 = {3, 2, 1};
//        int[] res1 = replicate(a1);
//        System.out.print("测试1：");
//        printArray(res1);
//
//        // 测试用例2：单个元素
//        int[] a2 = {4};
//        int[] res2 = replicate(a2);
//        System.out.print("测试2：");
//        printArray(res2);
//
//        // 测试用例3：包含0
//        int[] a3 = {2, 0, 3};
//        int[] res3 = replicate(a3);
//        System.out.print("测试3：");
//        printArray(res3);
//
//        // 测试用例4：空数组
//        int[] a4 = {};
//        int[] res4 = replicate(a4);
//        System.out.print("测试4：");
//        printArray(res4);
//    }
//
//    // 数组打印工具方法
//    public static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//            if (i != arr.length - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");
//    }
        public static void main(String[] args) {
            // 题目示例：{{1,2,3}, {}, {7,8}}
            int[][] test1 = {{1, 2, 3}, {}, {7, 8}};
            int[] result1 = flatten(test1);
            System.out.println("测试1结果：");
            printArray(result1); // 应输出：1 2 3 7 8

            // 测试空二维数组
            int[][] test2 = {};
            int[] result2 = flatten(test2);
            System.out.println("\n测试2结果（空数组）：");
            printArray(result2); // 空

            // 测试全是空数组
            int[][] test3 = {{}, {}, {}};
            int[] result3 = flatten(test3);
            System.out.println("\n测试3结果（全空）：");
            printArray(result3); // 空

            // 测试单个一维数组
            int[][] test4 = {{9, 8, 7}};
            int[] result4 = flatten(test4);
            System.out.println("\n测试4结果：");
            printArray(result4); // 9 8 7
        }

        // 辅助方法：打印数组
        public static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }
