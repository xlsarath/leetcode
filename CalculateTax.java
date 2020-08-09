import java.util.*;

public class CalculateTax {


    private double computeTax(List<List<Double>> levels, double salary){
        double remainSalary = salary;
        double tax = 0;
        int currentLevel = 0;
        double prevTaxAmount = 0;

        while(remainSalary > 0){
            List<Double> level = levels.get(currentLevel);
            double percent = level.get(1);

            if(level.get(0) == null){
                tax += remainSalary * percent;
                return tax;
            }
            double upperListAmount = level.get(0);
            double taxableSalaryAtLevel =  Math.min(remainSalary, upperListAmount - prevTaxAmount);
            
            tax += taxableSalaryAtLevel * percent;
            remainSalary -= taxableSalaryAtLevel;
            prevTaxAmount = level.get(0);
            currentLevel++;

        }

        return tax;

    }

    public static void main(String[] args){
        List<List<Double>> levels = new ArrayList<>();

        levels.add(Arrays.asList(10000.0,0.1));
        levels.add(Arrays.asList(20000.0,0.2));
        levels.add(Arrays.asList(30000.0,0.3));
        levels.add(Arrays.asList(null,0.4));

        CalculateTax ct = new CalculateTax();
        double tax = ct.computeTax(levels, 25000);
        
    }

}