package supermarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        //放行所有权限
        http.authorizeRequests().antMatchers("/**").permitAll()
                .and().csrf().disable();//并关闭默认的csrf认证
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        //添加两个管理用户
        auth.inMemoryAuthentication().
                withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()). //在外面的类把PasswordEncoder重写了（Override），这里就不用配置match和encode了
                withUser("zhounan").password("123456").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/index.html","/static/**");
        //忽略相关的静态资源
    }
}
