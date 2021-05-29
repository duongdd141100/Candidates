/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab22.candidates;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Do Duc Duong
 */
class Option {
    Scanner scan = new Scanner(System.in);
    CheckInput check = new CheckInput();
    void AddExperience(ArrayList<Candidates> list) {
        ArrayList<Candidates> listCandidates = new ArrayList<>();
        AddCandidates(listCandidates, 0);
        
        System.out.print("Enter year of experience: ");
        int year = check.getInt(1, 100);
        
        
        System.out.print("Enter professional skill: ");
        String proskill = check.getString("[a-zA-Z0-9 ]+", 0);
        
        list.add(new Experience(year, proskill, listCandidates.get(0).id, listCandidates.get(0).firstName, listCandidates.get(0).lastName, listCandidates.get(0).birthDate, listCandidates.get(0).address, listCandidates.get(0).Phone, listCandidates.get(0).email, listCandidates.get(0).type));
        
        
    }

    void AddFresher(ArrayList<Candidates> list) {
        ArrayList<Candidates> listCandidates = new ArrayList<>();
        AddCandidates(listCandidates, 0);    
        
        System.out.print("Enter graduation date: ");
        int graduationDate = check.getInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        
        System.out.println("1. Excellence");
        System.out.println("2. Good");
        System.out.println("3. Fail");
        System.out.println("4. Poor");
        System.out.print("Enter graduation rank: ");
        int rank = check.getInt(1, 4);
        String rankOfGraduation = "";
        switch(rank) {
            case 1: rankOfGraduation = "Excellence";
                break;
            case 2: rankOfGraduation = "Good";
                break;
            case 3: rankOfGraduation = "Fail";
                break;
            case 4: rankOfGraduation = "Poor";
        }
        
        System.out.print("Enter graduation university: ");
        String university = check.getString("[a-zA-Z ]+", 0);
        
        list.add(new Fresher(graduationDate, rankOfGraduation, university, list.get(0).id, list.get(0).firstName, list.get(0).lastName, list.get(0).birthDate, list.get(0).address, list.get(0).Phone, list.get(0).email, list.get(0).type));
    }

    void AddInturn(ArrayList<Candidates> list) {
        ArrayList<Candidates> listCandidates = new ArrayList<>();
        AddCandidates(listCandidates, 0);    
        
        System.out.print("Enter major: ");
        String major = check.getString("[a-zA-Z]+", 0);
        
        System.out.print("Enter semester: ");
        String semester = check.getString("[a-zA-Z0-9]+", 0);
        
        System.out.print("Enter university: ");
        String university = check.getString("[a-zA-Z ]+", 0);
        
        list.add(new Inturnship(major, semester, university, list.get(0).id, list.get(0).firstName, list.get(0).lastName, list.get(0).birthDate, list.get(0).address, list.get(0).Phone, list.get(0).email, list.get(0).type));
    }
    
    private void AddCandidates(ArrayList<Candidates> listCandidates, int type) {
        System.out.print("Enter ID: ");
        String id = check.getString("[a-zA-Z0-9]+", 0);
        
        System.out.print("Enter first name: ");
        String firstName = check.getString("[a-zA-Z]+",0);
        
        System.out.print("Enter last name:");
        String lastName = check.getString("[a-zA-Z]+",0);
        
        System.out.print("Enter birth date:");
        int birthDate = check.getInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        
        System.out.print("Enter address: ");
        String address = check.getString("[a-zA-Z0-9 ,./-]+",0);
        
        System.out.print("Enter phone: ");
        String phone = check.getString("[0-9]+",9);
        
        System.out.print("Enter email: ");
        String email = check.getString("^[a-zA-Z]+[\\d\\w]+@[A-Za-z0-9]+(\\.[A-Za-z]+){1,3}$",0);
        
        String stype = GetStringType(type);
        
        
        listCandidates.add(new Candidates(id, firstName, lastName, birthDate, address, phone, email, stype));
    }
    public String GetStringType(int type) {
        switch(type) {
            case 0:
                return "Experience";
            case 1:
                return "Fresher";
            case 2:
                return "Intern";
        }
        return null;
    }

    void Searching(ArrayList<Candidates> list) {
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = scan.nextLine();
        System.out.print("Input type of candidate: ");
        int type = check.getInt(0, 2);
        String stype = GetStringType(type);
        int count = 0;
        System.out.println("The candidates found: ");
        for(int i = 0; i < list.size(); i++) {
            if((list.get(i).firstName.contains(name) || list.get(i).lastName.contains(name)) && list.get(i).type.equalsIgnoreCase(stype)) {
                System.out.println(list.get(i).firstName + "\t" + list.get(i).lastName + "\t" + list.get(i).birthDate + "\t" + list.get(i).address + "\t" + list.get(i).Phone + "\t" + list.get(i).email + "\t" + list.get(i).type);
                count += 1;
            }
        }
        if(count == 0) {
            System.out.println("Nobody!!!");
        }
        
    }
}
