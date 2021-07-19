package com.company;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeCrud {

    Dbcon db =new Dbcon();
    Scanner scan =new Scanner(System.in);
    Employee employee =new Employee();

    //java frameworks

    public int checkAgeIfAbove18(int age){
        if (age >=18) {
            System.out.println("Continue with the registration");
            //


        }
        else {
            JOptionPane.showMessageDialog(null, "Under age to be registered");
            int correctage = scan.nextInt();
            System.exit(0);
        }

        return age;
    }
    public static String checkEmailIfInCorrectFormat(String email){

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        return email;

    }
    public void getUsers(){
        String users = "select * from employee";
        try {
            PreparedStatement statement = db.connection.prepareStatement(users);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(result.getString(4));
                System.out.println(result.getString(5));


            }

            }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
}
    public void getUser(){
        System.out.println("Enter employee Id");
        int userId =scan.nextInt();
        String user = "select * from employee where id="+ userId +"";

              try {
            PreparedStatement statement = db.connection.prepareStatement(user);
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }
    public void insert_user() {
        String insert_user = "insert into employee(id,first_name,last_name,email,age)" +
                "Values(?,?,?,?,?)";
//        Dbcon db= new Dbcon();


        try {
            PreparedStatement statement = db.connection.prepareStatement(insert_user);
            input(scan);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, checkEmailIfInCorrectFormat(employee.getEmail()));
            statement.setInt(5, checkAgeIfAbove18(employee.getAge()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully added to database");


        } catch (SQLException e) {

            System.out.println("Under Age to be Authorized to be registered" + e);
        }

    }
    public void delete_user(){
        System.out.println("Enter employee Id");
        int userId =scan.nextInt();
        String  delete_user="delete from employee where id="+userId+"";
        Dbcon db =new Dbcon();
        try {
            PreparedStatement statement = db.connection.prepareStatement(delete_user);
//            statement.setInt(1, 3);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Employee deleted Successfully");

            db.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public  void input(Scanner  scan) {

        System.out.println("Adding new Employee");
        System.out.println("Enter the Employee id:");
//        String   id = JOptionPane.showInputDialog("Enter the Employee id");
         employee.setId(scan.nextInt());
        System.out.println("Enter First Name");
        employee.setFirst_name(scan.next());
        System.out.println("Enter Last Name");
        employee.setLast_name(scan.next());
        System.out.println("Enter Email");
        employee.setEmail(scan.next());
        System.out.println("Enter Age");
        employee.setAge(scan.nextInt());

    }
    public void upate_user(){

        String  update_user="update employee set first_name = ?,last_name=?,email=?,age=? where id = $id";
        Dbcon db =new Dbcon();
        try {
            PreparedStatement statement = db.connection.prepareStatement(update_user);

            input(scan);
            statement.setInt(1, employee.getId());
             statement.setString(2, employee.getFirst_name());
            statement.setString(3, employee.getLast_name());
            statement.setString(4, employee.getEmail());
            statement.setInt(5, checkAgeIfAbove18(employee.getAge()));

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee Updated Successfully");


            statement.close();
            db.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
