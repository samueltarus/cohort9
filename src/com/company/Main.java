package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    Dbcon db = new Dbcon();
    public static void main(String[] args) {

        JOptionPane pane = new JOptionPane();

        String choice = JOptionPane.showInputDialog(pane,"Welcome to Crud For Employee\n---------------------\n1 Add Employee \n2 Get User Employee\n3 All Users\n4 Update Employee\n5 Delete Employee\n\nEnter Your Option\n");
        // write your code here

        EmployeeCrud  employee =new EmployeeCrud();
        /*System.out.println("Welcome to Crud For Employee");
        Scanner scan = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("1 Add Employee");
        System.out.println("2 Get User EMployee");
        System.out.println("3 All Users");
        System.out.println("4 Update Employee");
        System.out.println("5 Delete Employee");

        System.out.println("----------------------------\n");
        System.out.println("Enter Your Option");*/
        //int action= scan.nextInt();
        int action=action = Integer.parseInt(choice);

        switch (action){
            case 1:
                employee.insert_user();
                break;
            case 2:
                employee.getUser();
                break;
            case 3:
                employee.getUsers();
                break;
            case 4:
                employee.upate_user();
                break;
            case 5:
                employee.delete_user();
                break;
            default:
                System.out.println("Insert the correct option");

        }


    }
}

