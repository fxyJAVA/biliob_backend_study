package com.yxf.biliob_backendf_v2.security;

import com.yxf.biliob_backendf_v2.constant.ResultEnum;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Desc TODO
 * @Author fxy
 * @Date 2020/6/25 16:06
 **/
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        System.out.println("username:" +username+",password: "+password);
        System.out.println(authentication.getName());
        if(username.equals("111") && password.equals("111")) {
            Collection<GrantedAuthority> authorityCollection = new ArrayList<>();
            authorityCollection.add(new SimpleGrantedAuthority("USER"));
            return new UsernamePasswordAuthenticationToken(username,password,authorityCollection);
        }
        throw new BadCredentialsException(ResultEnum.LOGIN_FAILED.getMessage());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
