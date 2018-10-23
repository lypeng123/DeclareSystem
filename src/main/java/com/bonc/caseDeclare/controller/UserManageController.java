package com.bonc.caseDeclare.controller;

import com.bonc.caseDeclare.service.DeclareInfoService;
import com.bonc.caseDeclare.service.HistoricalCaseService;
import com.bonc.caseDeclare.service.UserManageService;
import com.bonc.util.IPvalidateUtil;
import com.bonc.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userManage")
public class UserManageController {

    private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

    @Autowired
    private UserManageService userManageService;

    /**
     * 获取用户信息列表
     * @param req
     * @return
     */
    @RequestMapping("/getUserInfo")
    public JsonResult<Object> getgetUserInfoResult(HttpServletRequest req){
        String ipAddr = IPvalidateUtil.getIpAddr(req).split(",")[0];// 访问的ip
        logger.info("IP为：【"+ipAddr+"】获取了用户信息列表");

        //JsonResult<Object> userResult = userManageService.getAllUser(req);
        JsonResult<Object> userResult = userManageService.allDeclareCompanyAccount(req);
        logger.info("用户信息查询结果："+userResult);

        return userResult;
    }

    /**
     * 查询企业信息
     */
    @RequestMapping("/allDeclareCompanyAccount")
    public JsonResult<Object> allDeclareCompanyAccount(HttpServletRequest request) {
        return userManageService.allDeclareCompanyAccount(request);

    }

    /**
     * 根据用户id查询用户信息
     * @param request
     * @return
     */
    @RequestMapping("/findUserById")
    public JsonResult<Object> findUserById(HttpServletRequest request,String user_id){
        String ipAddr = IPvalidateUtil.getIpAddr(request).split(",")[0];// 访问的ip
        logger.info("IP为：【"+ipAddr+"】查询了用户"+user_id+"的用户信息");
        return userManageService.findUserById(user_id);
    }

    /**
     * 修改用户信息
     * @param request
     * @param user_id
     * @return
     */
    @RequestMapping("/updateUserById")
    public JsonResult<Object> updateById(HttpServletRequest request,String user_id){
        String ipAddr = IPvalidateUtil.getIpAddr(request).split(",")[0];// 访问的ip
        logger.info("IP为：【"+ipAddr+"】修改了用户"+user_id+"的用户信息");
        return userManageService.updateUserById(request,user_id,ipAddr);
    }

    /**
     * 删除用户信息
     * @param request
     * @param user_id
     * @return
     */
    @RequestMapping("/deleteUserById")
    public JsonResult<Object> deleteUserById(HttpServletRequest request,String user_id){
        String ipAddr = IPvalidateUtil.getIpAddr(request).split(",")[0];// 访问的ip
        logger.info("IP为：【"+ipAddr+"】修改了用户"+user_id+"的用户信息");
        return userManageService.deleteUserById(user_id);
    }

}
