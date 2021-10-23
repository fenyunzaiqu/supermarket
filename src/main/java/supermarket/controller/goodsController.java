package supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supermarket.dto.resultDto;
import supermarket.service.goodsService;

@RestController //将java对象转为json/xml格式的数据，来提供给
@RequestMapping("/goods")//指定「哪个」控制器（controller)；即浏览器中输入local:8080/goods 用goods控制器来处理http的url请求
public class goodsController {
    @Autowired
    private goodsService goodsservice;

    @GetMapping("/{pageNo}/{size}")
    public resultDto findGoodsLess(@PathVariable("pageNo")int pageNo,@PathVariable("size") int size){
        return goodsservice.showGoodsLess(pageNo,size);
    }

    @GetMapping("/search/{id}")
    public resultDto searchGoodsById(@PathVariable("id") int id){
        return goodsservice.searchGoodsById(id);
    }
}
