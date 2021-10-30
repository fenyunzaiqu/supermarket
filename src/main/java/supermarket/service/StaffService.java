package supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supermarket.dto.pageDto;
import supermarket.dto.resultDto;
import supermarket.dto.staffDto;
import supermarket.mapper.StaffMapper;

import java.util.List;


@Service
public class StaffService {
    @Autowired
    private StaffMapper staffMapper;

    /*分页查询所有员工
    * @param page页数
    * @param size每页大小
    * @param staffName 员工姓名
    * @return 分页结果*/
    public resultDto getAllStaffByPage(Integer page, Integer size, String staffName){
        System.out.println("Service的"+staffName);
        int total = staffMapper.getCount(staffName);//通过
        System.out.println(total);
        if(total == 0){
            System.out.println(2);
            return resultDto.error("员工不存在");
        }
        pageDto<staffDto> pageDto = new pageDto<>(size,total,page);//初始化给dto层的page 实例/对象（object）
        System.out.println(3);
        List<staffDto> staffList = staffMapper.getStaffByPage(
                pageDto.getStart(),pageDto.getPageSize(),staffName
        );
        pageDto.setData(staffList);
        return resultDto.success("员工信息获取成功",pageDto);
    }
}
