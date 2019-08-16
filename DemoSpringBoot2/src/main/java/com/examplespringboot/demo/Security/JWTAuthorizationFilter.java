package com.examplespringboot.demo.Security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final String SECRET = "SecretKeyToGenJWTs";
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";

    private UserDetailsService userDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager
            , UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Lấy thông tin Authorization từ header
        String header = request.getHeader(HEADER_STRING);
        try{
            //Kiểm tra nếu không tồn tại hoặc sai cú pháp
            if(header == null || !header.startsWith(TOKEN_PREFIX)){
                response.setStatus(401);
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("vui long dang nhap");
                response.getWriter().close();
//            chain.doFilter(request,response);
                return;//Ngăn không cho request đi vào ứng dụng
            }

            String username = Jwts.parser()
                    //Nếu token ok => Giải mã token
                    .setSigningKey(SECRET)
                    //thay thế Bearer bằng
                    .parseClaimsJws(header.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            //Lấy thông tin của người dùng
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(userDetails != null) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //Set thông người dùng vào Security Context
                SecurityContextHolder.getContext().setAuthentication(authToken);
                //cho phép đi vào ứng dụng
                chain.doFilter(request,response);
            }
        } catch (RuntimeException e){
            response.setStatus(500);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("Token không đúng !");
            response.getWriter().close();
            e.printStackTrace();
        }

    }



}
