package org.scut.java2022.interceptor;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.scut.java2022.utils.TokenUntil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        log.info("token={}",token);

        Map<String,Object> result=new HashMap<>();
        try{
            TokenUntil.verify(token);
            return true;
        }catch (TokenExpiredException e){
            result.put("msg","token过期");
            result.put("code","1001");
            log.warn("token过期");
        }catch (Exception e){
            result.put("msg","非法token");
            result.put("code","1002");
            log.warn("非法token");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(json);

        return false;
    }
}
