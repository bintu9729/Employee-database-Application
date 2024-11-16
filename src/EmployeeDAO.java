import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {
    public static void createEmployee(Employee employee)throws SQLException {
        Connection cnn=DB.connect();
        PreparedStatement pstm=cnn.prepareStatement(Query.insert);
        pstm.setInt(1,employee.getId());
        pstm.setString(2,employee.getName());
        pstm.setString(3,employee.getEmail());
        pstm.setInt(4,employee.getSalary());
        pstm.execute();
        System.out.println("Employee added ");
        cnn.close();
    }

    public static ArrayList<Employee> readAllEmployee() throws SQLException {
        Connection cnn=DB.connect();
        ArrayList<Employee> list=new ArrayList<Employee>();
        Statement stm=cnn.createStatement();
        ResultSet rs=stm.executeQuery(Query.select);
        while(rs.next()){
            Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            list.add(emp);
        }
        cnn.close();
        return list;
    }

    public static void updateEmployee(int id, String name) throws SQLException {
        Connection cnn=DB.connect();
        PreparedStatement pstm=cnn.prepareStatement(Query.update);
        pstm.setString(1,name);
        pstm.setInt(2,id);
        pstm.executeUpdate();
        cnn.close();
        System.out.println("Updated success");
    }

    public static void deleteEmployee(int id) throws SQLException {
        Connection cnn=DB.connect();
        PreparedStatement pstm=cnn.prepareStatement(Query.delete);
        pstm.setInt(1,id);
        pstm.executeUpdate();
        cnn.close();
        System.out.println("Employee deleted");
    }

    public static void createTable() throws SQLException{
        Connection cnn=DB.connect();
        Statement stm=cnn.createStatement();
        stm.execute(Query.createTable);
        System.out.println("table created employee");
        cnn.close();
    }
}

