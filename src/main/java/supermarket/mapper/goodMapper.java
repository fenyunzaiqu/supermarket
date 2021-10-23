package supermarket.mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import supermarket.model.Goods;
import java.util.List;
import java.util.Map;

@Component
public interface goodMapper {
/*
*@param info存放页面大小
* @return 商品信息列表
* */
    List<Goods> selectGoodByPage(Map<String,Integer>info);
/*
@param start偏移量
@param size 页大小
@return商品列表
*/
    List<Goods> selectGoodLessByPage(int start,int size);
/*
查询库存不足商品
@return总数
 */
    int countGoodless();
    /*
    查询商品总数
    @return商品总数
     */
    int countGoods();
    /*
    * 通过商品编号查找商品信息(非名字）
    * @param goodsId 商品编号
    * @return 商品信息
    * */
    Goods selectGoodsById(int goodsId);
    /*通过商品名字查找商品编号
    * @param name 商品名称
    * @return 商品编号*/
    List<Integer> selectIdByName(String name);
    /*增加商品信息
    * @param goods 需要增加的商品
    * @return 行数*/
    int addGoods(Goods goods);
    /*修改商品信息
    * @param goods要更新的商品名字*/
    int updateGoods(Goods goods);
    /*通过商品编号查找商品名字
    * @param goodsID商品编号
    * @return 商品名称*/
    String selectNameById(int goodsId);
}

