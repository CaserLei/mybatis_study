package day67.many2many.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import day67.many2many.entity.Courses;
import day67.many2many.entity.Student;
import util.MybatisUtil;

/**
 * 持久层  查询个人身份证
 * @author leifeng
 * 2016年10月4日
 */
public class StudentCourseDao {
	
	/**
	 * 查询"哈哈"是选学了那些学科
	 * @param  学生姓名
	 * @return 返回学生选择的课程
	 */
	public List<Courses> findCoursesByStudentName(String name) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			return sqlSession.selectList("many2many_Courses.findCourseByStudentName", name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	/**
	 * 查询课程被那些学生选修
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentByCoursesName(String name) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			
			List<Student> studentList=sqlSession.selectList("many2many_Student.findStudentByCoursesName", name);
			
			return studentList;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	public Student findStudentById(int id) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			
			Student student=sqlSession.selectOne("many2many_Student.findStudentById", id);
			
			return student;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		StudentCourseDao dao=new StudentCourseDao();
		
		/*List<Courses> coursesList=dao.findCoursesByStudentName("哈哈");
		System.out.println("学生哈哈选择的课程如下：");
		for (Courses courses : coursesList) {
			System.out.println(courses.getName());
		}*/
		
		/*System.out.println("=-----------------------------------------------------");
		
		List<Student> studentList=dao.findStudentByCoursesName("java");
		System.out.println("学生哈哈选择的课程如下：");
		for (Student s : studentList) {
			System.out.println(s.getName());
		}*/
		
		
		Student student=dao.findStudentById(2);
		
		System.out.println(student.getId()+":"+student.getName()+":"+student.getCoursesList());
		List<Courses>  coursesList=student.getCoursesList();
		System.out.println("学生1选择的课程如下：");
		for (Courses courses : coursesList) {
			System.out.println(courses.getName());
		}
		
		
		
	}

}
