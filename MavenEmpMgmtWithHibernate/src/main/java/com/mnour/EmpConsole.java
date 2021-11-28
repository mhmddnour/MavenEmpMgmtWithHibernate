package com.mnour;



import com.mnour.dao.EmpDAO;

import java.util.Scanner;

public class EmpConsole {

    public static void main(String[] args) {
	// write your code here

        Scanner s = new Scanner(System.in);

        int ch;
        do{
            printNecessaryInformation();

            ch = s.nextInt();

            switch (ch){
                case 1:
                    EmpDAO.addEmp();
                    //System.out.println("New Employee Added Successfully ");
                    break;

                case 2:
                    System.out.println("*** List of Employees ***");
                    EmpDAO.getEmp();
                    break;

                case 3:
                    System.out.println("Updating Process ....");
                    System.out.println("Enter Emp ID to Update : ");
                    EmpDAO.updateEmp(s.nextInt());
                    break;

                case 4:
                    System.out.println("Deleting Process ....");
                    System.out.println("Enter Emp ID to Delete : ");
                    EmpDAO.deleteEmp(s.nextInt());
                    break;
                default:
                    System.out.println("*** please enter valid option ***");
            }

        }while (ch != 0);
        System.out.println("Thank you .. ^^");
    }

    private static void printNecessaryInformation(){
        System.out.println("***********************************************************");

        System.out.println("** Employee Management System **");
        System.out.println("Please Select your choice from the menu to proceed : ");
        System.out.println("1- Insert New Employee");
        System.out.println("2- List All Employees");
        System.out.println("3- Update an Employee");
        System.out.println("4- Delete an Employee");
        System.out.println("0- Exit ");

        System.out.println("***********************************************************");
    }
}
