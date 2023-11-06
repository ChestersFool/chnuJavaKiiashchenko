package lab4;

import lab1.models.builders.StudentBuilder;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestLab4 {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testForPhoneNumber() {
        new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A")
                .setDateOfBirth(LocalDate.parse("2022-01-11")).setPhoneNumber("++0999999999999").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testForDoB(){
        new StudentBuilder().setName("Ivan").setSurname("Ivanov").setStudentsClass("1-A")
                .setDateOfBirth(LocalDate.parse("2025-01-11")).setPhoneNumber("+0999999999999").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testForName(){
        new StudentBuilder().setName("Ivan1").setSurname("Ivanov").setStudentsClass("1-A")
                .setDateOfBirth(LocalDate.parse("2021-01-11")).setPhoneNumber("+0999999999999").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testForSurname(){
        new StudentBuilder().setName("Ivan").setSurname("Ivanov1").setStudentsClass("1-A")
                .setDateOfBirth(LocalDate.parse("2021-01-11")).setPhoneNumber("+0999999999999").build();
    }
}
