package supermarket.dto;

public class resultDto {
    private Integer status;
    private String msg;
    private Object data;
    private resultDto(){ }
    private resultDto(Integer status,String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    /*静态构建方法，对外提供接口*/
    public static resultDto create(){
        return new resultDto();
    }
    /*
    * 请求成功，统一返回200(http协议成功响应状态）
    * @param msg'响应消息*/
    public static resultDto success(String msg){
        return new resultDto(200,msg,null);
    }
    public static resultDto success(String msg,Object obj){
        return new resultDto(200,msg,obj);
    }
    public static resultDto error(String msg){
        return new resultDto(500,msg,null);
    }
    public static resultDto error(String msg,Object obj){
        return new resultDto(500,msg,obj);
    }
    public resultDto setMsg(String msg){
        this.msg=msg;
        return this;
    }
    public resultDto setStatus(Integer Status){
        this.status = status;
        return this;
    }
    public resultDto setData(Object data){
        this.data = data;
        return this;
    }

    public Integer getStatus(){
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
    @Override
    public String toString(){
        return "resultDto{"+"status="+status+",msg="+msg+'\''+",data="+data+'}';
    }
}
