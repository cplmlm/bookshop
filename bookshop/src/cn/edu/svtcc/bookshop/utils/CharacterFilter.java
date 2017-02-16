package cn.edu.svtcc.bookshop.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(initParams={@WebInitParam(name="encode",value="UTF-8")},
urlPatterns={"/*"})
public class CharacterFilter implements Filter {
       String encoding="";
       
       
   	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encode");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
