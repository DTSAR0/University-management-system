import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Contact studentContact1 = new Contact("jan.kowalski@student.pl", "123456789");
            Contact studentContact2 = new Contact("anna.nowak@student.pl", "987654321");
            Contact lecturerContact = new Contact("adam.nowicki@university.pl", "555444333");

            List<Student.Subject> studentPath1 = new ArrayList<>();
            studentPath1.add(Student.Subject.OBJECT_ORIENTED_PROGRAMMING);
            studentPath1.add(Student.Subject.DATABASES);

            HashMap<Student.Subject, Double> studentGrades1 = new HashMap<>();
            studentGrades1.put(Student.Subject.OBJECT_ORIENTED_PROGRAMMING, 5.0);
            studentGrades1.put(Student.Subject.DISCRETE_MATHEMATICS, 4.5);
            studentGrades1.put(Student.Subject.DATABASES, 4.0);

            Student student1 = new Student(
                    "Jan",
                    "Kowalski",
                    studentContact1,
                    1,
                    studentPath1,
                    Student.Major.COMPUTER_SCIENCE,
                    3,
                    1200.0,
                    studentGrades1
            );

            Student student2 = new Student(
                    "Anna",
                    "Nowak",
                    studentContact2,
                    2,
                    Student.Major.GRAPHIC_DESIGN,
                    2
            );

            student2.addGrade(Student.Subject.COMPUTER_GRAPHICS, 5.0);
            student2.addGrade(Student.Subject.ENGLISH, 4.0);
            student2.addIndividualCourse(Student.Subject.COMPUTER_GRAPHICS);
            student2.setScholarship(900.0);

            System.out.println("=== STUDENT TEST ===");
            student1.printData();
            System.out.println();
            student2.printData();
            System.out.println();
            System.out.println("Average grade of student 1: " + student1.getAverageGrade());
            System.out.println("Monthly fee of student 1: " + student1.calculateMonthlyFee());
            System.out.println("Yearly fee of student 1: " + student1.calculateYearlyFee());
            System.out.println();

            System.out.println("=== STUDENT EXTENT ===");
            Student.displayExtent();
            System.out.println();

            Student.saveExtent();
            Student.extent.clear();
            System.out.println("=== STUDENT EXTENT AFTER CLEARING ===");
            Student.displayExtent();
            System.out.println();

            Student.loadExtent();
            System.out.println("=== STUDENT EXTENT AFTER LOADING FROM FILE ===");
            Student.displayExtent();
            System.out.println();

            List<WorkExperience> experiences = new ArrayList<>();
            experiences.add(new WorkExperience(
                    "PJATK",
                    "Assistant",
                    LocalDate.of(2020, 10, 1),
                    LocalDate.of(2022, 9, 30)
            ));
            experiences.add(new WorkExperience(
                    "PJATK",
                    "Assistant Professor",
                    LocalDate.of(2022, 10, 1),
                    LocalDate.of(2026, 3, 29)
            ));

            List<AcademicEducation> education = new ArrayList<>();
            education.add(new AcademicEducation(
                    "Warsaw University of Technology",
                    AcademicDegree.MASTER,
                    LocalDate.of(2015, 7, 1)
            ));
            education.add(new AcademicEducation(
                    "University of Warsaw",
                    AcademicDegree.DOCTOR,
                    LocalDate.of(2020, 6, 15)
            ));

            Lecturer lecturer1 = new Lecturer(
                    "Adam",
                    "Nowicki",
                    lecturerContact,
                    100,
                    AcademicDegree.DOCTOR,
                    experiences,
                    education,
                    120,
                    80.0
            );

            System.out.println("=== LECTURER TEST ===");
            lecturer1.printData();
            System.out.println();
            System.out.println("Lecturer salary: " + lecturer1.calculateSalary());
            System.out.println();

            System.out.println("=== LECTURER EXTENT ===");
            Lecturer.displayExtent();
            System.out.println();

            Lecturer.saveExtent();
            Lecturer.extent.clear();
            System.out.println("=== LECTURER EXTENT AFTER CLEARING ===");
            Lecturer.displayExtent();
            System.out.println();

            Lecturer.loadExtent();
            System.out.println("=== LECTURER EXTENT AFTER LOADING FROM FILE ===");
            Lecturer.displayExtent();
            System.out.println();

            System.out.println("=== LECTURER VALIDATION TEST ===");
            try {
                new Lecturer(
                        "Piotr",
                        "Test",
                        new Contact("piotr@test.pl", "111222333"),
                        101,
                        AcademicDegree.MASTER,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        50,
                        20.0
                );
            } catch (RuntimeException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}