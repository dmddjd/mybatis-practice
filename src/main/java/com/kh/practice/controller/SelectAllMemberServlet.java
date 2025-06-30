package com.kh.practice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.practice.model.service.MemberServiceImpl;
import com.kh.practice.model.vo.Member;

/**
 * Servlet implementation class SelectAllMemberServlet
 */
@WebServlet("/member/selectAll")
public class SelectAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SelectAllMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new MemberServiceImpl().selectAllMember();
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());
	}
}