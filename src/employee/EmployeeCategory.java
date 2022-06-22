package employee;

import java.util.ArrayList;

public class EmployeeCategory extends Thread{

    
        protected ArrayList<Employee> employees = new ArrayList<Employee>();

        public float estimatePrice(){
                return 0f ;
        }
        public int getNumber(){
                return employees.size();
        }

        public int getLevel(){
                return 0;
        }

        public float getSalary(){
                return 0;
        }
        protected EmployeeCategory(){
        }

        @Override
        public void run() {

        }

        public void buy(){}

        public void upgrade() {}

        public void addEmployee(Employee employee){
            employees.add(employee);
        }
}
