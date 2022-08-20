package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.CourseBean;
import dao.CourseDAO;
import dto.CourseRequestDTO;
import dto.CourseResponseDTO;

@Controller
public class CourseController {
    @Autowired
    private CourseDAO dao;
    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value="/courseAddPage", method=RequestMethod.GET)
    public ModelAndView courseAddPage() {
        CourseBean cBean = new CourseBean();
        int i = dao.getId();
        String finalCourseString = "COU" + String.format("%03d", i);
        cBean.setCourseId(finalCourseString);
        return new ModelAndView("BUD003","cBean",cBean);
    }

    @RequestMapping(value="/courseAdd", method=RequestMethod.POST)
    public String courseAdd(@ModelAttribute("cBean")CourseBean cBean,ModelMap model) {
////        if(bs.hasErrors()) {
////            return "addCourse";
////        }
        if (cBean.getCourseName().isBlank()) {

            model.addAttribute("errorFill", "Fill the Blank!!!");
            return "BUD003";
        } else {

            CourseResponseDTO res = new CourseResponseDTO();
            CourseRequestDTO dto = new CourseRequestDTO();
            dto.setCourseName(cBean.getCourseName());
            dto.setCourseId(cBean.getCourseId());
            dao.insertCourseData(dto);
            List<CourseResponseDTO> courseList = dao.selectAllCourse();            
            servletContext.setAttribute("courseList", courseList);
            model.addAttribute("errorFill", "Success Add");
            return "BUD003";
        }

    }
}