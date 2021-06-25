import java.util.HashMap;
import java.util.List;
//time and space complexity : O(n)
//leet code yes
// steps : add employess into Hashmap as key and employee obj as value and proceed to use dfs.
public class EmployeeImportance690 {

    class Employee{
        int id;
        int importance;
        List<Integer> subordinates;

    }

    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map =  new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee emp = map.get(id);
        int result = emp.importance;
        for(Integer e : emp.subordinates){
                result+=dfs(e);
        }
        return result;

    }

}