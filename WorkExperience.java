import java.io.Serializable;
import java.time.LocalDate;

public class WorkExperience implements Serializable {

    private String institutionName;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;

    public WorkExperience(String institutionName, String position,
                          LocalDate startDate, LocalDate endDate) {
        this.institutionName = institutionName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return institutionName + " (" + position + ", " + startDate + " - " + endDate + ")";
    }
}