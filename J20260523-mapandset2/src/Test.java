import java.util.*;

class Student {
    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            func(str1,str2);
        }
    }

    private static void func(String str1,String str2) {
        Set<Character> set = new HashSet<>();
        //1. 遍历当前实际输出的字符串
        for(char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        //2. 遍历期望的字符串
        Set<Character> setBroken = new HashSet<>();
        for(char ch : str1.toUpperCase().toCharArray()) {
            if(!set.contains(ch) && !setBroken.contains(ch)) {
                setBroken.add(ch);
                System.out.print(ch);
            }
        }
    }

    /*public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        //1. 存储对应的映射关系
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }
        //2. 修改 next 和 random 的值
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }*/

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i < jewels.length();i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }

        for(int i = 0;i < stones.length();i++) {
            char ch = stones.charAt(i);
            if(set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3,4,5,1,2,3,2};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                //当前数据没有在 map 当中进行过统计
                map.put(array[i],1);
            }else {
                Integer val = map.get(array[i]);
                map.put(array[i],val + 1);
            }
        }
        //遍历 map
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println("key: " + entry.getKey() + " - > val: " + entry.getValue());
        }
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }else {
                set.remove(nums[i]);
            }
        }

        for(int i = 0;i < nums.length;i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main5(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("vibrant",8);
        map.put("Java",6);
        map.put("Java",86);
        System.out.println(map);
        HashSet<String> set = new HashSet<>();
        set.add("nice");
        set.add("essay");
        set.add("essay");
        System.out.println(set);
    }

    public static void main4(String[] args) {
        Student student = new Student("123456");
        /*int hashCode = student.hashCode();
        System.out.println(hashCode);*/
        Student student2 = new Student("123456");
        /*hashCode = student2.hashCode();
        System.out.println(hashCode);*/
        HashBucket2<Student,String>  hashBucket2 = new HashBucket2<>();
        hashBucket2.push(student,"industrious");
        String ret = hashBucket2.get(student2);
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.push(3,999);
        hashBucket.push(6,999);
        hashBucket.push(13,999);
        hashBucket.push(4,999);
        hashBucket.push(5,999);
        hashBucket.push(9,999);
        hashBucket.push(7,999);
        hashBucket.push(8,999);
        int val = hashBucket.get(13);
        System.out.println(val);
    }

    public static void main2(String[] args) {
        Set<String> strings = new TreeSet<>();
        strings.add("hello");
        strings.add("industrious");
        System.out.println(strings.contains("hello"));
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main1(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("hello",3);
        map.put("industrious",1);
        map.put("industrious",10);
        /*Set<String> set = map.keySet();
        System.out.println(set);
        Collection<Integer> collection = map.values();
        System.out.println(collection);*/
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry:entrySet) {
            System.out.println("key:" + entry.getKey() + " " + "value:" + entry.getValue());
        }
        /*map.remove("industrious");
        Integer ret = map.getOrDefault("industrious",9999);
        System.out.println(ret);*/
    }

}
