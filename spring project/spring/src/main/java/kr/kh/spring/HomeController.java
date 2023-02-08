package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv, String name, Integer age) {
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value = "/board/{num}")
	public ModelAndView board(ModelAndView mv, @PathVariable("num")Integer num) {
		System.out.println("게시글 번호 : " + num);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView test(ModelAndView mv,InfoVo info) {
		mv.addObject("info1",info);
		mv.setViewName("home2");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, String id, String pw) {
		System.out.println(id);
		System.out.println(pw);
		mv.setViewName("login");
		return mv;
	}
	
}
