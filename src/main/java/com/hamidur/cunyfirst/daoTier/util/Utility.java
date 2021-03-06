package com.hamidur.cunyfirst.daoTier.util;

import com.hamidur.cunyfirst.daoTier.models.Address;
import com.hamidur.cunyfirst.daoTier.models.Contact;
import com.hamidur.cunyfirst.daoTier.models.Course;
import com.hamidur.cunyfirst.daoTier.models.FAFSA;
import com.hamidur.cunyfirst.daoTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.daoTier.models.Instructor;
import com.hamidur.cunyfirst.daoTier.models.InstructorCourse;
import com.hamidur.cunyfirst.daoTier.models.InstructorLogin;
import com.hamidur.cunyfirst.daoTier.models.Login;
import com.hamidur.cunyfirst.daoTier.models.Person;
import com.hamidur.cunyfirst.daoTier.models.SecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Student;
import com.hamidur.cunyfirst.daoTier.models.StudentCourse;
import com.hamidur.cunyfirst.daoTier.models.StudentSecurityQuestion;
import com.hamidur.cunyfirst.daoTier.models.Term;
import com.hamidur.cunyfirst.daoTier.models.TransferInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utility
{
    public static com.hamidur.cunyfirst.viewTier.models.Course toViewCourse(Course daoCourse)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Course
                (daoCourse.getCourseId(), daoCourse.getCourseTitle(), daoCourse.getCourseName(),
                daoCourse.getCourseLevel(), daoCourse.getCourseCredits(), daoCourse.getDescription());
    }

    public static Course toDaoCourse(com.hamidur.cunyfirst.viewTier.models.Course course)
    {
        return new Course(course.getCourseTitle(), course.getCourseName(),
                course.getCourseLevel(), course.getCourseCredits(), course.getDescription());
    }

    public static Instructor toDaoInstructor(com.hamidur.cunyfirst.viewTier.models.Instructor instructor)
    {
        Instructor instructor1 = new Instructor();
        Person person = new Person();

        person.setFirstName(instructor.getFirstName());
        person.setLastName(instructor.getLastName());
        String[] parts = instructor.getDateOfBirth().split("/");
        person.setDateOfBirth(LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0])));
        person.setSsn(instructor.getSsn());
        person.setGender(instructor.getGender());

        instructor1.setPerson(person);
        return instructor1;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Instructor toViewInstructor(Instructor daoInstructor)
    {
        com.hamidur.cunyfirst.viewTier.models.Instructor instructor =
                new com.hamidur.cunyfirst.viewTier.models.Instructor();

        instructor.setInstructorId(daoInstructor.getInstructorId());
        instructor.setFirstName(daoInstructor.getPerson().getFirstName());
        instructor.setLastName(daoInstructor.getPerson().getLastName());
        instructor.setSsn(daoInstructor.getPerson().getSsn());
        instructor.setDateOfBirth(daoInstructor.getPerson().getDateOfBirth().toString());
        instructor.setGender(daoInstructor.getPerson().getGender());

        instructor.setLogin(toViewInstructorLogin(daoInstructor.getLogin()));

        return instructor;
    }

    public static Set<InstructorCourse> toDaoInstructorCourses
            (Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> instructorCourses)
    {
        Set<InstructorCourse> courses = new LinkedHashSet<>();

        instructorCourses.forEach(e ->
        {
            InstructorCourse instructorCourse = new InstructorCourse();

            instructorCourse.setCourse(Utility.toDaoCourse(e.getCourse()));
            instructorCourse.setInstructor(Utility.toDaoInstructor(e.getInstructor()));
            instructorCourse.setTerm(Utility.toDaoTerm(e.getTerm()));

            courses.add(instructorCourse);
        });
        return courses;
    }

    public static Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> toViewInstructorCourses
            (List<InstructorCourse> daoInstructorCourses)
    {
        Set<com.hamidur.cunyfirst.viewTier.models.InstructorCourse> courses = new LinkedHashSet<>();

        daoInstructorCourses.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.InstructorCourse instructorCourse =
                    new com.hamidur.cunyfirst.viewTier.models.InstructorCourse();

            instructorCourse.setCourse(Utility.toViewCourse(e.getCourse()));
            instructorCourse.setTerm(Utility.toViewTerm(e.getTerm()));

            courses.add(instructorCourse);
        });
        return courses;
    }

    public static Address toDaoAddress(com.hamidur.cunyfirst.viewTier.models.Address address)
    {
        Address address1 = new Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());

        if(address.getAddressId() == null) return address1;
        else address.setAddressId(address.getAddressId());
        return address1;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Address toViewAddress(Address address)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Address(address.getStreet(), address.getCrossStreet(),
                address.getCity(), address.getState(), address.getZipCode());
    }

    public static com.hamidur.cunyfirst.viewTier.models.Contact toViewContact(Contact daoContact)
    {
        com.hamidur.cunyfirst.viewTier.models.Contact contact = new com.hamidur.cunyfirst.viewTier.models.Contact();

        if(daoContact.getPhone() != null) contact.setPhone(daoContact.getPhone().getPhone());
        contact.setCollegeEmail(daoContact.getCollegeEmail());
        contact.setEmail(daoContact.getEmail());

        return contact;
    }

    public static Contact toDaoContact(com.hamidur.cunyfirst.viewTier.models.Contact contact)
    {
        Contact contact1 = new Contact(contact.getCollegeEmail(), contact.getEmail(), contact.getPhone());
        if(contact.getContactId() == null) return contact1;
        else contact1.setContactId(contact.getContactId());
        return contact1;
    }

    public static Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> toViewStudentCourses(Set<StudentCourse> studentCourses)
    {
        Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> studentCourseSet = new LinkedHashSet<>();

        if(studentCourses == null) return studentCourseSet;

        studentCourses.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.StudentCourse studentCourse =
                    new com.hamidur.cunyfirst.viewTier.models.StudentCourse();

            studentCourse.setCourse(toViewCourse(e.getCourse()));
            studentCourse.setCourseStatus(e.getCourseStatus());
            studentCourse.setGrade(e.getGrade());
            studentCourse.setTerm(toViewTerm(e.getTerm()));

            studentCourseSet.add(studentCourse);
        });

        return studentCourseSet;
    }

    public static Set<StudentCourse> toDaoStudentCourses(Set<com.hamidur.cunyfirst.viewTier.models.StudentCourse> studentCourses)
    {
        Set<StudentCourse> studentCourseSet = new LinkedHashSet<>();

        studentCourses.forEach(e ->
        {
            StudentCourse studentCourse = new StudentCourse();

            studentCourse.setCourse(toDaoCourse(e.getCourse()));
            studentCourse.setCourseStatus(e.getCourseStatus());
            studentCourse.setGrade(e.getGrade());
//            studentCourse.setStudent(toDaoStudent(e.getStudent()));

            studentCourseSet.add(studentCourse);
        });

        return studentCourseSet;
    }

    public static Student toDaoStudent(com.hamidur.cunyfirst.viewTier.models.Student student)
    {
        Student daoStudent = new Student();
        Person person = new Person();

        person.setFirstName(student.getFirstName());
        person.setLastName(student.getLastName());
        person.setSsn(student.getSsn());
        person.setDateOfBirth(toDaoDOB(student.getDateOfBirth()));
        person.setGender(student.getGender());

        daoStudent.setPerson(person);

        return daoStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Student toViewStudent(Student daoStudent)
    {
        com.hamidur.cunyfirst.viewTier.models.Student viewStudent =
                new com.hamidur.cunyfirst.viewTier.models.Student();

        viewStudent.setStudentId(daoStudent.getStudentId());
        viewStudent.setFirstName(daoStudent.getPerson().getFirstName());
        viewStudent.setLastName(daoStudent.getPerson().getLastName());
        viewStudent.setSsn(daoStudent.getPerson().getSsn());
        viewStudent.setDateOfBirth(toViewDOB(daoStudent.getPerson().getDateOfBirth()));
        viewStudent.setGender(daoStudent.getPerson().getGender());

        return viewStudent;
    }

    public static com.hamidur.cunyfirst.viewTier.models.SecurityQuestion toViewSecurityQuestion(SecurityQuestion securityQuestion)
    {
        return new com.hamidur.cunyfirst.viewTier.models.SecurityQuestion(securityQuestion.getQuestionId(), securityQuestion.getQuestion());
    }

    public static SecurityQuestion toDaoSecurityQuestion(com.hamidur.cunyfirst.viewTier.models.SecurityQuestion securityQuestion)
    {
        return new SecurityQuestion(securityQuestion.getQuestion());
    }

    public static Set<StudentSecurityQuestion> toDaoStudentSecurityQuestionsAns
            (Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> securityQuestionStringMap)
    {
        Set<StudentSecurityQuestion> securityQuestions = new LinkedHashSet<>();

        for(com.hamidur.cunyfirst.viewTier.models.SecurityQuestion securityQuestion: securityQuestionStringMap.keySet())
        {
            StudentSecurityQuestion question = new StudentSecurityQuestion();
            question.setSecurityQuestion(toDaoSecurityQuestion(securityQuestion));

            securityQuestions.add(question);
        }

        return securityQuestions;
    }

    public static Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> toViewStudentSecurityQuestionsAns
            (Set<StudentSecurityQuestion> studentSecurityQuestions)
    {
        Map<com.hamidur.cunyfirst.viewTier.models.SecurityQuestion, String> securityQuestions = new LinkedHashMap<>();

        if(studentSecurityQuestions == null) return securityQuestions;

        studentSecurityQuestions.forEach(e ->
                securityQuestions.put(toViewSecurityQuestion(e.getSecurityQuestion()), e.getAnswer()));

        return securityQuestions;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Login toViewStudentLogin(Login daoLogin)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Login(daoLogin.getUserName(), daoLogin.getPassword(), daoLogin.getActive());
    }

    public static Login toDaoInstructorLogin(com.hamidur.cunyfirst.viewTier.models.Login login)
    {
        return new Login(login.getUsername(), login.getPassword(), login.getActive());
    }

    public static com.hamidur.cunyfirst.viewTier.models.TransferInfo toViewTransferInfo(TransferInfo transferInfo)
    {
        if(transferInfo == null) return new com.hamidur.cunyfirst.viewTier.models.TransferInfo();
        return new com.hamidur.cunyfirst.viewTier.models.TransferInfo
                (transferInfo.getTransferSchoolName(), toViewTerm(transferInfo.getTerm()));
    }

    public static TransferInfo toDaoTransferInfo(com.hamidur.cunyfirst.viewTier.models.TransferInfo transferInfo)
    {
        TransferInfo transferInfo1 = new TransferInfo();

        if(transferInfo == null)
        {
            transferInfo1.setTerm(toDaoTerm(new com.hamidur.cunyfirst.viewTier.models.Term()));
            return transferInfo1;
        }
        transferInfo1.setTransferSchoolName(transferInfo.getTransferSchoolName());
        transferInfo1.setTerm(toDaoTerm(new com.hamidur.cunyfirst.viewTier.models.Term()));

        if(transferInfo.getTransferId() == null) return transferInfo1;
        else transferInfo1.setTransferInfoId(transferInfo.getTransferId());
        return transferInfo1;
    }

    public static com.hamidur.cunyfirst.viewTier.models.Term toViewTerm(Term term)
    {
        return new com.hamidur.cunyfirst.viewTier.models.Term(term.getTermName(), term.getTermYear());
    }

    public static Term toDaoTerm(com.hamidur.cunyfirst.viewTier.models.Term term)
    {
        return new Term(term.getTermName(), term.getTermYear());
    }

    public static com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo toViewHighSchoolInfo(HighSchoolInfo schoolInfo)
    {
        if(schoolInfo == null) return new com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo();

        com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo view =
                new com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo();

        view.setHighSchoolId(schoolInfo.getHighSchoolId());
        view.setHighSchoolName(schoolInfo.getHighSchoolName());
        view.setCity(schoolInfo.getCity());
        view.setCountry(schoolInfo.getCountry());
        view.setYear(schoolInfo.getYear());

        return view;
    }

    public static HighSchoolInfo toDaoHighSchoolInfo(com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo schoolInfo)
    {
        HighSchoolInfo highSchoolInfo = new HighSchoolInfo
                (schoolInfo.getHighSchoolName(), schoolInfo.getYear(), schoolInfo.getCity(), schoolInfo.getCountry());
        if(schoolInfo.getHighSchoolId() == null) return highSchoolInfo;
        else highSchoolInfo.setHighSchoolId(schoolInfo.getHighSchoolId());
        return highSchoolInfo;
    }

    public static com.hamidur.cunyfirst.viewTier.models.InstructorLogin toViewInstructorLogin(InstructorLogin daoLogin)
    {
        return daoLogin == null ? new com.hamidur.cunyfirst.viewTier.models.InstructorLogin() : new com.hamidur.cunyfirst.viewTier.models.InstructorLogin
                (daoLogin.getUserName(), daoLogin.getPassword(), daoLogin.getActive());
    }

    public static InstructorLogin toDaoInstructorLogin(com.hamidur.cunyfirst.viewTier.models.InstructorLogin login)
    {
        return new InstructorLogin(login.getUsername(), login.getPassword());
    }

    public static Set<FAFSA> toDaoFafsas(Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsas)
    {
        Set<FAFSA> fafsas1 = new LinkedHashSet<>();

        fafsas.forEach(e ->
        {
            FAFSA fafsa = new FAFSA();
            fafsa.setAmount(e.getAmount());
            fafsa.setTerm(toDaoTerm(e.getTerm()));
        });

        return fafsas1;
    }

    public static Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> toViewFafsas(Set<FAFSA> fafsas)
    {
        if(fafsas == null) return new LinkedHashSet<>();
        Set<com.hamidur.cunyfirst.viewTier.models.FAFSA> fafsaSet = new LinkedHashSet<>();

        fafsas.forEach(e ->
        {
            com.hamidur.cunyfirst.viewTier.models.FAFSA fafsa = new com.hamidur.cunyfirst.viewTier.models.FAFSA();
            fafsa.setAmount(e.getAmount());
            fafsa.setTerm(toViewTerm(e.getTerm()));

            fafsaSet.add(fafsa);
        });

        return fafsaSet;
    }

    public static LocalDate toDaoDOB(String dob)
    {
        String parts[] = dob.split("/");
        return LocalDate.of(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
    }

    public static String toViewDOB(LocalDate dob)
    {
        return dob.getDayOfWeek().getValue()+"/"+dob.getMonthValue()+"/"+dob.getYear();
    }

//    public static com.hamidur.cunyfirst.viewTier.models.FAFSA toViewFafsa(FAFSA fafsa) {
//        com.hamidur.cunyfirst.viewTier.models.FAFSA viewFafsa =
//                applicationContext.getBean(com.hamidur.cunyfirst.viewTier.models.FAFSA.class);
//        viewFafsa.setTerm(Utility.toViewTerm(fafsa.getTerm()));
//        viewFafsa.setAmount(fafsa.getAmount());
//        return
//    }
}
