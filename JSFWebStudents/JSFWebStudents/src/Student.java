

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@RequestScoped
public class Student{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    
    ArrayList usersList ;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Connection connection;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
   
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// Used to establish connection
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");   
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:8889/studentdb","root","root");
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
    // Used to fetch all records
    public ArrayList usersList(){
        try{
            usersList = new ArrayList();
            connection = getConnection();
            Statement stmt=getConnection().createStatement();  
            ResultSet rs=stmt.executeQuery("select * from student");  
            while(rs.next()){
            	Student user = new Student();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setEmail(rs.getString("email"));
                user.setLastName(rs.getString("lastName"));
               
                usersList.add(user);
            }
            connection.close();        
        }catch(Exception e){
            System.out.println(e);
        }
        return usersList;
    }
    // Used to save user record
    public String save(){
        int result = 0;
        try{
            connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into student(firstName,lastName,email) values(?,?,?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            
            result = stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        if(result !=0)
            return "index.xhtml?faces-redirect=true";
        else return "create.xhtml?faces-redirect=true";
    }
    // Used to fetch record to update
    public String edit(int id){
        Student user = null;
        System.out.println(id);
        try{
            connection = getConnection();
            Statement stmt=getConnection().createStatement();  
            ResultSet rs=stmt.executeQuery("select * from student where id = "+(id));
            rs.next();
            user = new Student();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setEmail(rs.getString("email"));
            user.setLastName(rs.getString("lastName"));
         
            sessionMap.put("editStudent", user);
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }       
        return "/edit.xhtml?faces-redirect=true";
    }
    // Used to update user record
    public String update(Student u){
        //int result = 0;
        try{
            connection = getConnection();  
            PreparedStatement stmt=connection.prepareStatement("update student set firstName=?,email=?,lastName=? where id=?");  
            stmt.setString(1,u.getFirstName());  
            stmt.setString(2,u.getEmail());  
            stmt.setString(3,u.getLastName());  
            stmt.setInt(4,u.getId());  
            stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println();
        }
        return "/index.xhtml?faces-redirect=true";      
    }
    // Used to delete user record
    public void delete(int id){
        try{
            connection = getConnection();  
            PreparedStatement stmt = connection.prepareStatement("delete from student where id = "+id);  
            stmt.executeUpdate();  
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
}
