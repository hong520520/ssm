package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.User;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;

@SessionAttributes("currentUser")
@Controller
public class TextController {
	
	@Resource
	private UserService userService;
	@RequestMapping("/login")
	public String login(@RequestParam("name")String name,
			@RequestParam("password")String password,Model model) throws Exception{
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		User result = userService.loginByNameAndPassword(user);
		if(result!=null){
			//登录成功
			model.addAttribute("currentUser", result.getName());	
			return "redirect:findPage";
		}
		return "error";
	}
	
	@RequestMapping("/findPage")
	public String findPageUser(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model)throws Exception{
		model.addAttribute("pagemsg", userService.findByPage(currentPage));//回显分页数据
		return "user";
	}
	
	@RequestMapping("/updateById")
	public String updateById(User user) {
		userService.updateById(user);
		return "redirect:findPage"; 
	}
	
	/*@RequestMapping("/save")
	public String save(User user) {
	   System.out.println(user.toString());
	   if(user.getId()==null){
		   userService.add(user);
	   }else{
		   userService.updateById(user);
	   }
		return "redirect:findAll";
	}*/

	@RequestMapping("/deleteById")
	public String deleteById(Integer id) {
		userService.deleteById(id);
		return "redirect:findPage";
	}

	@RequestMapping("/add")
	public String addUser(User user) {
	    userService.add(user);
		return "redirect:findPage";
	}
	@RequestMapping("/registUser")
	public String regist(User user) {
	    userService.add(user);
		return "index";
	}
	 @RequestMapping("/toIndex")
		public String toIndex(){
			return "index";
		}
	 @RequestMapping("/toAddUser")
		public String toAddUser(){
			return "addUser";
		}
	 @RequestMapping("/toRegist")
		public String regist(){
			return "regist";
		}
	@RequestMapping("/selectById")
	public ModelAndView selectById(Integer id) {
		User user = userService.selectById(id);
		ModelAndView mav = new ModelAndView("/userInfo");
		mav.addObject("u", user);
		return mav;
	}
	
	/*@RequestMapping("/selectById")
	 public String selectById(@RequestParam(value="id")integer id, Model model )throws Exception{
		    User user=userService.selectById(id);
			model.addAttribute("u", user);
			return "userInfo";
	 }  
	*/
	/*@RequestMapping("/selectByName")
	public ModelAndView selectByName(String name) {
		User user=userService.selectByName(name);
		ModelAndView mav = new ModelAndView("/userInfo");
		mav.addObject("u", user);
		return mav;
	}*/
	 
	@RequestMapping("/selectByName")
	 public String selectByName(@RequestParam(value="name")String name, Model model )throws Exception{
		    User user=userService.selectByName(name);
		    if(user!=null){
			model.addAttribute("u", user);
			return "userInfo";
		    }
			return "none";
	 } 
}
