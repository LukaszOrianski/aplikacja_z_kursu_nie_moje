package weekop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import weekop.model.User;
import weekop.service.UserService;

@WebFilter("/*")
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		if (httpReq.getUserPrincipal() != null && httpReq.getSession().getAttribute("user") == null) {
			saveUserInSession(httpReq);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	private void saveUserInSession(HttpServletRequest req) {
		UserService userService = new UserService();
		String username = req.getUserPrincipal().getName();
		User userByUsername = userService.getUserByUsername(username);
		req.getSession(true).setAttribute("user", userByUsername);
	}

}
