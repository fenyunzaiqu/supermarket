package supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supermarket.dto.pageDto;
import supermarket.dto.resultDto;
import supermarket.mapper.goodMapper;
import supermarket.model.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class goodsService {
    @Autowired
    private goodMapper goodmapper;

    /*分页展示商品信息
    * @param pageNo 页码
    * @param size 页面大小
    * @return 商品信息列表*/
    public resultDto showGoodsList(int pageNo,int size){
        int totalCount = goodmapper.countGoods();//通过mapper层mybatis的.xml文件来链接数据库，统计一共有多少货物
        pageDto<Goods> pagedto = new pageDto<>(size,totalCount,pageNo);//Dto层给前段的实例化，因为是Template模版类，所以有<Goods>对象作为初始化
        Map<String,Integer> info = new HashMap<>(2);//用哈希表存信息，大小为2条
        info.put("start",pagedto.getStart());//信息1是偏移量
        info.put("size",pagedto.getPageSize());//信息2是每页大小
        pagedto.setData(goodmapper.selectGoodByPage(info));//根据这两个信息去查数据库，然后将结果通过setData接口初始化pagedto，具体实现在mybatis的.xml文件里
        return resultDto.success("查询成功",pagedto);//返回结果：提示信息+填了数据的实例
    }

    /*
    * 通过商品编号查找商品
    * @param id 商品编号
    * @return 返回商品以及信息*/
    public resultDto searchGoodsById(int id){
        Goods goods = goodmapper.selectGoodsById(id);//同上mybatis
        if(goods!=null){
            return resultDto.success("",goods);
        }
        return resultDto.error("该商品不存在！");
    }

    /*分页查询库存少于50的商品
    * @param pageNo 页码
    * @param size 页面大小
    * @return 给dto层的结果*/
    public resultDto showGoodsLess(int pageNo,int size){
        int count = goodmapper.countGoodless();//同上mybatis链接数据库查询
        pageDto<Goods> pagedto = new pageDto<>(size,count,pageNo);//模版类，初始化（构造）
        List<Goods> goods = goodmapper.selectGoodLessByPage(pagedto.getStart(),pagedto.getPageSize());
        pagedto.setData(goods);
        return resultDto.success("库存少于50的商品",pagedto);
    }
}
