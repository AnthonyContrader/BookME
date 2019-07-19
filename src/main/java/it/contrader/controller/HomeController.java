package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.CategoryService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	private final CategoryService categoryService;

	@Autowired
	public HomeController(UserService userService, CategoryService categoryService) {
		this.userService = userService;
		this.categoryService = categoryService;
		
	}
	
	public void getList(HttpServletRequest request) {
		List<CategoryDTO> list = this.categoryService.getListaCategoryDTO();
		request.getSession().setAttribute("categoryList", list);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeManagement(HttpServletRequest request) {
		getList(request);
		return "home";
	}

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "homeUser";

	}
	
	@RequestMapping(value = "/gobackhome")
	public String gobackhome(HttpServletRequest request) {  // Mio metodo
		getList(request);
		return "home";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "home";

	}
	
}