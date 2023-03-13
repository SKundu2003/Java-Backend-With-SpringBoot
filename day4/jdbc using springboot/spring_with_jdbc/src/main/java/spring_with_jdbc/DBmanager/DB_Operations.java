package spring_with_jdbc.DBmanager;

import spring_with_jdbc.DAOs.Persons;
import spring_with_jdbc.Requests.CreateRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DB_Operations {
    private static volatile Connection connection;
    //using synchronization
    public static Connection getConnection() throws SQLException {
        if (connection==null)
        {
            synchronized (DB_Operations.class){

                //double-checking
                if (connection==null){
                    connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","souvik","souvik2003");
                }
        }

        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection!=null)
        {
            synchronized (DB_Operations.class)
            {
                if (connection!=null)
                {
                    connection.close();
                }
            }
        }
    }
    public static void insertPerson(CreateRequest request) throws SQLException {
        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jdbc_test_table values (?,?,?,?)");
        preparedStatement.setInt(1,request.getId());
        preparedStatement.setString(2,request.getName());
        preparedStatement.setInt(3,request.getAge());
        preparedStatement.setString(4,request.getAddress());
        preparedStatement.executeUpdate();
        System.out.println("insert successfull");
//        closeConnection();
    }
    public static void getPersonById() {

    }
    public static List<Persons> getPersons() throws SQLException {
        //getting persons from db
        getConnection();
        List<Persons> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc_test_table");
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);
            Persons persons = new Persons(id,name,age,address);
            list.add(persons);
        }
        return list;
    }

    public static void deletePerson(){

    }
    public static void updatePerson(){

    }
}
