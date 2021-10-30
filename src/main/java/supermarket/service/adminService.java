package supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import supermarket.dto.LoginDto;

import org.springframework.stereotype.Service;
import supermarket.dto.resultDto;
import supermarket.mapper.adminMapper;
import supermarket.model.Admin;

import java.util.Date;
import java.util.UUID;

@Service //@Service注解用于类上，标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了。
//bean是什么：<bean id="person" class="me.sjl.bean.Person">
//    <property name="age" value="18"/>
//    <property name="name" value="sjl"/>
//</bean> 给xml用的一个类似「标签」或者「定义」，告诉xml去哪里找，这东西是什么类的
public class adminService {
    @Autowired //自动注入bean
    private adminMapper adminmapper;
    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    /*用户登录
    * @param admin 用户名
    * return结果返回给dto层*/
    public resultDto login(Admin admin){
        Admin dbAdmin = adminmapper.selectAdminByUsername(admin.getAdminName()); //创造一个和admin同名的对象
        System.out.println(1);
        if(dbAdmin!=null){
            if((admin.getAdminPassword().equals(dbAdmin.getAdminPassword())))//密码验证
            {
                String token = UUID.randomUUID().toString();//生成唯一标识符
                Date date = new Date(System.currentTimeMillis());
                dbAdmin.setCreateTime(date);//获取当前时间
                //dbAdmin.setToken(token);//设置口令
                int updated = adminmapper.updateAdmin(dbAdmin);//更新用户
                System.out.println(updated);
                System.out.println("6");
                if(updated == 1){ //给前端数据，即Dto层里
                    LoginDto loginDto = new LoginDto();
                    loginDto.setToken(token);
                    loginDto.setUserName(admin.getAdminName());
                    return resultDto.success("登陆成功",loginDto);
                }
            }
        }
        return resultDto.error("用户名或密码错误，请输入重试");
    }

    /*
    * 添加用户
    * @param admin "用户对象"
    * @return 给前端（dto层）的消息*/
    public resultDto addUser(Admin admin){
        Admin dbAdmin = adminmapper.selectAdminByUsername(admin.getAdminName());
        if(dbAdmin == null){
            String dbPassword = bCryptPasswordEncoder.encode(admin.getAdminPassword());//密码明文加密
            admin.setAdminPassword(dbPassword);//保存加密密码
            adminmapper.addUser(admin);
            return resultDto.success("用户添加成功");
        }
        return resultDto.error("用户已存在");
    }
}
