import java.time.LocalDate;

// Define an object class for Student creation.
public class Student {

    // student name
    private String name;
    // date of birth
    private Integer birthDate;
    // cumulative GPA
    private Float gpa;
    // department
    private String department;

    // NoArgs/When creating an object, it is created without any factors.
    public Student() {

    }

    // AllArgs/When creating an object, you get input at once.
    public Student(String name, Integer birthDate, Float gpa, String department) {
        this.name = name;
        this.birthDate = birthDate;
        this.gpa = gpa;
        this.department = department;
    }

    // Since each element is set to private, getter and setter functions are required to access.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Using LocalDate, Calculate the Global Age
    public Integer getAge() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() - this.birthDate;
    }
}
