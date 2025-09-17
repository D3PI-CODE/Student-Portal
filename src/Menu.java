import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("===========================");
        System.out.println("Welcome to Student Central");
        System.out.println("===========================");
        System.out.println("Your options are: \n \n 1) Add new student \n 2) Edit student \n 3) View all students \n 4) Filter students \n 5) analysis \n 6) Search student by ID \n 0) Exit");
    }
    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        if (!sc.hasNextInt()) {
            sc.next(); // Clear invalid input
            return -1; // Return an invalid choice
        } else {
            return sc.nextInt();
        }
    }

    public static void selection(int choice, student[] students) {
        switch (choice) {
            case 1:
                // Add new student
                try {
                    System.out.print("Enter student ID: ");
                    String studentID;
                    if ((studentID = sc.next()).charAt(0) == 'S') {
                        sc.nextLine();
                    } else {
                        break;
                    }
                        
                    System.out.print("Enter first name: ");
                    String firstName = sc.nextLine();
                        
                    System.out.print("Enter family name: ");
                    String familyName = sc.nextLine();
                        
                    System.out.print("Enter course enrolled: ");
                    String courseEnrolled = sc.nextLine();
                        
                    System.out.print("Enter year level: ");
                    int yearLevel = sc.nextInt();
                        
                    System.out.print("Enter CWA: ");
                    double cwa = sc.nextDouble();
                        
                    System.out.print("Enter status (FT, PT): ");
                    String status = sc.next().toUpperCase();
                        
                    System.out.print("Enter credits earned: ");
                    int creditsEarned = sc.nextInt();
                        
                    // Append new student to the CSV file
                    String newStudentData = "\n" + studentID + "," + firstName + "," + familyName + "," + courseEnrolled + "," + yearLevel + "," + cwa + "," + status + "," + creditsEarned;
                    handler.append(newStudentData);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter the correct data type.");
                    sc.nextLine();
                    break;
                }
                System.out.println("\nNew student added successfully!\n");
                break;
            case 2:
                // Edit student
                boolean found = false;
                try {
                    int editChoice = -1;
                    System.out.print("enter ID: ");
                    String id = sc.next();
                    for (student std: students) {
                        if (std.getStudentID().equals(id)) {
                            System.out.println("Name: " + std.firstName + " " + std.familyName);
                            found = true;
                            do {
                                System.out.print("What would you like to edit? \n 1) First Name \n 2) Family Name \n 3) Course Enrolled \n 4) Year Level \n 5) CWA \n 6) Status \n 7) Credits Earned \n 0) Exit \nSelect option: ");
                                editChoice = sc.nextInt();
                                sc.nextLine(); // Consume newline
                                switch (editChoice) {
                                    case 1:
                                        System.out.print("Enter new first name: ");
                                        std.firstName = sc.nextLine();
                                        break;
                                    case 2:
                                        System.out.print("Enter new family name: ");
                                        std.familyName = sc.nextLine();
                                        break;
                                    case 3:
                                        System.out.print("Enter new course enrolled: ");
                                        std.courseEnrolled = sc.nextLine();
                                        break;
                                    case 4:
                                        System.out.print("Enter new year level: ");
                                        std.yearLevel = sc.nextInt();
                                        break;
                                    case 5:
                                        System.out.print("Enter new CWA: ");
                                        std.cwa = sc.nextDouble();
                                        break;
                                    case 6:
                                        System.out.print("Enter new status (FT, PT): ");
                                        std.status = sc.next().toUpperCase();
                                        break;
                                    case 7:
                                        System.out.print("Enter new credits earned: ");
                                        std.creditsEarned = sc.nextInt();
                                        break;
                                    case 0:
                                        System.out.println("Exiting edit menu.");
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
                                }
                            } while (editChoice != 0);
                            handler.edit(students);
                        }
                    }
                    if (!found) {
                        System.out.println("\nStudent not found with ID: " + id);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter the correct data type.");
                    sc.nextLine();
                    break;
                }
                break;
            case 3:
                // View all students
                System.out.println("\nAll students: \n");
                for (student std: students) {
                    System.out.println("ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName );
                }
                System.out.println("");
                break;
            case 4:
                // Filter students
                System.out.print("Filter options: \n a) By course \n b) By year level \n c) By status \nselect filter: ");
                char filterChoice = sc.next().toLowerCase().charAt(0);
                sc.nextLine();
                switch (filterChoice) {
                    case 'a':
                        System.out.print("Enter course to filter by: ");
                        String course = sc.nextLine();
                        System.out.println("\nStudents enrolled in " + course + ": \n");
                        for (student std: students) {
                            if (std.courseEnrolled.toLowerCase().equals(course.toLowerCase())) {
                                System.out.println("ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName);
                            }
                        }
                        System.out.println("");
                        break;
                    case 'b':
                        System.out.print("Enter year level to filter by: ");
                        int filterYearLevel = sc.nextInt();
                        System.out.println("\nStudents in year " + filterYearLevel + ": \n");
                        for (student std: students) {
                            if (std.yearLevel == filterYearLevel) {
                                System.out.println("ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName);
                            }
                        }
                        System.out.println("");
                        break;
                    case 'c':
                        System.out.print("Enter status to filter by (FT, PT): ");
                        String filterStatus = sc.next().toUpperCase();
                        for (student std: students) {
                            if (std.status.equals(filterStatus)) {
                                System.out.println("ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName);
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid filter choice.");
                        break;
                }
                break;
            case 5:
                // Analysis
                System.out.print("what analysis would you like to perform? \n a) Credit \n b) Highest CWA \nSelect analysis: ");
                char analysisChoice = sc.next().toLowerCase().charAt(0);
                sc.nextLine();
                switch (analysisChoice) {
                    case 'a':
                        System.out.println("\nStudents eligible for graduation: \n");
                        for (student std: students) {
                            if (std.creditsEarned >= 400) {
                                System.out.println("ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName + " || Credits Earned: " + std.creditsEarned);
                            }
                        }
                        break;
                    case 'b':
                        System.out.println("\nHighest CWA: \n");
                        double highestCWA = 0;
                        for (student std: students) {
                            if (std.cwa > highestCWA) {
                                highestCWA = std.cwa;
                            }
                        }
                        System.out.println("the highest CWA is: " + highestCWA + "\nStudents with the highest CWA:");
                        for (student std: students) {
                            if (std.cwa == highestCWA) {
                                System.out.println(" | " + "ID: " + std.getStudentID() + " || Name: " + std.firstName + " " + std.familyName + " || CWA: " + std.cwa);
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid analysis choice.");
                        break;
                }
                break;
            case 6:
                //search student by ID
                found = false;
                System.out.print("enter ID: ");
                String Tempid = sc.next();
                for (student std: students) {
                    if (std.getStudentID().equals(Tempid)) {
                        System.out.println("Name: " + std.firstName + " " + std.familyName + " || Credits Earned: " + std.creditsEarned);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("\nStudent not found with ID: " + Tempid);
                }
                break;
            case 0:
                // Exit
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println(" \nInvalid choice. Please try again.");
                break;
        }
    }

}
