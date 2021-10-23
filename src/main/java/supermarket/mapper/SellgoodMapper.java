package supermarket.mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import supermarket.model.Sellgood;
import java.util.List;

@Component
public interface SellgoodMapper {
    /*
    * 批量增加销售项
    * @param goods 销售项集合
    * @return 影响行数*/
    int addItems(Sellgood[] goods);

    /*
    * 按销售编号查找所有销售项
    * @param sellId销售编号
    * @param 所有销售项列表*/
    List<Sellgood> selectAllGoodsById(int sellId);
}
