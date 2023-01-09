//package aarogya_hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator; 

// the main class
public class AarogyaHospital {

  // class for storing the patient information
  class AarogyaMember {
    // declare all the details for the patient including name, age, gender, Aadhar
    // Card number, contact number, city, address, date of admission, guardian name,
    // guardian address, guardian contact number
    String name;
    int age;
    String gender;
    long Aadhar_card_number;
    long contact_number;
    String city;
    String address;
    String date_of_admission;
    String guardian_name;
    String guardian_address;
    long guardian_contact_number;
    int count = 100;
    int id;
    boolean recovered;

    // make constructor for the class and assign it a unique Id
    public AarogyaMember() {
      count++;
      id = count;
      recovered = false;
    }

    // for taking patient information
    public void input() {
      Scanner ip = new Scanner(System.in);
      System.out.println("patient name :");
      name = ip.nextLine();
      System.out.println("patient age : ");
      age = ip.nextInt();
      System.out.println("patient gender : ");
      String age1 = ip.nextLine();
      gender = ip.nextLine();
      System.out.println("patient aadharcardNumber :");
      Aadhar_card_number = ip.nextLong();
      System.out.println("patient contactNumber :");
      contact_number = ip.nextLong();
      System.out.println("patient city : ");
      String city1 = ip.nextLine();
      city = ip.nextLine();
      System.out.println("patient address : ");
      address = ip.nextLine();
      System.out.println("date Of Admission : ");
      date_of_admission = ip.nextLine();
      System.out.println("guardian Name : ");
      guardian_name = ip.nextLine();
      System.out.println("guardian Address : ");
      guardian_address = ip.nextLine();
      System.out.println("guardian ContactNumber : ");
      guardian_contact_number = ip.nextLong();
    }

  }

  // pick the choice of task to be performed
  static long choices() {
    System.out.println("Press 1 for adding new member");
    System.out.println("Press 2 to view list of all available members");
    System.out.println("Press 3 to search member by ID");
    System.out.println("Press 4 to search member from a particular city");
    System.out.println("Press 5 to search member from a particular age group");
    System.out.println("Press 6 to mark recovery of a member");
    System.out.println("Press 7 to delete data of a member");
    System.out.println("Press 0 to exit");

    // create scanner class to take input
    Scanner ip = new Scanner(System.in);
    long option = ip.nextLong();
    return option;
  }

  static void displayDetails(AarogyaHospital.AarogyaMember patient) {
    System.out.println("patientName: " + patient.name);
    System.out.println("patientAge: " + patient.age);
    System.out.println("patient Gender: " + patient.gender);
    System.out.println("patient city: " + patient.city);
    System.out.println("patient contact No: " + patient.contact_number);
  }

  public static void main(String args[]) {

    // initialise array list to store list of patients information
    ArrayList<AarogyaMember> patients = new ArrayList<AarogyaMember>();
    AarogyaHospital hospital = new AarogyaHospital();
    // for adding aarogya member information
    Scanner ip = new Scanner(System.in);
    Iterator<AarogyaMember> it = patients.iterator();
    boolean found;
    while (true) {
      // take choice
      long option = choices();

      // invalid choice
      if (option < 0 || option > 7) {
        System.out.println("enter valid option: ");
      }
      // take the input and add in the arrayList
      else if (option == 1) {
        AarogyaHospital.AarogyaMember newpatient = hospital.new AarogyaMember();
        newpatient.input();
        patients.add(newpatient);
      }
      // iterate and print all the patients information
      else if (option == 2) {
        found = false;
        it = patients.iterator();
        while (it.hasNext()) {
          found = true;
          AarogyaHospital.AarogyaMember patient = it.next();
          displayDetails(patient);
        }
        if (!found)
          System.out.println("No patient data available: ");
      }

      // print details of the patient with a particular id (take id as input)
      else if (option == 3) {
        System.out.println("Enter the patient Id: ");
        found = false;
        int id = ip.nextInt();
        it = patients.iterator();
        while (it.hasNext()) {
          AarogyaHospital.AarogyaMember patient = it.next();
          if (patient.id == id) {
            found = true;
            displayDetails(patient);
          }
        }
        if (!found)
          System.out.println("No information about patient: ");
      }

      // to print all the patients from a particular city (take city as input)
      else if (option == 4) {
        System.out.println("Enter the city: ");
        found = false;
        String city = ip.nextLine();
        it = patients.iterator();
        while (it.hasNext()) {
          AarogyaHospital.AarogyaMember patient = it.next();
          if (patient.city.equals(city)) {
            found = true;
            displayDetails(patient);
          }
        }
        if (!found)
          System.out.println("No information about patient: ");
      }
      // to print details of all the patients in a particular age group (take age
      // limits as input)
      else if (option == 5) {
        found = false;
        System.out.println("Enter the age: ");
        int age = ip.nextInt();
        it = patients.iterator();
        while (it.hasNext()) {
          AarogyaHospital.AarogyaMember patient = it.next();
          if (patient.age == age) {
            found = true;
            displayDetails(patient);
          }
        }
        if (!found)
          System.out.println("No information about patient: ");
      }
      // take member id as input to maintain recovered information of patient
      else if (option == 6) {
        found = false;
        System.out.println("Enter the id: ");
        int id = ip.nextInt();
        it = patients.iterator();
        while (it.hasNext()) {
          AarogyaHospital.AarogyaMember patient = it.next();
          if (!(patient.id == id)) {
            found = true;
            if (!patient.recovered) {
              patient.recovered = true;
              System.out.println("patient " + patient.id + " has been marked as recovered");
            } else
              System.out.println("this patient already marked as recovered: ");
          }
        }
        if (!found)
          System.out.println("No information about patient: ");

      }
      // take member id as input to delete patient information
      else if (option == 7) {
        found = false;
        int index = 0;
        System.out.println("Enter the id: ");
        int id = ip.nextInt();
        it = patients.iterator();
        while (it.hasNext()) {
          AarogyaHospital.AarogyaMember patient = it.next();
          if (patient.id == id) {
            found = true;
            System.out.println("patient " + patient.id + "has been removed");
            break;
          }
          index++;
        }
        if (!found)
          System.out.println("No information about patient: ");

      }

      else {
        break;
      }
    }
  }
}
