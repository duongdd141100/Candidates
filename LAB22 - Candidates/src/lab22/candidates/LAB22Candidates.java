/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22.candidates;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Do Duc Duong
 */
public class LAB22Candidates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Candidates> list = new ArrayList<>();
        Experience exp = new Experience();
        Candidates cd = new Candidates();
        Option op = new Option();
        CheckInput check = new CheckInput();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("    1. Experience");
            System.out.println("    2. Fresher");
            System.out.println("    3. Internship");
            System.out.println("    4. Searching");
            System.out.println("    5. Exit\n");
            System.out.print("Enter choice: ");
            int choice = check.Choice();

            switch (choice) {
                case 1:
                    while (true) {
                        op.AddExperience(list);
                        if (!YesOrNo()) {
                            Display(list);
                            break;
                        }
                    }

                    break;
                case 2:
                    while (true) {
                        op.AddFresher(list);
                        if (!YesOrNo()) {
                            Display(list);
                            break;
                        }
                    }

                    break;
                case 3:
                    while (true) {
                        op.AddInturn(list);
                        if (!YesOrNo()) {
                            Display(list);
                            break;
                        }
                    }

                    break;
                case 4:
                    while (true) {
                        op.Searching(list);
                        if (!YesOrNo()) {
                            break;
                        }
                    }
                    break;
                case 5:

                    break;

            }

        }
    }

    private static boolean YesOrNo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to continue (Y-Yes N-No): ");
        while (true) {
            String check = scan.nextLine();
            if (check.equalsIgnoreCase("y")) {
                return true;
            } else if (check.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.print("Please enter Y-Yes/N-No: ");
            }
        }
    }

    private static void Display(ArrayList<Candidates> list) {
        Experience ex = new Experience();
        int countExp = 0;
        int countFresher = 0;
        int countInturn = 0;
        System.out.println("===========EXPERIENCE CANDIDATE============");
        System.out.println("ID\tFirst Name\tLast Name\tBirth Date\tAddress\tPhone\tEmail\tType\tYear Of Experience\tProfessional Skill");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type.equalsIgnoreCase("Experience")) {
                countExp += 1;
                System.out.println(list.get(i).id + "\t" + list.get(i).firstName + "\t\t" + list.get(i).lastName + "\t" + list.get(i).birthDate + "\t" + list.get(i).address + "\t" + list.get(i).Phone + "\t" + list.get(i).email + "\t" + ((Experience) list.get(i)).yearOfExp + "\t" + ((Experience) list.get(i)).proSkill);
            }
        }
        if (countExp == 0) {
            System.out.println("Nobody is Experience!");
        }

        System.out.println("\n==========FRESHER CANDIDATE==============");
        System.out.println("ID\tFirst Name\tLast Name\tBirth Date\tAddress\tPhone\tEmail\tType\tGraduation Date\tGraduation Rank\tUniversity");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type.equalsIgnoreCase("Fresher")) {
                countFresher += 1;
                System.out.println(list.get(i).id + "\t" + list.get(i).firstName + "\t\t" + list.get(i).lastName + "\t" + list.get(i).birthDate + "\t" + list.get(i).address + "\t" + list.get(i).Phone + "\t" + list.get(i).email + "\t" + ((Fresher) list.get(i)).graduationDate + "\t" + ((Fresher) list.get(i)).rankOfGraduation + "\t" + ((Fresher) list.get(i)).university);
            }
        }
        if (countFresher == 0) {
            System.out.println("Nobody is Fresher!");
        }

        System.out.println("\n===========INTERN CANDIDATE==============");
        System.out.println("ID\tFirst Name\tLast Name\tBirth Date\tAddress\tPhone\tEmail\tType\tMajor\tSemester\tUniversity");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).type.equalsIgnoreCase("Fresher")) {
                countInturn += 1;
                System.out.println(list.get(i).id + "\t" + list.get(i).firstName + "\t\t" + list.get(i).lastName + "\t" + list.get(i).birthDate + "\t" + list.get(i).address + "\t" + list.get(i).Phone + "\t" + list.get(i).email + "\t" + ((Inturnship) list.get(i)).majors + "\t" + ((Inturnship) list.get(i)).semester + "\t" + ((Inturnship) list.get(i)).university);
            }
        }
        if (countInturn == 0) {
            System.out.println("Nobody is Fresher!");
        }
    }

}
