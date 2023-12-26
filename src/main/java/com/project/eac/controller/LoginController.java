package com.project.eac.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.project.eac.entity.User;
import com.project.eac.entity.dto.UserDTO;
import com.project.eac.handler.exceptions.UserLoginException;
import com.project.eac.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.Objects;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LoginController {
    private final UserMapper userMapper;
    @PostMapping("/login")
    public User login(@RequestBody UserDTO user){
        User loginUser = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUserName, user.getUserName()));
        if(loginUser == null || !Objects.equals(loginUser.getPassword(), user.getPassword())){
            throw new UserLoginException("用户名或密码错误");
        }
        String token = null;
        return loginUser;
    }
}
