import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static int removeDuplicates(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] = nums[i + 1];
                i--;
            }
        }
        int k = nums.length;
        return k;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0;i < n;i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int ret = removeDuplicates(arr);
        System.out.println(ret);
        System.out.println(Arrays.toString(arr));
    }
    public static void main5(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int m = 3;
        int[] arr2 = {2,5,6};
        int n = 3;
        merge(arr1,m,arr2,n);
    }

    public static void main4(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>(13);
        list2.add(11);
        list2.add(21);
        list2.add(31);
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
    }
    public static void main3(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        try{
            myArrayList.add(0,11);
            myArrayList.add(1,21);
            myArrayList.add(2,31);
            myArrayList.add(3,41);
            myArrayList.add(4,51);
            myArrayList.display();

            myArrayList.remove(131);
            myArrayList.display();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
            System.out.println("add-pos位置异常!");
        }catch (EmptyListException e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        try{
            myArrayList.add(0,11);
            myArrayList.add(1,21);
            myArrayList.add(2,31);
            myArrayList.add(3,41);
            myArrayList.add(4,51);
            myArrayList.display();
            myArrayList.add(5,61);
            myArrayList.add(0,99);
            myArrayList.display();
            myArrayList.set(0,18888);
            myArrayList.display();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
            System.out.println("add-pos位置异常!");
        }catch (EmptyListException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.display();
        System.out.println(myArrayList.size());
        int ret = myArrayList.indexOf(4);
        System.out.println(ret);
        try {
            int i = myArrayList.get(3);
            System.out.println(i);
        }catch (EmptyListException e) {
            e.printStackTrace();
        }catch (PosIllegalityException e) {
            e.printStackTrace();
        }

    }
}
