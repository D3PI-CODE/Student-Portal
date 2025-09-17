import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class handler {
    
    public static student[] read() {
        int i = 0;
        int rowcount = 0;
        String Filename = "Data.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(Filename)))  {
            br.readLine();
            while ((br.readLine()) != null) {
                rowcount ++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        student[] students = new student[rowcount];

        try (BufferedReader br = new BufferedReader(new FileReader(Filename)))  {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students[i] = new student(
                        values[0].trim(), 
                        values[1].trim(),
                        values[2].trim(), 
                        values[3].trim(),
                        Integer.parseInt(values[4].trim()), 
                        Double.parseDouble(values[5].trim()), 
                        values[6].trim(), 
                        Integer.parseInt(values[7].trim())
                        );
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void append(String appends) {
        // Implementation for writing student data back to the file
        String Filename = "Data.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filename, true))) {
            bw.append(appends);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void edit(student[] students) {
        // Implementation for editing student data in the file
        String Filename = "Data.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Filename))) {
            bw.write("StudentID, FirstName, FamilyName, CourseEnrolled, YearLevel, CWA, Status, CreditsEarned\n");
            for (student std : students) {
                if (std != null) {
                    bw.write(std.getStudentID() + "," + std.firstName + "," + std.familyName + "," + std.courseEnrolled + "," + std.yearLevel + "," + std.cwa + "," + std.status + "," + std.creditsEarned + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

