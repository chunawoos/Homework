package hwjava15_서울_8반_천창민;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hw.emp.DBUtil;

public class EmpMgrImpl implements EmpMgr{

	private static EmpMgrImpl instance = null;
	
	public EmpMgrImpl() { }
	
	public static EmpMgrImpl getInstance() {
		if(instance == null) {
			instance = new EmpMgrImpl();
			
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = null;
			
			String sql;
			try {
				sql = "create table if not exists employee (empNo int primary key, name varchar(20) not null, position varchar(20) not null, dept varchar(20) not null)";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(ps != null) DBUtil.close(ps);
				if(con != null) DBUtil.close(con);				
			}
		}
		return instance;
	}
	
	@Override
	public void add(Employee b) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		
		String sql;
		try {
			sql = "insert into employee(empNo, name, position, dept)" + " values (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b.getEmpNo());
			ps.setString(2, b.getName());
			ps.setString(3, b.getPosition());
			ps.setString(4, b.getDept());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null) DBUtil.close(ps);
			if(con != null) DBUtil.close(con);
		}
	}

	@Override
	public List<Employee> search() {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		
		String sql;
		try {
			sql = "select empNo, name, position, dept from employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpNo(rs.getInt("empNo"));
				e.setName(rs.getString("name"));
				e.setPosition(rs.getString("position"));
				e.setDept(rs.getString("dept"));
				
				list.add(e);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) DBUtil.close(rs);
			if(ps != null) DBUtil.close(ps);
			if(con != null) DBUtil.close(con);
		}
		return list;
	}

	@Override
	public List<Employee> search(String name) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		
		String sql;
		try {
			sql = "select empNo, name, position, dept from employee where name like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpNo(rs.getInt("empNo"));
				e.setName(rs.getString("name"));
				e.setPosition(rs.getString("position"));
				e.setDept(rs.getString("dept"));
				
				list.add(e);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) DBUtil.close(rs);
			if(ps != null) DBUtil.close(ps);
			if(con != null) DBUtil.close(con);
		}
		return list;
	}

	@Override
	public boolean update(int empNo, String dept) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		
		String sql;
		int cnt = 0;
		try {
			sql = "update employee set dept = ? where empNo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dept);
			ps.setInt(2, empNo);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) DBUtil.close(ps);
			if(con != null) DBUtil.close(con);			
		}
		if(cnt == 1)
			return true;
		return false;
	}

	@Override
	public boolean delete(int empNo) {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		
		String sql;
		int cnt = 0;
		try {
			sql = "delete from employee where empNo = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, empNo);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) DBUtil.close(ps);
			if(con != null) DBUtil.close(con);			
		}		
		if(cnt == 1)
			return true;
		return false;
	}
 
}
