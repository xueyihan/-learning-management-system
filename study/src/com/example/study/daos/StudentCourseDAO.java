package com.example.study.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.objectweb.asm.xwork.tree.IntInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Course;
import com.example.study.entities.Student;
import com.example.study.entities.StudentCourse;
import com.example.study.entities.Term;

@Repository
public class StudentCourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 根据课程ID获取该课程的所有学生
	public List<Student> getAllStudents(Integer courseId) {
		String hql = "from StudentCourse sc where sc.course.courseId=?";
		Query query = getSession().createQuery(hql).setInteger(0, courseId);
		List<StudentCourse> studentCourses = (List<StudentCourse>) query.list();
		List<Student> students = new ArrayList<Student>();
		for(int i = 0;i < studentCourses.size();i++)
		{
			students.add(studentCourses.get(i).getStudent());
		}
		return students;
	}
	//根据课程ID和学生ID来添加选课信息
	public void addStudent(StudentCourse studentCourse)
	{
//		//根据学生ID得到学生
//		String studentHql = "from Student s where s.studentId=?";
//		Query studentQuery = getSession().createQuery(studentHql).setString(0, studentId);
//		Student student = (Student) studentQuery.uniqueResult();
//		//根据课程ID得到课程
//		String courseHql = "from Course c where c.courseId=?";
//		Query courseQuery = getSession().createQuery(courseHql).setInteger(0, courseId);
//		Course course = (Course) courseQuery.uniqueResult();
//		//根据课程ID得到学期
//		String termHql = "from Term t where t.termId=?";
//		Query termQuery = getSession().createQuery(termHql).setInteger(0, course.getTerm().getTermId());
//		Term term = (Term) termQuery.uniqueResult();
//		//添加选课信息
//		StudentCourse studentCourse = new StudentCourse(term,student,course);
		getSession().save(studentCourse);
	}
	
	//根据学生Id获得他所选的课程
	public Set<Course> getCoursesByStudentId(String studentId)
	{
		String hql = "from StudentCourse sc where sc.student.studentId=?";
		Query query = getSession().createQuery(hql).setString(0, studentId);
		List<StudentCourse> studentCourses = query.list();
		Set<Course> courses = new HashSet<Course>();
		for(StudentCourse sc : studentCourses)
		{
			courses.add(sc.getCourse());
		}
		return courses;
	}
}
