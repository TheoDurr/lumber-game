import vehicle.Vehicle;

import java.util.ArrayList;

public class EmployeeCategory extends Thread{

    
        private ArrayList<Employee> employees = new ArrayList<Employee>();

        public EmployeeCategory(Employee employee){
            employees.add(employee);
        }

        @Override
        public void run() {
            System.out.println("A");
            System.out.println("B");


        }

}
