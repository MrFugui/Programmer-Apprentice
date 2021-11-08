package com.wangfugui.apprentice.controller;


import com.alibaba.fastjson.JSONObject;
import com.wangfugui.apprentice.common.util.JwtTokenUtils;
import com.wangfugui.apprentice.dao.domain.ChatUser;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.service.UserService;
import com.wangfugui.apprentice.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Controller
public class ChatController {

	@Autowired
	UserService userService;
	

	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(@RequestParam("currentuser") String currentuser) {
		ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		Set<String> nameset = new HashSet<String>();
		while (it.hasNext()) {
			String entry = it.next();
			if (!entry.equals(currentuser)) {
				nameset.add(entry);
			}
		}
		return nameset;
	}



	@RequestMapping(value = "/loginvalidate", method = RequestMethod.POST)
	public String loginvalidate(JSONObject jsonObject, HttpSession httpSession) {
		String username = (String) jsonObject.get("username");
		String password = (String) jsonObject.get("password");
		if (username == null) {
			return "login";
		}
		String realpwd = userService.getpwdbyname(username);
		if (realpwd != null && password.equals(realpwd)) {
			long uid = userService.getUidbyname(username);
			httpSession.setAttribute("uid", uid);
			return "chatroom";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/chatroom")
	public String chatroom(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		//如果没有cookie则返回登录页面
		Cookie authCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName()
				.contains(JwtTokenUtils.TOKEN_HEADER)).collect(Collectors.toList()).get(0);

		if (authCookie == null) {
			return "login";
		}
		String tokenHeader = authCookie.getValue();
		String username = JwtTokenUtils.getUsername(tokenHeader);
		HttpSession session = request.getSession();
		User idByUserName = userService.getIdByUserName(username);
		session.setAttribute("uid", idByUserName.getId());
		return "chatroom";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		return "login";
	}

	@RequestMapping(value = "/currentuser", method = RequestMethod.GET)
	@ResponseBody
	public ChatUser currentuser(HttpSession httpSession) {
		int uid = (int)httpSession.getAttribute("uid");
		String name = userService.getnamebyid(uid);
		return new ChatUser(uid, name);
	}
}