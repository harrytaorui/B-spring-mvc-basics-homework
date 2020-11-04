package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.GlobalException;
import com.thoughtworks.capacity.gtb.mvc.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Slf4j
@Validated
public class UserController {

    private final RegisterService registerService;

    public UserController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) throws GlobalException {
        registerService.register(user);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam(name = "username")
                      @NotEmpty(message = "用户名不能为空")
                      @Size(min = 3, max = 10, message = "用户名不合法")
                      @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "用户名不合法") String username,
                      @RequestParam(name = "password")
                      @NotEmpty(message = "密码不能为空")
                      @Size(min = 5, max = 12, message = "密码不合法") String password) throws GlobalException {
        return registerService.login(username, password);
    }


}
