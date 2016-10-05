package day66.app03.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import day66.app03.entity.Student;
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
			int i=sqlSession.insert("student_app03.insert",student);
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
			Student student=sqlSession.selectOne("student_app03.findById",id);
			
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
			int i=sqlSession.update("student_app03.update",student);
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
			List<Student> studentList=sqlSession.selectList("student_app03.findAll");
			
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
		    sqlSession.delete("student_app03.deleteStudentById",id);
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
	
	/**
	 * 分页查询学生
	 * @param args
	 * @throws Exception
	 */
	public List<Student> findAllWithFy(int pageStart,int pageSize) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("pageStart", pageStart);
			params.put("pageSize", pageSize);
			
		    List<Student> studentList=sqlSession.selectList("student_app03.findAllWithFy",params);
			
		    return studentList;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	/**
	 * 分页查询学生
	 * @param args
	 * @throws Exception
	 */
	public List<Student> findAllByNameWithFy(String name,int pageStart,int pageSize) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("name", "%"+name+"%");
			params.put("pageStart", pageStart);
			params.put("pageSize", pageSize);
			
		    List<Student> studentList=sqlSession.selectList("student_app03.findAllByNameWithFy",params);
			
		    return studentList;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		StudentDao dao=new StudentDao();
		
		//mysql分页
		System.out.println("--------------------------------第一页");
		List<Student> studentList1=dao.findAllByNameWithFy("哈哈哈",0,3);
		for (Student s : studentList1) {
			System.out.println(s);
		}
		
		System.out.println("--------------------------------第2页");
		List<Student> studentList2=dao.findAllByNameWithFy("哈哈哈哈哈",0,3);
		for (Student s : studentList2) {
			System.out.println(s);
		}
		
		System.out.println("--------------------------------第3页");
		List<Student> studentList3=dao.findAllByNameWithFy("哈哈哈哈哈",0,3);
		for (Student s : studentList3) {
			System.out.println(s);
		}
		
		System.out.println("--------------------------------第4页");
		List<Student> studentList4=dao.findAllByNameWithFy("哈哈哈哈哈",0,3);
		for (Student s : studentList4) {
			System.out.println(s);
		}
		
		System.out.println("--------------------------------第5页");
		List<Student> studentList5=dao.findAllByNameWithFy("哈哈哈哈哈",0,3);
		
		for (Student s : studentList5) {
			System.out.println(s);
		}
		
		
	}

}
