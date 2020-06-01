
/*
Example class, not intended to be used, is reference
https://stackoverflow.com/questions/52373469/how-to-launch-junit-5-platform-from-the-command-line-without-maven-gradle/52373592#52373592
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    private static ArrayList<Student> students;
    private static ArrayList<Student> inAgeOrderStudents;
    private static ArrayList<Student> inNameOrderStudents;

    @BeforeAll
    static void setUp(){
        initializeStudents();
        initSortedAgeStudents();
        initSortedNameStudents();
    }

    @BeforeEach
    void reloadStudents() {
        Collections.shuffle(students);
    }

   static void initializeStudents(){
        students = new ArrayList<Student>();

        students.add(new Student(18, "Tim"));
        students.add(new Student(18, "Tim"));
        students.add(new Student(16, "Jean"));
        students.add(new Student(14, "Lin"));
        students.add(new Student(19, "Sam"));
    }

    static void initSortedAgeStudents(){
        inAgeOrderStudents = new ArrayList<Student>();
        inAgeOrderStudents.add(new Student(14, "Lin"));
        inAgeOrderStudents.add(new Student(16, "Jean"));
        inAgeOrderStudents.add(new Student(18, "Tim"));
        inAgeOrderStudents.add(new Student(18, "Tim"));
        inAgeOrderStudents.add(new Student(19, "Sam"));
    }

    static void initSortedNameStudents(){
        inNameOrderStudents = new ArrayList<Student>();
        inNameOrderStudents.add(new Student(16, "Jean"));
        inNameOrderStudents.add(new Student(14, "Lin"));
        inNameOrderStudents.add(new Student(19, "Sam"));
        inNameOrderStudents.add(new Student(18, "Tim"));
        inNameOrderStudents.add(new Student(18, "Tim"));
    }



    @Test
    void testMergeSort() {
        assertNotEquals(students, inAgeOrderStudents);
        StudentSortSearch.mergesort(students,StudentSortSearch.SortSearchCriteria.AGE);
        assertEquals(14,students.get(0).getAge());
        assertEquals(19,students.get(4).getAge());
        assertEquals(students, inAgeOrderStudents);

        assertEquals(true,students.equals(inAgeOrderStudents));
    }

    @Test
    void testQuickSort() {
        StudentSortSearch.quickSort(students,StudentSortSearch.SortSearchCriteria.NAME);
        assertEquals("Jean",students.get(0).getName());
        assertEquals("Tim",students.get(4).getName());

        assertEquals(students, inNameOrderStudents);
    }

    @Test
    void testBinarySearch() {
        StudentSortSearch searcher = new StudentSortSearch();
        ArrayList<Student> searchResults = searcher.binarySearch(students, 18);
        assertEquals(2, searchResults.size());
        assertEquals(18,searchResults.get(1).getAge());
        assertEquals(18,searchResults.get(0).getAge());

        searchResults = searcher.binarySearch(students, "Lin");
        assertEquals(1, searchResults.size());
        assertEquals(14,searchResults.get(0).getAge());
    }
}