package com.bw.weiducommerce.api;

/*Time:2019/3/20
 *Author:chenxuewen
 *Description:接口地址
 */
public class Api {
    //public static final String registerUrl = "";
    //登录接口 外网mobile.bwstudent.com
    //内网http://172.17.8.100
    public static final String loginUrl = "http://mobile.bwstudent.com/small/user/v1/login";
    //注册接口
    public static final String registerUrl = "http://mobile.bwstudent.com/small/user/v1/register";
    //修改昵称
    public static final String updateNameUrl = "http://mobile.bwstudent.com/small/user/verify/v1/modifyUserNick";
    //首页展示列表small/commodity/v1/commodityList
    public static final String showUrl = "http://mobile.bwstudent.com/small/commodity/v1/";
    //详情http://172.17.8.100/small/commodity/v1/findCommodityDetailsById
    public static final String detailUrl = "http://mobile.bwstudent.com/small/commodity/v1/";
}
