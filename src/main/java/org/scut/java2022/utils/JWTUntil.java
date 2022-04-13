package org.scut.java2022.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.scut.java2022.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class JWTUntil {
    private static final String SING = "12345678";

    public static String getToken(User user){
        //设定过期时间为一天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);

        //创建JWT builder
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userId",user.getId())
                .withClaim("username",user.getUserName())
                .withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(SING));
    }

    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }
}
