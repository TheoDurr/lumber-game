import vehicle.Vehicle;

import java.util.ArrayList;

public class EmployeeCategory extends Thread{

    
        protected ArrayList<Employee> employees = new ArrayList<Employee>();


        protected EmployeeCategory(){
        }

        @Override
        public void run() {

        }

        public void addEmployee(Employee employee){
            employees.add(employee);
        }
}
