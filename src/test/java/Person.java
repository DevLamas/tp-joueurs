import java.sql.*;

public class Person {
    private int id;
    private String firstname;
    private String lastname;
    //private java.sql.Date dob;

    public Person (int id, String firstName, String lastName){
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        //this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*
    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

     */

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
