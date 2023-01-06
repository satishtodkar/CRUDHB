package com.codemind.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codemind.model.Student;
import com.codemind.util.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			 transaction = session.beginTransaction();
			 
			 Object object = session.save(student);
			 
			 session.get(Student. class, (Serializable) object);
			 
			 transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void insertStudent() {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			String hql = "INSERT INTO Student (rollno, name, emailId, mobileNo, city)"+"SELECT rollno, name, emailId, mobileNo, city FROM Student";
			
			Query query = session.createQuery(hql);
//			query.setParameter("studentId", Id);
			int result = query.executeUpdate();
			System.out.println("Rows affected");
	
		
		transaction.commit();
	} catch (Exception e) {
		if(transaction !=null) {
			transaction.rollback();
		}	
		e.printStackTrace();
		}
	}
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			String hql = "UPDATE Student set name =:name "  + "WHERE id = :studentId";
			
			Query query = session.createQuery(hql);
			query.setParameter("name", student.getName());
			
			query.setParameter("studentId", 1);
			int result = query.executeUpdate();
			System.out.println("Row affected: " + result);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void deleteStudent(int Id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			Student student = session.get(Student.class, Id);
			if(student != null) {
				String hql = "DELETE FROM Student " + "WHERE Id =: stundetId";
				
				Query query = session.createQuery(hql);
				query.setParameter("studentId", Id);
				int result = query.executeUpdate();
				System.out.println("Row affected:" + result);
			}
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public Student getStudent(int Id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			String hql = "FROM Student S.id = :studentId";
			
			Query query = session.createQuery(hql);
			query.setParameter("studentId", Id);
			List result  = query.getResultList();
			
			if(result != null && !result.isEmpty()) {
				student = (Student) result.get(0);
			}
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}
	public List<Student> getStudent(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Student", Student.class).list();
		}
	}

}
