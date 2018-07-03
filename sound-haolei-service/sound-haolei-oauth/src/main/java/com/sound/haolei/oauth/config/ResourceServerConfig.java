package com.sound.haolei.oauth.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableResourceServer
@Order(5)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    @Primary
    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setAccessTokenValiditySeconds(3600);
        defaultTokenServices.setRefreshTokenValiditySeconds(3600);
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setReuseRefreshToken(false);
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        OAuth2AuthenticationProcessingFilter f = new OAuth2AuthenticationProcessingFilter();
        OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        OAuth2AuthenticationManager o = new OAuth2AuthenticationManager();
        DefaultTokenServices dt = new DefaultTokenServices();

        oAuth2AuthenticationEntryPoint.setExceptionTranslator(webResponseExceptionTranslator());
        f.setAuthenticationEntryPoint(getExceptionEntryPoint());

        dt.setTokenStore(tokenStore());
        o.setTokenServices(dt);
        f.setAuthenticationManager(o);

        http
                .csrf().disable().addFilterBefore(f,AbstractPreAuthenticatedProcessingFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(getExceptionEntryPoint())
            .and()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .httpBasic();
    }

    @Bean
    @ExceptionHandler
    public AuthenticationEntryPoint getExceptionEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {

            System.out.println(".............http status..............."+httpServletResponse.getStatus());
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            out = httpServletResponse.getWriter();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("msg", "参数错误或未通过认证");
            resultMap.put("code", "-1");
            resultMap.put("data", new ArrayList());
            Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
            try {
                out = httpServletResponse.getWriter();
                out.append(gson2.toJson(resultMap));
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,gson2.toJson(resultMap));
        };
    }

    @Bean
    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity translate(Exception e) throws Exception {
                ResponseEntity responseEntity = super.translate(e);
                OAuth2Exception body = (OAuth2Exception) responseEntity.getBody();
                body.addAdditionalInformation("key","dd");
                HttpHeaders headers = new HttpHeaders();
                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
                // do something with header or response
                System.out.println( "................responseEntity.............."+responseEntity.getStatusCode());
                if (401 == responseEntity.getStatusCode().value()) {
                    Map<String, Object> resultMap = new HashMap<String, Object>();
                    resultMap.put("msg", "未获取授权");
                    return new ResponseEntity(resultMap, headers, responseEntity.getStatusCode());
                } else {
                    return new ResponseEntity(body, headers, responseEntity.getStatusCode());
                }
            }
        };
    }
}
