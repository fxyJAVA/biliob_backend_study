package com.yxf.biliob_backendf_v2.controller;

import com.yxf.biliob_backendf_v2.constant.ResultEnum;
import com.yxf.biliob_backendf_v2.entity.Result;
import com.yxf.biliob_backendf_v2.security.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc TODO
 * @Author fxy
 * @Date 2020/6/25 16:00
 **/
@RestController
public class UserController {
    private UserAuthenticationProvider userAuthenticationProvider;
    @Autowired
    public UserController(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @GetMapping("/user/info")
    public ResponseEntity getUserInfo() {
        return new ResponseEntity<>(new Result(ResultEnum.TEST), HttpStatus.OK);
    }

    @GetMapping("/user/login")
    public ResponseEntity login(String username,String password) {
        try {
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, password);
            Authentication result = userAuthenticationProvider.authenticate(user);
            SecurityContextHolder.getContext().setAuthentication(result);
            return new ResponseEntity<>(new Result<>(ResultEnum.LOGIN_SUCCESS,user),HttpStatus.OK);
        } catch(AuthenticationException e) {
            return ResponseEntity.badRequest().body(new Result<>(ResultEnum.LOGIN_FAILED));
        }
    }
}
