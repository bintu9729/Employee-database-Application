public class Query {
    static String insert="INSERT INTO employee(id,name,email,salary) VALUES (?,?,?,?)";
    static String update="UPDATE employee SET name=? WHERE id=?";
    static String delete="DELETE FROM employee Where id=?";
    static String select="SELECT * FROM employee";
    static String createTable="CREATE TABLE employee(id int,name varchar(50),email varchar(50),salary int)";
}

