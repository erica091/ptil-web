package com.pactera.ptil.web.common;

/**
 * 
* @ClassName: ResultCode  
* @author Zhi.WZ.Wang
* @date 2021/03/20 
*
 */
public enum ResultCode {

    SUCCESS("0", "SUCCESS"),

    FAILED("1", "FAILED"),

    SYS_ERROR("2", "SYS_ERROR");
	
	 private String val;
	 private String msg;

    ResultCode(String status, String msg) {
        this.val = status;
        this.msg = msg;
    }


    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

   

}
