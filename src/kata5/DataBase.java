package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private String URL;
    private Connection connection;
    
    public DataBase(String URL) {
        this.URL=URL;
    }
    
    public void open(){
        try{
            this.connection=DriverManager.getConnection(this.URL);
            System.out.println("Base de Datos abierta...");
        }
        catch(SQLException exception){
            System.out.println("ERROR DataBase::open (SQLException)" + exception.getMessage());
        }
    }
    
    public void close(){
        try{
            if(this.connection!=null){
               connection.close();
                System.out.println("Base de Datos cerrada..."); 
            }
        }
        catch(SQLException exception){
            System.out.println("ERROR DataBase::close (SQLException)" + exception.getMessage());
        }
    }

    public void selectPEOPLE() {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NAME \t APELLIDOS \t DEPARTAMENTO");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + "\t" +
                        resultset.getString("NAME") + "\t" +
                        resultset.getString("APELLIDOS") + "\t" +
                        resultset.getString("DEPARTAMENTO"));
            }
        }
        catch(SQLException exception){
            System.out.println("ERROR DataBase::close (SQLException)" + exception.getMessage());
        }
    }

    void insertPEOPLE(People people) {
        String SQL = "INSERT INTO PEOPLE (NAME, APELLIDOS, DEPARTAMENTO) VALUES(?,?,?)";
        try{
            PreparedStatement preparestatement = this.connection.prepareStatement(SQL);
            preparestatement.setString(1, people.getName());
            preparestatement.setString(2, people.getApellidos());
            preparestatement.setString(3, people.getDepartamento()); 
            preparestatement.executeUpdate();
        }catch(SQLException exception){
            System.out.println("ERROR DataBase::insertar (SQLException)" + exception.getMessage());
        }
    }
}
