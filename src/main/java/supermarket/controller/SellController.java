package supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import supermarket.dto.resultDto;
import supermarket.model.Sellgood;
import supermarket.service.SellService;
import supermarket.service.goodsService;

@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private goodsService goodsservice;

    /*分页展示商品，让员工选取销售项
    * @param pageNo 页码
    * @param size 页面大小
    * @return 商品信息*/
    @GetMapping("/goods/{pageNo}/{size}")
    public resultDto showGoods(@PathVariable("pageNo")int pageNo, @PathVariable("size") int size){
        return goodsservice.showGoodsList(pageNo, size);
    }

    /*按商品编号搜索商品
    * @param goodsId 商品编号
    * @return 商品信息*/
    @GetMapping("/goods/search/{id}")
    public resultDto searchGoods(@PathVariable("id")int goodsId){
        return goodsservice.searchGoodsById(goodsId);
    }

    /*提交销售记录
    * @param sellgoods销售项集合
    * @param sfId 员工编号
    * @return 提示消息*/
    @PostMapping(value = "/addOrder/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public resultDto addOrder(@RequestBody Sellgood[] sellgoods,@PathVariable("id") int sfId){
        return sellService.sell(sellgoods,sfId);
    }

    /*分页查询销售记录
    * @param pageNo 页码
    * @param size 页面大小
    * @return 销售记录*/
    @GetMapping("/record/{pageNo}/{size}")
    public resultDto getSellRecords(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size){
        return sellService.showSellRecordList(pageNo, size);
    }

    /*按照销售项编号查询销售项
    * @param sellId 销售编号
    * @return 销售项列表*/
    @GetMapping("/recordItem/{id}")
    public resultDto getRecordItem(@PathVariable("id") int sellId){
        return sellService.showSellItem(sellId);
    }





}
