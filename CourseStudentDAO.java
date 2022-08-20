package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MyConnection;
import dto.CourseStudentRequestDTO;

public class CourseStudentDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int insertCourseStudnetData(CourseStudentRequestDTO dto) {
        int result=0;
        String sql="insert into course_student (stuId,courseName) values(?,?)";
        try {

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setString(1,dto.getStuId());
                ps.setString(2,dto.getCourseName());
                result=ps.executeUpdate();
        } catch (SQLException e) {
        	
            System.out.println("Database error in inserting course_stu data.");
            e.printStackTrace();
        }
        return result;
    }
	
	public ArrayList<String> selectOne(String id) {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from course_student where stuId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				
				list.add(rs.getString("courseName")	);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> selectReverse(String course) {
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from course_student where courseName LIKE ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + course + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add( rs.getString("stuId"));
			}
		} catch (SQLException e) {
			 System.out.println("Database error in selsect rev");
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteData(CourseStudentRequestDTO dto) {
		String sql = "delete from course_student where stuId=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStuId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error delete");
		}

	}
}
