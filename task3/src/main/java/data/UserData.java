package data;

public class UserData {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public UserData(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;

        UserData userData = (UserData) o;

        if (!firstName.equals(userData.firstName)) return false;
        if (!lastName.equals(userData.lastName)) return false;
        if (!email.equals(userData.email)) return false;
        if (!age.equals(userData.age)) return false;
        if (!salary.equals(userData.salary)) return false;
        return department.equals(userData.department);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
