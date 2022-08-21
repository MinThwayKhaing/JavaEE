package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.CourseDAO;
import DTO.CourseRequestDTO;
import DTO.CourseResponseDTO;
import Model.CourseBean;
import Model.UserBean;

@Controller
public class CourseController 
{
	 @Autowired
	    private CourseDAO dao;
	

	    @RequestMapping(value="/courseaddpage", method=RequestMethod.GET)
	    public ModelAndView addCourse() {
			return new ModelAndView("BUD001", "coursebean", new CourseBean());
		}
		
	    @RequestMapping(value="/courseAddPage", method=RequestMethod.POST)
	    public String courseAdd(@ModelAttribute("coursebean")CourseBean coursebean,ModelMap model) 
	    {
	        if (coursebean.getCoursename().isBlank()) {

	            model.addAttribute("errorFill", "Fill the Blank!!!");
	            return "BUD003";
	        } else {

	            CourseResponseDTO res = new CourseResponseDTO();
	            CourseRequestDTO dto = new CourseRequestDTO();
	            dto.setCoursename(coursebean.getCoursename());
	            dto.setCourseid(coursebean.getCourseid());
	            dao.insertCourseData(dto);
	           
	       
	            return "redirect:/studentaddpage";
	        }
	    }
}
