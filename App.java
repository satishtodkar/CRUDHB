package com.codemind;

import java.util.List;

import com.codemind.dao.StudentDao;
import com.codemind.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("61", "Satish", "satodkar2000@gmail.com", "7875621562", "Sangola");
        
        studentDao.saveStudent(student);
        
        studentDao.insertStudent();
        
        Student student1 = new Student("62", "Vishal", "vishal2000@gmail.com", "7821084386", "Sangola");
        studentDao.updateStudent(student1);
        
        List<Student> students = studentDao.getStudent();
        students.forEach(s-> System.out.println(s.getRollno()));
        
        Student student2 = studentDao.getStudent(1);
        System.out.println(student2.getRollno());
        
        studentDao.deleteStudent(1);
    }
}
