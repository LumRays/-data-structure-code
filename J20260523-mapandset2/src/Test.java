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
