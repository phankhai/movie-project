package com.examplespringboot.demo.Security;

import com.examplespringboot.demo.Entity.CustomUserDetails;
import com.examplespringboot.demo.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.transform.Undefined;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

//UsernamePasswordAuthenticationFilter sử dụng link /login
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String SECRET = "SecretKeyToGenJWTs";
    private final long EXCEPTION_TIME = 864_000_000;
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    //Phương thức attemptAuthentication trả về một đối tượng Authentication
    //Authentication cung cấp các phương thức để lấy thông tin user sau khi đăng nhập
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request
            , HttpServletResponse response) throws AuthenticationException {
        try {
            //lấy thông tin đăng nhập từ req => chuyển json sang object
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            //usernamepasswordAuthenticationToken lưu trữ thông tin đăng nhập
            return this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail()
                            , user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuthenticationException authe){
            authe.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //lấy ra thông tin đăng nhập từ Authentication
        UserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();

        //tạo token
        String token = Jwts.builder().setSubject(userDetails.getUsername())
            //Đặt thời gian sống
            .setExpiration(new Date(System.currentTimeMillis()+ EXCEPTION_TIME))
            //Mã hóa token
            .signWith(SignatureAlgorithm.HS512, SECRET).compact();
        //gán token vào header
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        //trả token về cho client
        response.getWriter().write(TOKEN_PREFIX + token);
        response.getWriter().close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response
            , AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Sai tên đăng nhập hoặc mật khẩu");
        response.getWriter().close();
    }




}
