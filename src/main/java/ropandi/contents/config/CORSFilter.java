package ropandi.contents.config;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
@Component
public class CORSFilter implements Filter {

 public CORSFilter() {
	// TODO Auto-generated constructor stub
}
 	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    res.setHeader("Access-Control-Allow-Origin", "*");
	    res.setHeader("Access-Control-Allow-Credentials", "true");
	    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    res.setHeader("Access-Control-Max-Age", "3600");
	    res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, remember-me");
	    chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
