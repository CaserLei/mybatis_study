package day66.app02.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import day66.app02.entity.Student;
import util.MybatisUtil;

/**
 * 持久层
 * @author leifeng
 * 2016年10月1日
 */
public class StudentDao {
	/**
	 * 增加学生
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			//事物开启(默认)
			//读取StudentMapper.xml 映射文件中的SQL语句
			int i=sqlSession.insert("student_app02.insert",student);
			System.out.println("本次操作影响了"+i+"行");
			//事物提交
			sqlSession.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//事物回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
	}
	
	/**
	 * 查询学生
	 * @param args
	 * @throws Exception
	 */
	public Student findStudentById(int id) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			Student student=sqlSession.selectOne("student_app02.findById",id);
			
			sqlSession.commit();
			
			return student;
			
		}catch(Exception e){
			e.printStackTrace();
			//事物回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	/**
	 * 查询学生
	 * @param args
	 * @throws Exception
	 */
	public void updateStudentById(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			int i=sqlSession.update("student_app02.update",student);
			System.out.println("更新了"+i+"个学生！");
			sqlSession.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//事物回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	/**
	 * 查询所有学生
	 * @param args
	 * @throws Exception
	 */
	public List<Student> findAll() throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			List<Student> studentList=sqlSession.selectList("student_app02.findAll");
			
			sqlSession.commit();
			
			return studentList;
			
		}catch(Exception e){
			e.printStackTrace();
			//事物回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	/**
	 * 查询所有学生
	 * @param args
	 * @throws Exception
	 */
	public void deleteStudentById(int id) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
		    sqlSession.delete("student_app02.deleteStudentById",id);
			System.out.println("删除了id为"+id+"的学生");
			sqlSession.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//事物回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		StudentDao dao=new StudentDao();
		/*dao.add(new Student(2,"哈哈哈",10000.00));
		dao.add(new Student(3,"哈asdf",90000.00));
		dao.add(new Student(4,"哈哈asdf哈",80000.00));
		dao.add(new Student(6,"哈ada",70000.00));
		dao.add(new Student(7,"哈dsf",60000.00));
		dao.add(new Student(8,"哈哈哈",50000.00));
		dao.add(new Student(9,"哈adf",50000.00));
		dao.add(new Student(10,"哈asdf",50000.00));
		dao.add(new Student(13,"哈ee",50000.00));
		dao.add(new Student(12,"哈asd",50000.00));
		dao.add(new Student(11,"哈sdfsd",50000.00));*/
/*		
		Student student=dao.findStudentById(2);
		System.out.println(student);
		
		student.setName("我是王二小");
		student.setSal(3000.33);
		
		dao.updateStudentById(student);
		
		Student student3=dao.findStudentById(2);
		
		System.out.println(student3);
		
*/		
		for(int i=1;i<13;i++){
			dao.deleteStudentById(i);
		}
		List<Student> studentList=dao.findAll();
		if(studentList.size()!=0 && studentList !=null){
			for (Student student2 : studentList) {
				System.out.println(student2);
			}
		}
		
	}

}
