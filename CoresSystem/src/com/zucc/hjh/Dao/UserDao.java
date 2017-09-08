 package com.zucc.hjh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zucc.hjh.model.*;

public class UserDao {
	//判断学生用户名是否存在
	public boolean S_userExist(String S_username){
		Connection conn = DataBaseUtil.getConnection();
		String sql = "select*from info_student where S_username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, S_username);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				return true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConnection(conn);
		}
		return false;
	}
	//判断教师用户名是否存在
		public boolean T_userExist(String T_username){
			Connection conn = DataBaseUtil.getConnection();
			String sql = "select*from info_teacher where T_username = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, T_username);
				ResultSet rs = ps.executeQuery();
				if(!rs.next()){
					return true;
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DataBaseUtil.closeConnection(conn);
			}
			return false;
		}
	//将学生信息存入数据库
		public void SsaveUser(Suser suser){
			Connection conn = DataBaseUtil.getConnection();
			String sql = "insert into info_student (S_username,S_password,S_num,S_name,S_class,S_sex)values(?,?,?,?,?,?)";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, suser.getS_username());
				ps.setString(2, suser.getS_password());
				ps.setString(3, suser.getS_num());
				ps.setString(4, suser.getS_name());
				ps.setString(5, suser.getS_class());
				ps.setString(6, suser.getS_sex());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DataBaseUtil.closeConnection(conn);
			}
		}
		//将学生教师信息存入数据库
				public void TsaveUser(Tuser tuser){
					Connection conn = DataBaseUtil.getConnection();
					String sql = "insert into info_teacher(T_username,T_password,T_num,T_name,T_sex)values(?,?,?,?,?)";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, tuser.getT_username());
						ps.setString(2, tuser.getT_password());
						ps.setString(3, tuser.getT_num());
						ps.setString(4, tuser.getT_name());
						ps.setString(5, tuser.getT_sex());
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
				}
		//学生登录
		public Suser Slogin(String S_username,String S_password){
			Suser suser = null;
			Connection conn = DataBaseUtil.getConnection();
			String sql = "select * from info_student where S_username = ? and S_password=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,S_username);
				ps.setString(2,S_password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					suser = new Suser();
					suser.setS_num(rs.getString("S_num"));
					suser.setS_username(rs.getString("S_username"));
					suser.setS_password(rs.getString("S_password"));
					suser.setS_name(rs.getString("S_name"));
					suser.setS_class(rs.getString("S_class"));
					suser.setS_sex(rs.getString("S_sex"));
				}
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DataBaseUtil.closeConnection(conn);
			}
			return suser;
		}
		//教师登录
				public Tuser Tlogin(String T_username,String T_password){
					Tuser tuser = null;
					Connection conn = DataBaseUtil.getConnection();
					String sql = "select * from info_teacher where T_username = ? and T_password=?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1,T_username);
						ps.setString(2,T_password);
						ResultSet rs = ps.executeQuery();
						if(rs.next()){
							tuser = new Tuser();
							tuser.setT_num(rs.getString("T_num"));
							tuser.setT_username(rs.getString("T_username"));
							tuser.setT_password(rs.getString("T_password"));
							tuser.setT_name(rs.getString("T_name"));
							tuser.setT_sex(rs.getString("T_sex"));
						}
						ps.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					return tuser;
				}
				//保存课程信息
				public void coresSave(Cores cores){
					Connection conn = DataBaseUtil.getConnection();
					String sql = "insert into info_cores (cNo,coresname,credit)values(?,?,?)";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, cores.getcNo());
						ps.setString(2,cores.getCoresname());
						ps.setString(3, cores.getCredit());
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
				}
				//课程编号是否存在
				public boolean coresExist(String cNo){
					Connection conn = DataBaseUtil.getConnection();
					String sql = "select*from info_cores where cNo= ?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, cNo);
						ResultSet rs = ps.executeQuery();
						if(!rs.next()){
							return true;
						}
						rs.close();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					return false;
				}
				
				//修改教师密码
				public void Tupdate(String T_username,String NT_password){					
					Connection conn = DataBaseUtil.getConnection();
					String sql = "UPDATE info_teacher SET T_password = ? WHERE T_username = ?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);	
						ps.setString(1, NT_password);
						ps.setString(2, T_username);
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					
				}
				//修改学生密码
				public void Supdate(String S_username,String NS_password){					
					Connection conn = DataBaseUtil.getConnection();
					String sql = "UPDATE info_student SET S_password = ? WHERE S_username = ?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);	
						ps.setString(1, NS_password);
						ps.setString(2, S_username);
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					
				}
				//从数据库读取课程信息
				public List<List> coresinfo(){
					List <String> a=new ArrayList<String>();
					List <String> b=new ArrayList<String>();
					List <String> c=new ArrayList<String>();
					List<List> list=new ArrayList<List>();
				    
					Cores cores = null;
					String []n=null;
					Connection conn = DataBaseUtil.getConnection();
					String sql = "select * from info_cores ";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()){
							cores = new Cores();
							a.add(rs.getString("cNo"));							
							b.add(rs.getString("coresname"));
							c.add(rs.getString("credit"));
							
						}
					list.add(a);
					list.add(b);
					list.add(c);
					rs.close(); 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					
					return list;
				}
				//删除课程信息 
				public void Delet(String id){
				
					Connection conn = DataBaseUtil.getConnection();
					String sql ="delete from info_cores where cNo =?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);						
						ps.setString(1,id);
						ps.executeUpdate();					
						ps.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
				}
				//删除选择的课程
				public void Ydelet(String id){
				
					Connection conn = DataBaseUtil.getConnection();
					String sql ="delete from info_takecores where cNo =?";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);						
						ps.setString(1,id);
						ps.executeUpdate();					
						ps.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
				}
				//查询选中课程
				public TakeCores take(String cNo){
					TakeCores takeCores = null;
					Connection conn = DataBaseUtil.getConnection();
					String sql = "select * from info_cores where cNo = ? ";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1,cNo);
						ResultSet rs = ps.executeQuery();
						if(rs.next()){
							takeCores = new TakeCores();
							takeCores.setcNo(rs.getString("cNo"));
							takeCores.setCoresname(rs.getString("coresname"));
							takeCores.setCredit(rs.getString("credit"));							
						}
						ps.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					return takeCores;
				}
				//已选课程
				public void saveTakeCores(TakeCores takeCores){
					Connection conn = DataBaseUtil.getConnection();
					String sql = "insert into info_takecores(cNo,coresname,credit)values(?,?,?)";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, takeCores.getcNo());
						ps.setString(2, takeCores.getCoresname());
						ps.setString(3, takeCores.getCredit());
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
				}
				//从数据库读取选课信息
				public List<List> takecores(){
					List <String> a=new ArrayList<String>();
					List <String> b=new ArrayList<String>();
					List <String> c=new ArrayList<String>();
					List<List> list=new ArrayList<List>();
				    
					Cores cores = null;
					String []n=null;
					Connection conn = DataBaseUtil.getConnection();
					String sql = "select * from info_takecores ";
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()){
							cores = new Cores();
							a.add(rs.getString("cNo"));							
							b.add(rs.getString("coresname"));
							c.add(rs.getString("credit"));
							
						}
					list.add(a);
					list.add(b);
					list.add(c);
					rs.close(); 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DataBaseUtil.closeConnection(conn);
					}
					
					return list;
				}


}
