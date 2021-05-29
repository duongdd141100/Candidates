/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22.candidates;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Do Duc Duong
 */
class CheckInput {

    Scanner scan = new Scanner(System.in);

    int Choice() {
        int choice;
        while (true) {
            while (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (choice > 0 && choice < 6) {
                    return choice;
                }
                System.out.print("Invalid Input! Please choose option 1-5: ");
            }
            System.out.print("Invalid Input! Please choose option 1-5: ");
            scan.next();
        }
    }

    int getInt(int min, int max) {
//        int num;
//        while (true) {
//            while (scan.hasNextInt()) {
//                num = Integer.parseInt(scan.nextLine());
//                System.out.println(num);
//                if (num >= min && num <= max) {
//                    return num;
//                }
//                System.out.print("Invalid date! Enter date is number " + min + "-" + max +": ");
//            }
//            System.out.print("Invalid date! Enter date is number " + min + "-" + max +": ");
//            scan.next();
//        }
        while(true) {
            try {
//                String a = scan.nextLine();
                String a = scan.nextLine();
                int num = Integer.parseInt(a);
                if(num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Invalid date! Enter date is number " + min + "-" + max +": ");
                }
            } catch(Exception e) {
                System.out.print("Invalid date! Enter date is number " + min + "-" + max +": ");
            }
        }
        
    }

    

   

    String getString(String form, int num) {
        while(true) {
            String input = "";
            input += scan.nextLine();
            if(input.matches(form) && input.length() > 0) {
                return input;
            }
            System.out.print("Invalid: ");
        }
    }
    
    

}
