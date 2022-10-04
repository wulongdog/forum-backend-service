package com.fwf_bbs.forumshiro.utils;

import com.fwf_bbs.forumcommon.service.RedisService;
import com.fwf_bbs.forumshiro.entity.JwtMeg;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

/**
 * @className JwtTokenUtil
 * @description JWT 工具
 * @auther wulongdog
 * @date 2022/10/4  12:06
 */
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String CLAIM_KEY_ID = "uid";

    private static final String CLAIM_KEY_ROLE = "urole";

    private static final String secret = "secret12345";


    /**
     * 获取负载
     * @param token
     * @return
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.info("JWT格式解析错误:{}",token);
        }
        return claims;
    }

    /**
     * 获取jwt信息
     * @param token
     * @return
     */
    public static JwtMeg getJwtMeg(String token) {
        JwtMeg jwtMeg = new JwtMeg();
        try {
            Claims claims = getClaimsFromToken(token);
            jwtMeg.setIss(claims.getIssuer());
            jwtMeg.setIat(claims.getIssuedAt());
            jwtMeg.setUid((Long) claims.get(CLAIM_KEY_ID));
            jwtMeg.setUrole((Integer) claims.get(CLAIM_KEY_ROLE));
        }catch (Exception e){
            jwtMeg = null;
        }
        return jwtMeg;
    }

    /**
     * 判断token是否已经失效
     * @param token
     * @return
     */
    public static boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    private static Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

}
