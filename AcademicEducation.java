import java.io.Serializable;
import java.time.LocalDate;

public class AcademicEducation implements Serializable {

    private String universityName;
    private AcademicDegree degree;
    private LocalDate degreeAwardDate;

    public AcademicEducation(String universityName, AcademicDegree degree, LocalDate degreeAwardDate) {
        this.universityName = universityName;
        this.degree = degree;
        this.degreeAwardDate = degreeAwardDate;
    }

    public String getUniversityName() {
        return universityName;
    }

    public AcademicDegree getDegree() {
        return degree;
    }

    public LocalDate getDegreeAwardDate() {
        return degreeAwardDate;
    }

    @Override
    public String toString() {
        return universityName + " (" + degree + ", " + degreeAwardDate + ")";
    }
}