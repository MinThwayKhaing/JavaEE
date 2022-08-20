package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MyConnection;
import dto.StudentRequestDTO;
import dto.StudentResponseDTO;

public class StudentDAO {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int insertStudentData(StudentRequestDTO dto) {
        int result=0;
        String sql="insert into student(stuId,stuName,stuDob,stuGender,stuPhone,stuEducation) values(?,?,?,?,?,?)";
        try {

                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,dto.getStuId());
                ps.setString(2,dto.getStuName());
                ps.setString(3,dto.getStuDob());
                ps.setString(4,dto.getStuGender());
                ps.setString(5,dto.getStuPhone());
                ps.setString(6,dto.getStuEducation());
    
                result=ps.executeUpdate();
        } catch (SQLException e) {
        	
            System.out.println("Database error in inserting course data.");
            e.printStackTrace();
        }
        return result;
    }
	
	public void updateStudentData(StudentRequestDTO dto) {
		String sql = "update student set stuName=?,stuDob=?,stuGender=?,stuPhone=?,stuEducation=? where stuId=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,dto.getStuName());
            ps.setString(2,dto.getStuDob());
            ps.setString(3,dto.getStuGender());
            ps.setString(4,dto.getStuPhone());
            ps.setString(5,dto.getStuEducation());
            ps.setString(6,dto.getStuId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error in update");
		}

	}
	
	public void deleteStudnetData(StudentRequestDTO dto) {
		String sql = "delete from student where stuId=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStuId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error delete");
		}

	}
	
	public StudentResponseDTO selectId(String id) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select id ");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectName(String name) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuName=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select name ");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectCourse(String course) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuCourse=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select course");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectIdAndName(String id,String name) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuId=? OR stuName LIKE %?%";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select id name ");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectIdAndCourse(String id,String course) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuId=? OR stuCourse LIKE %?%";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select id course");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectIdAndNameAndCourse(String id,String name,String course) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuId=? OR stuName LIKE %?% OR stuCourse LIKE %?%";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println("select id name course");
			e.printStackTrace();
		}
		return res;

	}
	
	public StudentResponseDTO selectNameAndCourse(String name,String course) {
		StudentResponseDTO res = new StudentResponseDTO();
		String sql = "select * from student where stuName LIKE %?% OR stuCourse LIKE %?%";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, course);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
			}
		} catch (SQLException e) {
			System.out.println(" select one");
			e.printStackTrace();
		}
		return res;

	}
	
	
	
	
	
	public ArrayList<StudentResponseDTO> selectAll(){
		ArrayList<StudentResponseDTO> list = new ArrayList<>();
		String sql = "select * from student";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentResponseDTO res = new StudentResponseDTO();
				res.setStuId(rs.getString("stuId"));
				res.setStuName(rs.getString("stuName"));
				res.setStuDob(rs.getString("stuDob"));
				res.setStuGender(rs.getString("stuGender"));
				res.setStuPhone(rs.getString("stuPhone"));
				res.setStuEducation(rs.getString("stuEducation"));
				list.add(res);
			}
		} catch (SQLException e) {
			System.out.println("eroor selectall");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getId() {
		int res =0;
		String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mvcproject' AND TABLE_NAME = 'student';";
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
	
}
