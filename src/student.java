
public class student {
    private String studentID;
    String firstName;
    String familyName;
    String courseEnrolled;
    int yearLevel;
    double cwa;
    String status;
    int creditsEarned;
    
    public student (String studentID, String firstName, String familyName, String courseEnrolled,
                   int yearLevel, double cwa, String status, int creditsEarned) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.familyName = familyName;
        this.courseEnrolled = courseEnrolled;
        this.yearLevel = yearLevel;
        this.cwa = cwa;
        this.status = status;
        this.creditsEarned = creditsEarned;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

}
