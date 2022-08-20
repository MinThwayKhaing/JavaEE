package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MyConnection;
import dto.CourseRequestDTO;
import dto.CourseResponseDTO;

public class CourseDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public int insertCourseData(CourseRequestDTO dto) {
        int result=0;
        String sql="insert into course(courseId,courseName) values(?,?)";
        try {

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setString(1,dto.getCourseId());
                ps.setString(2,dto.getCourseName());
                result=ps.executeUpdate();
        } catch (SQLException e) {
        	
            System.out.println("Database error in inserting course data.");
            e.printStackTrace();
        }
        return result;
    }

	public void updateCourseData(CourseRequestDTO dto) {
		String sql = "update course set courseName=?" + "where courseId=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, dto.getCourseName());
			ps.setString(2, dto.getCourseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}

	}

	public void deleteCourseData(CourseRequestDTO dto) {
		String sql = "delete from course where courseId=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCourseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}

	}

	public CourseResponseDTO selectOne(CourseRequestDTO dto) {
		CourseResponseDTO res = new CourseResponseDTO();
		String sql = "select * from course where courseId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCourseId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setCourseId(rs.getString("courseId"));
				res.setCourseName(rs.getString("courseName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
	
	public ArrayList<CourseResponseDTO> selectAllCourse(){
		ArrayList<CourseResponseDTO> list = new ArrayList<>();
		String sql = "select * from course";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CourseResponseDTO res = new CourseResponseDTO();
				res.setCourseName(rs.getString("courseName"));
				list.add(res);
			}
		} catch (SQLException e) {
			System.out.println("error select course");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getId() {
		int res =0;
		String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mvcproject' AND TABLE_NAME = 'course';";
//		SELECT MAX(id) AS id FROM user
//		SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mvcproject' AND TABLE_NAME = 'user';
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			 while (rs.next()){
		            res=rs.getInt(1);
		        }
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("eroor getiing id");
			
			e.printStackTrace();
		}
		return res;
	}

//	SELECT LAST_INSERT_ID() as id from course;
//
}
