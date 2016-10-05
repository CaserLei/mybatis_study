package day67.one2one.dao;

import org.apache.ibatis.session.SqlSession;

import day67.one2one.entity.Person;
import util.MybatisUtil;

/**
 * 持久层  查询个人身份证
 * @author leifeng
 * 2016年10月4日
 */
public class PersonCardDao {
	
	/**
	 * 查询1号学生的信息与身份证信息
	 * @param id学生的编号
	 */
	public Person findPersonByid(int id)throws Exception{
		SqlSession  sqlSession=null;
		try{
			
			sqlSession=MybatisUtil.getSqlSession();
			Person person=sqlSession.selectOne("Person_day67.findById", id);
			return person;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
		
	}
	
	
	/**
	 * 查询"哈哈"学生的信息与身份证信息
	 */
	public Person findByName(String name) throws Exception{
		SqlSession  sqlSession=null;
		try{
			sqlSession=MybatisUtil.getSqlSession();
			Person person=sqlSession.selectOne("Person_day67.findName", name);
			return person;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			MybatisUtil.closSqlSession();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		PersonCardDao dao=new PersonCardDao();
		
		Person s=dao.findPersonByid(1);
		System.out.println("学生编号："+s.getId()+" 学生姓名："+s.getName()+" 省份证id:"+s.getCard().getId()+" 身份证编号："+s.getCard().getNum());
		
		System.out.println("----------------------------------------------------");
		
		Person s2=dao.findByName("哈达打发的说法");
		System.out.println(" 学生："+s2.getName()+" 身份证编号："+s2.getCard().getNum());
		
	}

}
