package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;
import com.ssafy.model.util.DBUtil;

@Repository
public class ProductRepoImpl implements ProductRepo {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, price, description from product");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getString("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setDescription(rs.getString("description"));
				list.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public Product select(String id) {
		Product prod = new Product();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, price, description \n");
			sql.append("from product \n");
			sql.append("where id =? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				prod.setId(rs.getString("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return prod;
	}

	@Override
	public int insert(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int t = 0;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product (id,name,price,description) \n");
			sql.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			t = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return t;
	}

	@Override
	public int update(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int t = 0;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update product \n");
			sql.append("set id = ?, name = ?, price = ?, description = ? \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getId());			
			t = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return t;
	}

	@Override
	public int delete(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int t = 0;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getId());
			t = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return t;
	}

}
