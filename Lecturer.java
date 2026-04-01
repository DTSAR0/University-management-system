import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Lecturer extends Person implements Serializable {

    public static List<Lecturer> extent = new ArrayList<>(); // extent
    private static final String EXTENT_FILE = "lecturer_extent.ser"; // extent - persistence

    private static final double MIN_HOURLY_RATE = 35.0; // class attribute
    private static final int MIN_TEACHING_HOURS = 80; // class attribute
    private static final int MAX_TEACHING_HOURS = 192; // class attribute

    private int id;
    private AcademicDegree academicDegree; // simple attribute
    private List<WorkExperience> workExperience; // repeating composite attribute
    private List<AcademicEducation> academicEducation; // repeating composite attribute
    private int teachingHours; // simple attribute
    private double hourlyRate; // simple attribute

    public Lecturer(String firstName,
                    String lastName,
                    Contact contact,
                    int id,
                    AcademicDegree academicDegree,
                    List<WorkExperience> workExperience,
                    List<AcademicEducation> academicEducation,
                    int teachingHours,
                    double hourlyRate) {
        super(firstName, lastName, contact);
        this.id = id;
        this.academicDegree = academicDegree;
        this.workExperience = workExperience != null ? new ArrayList<>(workExperience) : new ArrayList<>();
        this.academicEducation = academicEducation != null ? new ArrayList<>(academicEducation) : new ArrayList<>();
        setTeachingHours(teachingHours);
        setHourlyRate(hourlyRate);
        addToExtent(this);
    }

    public static void addToExtent(Lecturer lecturer) {
        extent.add(lecturer);
    }

    public static void displayExtent() {
        for (Lecturer lecturer : extent) {
            lecturer.printData();
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
            extent = (List<Lecturer>) in.readObject();
        }
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < MIN_HOURLY_RATE) {
            throw new RuntimeException("Minimum hourly rate is 35");
        }
        this.hourlyRate = hourlyRate;
    }

    public void setTeachingHours(int teachingHours) {
        if (teachingHours < MIN_TEACHING_HOURS || teachingHours > MAX_TEACHING_HOURS) {
            throw new RuntimeException("Teaching hours must be in the range 80-192");
        }
        this.teachingHours = teachingHours;
    }

    public double calculateSalary() { // derived attribute
        return teachingHours * hourlyRate;
    }

    @Override // override
    public void printData() {
        super.printData();
        System.out.print(", id: " + id +
                ", academic degree: " + academicDegree +
                ", teaching hours: " + teachingHours +
                ", hourly rate: " + hourlyRate +
                ", salary: " + calculateSalary() +
                ", work experience: " + workExperience +
                ", academic education: " + academicEducation);
    }
}