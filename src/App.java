import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args)throws Exception{
        System.out.println("Welcome to employment database");
        EmployeeDAO.createTable();
        while(true){
            System.out.println("\n employee Management");
            System.out.println("press any Operation ");
            System.out.println("1=create,2=Read,3=Update,4=Delete");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            if(choice<1||choice>=5) break;
            switch(choice){
                case 1:
                    System.out.println("id ,name ,email ,salary");
                    int id=sc.nextInt();
                    sc.nextLine();
                    String name=sc.nextLine();
                    String email=sc.nextLine();
                    int salary=sc.nextInt();
                    Employee emp=new Employee(id,name,email,salary);
                    EmployeeDAO.createEmployee(emp);
                    break;
                case 2:
                    ArrayList<Employee> list=EmployeeDAO.readAllEmployee();
                    for(Employee employee:list){
                        System.out.println(employee.toString());
                    }
                    break;
                case 3:
                    System.out.println("please enter id and name");
                    id = sc.nextInt();
                    sc.nextLine();
                    name=sc.nextLine();
                    EmployeeDAO.updateEmployee(id,name);
                    break;
                case 4:
                    System.out.println("please enter id ");
                    id=sc.nextInt();
                    EmployeeDAO.deleteEmployee(id);
                    break;

            }
        }

    }
}

