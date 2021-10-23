package supermarket.mapper;
import org.springframework.stereotype.Component;
import supermarket.model.SellRecord;


import java.util.List;
import java.util.Map;

@Component
public interface SellRecordMapper {
    /*分页查询销售记录
    * @param info存放记录下标及分页大小
    * @return 销售记录列表*/
    List<SellRecord> selectRecordByPages(Map<String,Integer> info);

    /*查询最后一条销售记录
    * @return 销售记录*/
    SellRecord selectLastRecord();

    /*计算销售记录总条数
    * @return 总条数
    * */
    int countRecords();

    /*
    * 增加一条销售记录
    * @param record 销售记录
    * */
    void addSellRecord(SellRecord record);
}
