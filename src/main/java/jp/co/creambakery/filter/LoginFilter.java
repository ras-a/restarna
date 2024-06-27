package jp.co.creambakery.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component
public class LoginFilter extends HttpFilter {

	/** 必ず通したいリクエスト */
	private static final String[] whiteList = {
		"/static/.*",
		".*/css/.*",
	};

	/** 管理者からアクセスできないリソース */
	private static final String[] adminIllegal = {
		"/user/.*",
		"/item/cart/?.*",
		"/item/order.*",
	};
	
	/** 管理者からアクセスできないリソース */
	private static final String[] userIllegal = {
		"/admin/.*",
	};

	/** 管理者からアクセスできないリソース */
	private static final String[] publicIllegal = {
		"/admin/(?!login).*",
		"/user/(?!login|register).*",
		"/item/review/add/?.*",
		"/item/cart/?.*",
		"/item/order.*",
	};

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var session = request.getSession();
		var uri = request.getRequestURI();
		
		if (!triggers(uri, whiteList))
		{
			if (session.getAttribute("admin") != null)
			{
				if (triggers(uri, adminIllegal))
				{
					response.sendRedirect("/admin/");
					return;
				}
			}
			else if (session.getAttribute("user") != null)
			{
				if (triggers(uri, userIllegal))
				{
					response.sendRedirect("/user/home");
					return;
				}
			}
			else if (triggers(uri, publicIllegal))
			{
				response.sendRedirect("/user/login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	private boolean triggers (String uri, String[] filters)
	{
		for (var filter: filters)
		{
			if (uri.matches(filter))
			{
				return true;
			}
		}

		return false;
	}
}
