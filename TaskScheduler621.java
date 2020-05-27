
//time complexity : O(n)
//space complexity : O(1)
//leet code : yes
//steps : greedy approach.
public class TaskScheduler621 {

        public int leastInterval(char[] tasks, int n) {
            
            int maxFreq = 0;
            int occMaxFreq = 0;
            
            int frequency[] = new int[26];
            
            for(char task:tasks){
                frequency[task-'A']++;
                if(frequency[task-'A']>maxFreq){
                    maxFreq = frequency[task-'A'];
                    occMaxFreq=1;
                } else if(frequency[task-'A']==maxFreq) {
                    occMaxFreq++;
                }
            }
            
            //4A4B2C2D
            //ABC|ABCD|ABCAB
            int partitionCount = maxFreq -1; //3
            int emptySlots = partitionCount *(n-(occMaxFreq-1)); //3 * 4 - 1 = 9
            int pendingTasks = tasks.length-maxFreq*occMaxFreq; // 
            int idleSlots = Math.max(0,emptySlots-pendingTasks);
            
            return tasks.length + idleSlots;
        }

        public static void main(String[] args) {
            System.out.println(new TaskScheduler621().leastInterval(new char[]{'A','A','A','A','B','B','B','B','C','C','D','D'}, 2));
            System.out.println(new TaskScheduler621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        }
    }