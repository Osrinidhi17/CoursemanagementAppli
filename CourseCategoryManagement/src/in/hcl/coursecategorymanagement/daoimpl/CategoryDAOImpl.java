package in.hcl.coursecategorymanagement.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import in.hcl.coursecategorymanagement.dao.CategoryDAO;
import in.hcl.coursecategorymanagement.exception.CategoryNotFoundException;
import in.hcl.coursecategorymanagement.model.Category;

@Component
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	private Connection conn = null;
	private Statement stmt = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	

	@Override
	public int addCategory(Category category) {
		String sql = "insert into categories(name,number,type,description)value('"+category.getCategoryName()+"','"+category.getCategoryNumber()+"','"+category.getCategoryType()+"','"+category.getDescription()+"')";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("************Category add successfully****************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public int deleteCategory(Long id) throws CategoryNotFoundException {
		String sql = "delete from categories where id= '"+id+"'";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("************Category Deleted successfully****************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public int updateCategory(Category category) {
		String sql = "update categories set name = '"+category.getCategoryName()+"', number = '"+category.getCategoryNumber()+"', type = '"+category.getCategoryType()+"', description = '"+category.getDescription()+"' where id = '"+category.getId()+"'";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("**********Category updated successfully**************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public void showCategory() {
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "select id,name,number,type,description from categories";
			ResultSet i = stmt.executeQuery(sql);
			while(i.next()){
	            //Display values
	            System.out.print("ID: " + i.getInt("id"));
	            System.out.print(", Category Name: " + i.getString("name"));
	            System.out.print(", Category Number: " + i.getString("number"));
	            System.out.println(", Category Type: " + i.getString("type"));
	            System.out.println(", Description: " + i.getString("description"));
			}
		}
		catch(SQLException e) {	
			e.printStackTrace();
		}
	}

}
