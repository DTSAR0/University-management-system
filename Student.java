import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Student extends Person implements Serializable {

    public static List<Student> extent = new ArrayList<>(); // extent
    private static final String EXTENT_FILE = "student_extent.ser"; // extent - persistence

    public enum Major {
        COMPUTER_SCIENCE,
        MANAGEMENT,
        GRAPHIC_DESIGN
    }

    public enum Subject {
        OBJECT_ORIENTED_PROGRAMMING,
        DISCRETE_MATHEMATICS,
        MATHEMATICAL_ANALYSIS,
        DATABASES,
        COMPUTER_NETWORKS,
        OPERATING_SYSTEMS,
        ALGORITHMS_AND_DATA_STRUCTURES,
        STATISTICS,
        ARTIFICIAL_INTELLIGENCE,
        COMPUTER_GRAPHICS,
        ENGLISH,
        PROJECT_MANAGEMENT
    }

    private static final double BASE_MONTHLY_FEE = 400.0; // class attribute
    private static final double ITN_SUBJECT_FEE = 50.0; // class attribute

    private long id;
    private List<Subject> individualCoursePath; // repeating attribute
    private Major major;
    private int semesterNumber;
    private Double scholarship; // optional attribute
    private HashMap<Subject, Double> grades; // repeating attribute

    public Student(String firstName, String lastName, Contact contact,
                   long id, List<Subject> individualCoursePath, Major major, int semesterNumber,
                   Double scholarship, HashMap<Subject, Double> grades) {
        super(firstName, lastName, contact);
        this.id = id;
        this.individualCoursePath = individualCoursePath != null ? new ArrayList<>(individualCoursePath) : new ArrayList<>();
        this.major = major;
        this.semesterNumber = semesterNumber;
        this.scholarship = scholarship;
        this.grades = grades != null ? new HashMap<>(grades) : new HashMap<>();
        addToExtent(this);
    }

    public Student(String firstName, String lastName, Contact contact,
                   long id, Major major, int semesterNumber) {
        super(firstName, lastName, contact);
        this.id = id;
        this.major = major;
        this.semesterNumber = semesterNumber;
        this.individualCoursePath = new ArrayList<>();
        this.grades = new HashMap<>();
        this.scholarship = null;
        addToExtent(this);
    }

    public static void addToExtent(Student student) {
        extent.add(student);
    }

    public static void displayExtent() {
        for (Student student : extent) {
            student.printData();
            System.out.println();
        }
    }

    public static void saveExtent() throws IOException { // extent - persistence
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(EXTENT_FILE))) {
            out.writeObject(extent);
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadExtent() throws IOException, ClassNotFoundException { // extent - persistence
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(EXTENT_FILE))) {
            extent = (List<Student>) in.readObject();
        }
    }

    @Override // override
    public void printData() {
        super.printData();
        System.out.print(
                ", id: " + id +
                        ", major: " + major +
                        ", semester number: " + semesterNumber +
                        ", scholarship: " + (scholarship != null ? scholarship : "none") +
                        ", average grade: " + getAverageGrade() +
                        ", monthly fee: " + calculateMonthlyFee() +
                        ", individual course path: " + individualCoursePath +
                        ", grades: " + grades
        );
    }

    public void setScholarship(Double scholarship) {
        this.scholarship = scholarship;
    }

    public Double getScholarship() {
        return scholarship;
    }

    public void addGrade(Subject subject, Double grade) {
        grades.put(subject, grade);
    }

    public void removeGrade(Subject subject) {
        grades.remove(subject);
    }

    public Double getGrade(Subject subject) {
        return grades.get(subject);
    }

    public void addIndividualCourse(Subject subject) {
        if (!individualCoursePath.contains(subject)) {
            individualCoursePath.add(subject);
        }
    }

    public void removeIndividualCourse(Subject subject) {
        individualCoursePath.remove(subject);
    }

    public double calculateMonthlyFee() { // derived attribute
        double monthlyFee = BASE_MONTHLY_FEE;
        if (individualCoursePath == null || individualCoursePath.isEmpty()) {
            return monthlyFee;
        }
        monthlyFee += individualCoursePath.size() * ITN_SUBJECT_FEE;
        return monthlyFee;
    }

    public double getAverageGrade() { // derived attribute
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public long getId() {
        return id;
    }

    public Major getMajor() {
        return major;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public List<Subject> getIndividualCoursePath() {
        return new ArrayList<>(individualCoursePath);
    }

    public Map<Subject, Double> getGrades() {
        return new HashMap<>(grades);
    }

    public double calculateMonthlyFee(int numberOfMonths) { // overloading
        return calculateMonthlyFee() * numberOfMonths;
    }

    public double calculateYearlyFee() {
        return calculateMonthlyFee(12);
    }
}