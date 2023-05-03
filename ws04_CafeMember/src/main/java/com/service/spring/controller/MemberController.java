package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MemberVO;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/showAll.do")
	public ModelAndView showAllMember() throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		return new ModelAndView("allView", "list", list);
	}
	
	@RequestMapping("/find.do")
	public ModelAndView find(String id) throws Exception{
		MemberVO vo=memberService.getMember(id);
		return new ModelAndView("find_ok", "vo", vo);
	}
	
	@RequestMapping("/register.do")
	public ModelAndView registerMember(MemberVO vo) throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("register_result", "vo", vo);
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO vo) throws Exception{
		memberService.updateMember(vo);
		return new ModelAndView("update_result", "vo",vo);
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, MemberVO vo) throws Exception{
		MemberVO memberVO = memberService.getMember(vo.getId());
		if(memberVO!=null && vo.getPassword().equals(memberVO.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", memberVO);
			return new ModelAndView("login_result", "vo", memberVO);
		}
		return null;
	}
}
