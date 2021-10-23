package supermarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import supermarket.mapper.adminMapper;
import supermarket.model.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jdk.nashorn.internal.parser.DateParser.DAY;

@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private adminMapper adminmapper;
    private static final long Day = 86400000;

    /*处理请求之前调用，验证是否存在口令*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
        throws Exception{
        String token = request.getParameter("Authorization");
        if(token!=null && !"".equals(token)){//验证token不为空
            System.out.println("token为: "+token);
            Admin dbAdmin = adminmapper.selectAdminByToken(token);//在数据库里找出符合对应的User用户
            if(dbAdmin == null){
                System.out.println("该用户不存在");
                return false;
            }
            System.out.println("用户为"+dbAdmin);
            if((System.currentTimeMillis() - dbAdmin.getCreateTime()) > DAY){
                request.setAttribute("Authorization",null);
                System.out.println("验证口令token失效，请重新登陆");
                return false;
            }
        }
        return true;
    }

    /*
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{

    }

    @Override
    public void afterComletion()

     */
}
