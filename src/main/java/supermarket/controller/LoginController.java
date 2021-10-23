package supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supermarket.dto.resultDto;
import supermarket.model.Admin;
import supermarket.service.adminService;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private adminService adminservice;

    @PostMapping("/login") //等同@RequestMapping(value = "/get/{id}", method = RequestMethod.POST),映射一个post请求（http）
    //post请求又是：GET把参数包含在URL中，POST通过request body传递参数。
    //这里将前端传过来的admin对象登陆
    public resultDto login(@RequestBody Admin admin){
        System.out.println(admin.toString());
        return adminservice.login(admin);//通过service层登陆
    }
}
