package com.hamidur.cunyfirst.viewTier.configs.beanConfig;


import com.hamidur.cunyfirst.daoTier.daoServices.AdminService;
import com.hamidur.cunyfirst.daoTier.daoServices.CourseService;
import com.hamidur.cunyfirst.daoTier.daoServices.InstructorService;
import com.hamidur.cunyfirst.daoTier.daoServices.StudentService;
import com.hamidur.cunyfirst.daoTier.util.HibernateUtility;

import com.hamidur.cunyfirst.serviceTier.ApiService;

import com.hamidur.cunyfirst.viewTier.models.Address;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Contact;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.FAFSA;
import com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.InstructorCourse;
import com.hamidur.cunyfirst.viewTier.models.InstructorLogin;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.Person;
import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import com.hamidur.cunyfirst.viewTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
import com.hamidur.cunyfirst.viewTier.models.Term;
import com.hamidur.cunyfirst.viewTier.models.TransferInfo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackages =
        {"com.hamidur.cunyfirst.viewTier.models", "com.hamidur.cunyfirst.daoTier.models",
        "com.hamidur.cunyfirst.daoTier.util", "com.hamidur.cunyfirst.daoTier.daoServices"})
@Lazy
public class BeanConfiguration
{
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ApplicationContextProvider applicationContextProvider()
    {
        return new ApplicationContextProvider();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ApplicationContext applicationContext()
    {
        return applicationContextProvider().getApplicationContext();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PropertyHandler propertyHandler()
    {
        return new PropertyHandler();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Student student()
    {
        Student student = new Student();
        student.setAddress(address());
        student.setContact(contact());
        student.setHighSchoolInfo(highSchoolInfo());
        student.setTransferInfo(transferInfo());
        student.setLogin(login());
        student.setQuestionAnswers(questionAnswers());
        student.setFafsas(fafsas());
        student.setStudentCourses(studentCourses());

        return student;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Address address()
    {
        return new Address();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Contact contact()
    {
        return new Contact();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public HighSchoolInfo highSchoolInfo()
    {
        return new HighSchoolInfo();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TransferInfo transferInfo()
    {
        TransferInfo transferInfo = new TransferInfo();
        transferInfo.setTerm(term());
        return transferInfo;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Login login()
    {
        return new Login();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Term term()
    {
        return new Term();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Course course()
    {
        return new Course();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Set<StudentCourse> studentCourses()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SecurityQuestion securityQuestion()
    {
        return new SecurityQuestion();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Set<FAFSA> fafsas()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public FAFSA fafsa()
    {
        FAFSA fafsa = new FAFSA();
        fafsa.setTerm(term());
        return fafsa;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StudentCourse studentCourse()
    {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setTerm(term());
        studentCourse.setGrade(new String());
        studentCourse.setCourseStatus(new String());
        studentCourse.setCourse(course());
        return studentCourse;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Map<SecurityQuestion, String> questionAnswers()
    {
        return new LinkedHashMap<>();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Admin admin()
    {
        return new Admin();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Instructor instructor()
    {
        Instructor instructor = new Instructor();
        instructor.setLogin(instructorLogin());
        instructor.setInstructorCourses(instructorCourses());
        return instructor;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person person()
    {
        return new Person();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public InstructorLogin instructorLogin()
    {
        return new InstructorLogin();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Set<InstructorCourse> instructorCourses()
    {
        return new LinkedHashSet<>();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public InstructorCourse instructorCourse()
    {
        InstructorCourse instructorCourse = new InstructorCourse();

        instructorCourse.setTerm(term());
        instructorCourse.setCourse(course());

        return instructorCourse;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public HibernateUtility hibernateUtility()
    {
        return HibernateUtility.getInstance();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public ApiService apiService()
    {
        return new ApiService(studentService(), instructorService(), courseService(), adminService());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public StudentService studentService()
    {
        return new StudentService(hibernateUtility(), applicationContext());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public CourseService courseService()
    {
        return new CourseService(hibernateUtility(), applicationContext());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdminService adminService()
    {
        return new AdminService(hibernateUtility(), applicationContext());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public InstructorService instructorService()
    {
        return new InstructorService(hibernateUtility(), applicationContext());
    }
}