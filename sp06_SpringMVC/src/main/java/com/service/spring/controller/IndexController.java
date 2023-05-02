package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.ControllerEventListener;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * 폼 값 받아서
		 * vo 생성
		 * dao 리턴..비즈니스로직 호출
		 * 반환값 바인딩
		 * ----- 했다치고
		 * 네비게이션(결과페이지 이름, 페이지 이동방법)
		 */
		return new ModelAndView("result", "message", "Hello Spring MVC");
	}

}
