package com.sooji.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	/***
	 * 메인 페이지 호출
	 * @return
	 */
	@GetMapping("/")
	public ModelAndView mainPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@GetMapping("/{path1}.do")
	public ModelAndView path1(@PathVariable("path1") String path1) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path1);
		return  mav;
	}

	@GetMapping("/{path1}/{path2}.do")
	public ModelAndView path2(@PathVariable("path1") String path1, @PathVariable("path2") String path2) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path1 + "/" + path2);
		return  mav;
	}
	
	@GetMapping("/{path1}/{path2}/{path3}.do")
	public ModelAndView path3(@PathVariable("path1") String path1, @PathVariable("path2") String path2,@PathVariable("path3") String path3) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path1 + "/" + path2 + "/" + path3);
		return  mav;
	}
	
	@GetMapping("/{path1}/{path2}/{path3}/{path4}.do")
	public ModelAndView path4(@PathVariable("path1") String path1, @PathVariable("path2") String path2,@PathVariable("path3") String path3, @PathVariable("path4") String path4) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path1 + "/" + path2 + "/" + path3 + "/" + path4);
		return  mav;
	}

}
