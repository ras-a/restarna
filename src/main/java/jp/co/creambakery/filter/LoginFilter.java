// package jp.co.creambakery.filter;

// import java.io.*;

// import org.springframework.beans.factory.annotation.*;
// import org.springframework.stereotype.*;

// import jakarta.servlet.*;
// import jakarta.servlet.http.*;
// import jp.co.creambakery.repository.*;
// import jp.co.creambakery.bean.*;

// // @Component
// public class LoginFilter extends HttpFilter {

// 	@Override
// 	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
// 			throws IOException, ServletException {
// 		var session = request.getSession();

// 		var user = session.getAttribute("user");

// 		var factory = new BeanFactory();

// 		if (user == null)
// 			session.setAttribute("user", factory.createBean(repository.getReferenceById(1)));

// 		chain.doFilter(request, response);
// 	}
// }
