package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.CategoryService;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private final CategoryService categoryService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService, CategoryService categoryService) {
		this.userService = userService;
		this.categoryService = categoryService;
	}
	
	public void getList(HttpServletRequest request) {
		List<CategoryDTO> list = this.categoryService.getListaCategoryDTO();
		request.getSession().setAttribute("categoryList", list);
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		getList(request);
		return "UserManager";		
	}
	
	@RequestMapping(value = "/userManager")
	public String userManager(HttpServletRequest request)
	{
		visualUser(request);
		getList(request);
		return "UserManager";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);

		return "UserManager";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "home";

	}
	
	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = "USER";

		UserDTO userObj = new UserDTO(0, username, password, usertype);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "register";
	}
	@RequestMapping(value = "/creaUserByAdminPage", method = RequestMethod.POST)
	public String creaUserByAdminPage(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		System.out.print(usertype);

		UserDTO userObj = new UserDTO(0, username, password, usertype);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "UserManager";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String usertype = userDTO.getUsertype();
		getList(request);
		if (!StringUtils.isEmpty(usertype)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (usertype.equals("ADMIN"))
			{	
				visualUser(request);
				return "home";
			} else if (usertype.equals("USER")) {
				return "home";
			}
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public String enter(HttpServletRequest request) {
		return "login";
		
	}
}
