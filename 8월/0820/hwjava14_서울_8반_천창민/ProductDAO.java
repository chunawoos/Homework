package hwjava14_서울_8반_천창민;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","blue!!1100");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement statement) {
		try {
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertProduct(Product prod) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = getConnection();
			st = con.prepareStatement("insert into Product(isbn, name, price, stock)" + " values (?, ?, ?, ?)");
			st.setString(1,  prod.getIsbn());
			st.setString(2,  prod.getName());
			st.setInt(3, prod.getPrice());
			st.setInt(4, prod.getStock());
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(st);
			close(con);
			
		}
	}
	
	public List<Product> findProd() {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		List<Product> list = new ArrayList<>();
		try {
			con = getConnection();
			st = con.prepareStatement("select isbn, name, price, stock from product ");
			rs = st.executeQuery();
		
			while(rs.next()) {
				Product prod = new Product();
				prod.setIsbn(rs.getString("isbn"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setStock(rs.getInt("Stock"));
				list.add(prod);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}
	
	public List<Product> findProdName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		List<Product> list = new ArrayList<>();
		try {
			con = getConnection();
			st = con.prepareStatement("select isbn, name, price, stock from product where name like ?");
			st.setString(1, "%"+name+"%"
					+ "");
			rs = st.executeQuery();
		
			while(rs.next()) {
				Product prod = new Product();
				prod.setIsbn(rs.getString("isbn"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setStock(rs.getInt("Stock"));
				list.add(prod);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}
	
	public List<Product> listProdPrice(int price) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		List<Product> list = new ArrayList<>();
		try {
			con = getConnection();
			st = con.prepareStatement("select isbn, name, price, stock from product where price <= ? ");
			st.setInt(1, price);
			rs = st.executeQuery();
		
			while(rs.next()) {
				Product prod = new Product();
				prod.setIsbn(rs.getString("isbn"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setStock(rs.getInt("Stock"));
				list.add(prod);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return list;
	}
	
	public Product findProdISBN(String isbn) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		Product prod = new Product();
		try {
			con = getConnection();
			st = con.prepareStatement("select isbn, name, price, stock from product where isbn = ?");
			st.setString(1, isbn);
			rs = st.executeQuery();
		
			while(rs.next()) {
				prod.setIsbn(rs.getString("isbn"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getInt("price"));
				prod.setStock(rs.getInt("Stock"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(st);
			close(con);
		}
		return prod;
	}
	
	public void delete(String isbn) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = getConnection();
			st = con.prepareStatement("delete from product where isbn = ? ");
			st.setString(1, isbn);
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(st);
			close(con);
		}
	}
	
	public void updatePrice(String isbn, int price) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con = getConnection();
			st = con.prepareStatement("update product set price = ? where isbn = ?");
			st.setInt(1, price);
			st.setNString(2, isbn);
			st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(st);
			close(con);
		}
	}
}
