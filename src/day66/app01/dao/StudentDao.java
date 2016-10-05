package day66.app01.dao;

import org.apache.ibatis.session.SqlSession;

import day66.app01.entity.Student;
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
	public void add() throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			//事物开启(默认)
			//读取StudentMapper.xml 映射文件中的SQL语句
			int i=sqlSession.insert("studentNamespace.insert");
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
	
	public void add2(Student student) throws Exception{
		SqlSession sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			//事物开启(默认)
			//读取StudentMapper.xml 映射文件中的SQL语句
			int i=sqlSession.insert("studentNamespace.insert",student);
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
	
	
	public static void main(String[] args) throws Exception {
		StudentDao dao=new StudentDao();
		dao.add2(new Student(3,"呵呵呵",30000.3));
	}

}
