package com.pactera.ptil.web.common;

/**
 * 
* @ClassName: JsonResult  
* @author Zhi.WZ.Wang
* @date 2021/03/20 
*
 */
public class JsonResult<T> {

    private String code;

    private String message;

    private T data;

    public JsonResult() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("SUCCESS！");
    }

    public JsonResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public JsonResult(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public JsonResult(ResultCode code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public JsonResult(T data) {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("SUCCESS！");
        this.setData(data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static <T> JsonResult<T> ok(String resultMsg, T data) {
        return new JsonResult<>(ResultCode.SUCCESS, resultMsg, data);
    }

    public static <T> JsonResult<T> ok() {
        return new JsonResult<>();
    }


    public static <T> JsonResult<T> ok(T data) {
        return new JsonResult<>(data);
    }

    public static <T> JsonResult<T> success(String resultMsg) {
        return new JsonResult<>(ResultCode.SUCCESS, resultMsg);

    }

    public static <T> JsonResult<T> fail(String resultMsg) {
        return new JsonResult<>(ResultCode.FAILED, resultMsg);

    }

    public static <T> JsonResult<T> error(String resultMsg) {
        return new JsonResult<>(ResultCode.SYS_ERROR, resultMsg);

    }

    public static <T> JsonResult<T> error(Integer code, String resultMsg) {
        return new JsonResult<>(String.valueOf(code), resultMsg);

    }

    public static <T> JsonResult<T> error(String code, String resultMsg) {
        return new JsonResult<>(code, resultMsg);

    }

    public static <T> JsonResult<T> error() {
        return new JsonResult<>(ResultCode.SYS_ERROR, ResultCode.SYS_ERROR.msg());

    }
}