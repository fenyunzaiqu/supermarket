package supermarket.mapper;
import org.springframework.stereotype.Component;
import supermarket.model.Admin;
@Component
public interface adminMapper {
    Admin selectAdminByUsername(String name);
    void addUser(Admin admin);
    Admin selectAdminByToken(String token);
    int updateAdmin(Admin admin);
}
