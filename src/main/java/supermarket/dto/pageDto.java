package supermarket.dto;

import java.util.List;

public class pageDto<T>{
    /*数据记录集合*/
    private List<T> data;

    /*总页码*/
    Integer pagesNum;

    /*记录总条数*/
    private Integer recordNum;

    /*偏移量*/
    private  Integer start;

    /*页面大小*/
    private  Integer pageSize;

    /*
    * @param pageSize 页面大小
    * @param totalCount 记录总条数
    * @param pageNo 当前页码*/
    public pageDto(int pageSize, int totalCount, int pageNo){
        recordNum = totalCount;
        pageNo=pageNo<=0?5:pageNo;
        pageSize=pageSize<=0?5:pageSize;
        pagesNum = totalCount % pageSize == 0 ?
                totalCount / pageSize : totalCount / pageSize + 1;
        pageNo = pageNo>pagesNum?pagesNum:pageNo;
        this.pageSize=pageSize;
        this.start = (pageNo-1)*pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
