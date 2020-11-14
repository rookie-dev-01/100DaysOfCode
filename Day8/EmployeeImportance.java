package day8;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 * @author amjain
 *
 */
public class EmployeeImportance {

	// Definition for Employee.
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};

	    int globalSum = 0;
	    public int getImportance(List<Employee> employees, int id) {
	        //find the parent employee from the list
	        // find the list of children
	        //find their importance
	        //add them all and return
	        
	        for(Employee employee:employees){
	            if(id==employee.id){
	                globalSum += employee.importance;
	                for(Integer subs:employee.subordinates){
	                    getImportance(employees,subs);
	                }
	            }
	        }
	        return globalSum;
	    }
	
	public static void main(String[] args) {
		EmployeeImportance obj = new EmployeeImportance();

		System.out.println(obj.getImportance(Arrays.asList(obj.new Employee()),1));
	}
}
