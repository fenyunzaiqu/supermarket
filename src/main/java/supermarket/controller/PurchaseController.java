package supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import supermarket.dto.pageDto;
import supermarket.dto.purchaseDto;
import supermarket.dto.resultDto;
import supermarket.model.PurchaseRecord;
import supermarket.service.goodsService;
import supermarket.service.purchaseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Resource //通过名字注入
    private purchaseService purchaseservice;
    @Autowired //通过类型注入
    private goodsService goodsservice;

    /*分页展示商品，供员工进货商品
    * @param pageNo 页码
    * @param size 页面大小
    * @return 商品信息*/
    @GetMapping("/goods/{pageNo}/{size}")//get用来请求指定页面资源
    public resultDto showGoods(@PathVariable("pageNo") int pageNo,@PathVariable("size") int size){
        return goodsservice.showGoodsList(pageNo,size);
    }

    /*按商品编号搜索商品
    * @param goodsId 商品编号
    * @return 商品信息*/
    @GetMapping("/goods/search/{id}")
    public resultDto searchGoods(@PathVariable("id") int goodsId){
        return goodsservice.searchGoodsById(goodsId);
    }

    /*新增进货记录
    * @param purchaseRecord 一条进货记录
    * @return 进货成功或失败的提示信息*/

    @PostMapping(value = "/addPurchase", consumes = MediaType.APPLICATION_JSON_VALUE)//consumes指定处理请求的内容类型，为json数据格式
    public String addPurchaseRecord(@RequestBody PurchaseRecord purchaseRecord){//post请求传递Request Body体
        return purchaseservice.purchase(purchaseRecord);//扔给服务层处理，返回成功或失败信息
    }

    /*分页展示进货记录
    * @return 进货记录列表 以List存储*/
    @GetMapping("/allPurRecord")
    public pageDto<purchaseDto> getPurRecordByPage(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("pageNo"));//字符串转整型，然后通过Http请求得到参数的字符串值
        int size = Integer.parseInt(request.getParameter("size"));
        return purchaseservice.showPurRecordByPage(page,size,request.getParameter("name"));
    }

    /*按照进货编号查询进货记录
    * @param purchaseId 进货记录编号
    * @return 一条进货记录，List存储*/
    @GetMapping("/PurRecordById/{id}")
    public List<PurchaseRecord> getPurRecordById(@PathVariable("id") int purchaseId){
        return purchaseservice.showPurRecordById(purchaseId);
    }







}
