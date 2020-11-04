package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @NotEmpty(message = "用户名不能为空")
    @Size(min=3, max=10,message = "用户名不合法")
    @Pattern(regexp = "^[0-9a-zA-Z_]+$",message = "用户名不合法")
    private String username;
    @NotEmpty(message = "密码不能为空")
    @Size(min=5, max = 12, message = "密码不合法")
    private String password;
    @Email(message = "邮箱地址不合法")
    @Builder.Default
    private String email="";
    private Integer id;
}
