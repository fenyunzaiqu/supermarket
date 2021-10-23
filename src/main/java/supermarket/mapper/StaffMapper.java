package supermarket.mapper;

import org.springframework.data.repository.query.Param;
import supermarket.dto.staffDto;
import org.springframework.stereotype.Component;
import supermarket.model.Staff;

import java.util.List;

@Component
public interface StaffMapper {
    /*
    * 获取员工总数
    * @param search 员工姓名
    * @return记录数
    * */
    int getCount(String search);

    /*
    * 根据也没信息分页获取员工
    * @param start 偏移量
    * @param pageSize 查询条数
    * @param staffName 查询的员工名
    * @return 员工集合*/
    List<staffDto> getStaffBypage(@Param("start")Integer start,@Param("pageSize")Integer pageSize,
                                  @Param("staffName")String staffName); //这里@param是在注解

    /*
    * 根据员工编号查询员工
    * @param staffId 员工编号
    * @return 员工实体*/
    Staff selectStaffById(int staffId);

    /*
    * 增加员工信息
    * @param staff 员工这个类以及其信息
    * @return 行数*/
    int addStaff(Staff staff);

    /*
    * 修改员工信息
    * @param staff 要修改的信息
    * @return 行数*/
    int updateStaff(Staff staff);

    /*
    * 删除员工信息
    * @param staffId 员工编号
    * @return 行数*/
    int deleteStaff(int staffId);

}
