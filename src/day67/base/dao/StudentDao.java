package day67.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import day67.base.entity.Student;
import util.MybatisUtil;

/**
 * 持久层
 * @author leifeng
 * 2016年10月1日
 */
public class StudentDao {
	/**
	 * 条件查询
	 * @param id
	 * @param name
	 * @param sal
	 * @return
	 * @throws Exception
	 */
	public List<Student> findAllByMap(Integer id,String name,Double sal) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			Map<String, Object> params=new HashMap<String,Object>();
			params.put("id", id);
			params.put("name", name);
			params.put("sal", sal);
			
			List<Student> studentList=sqlSession.selectList("student_day67_base.findAllByMap",params);
			
			return studentList;
			
		}catch(Exception e){
			e.printStackTrace();
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
			Student student=sqlSession.selectOne("student_day67_base.findById",id);
			
			return student;
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	/**
	 * 批量删除学生
	 * @param args
	 * @throws Exception
	 */
	public void deleteByIds(int... ids) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			sqlSession.delete("student_day67_base.deleteByIds",ids);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	/**
	 * 批量删除学生
	 * @param args
	 * @throws Exception
	 */
	public void deleteByIdsParamsIsList(List<Integer> ids) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			sqlSession.delete("student_day67_base.deleteByIdsParamsIsList",ids);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closSqlSession();
		}
		
	}
	
	/**
	 *更新学生
	 * @param args
	 * @throws Exception
	 */
	public void updateStudentById(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			int i=sqlSession.update("student_day67_base.updateByEntity",student);
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
	 *动态通过拼接SQL添加学生
	 * @param args
	 * @throws Exception
	 */
	public void insertByDynaSQL(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			int i=sqlSession.insert("student_day67_base.insertByDynaSQL",student);
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
	 *添加学生
	 * @param args
	 * @throws Exception
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			int i=sqlSession.insert("student_day67_base.add",student);
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
	
	public static void main(String[] args) throws Exception {
		StudentDao dao=new StudentDao();
		
		List<Student> studentList=dao.findAllByMap(null,null, null);
		for (Student student : studentList) {
			System.out.println(student);
		}
		
		
		
	}

}
