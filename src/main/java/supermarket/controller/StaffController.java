package supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supermarket.dto.resultDto;
import supermarket.service.StaffService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    /*分页展示所有员工
    * @param request Http请求
    * @return 查询结果*/
    @GetMapping("/basicInfo")
    private resultDto getAllEmployeeByPage(HttpServletRequest request){
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String search = request.getParameter("search");
        System.out.println(search+"Controller的search");
        return staffService.getAllStaffByPage(page,size,search);
    }
}
