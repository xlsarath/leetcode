import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//time complexity : o(1)
//space complexity : O(n)
//leet code : yes
//steps : implemented using queue and hahset.
public class DesignPhoneDirectory379 {
    Queue<Integer> queue;
    HashSet<Integer> set;

    public DesignPhoneDirectory379(int maxNumber){

        queue = new LinkedList<>();
        set = new HashSet<>();

        for(int i=0; i<maxNumber; i++){
            queue.offer(i);
        }

    }

    public int get(){
        Integer number = queue.poll();
        if(number==null) return -1;
        set.add(number);
        return number;
    }

    public boolean check(int number){
        return !set.contains(number);
    }

    public void release(int number){
        if(set.remove(number)){
            queue.offer(number);
        }
    }

public static void main(String[] args) {
    DesignPhoneDirectory379 phone = new DesignPhoneDirectory379(5);
    System.out.println(phone.check(5));
    System.out.println(phone.get());
    System.out.println(phone.get());
    System.out.println(phone.get());
    phone.release(1);
    System.out.println(phone.check(2));
}

}