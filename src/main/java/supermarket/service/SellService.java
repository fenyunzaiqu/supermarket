package supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supermarket.dto.pageDto;
import supermarket.dto.resultDto;
import supermarket.mapper.SellRecordMapper;
import supermarket.mapper.SellgoodMapper;
import supermarket.mapper.StaffMapper;
import supermarket.mapper.goodMapper;
import supermarket.model.Goods;
import supermarket.model.SellRecord;
import supermarket.model.Sellgood;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SellService {
    @Autowired
    private SellgoodMapper sellgoodMapper;
    @Autowired
    private SellRecordMapper sellRecordMapper;
    @Autowired
    private goodMapper goodmapper;
    @Autowired
    private StaffMapper staffMapper;
    /*
    * 查询商品是否存在且库存充足
    * @param id 商品编号
    * @param amount 库存
    * @return 如果商品存在则返回商品，否则返回null*/
    public Goods existAndEnough(int id,int amount){
        Goods goods = goodmapper.selectGoodsById(id);
        if(goods!=null){
            if(amount<=goods.getAmount()){
                return goods;
            }
        }
        return null;
    }
    /*
    * 销售处理，添加销售记录，销售商品（项），修改商品库存
    * @param goods销售商品（项）集合
    * @param sfId  员工编号
    * @return 提示信息*/
    public resultDto sell(Sellgood[] items,int sfId) {
        //对输入参数的错误（异常）处理
        if (items.length == 0) {
            return resultDto.error("不能提交空的销售项");
        }
        if (staffMapper.selectStaffById(sfId) == null) {
            return resultDto.error("该员工不存在");
        }
        //new Date出现在时间点，然后创建销售记录对象，实例（object）
        sellRecordMapper.addSellRecord(new SellRecord(null, sfId, new Date()));
        Integer sellId = sellRecordMapper.selectLastRecord().getSellId();//因为销售记录是数据库里自增，输入null进去，返回一个自增的销售记录
        Goods good = null;
        for (Sellgood item : items) {
            if ((good = existAndEnough(item.getGoodsId(), item.getAmount())) != null) {//检查要销售的数量和库存够不够
                good.setAmount(good.getAmount() - item.getAmount());//减少卖出去后的库存
                goodmapper.updateGoods(good);//修改数据库中的库存信息
                item.setSellId(sellId);//为这次销售项注入销售编号
            } else {
                return resultDto.error("商品不存在或者库存不足");
            }
        }
        int row = sellgoodMapper.addItems(items);//批量增加销售项
        if(row == items.length){
            return resultDto.success("添加"+row+"成功");}
        else {
            return resultDto.error("添加失败");
        }
    }
        /*分页查询销售记录
        * @param pageNo 页码
        * @param size 页大小
        * @return 销售记录列表*/
    public resultDto showSellRecordList(int pageNo,int size){
        int totalCount = sellRecordMapper.countRecords();//查找一共有多少条销售记录
        pageDto<SellRecord> pagedto = new pageDto<>(size,totalCount,pageNo);//创建分页dto对象
        Map<String,Integer> info = new HashMap<>(2);
        info.put("start",pagedto.getStart());//根据对象的构造函数计算后得到分页的偏移量和每页大小
        info.put("start",pagedto.getPageSize());
        pagedto.setData(sellRecordMapper.selectRecordByPages(info));//然后将两个参数输入进数据库得到分页查询的结果（data）
        return resultDto.success("查询成功",pagedto);
    }
    /*根据销售编号查找销售项
    * @param sellId 销售编号
    * @return 销售项列表*/
    public resultDto showSellItem(int sellId){
        return resultDto.success("查询成功",sellgoodMapper.selectAllGoodsById(sellId));
    }


    }
