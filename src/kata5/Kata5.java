package kata5;

public class Kata5 {

    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DBSQL_lite\\DataBase.db");
        DataBase database = new DataBase(URL);
        
        database.open();
        
        database.selectPEOPLE();
        
        People people = new People ("CARLOS", "FERNANDEZ","PROFESORADO");
        database.insertPEOPLE(people);
        
        System.out.println("* * * * *");
        database.selectPEOPLE();
        database.close();
        
    }
    
}
