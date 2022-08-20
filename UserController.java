package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDAO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;

import Model.UserBean;


@Controller
public class UserController 
{
	@Autowired
	private UserDAO UserDAO;
	

	@RequestMapping(value="/searchUserPage",method=RequestMethod.GET)
	public ModelAndView searchUserPage(ModelMap model)
	{
		UserDAO.selectAll();
		ArrayList<UserResponseDTO> list=UserDAO.selectAll();
		model.addAttribute("list",list);
		return new ModelAndView("USR003", "userbean", new UserBean());
	}
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public ModelAndView searchUser(@ModelAttribute("userbean") UserBean userbean, ModelMap model) 
	{
		UserRequestDTO req = new UserRequestDTO();
		req.setUserid(userbean.getSearchid());
		req.setUsername(userbean.getSearchname());


		UserDAO dao = new UserDAO();
		if(dao.search(req).isEmpty()) {
		
			return new ModelAndView("USR003", "userBean", new UserBean());
		}
		else {

		model.addAttribute("list",dao.search(req));
		List<UserResponseDTO> dto=dao.search(req);
		
		return new ModelAndView("USR003", "userBean", new UserBean());
		}
	}
	
	
//UserRegister
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		return new ModelAndView("USR001", "userbean", new UserBean());
	}
	
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(@ModelAttribute("userbean") UserBean userbean, ModelMap model) {

		if (userbean.getUserid().isBlank() || userbean.getUsername().isBlank() || userbean.getConfirmpassword().isBlank()
				|| userbean.getUserrole().isBlank()) {
			model.addAttribute("errorFill", "Fill the Blank!!!");
			return "USR001";
		} else {
			UserRequestDTO dto=new UserRequestDTO();
			dto.setUserid(userbean.getUserid());
			dto.setUsername(userbean.getUsername());
			dto.setEmail(userbean.getEmail());
			dto.setPassword(userbean.getPassword());
			dto.setUserrole(userbean.getUserrole());
			int rs=UserDAO.insertData(dto);
			return "redirect:/searchUserPage";
		}
	}

	@RequestMapping(value="/setupupdateuser/{userid}" ,method=RequestMethod.GET)
	public ModelAndView setupupdateuser(@PathVariable String userid,ModelMap model)
	{
		UserRequestDTO dto=new UserRequestDTO();
		dto.setUserid(userid);
		return new ModelAndView("USR002","userbean",UserDAO.selectOne(dto));
	}
	@RequestMapping(value="/setupupdateuser/updateUser",method=RequestMethod.POST)
	public String updateuser(@ModelAttribute("userbean")@Validated UserBean userbean,BindingResult bs,ModelMap model)
	{
		if(bs.hasErrors())
		{
			return "USR002";
		}
		UserRequestDTO dto=new UserRequestDTO();
		dto.setUserid(userbean.getUserid());
		dto.setUsername(userbean.getUsername());
		dto.setEmail(userbean.getEmail());
		dto.setPassword(userbean.getPassword());
		
		dto.setUserrole(userbean.getUserrole());
	
		
		int rs=UserDAO.updateData(dto);
		
		
			return"redirect:/searchUserPage";
		
		
		
	}
	
	
	@RequestMapping(value="/Deleteuser/{userid}",method=RequestMethod.GET)
	public String Deleteuser(@PathVariable String userid, ModelMap model)
	{
		UserRequestDTO dto=new UserRequestDTO();
		dto.setUserid(userid);
		UserDAO.deleteData(dto);
		return "redirect:/searchUserPage";
	}
	
}
