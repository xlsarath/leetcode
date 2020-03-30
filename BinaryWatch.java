import java.util.LinkedList;
import java.util.List;


class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        
        List<String> result = new LinkedList<>();
        String hours[] =  {"1","2","4","8"};
        String mins[] =  {"1","2","4","8","16","32"};
        dfs(result,num,0,hours,mins,0,0);
        
        return result;
    }

    private void dfs(List<String> result, int num, int cursor, String[] hours, String[] mins, int hours_index,
            int mins_index) {

        // isGoal
        if(hours_index==hours.length && mins_index==mins.length) return;
        // ivalid
        if(cursor<num){
            if(hours_index<hours.length && mins_index < hours.length)
              System.out.println(hours[hours_index]+":00");
            if(mins_index<mins.length)
            if(Integer.parseInt(mins[mins_index])<10)
                System.out.println("0:0"+mins[mins_index]);
            else
                System.out.println("0:"+mins[mins_index]);

        }


        for (int i = cursor; i < num; i++) {
            if(hours_index<hours.length)
                hours_index++;
            if(mins_index<mins.length)
                mins_index++;
            dfs(result, num, i, hours, mins, hours_index, mins_index);

        //hours ..sums upto 12

        //minutes sums ipto 60


    }
        

    }
    
   
    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        System.out.println(bw.readBinaryWatch(3));
    }
        
        
        
        
        
        
        
    
}

/**
 * 
 * hours [1 2 4 8]

1 -- 1 2 4 8
2 -- 3 5 9 6 10 12
3 -- 7 11
4 -- 0



for int i =cursor i < nums.length i++
t[0]



 */