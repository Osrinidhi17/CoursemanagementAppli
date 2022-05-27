package in.hcl.coursecategorymanagement.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.hcl.coursecategorymanagement.dao.CourseDAO;
import in.hcl.coursecategorymanagement.exception.CourseNotFoundException;
import in.hcl.coursecategorymanagement.model.Course;

@Component
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	private Connection conn = null;
	private Statement stmt = null;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDatasource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int addCourse(Course course) {
		String sql = "insert into courses(name,description,startDate,endDate)value('"+course.getCourseName()+"','"+course.getDescription()+"','"+course.getStartDate()+"','"+course.getEndDate()+"')";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("************Course add successfully****************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public int deleteCourse(Long id) throws CourseNotFoundException {
		String sql = "delete from courses where id = '"+id+"'";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("************Course delete successfully****************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public int updateCourse(Course course) {
		String sql = "update courses set name = '"+course.getCourseName()+"', description = '"+course.getDescription()+"',startDate = '"+course.getStartDate()+"', endDate = '"+course.getEndDate()+"' where id = '"+course.getId()+"'";
		jdbcTemplate.setDataSource(dataSource);
		System.out.println("***********Course updated successfully**************");
		return jdbcTemplate.update(sql);
	}

	@Override
	public void showCourse() {
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "select id,name,description,startDate,endDate from courses";
			ResultSet i = stmt.executeQuery(sql);
			while(i.next()){
	            //Display values
	            System.out.print("ID: " + i.getInt("id"));
	            System.out.print(", Course Name: " + i.getString("name"));
	            System.out.print(", Description: " + i.getString("description"));
	            System.out.println(", Start Date: " + i.getString("startDate"));
	            System.out.println(", End Date: " + i.getString("endDate"));
			}
		}
		catch(SQLException e) {	
			e.printStackTrace();
		}

	}

}
