package day67.one2many.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import day67.one2many.entity.Grades;
import day67.one2many.entity.Student;
import day67.one2one.entity.Person;
import util.MybatisUtil;

/**
 * 持久层  查询个人身份证
 * @author leifeng
 * 2016年10月4日
 */
public class PersonCardDao {
	
	/**
	 * 查询"哈哈"是属于哪个学科的的信息
	 */
	public Grades findGradesByStudentName(String name) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			return sqlSession.selectOne("one2many_Grades.findGradesByStudentName", name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	/**
	 * 查询某学科下有多少个学生
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentByGradeName(String name) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			
			List<Student> studentList=sqlSession.selectList("one2many_Student.findStudentByGradeName", name);
			
			return studentList;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		PersonCardDao dao=new PersonCardDao();
		/*
		List<Student> studentList=dao.findStudentByGradeName("java");
		System.out.println("java学科有"+studentList.size()+"个学生，他们信息如下：");
		for (Student student : studentList) {
			System.out.println(student.getId()+":"+student.getName());
		}*/
		
		System.out.println("----------------------------------------------------");
		
		Grades grade=dao.findGradesByStudentName("哈哈哈");
		System.out.println("哈哈哈是属于："+grade.getName()+"学科的");
		
		
		
	}

}
