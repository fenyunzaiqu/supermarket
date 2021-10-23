package supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supermarket.dto.pageDto;
import supermarket.dto.purchaseDto;
import supermarket.mapper.StaffMapper;
import supermarket.mapper.goodMapper;
import supermarket.mapper.purchaseMapper;
import supermarket.model.Goods;
import supermarket.model.PurchaseRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class purchaseService {
    @Autowired
    private purchaseMapper purchasemapper;
    @Autowired
    private goodMapper goodsmapper;
    @Autowired
    private StaffMapper staffMapper;

    /*
    * 进货处理，添加进货记录，修改库存
    * @param purchaseRecord 一条进货记录
    * @return 提示信息*/

    public String purchase(PurchaseRecord purchaseRecord){
        System.out.println(purchaseRecord);
        if(purchaseRecord==null){
            return "请添加进货记录";
        }
        Goods goods = goodsmapper.selectGoodsById(purchaseRecord.getGoodsId());//进货记录的货物id与数据库里的对比（查找）
        if(goods == null){
            return "该商品不存在，请录入商品信息";
        }
        purchaseRecord.setPurchaseDate(new Date());//录入的时间
        int res = purchasemapper.addPurchase(purchaseRecord);//将进货记录加入到数据库里
        System.out.println(res);
        goods.setAmount(goods.getAmount()+purchaseRecord.getAmount());//更新货物数量
        int updated = goodsmapper.updateGoods(goods);
        if(updated == 1){
            return "进货成功";
        }
        return "操作失败";
    }

    /*
    * 分页展示进货记录
    * @param page 第几页
    * @param size 每页大小
    * @param total 记录总数
    * @return 进货记录列表，pageDto是一个模版类，这次里面的参数是进货Dto（给前端）对象（实例/object）*/
    public pageDto<purchaseDto> showPurRecordByPage(int page,int size,String goodsName){
        List<Integer> goodIdList = goodsmapper.selectIdByName(goodsName);//数据库通过名字找id，通过List存着
        if(goodIdList.size() == 0){
            return null;
        }
        int total = purchasemapper.getCount(goodIdList);//进货总记录条数
        pageDto<purchaseDto> pageDto = new pageDto<>(size,total,page);//分页参数，创建一个pageDto对象
        List<PurchaseRecord> allPurRecord = purchasemapper.selectPurRecordByPage(
                pageDto.getStart(),pageDto.getPageSize(),goodIdList);//（这一页的）所有进货记录
        List<purchaseDto> data = new ArrayList<>(allPurRecord.size());//创建一个list，用于保存查询记录
        for(PurchaseRecord record : allPurRecord){//对于这一页所有的进货（id）记录
            data.add(new purchaseDto( record.getPurchaseId(),//用全参（Allargs）构造函数创建一个给前段的purchaseDto对象）
                    goodsmapper.selectNameById(record.getGoodsId()),
                    record.getPrice(),
                    record.getAmount(),
                    record.getPurchaseDate(),
                    record.getStaffId()
            ));
        }
        pageDto.setData(data);
        return pageDto;
    }

    /*根据进货编号查询进货记录
    * @param purchaseId 进货记录编号
    * @return 一条对应编号的进货记录，用List存储
    * */
    public List<PurchaseRecord> showPurRecordById(int purchaeId){
        return purchasemapper.selectPurRecordById(purchaeId);
    }
}
