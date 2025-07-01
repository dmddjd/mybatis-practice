package com.kh.practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.practice.model.service.MemberService;
import com.kh.practice.model.service.MemberServiceImpl;
import com.kh.practice.model.vo.Member;

@WebServlet("/member/searchById")
public class SearchMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMemberByIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		MemberService service = new MemberServiceImpl();
		Member member = service.selectMemberById(userId);
		
		new Gson().toJson(member, response.getWriter());
		response.setContentType("application/json; charset=uft-8");
		
		
	}
}
