package com.hamidur.cunyfirst.viewTier;

import com.hamidur.cunyfirst.viewTier.models.Address;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Contact;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.FAFSA;
import com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.InstructorCourse;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
import com.hamidur.cunyfirst.viewTier.models.Term;
import com.hamidur.cunyfirst.viewTier.models.TransferInfo;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ViewRelatedTester
{
    public static void main(java.lang.String[] args)
    {
        try
        {
            String p[] = "10/5/2015".split("/");
            System.out.println(p[0] + " " + p[1] + " " + p[2]);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Student testStudent()
    {
        Student student = new Student("Hamidur", "Rahman", "090212999", "10/05/1997", "M");
        student.setStudentId(10000001);
        student.setAddress(testAddress());
        student.setContact(testContact());
        student.setHighSchoolInfo(testHighSchoolInfo());
        student.setTransferInfo(testTransferInfo());
        student.setLogin(testLogin());
//        student.setStudentCourses(studentCourses());
        student.setFafsas(fafsas());
        return student;
    }

    public static Instructor testInstructor()
    {
        return new Instructor(101,"Hamidur", "Rahman", "123456789", "11/21/1998", "M");
    }

    public static Set<FAFSA> fafsas()
    {
        Set<FAFSA> fafsas = new LinkedHashSet<>();
        fafsas.add(new FAFSA(testTerm().get(0), 1890.50));
        fafsas.add(new FAFSA(testTerm().get(1), 2100.00));
        return fafsas;
    }

//    public static Admin testAdmin()
//    {
//        return new Admin("Hamidur", "Rahman", "212990121", "12/12/1998", Gender.F.toString());
//    }
    
    public static Address testAddress()
    {
        return new Address("47th", "5040", "woodside", "NY", "00123");
    }
    
    public static Contact testContact()
    {
        return new Contact("1112220000", "personal@email.com", "college@college.edu");
    }
    
    public static HighSchoolInfo testHighSchoolInfo()
    {
        return new HighSchoolInfo("Model High School", 2014, "Sylhet", "BD");
    }
    
    public static TransferInfo testTransferInfo()
    {
        return new TransferInfo("schoolName", testTerm().get(0));
    }
    
    public static List<Term> testTerm()
    {
        return new LinkedList<>(Arrays.asList(new Term("Spring", 2016),
                new Term("Fall", 2016)));
    }
    
    public static Login testLogin()
    {
        return new Login("hamidur.rahman@college.edu", "hashfunction", true);
    }

//    public static List<Course> demoCourses()
//    {
//        List<Course> courses = new LinkedList<>();
//
//        Course c1 = new Course("Beginner Arts", CourseName.HUA.toString(), 101, 3.0f, "description");
//
//        Course c2 = new Course("Intermediate Accounting", CourseName.BTA.toString(), 111, 3.0f, "description");
//
//        Course c3 = new Course("Sub 3", CourseName.MAC.toString(), 101, 3.0f, "description");
//
//        Course c4 = new Course("Sub 4 Accounting", CourseName.ENG.toString(), 270, 3.0f, "description");
//
//        Course c5 = new Course("Sub 5 Accounting", CourseName.SCP.toString(), 231, 4.0f, "description");
//
//        courses.addAll(Arrays.asList(c1, c2, c3, c4, c5));
//
//        return courses;
//    }

//    public static Set<StudentCourse> studentCourses()
//    {
//        Set<StudentCourse> studentCourses = new LinkedHashSet<>();
//        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.TAKEN.getValue(),
//                Grade.A.getValue(), testTerm().get(0)));
//        studentCourses.add(new StudentCourse(demoCourses().get(2), CourseStatus.TAKEN.getValue(),
//                Grade.C_PLUS.getValue(), testTerm().get(0)));
//        studentCourses.add(new StudentCourse(demoCourses().get(3), CourseStatus.TAKEN.getValue(),
//                Grade.A.getValue(), testTerm().get(1)));
//        studentCourses.add(new StudentCourse(demoCourses().get(4), CourseStatus.TAKEN.getValue(),
//                Grade.F.getValue(), testTerm().get(1)));
//        return studentCourses;
//    }

//    public static Set<StudentCourse> allStudentCourses()
//    {
//        Set<StudentCourse> studentCourses = new LinkedHashSet<>();
//
//        Student s1 = new Student("first name", "last name", "", "", "");
//        s1.setStudentId(10000021);
//
//        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.IN_PROGRESS.getValue(),
//                Grade.A.getValue(), testTerm().get(0)));
//        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.IN_PROGRESS.getValue(),
//                Grade.C_PLUS.getValue(), testTerm().get(0)));
//        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.IN_PROGRESS.getValue(),
//                Grade.A_MINUS.getValue(), testTerm().get(0)));
//        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.IN_PROGRESS.getValue(),
//                Grade.B.getValue(), testTerm().get(0)));
//
//        return studentCourses;
//    }

//    public static List<InstructorCourse> instructorCourses()
//    {
//        List<InstructorCourse> instructorCourses = new LinkedList<>();
//
//        InstructorCourse ic1 = new InstructorCourse(); ic1.setCourse(demoCourses().get(0)); ic1.setTerm(testTerm().get(0));
//        InstructorCourse ic2 = new InstructorCourse(); ic2.setCourse(demoCourses().get(1)); ic2.setTerm(testTerm().get(1));
//
//        instructorCourses.add(ic1);
//        instructorCourses.add(ic2);
//
//        return instructorCourses;
//    }
}
