package com.bonc.caseDeclare.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bonc.util.JsonResult;

/**
 * 用户管理
 * @author qiushi.liu
 * @date 2018年10月19日
 *
 */
public interface UserManageService {
    /**
     * 获取所有用户信息
     * @return
     */
    JsonResult<Object> getAllUser(HttpServletRequest req);

    /**
     * 得到所有申报单位账号
     * @param request
     * @return
     */
    JsonResult<Object> allDeclareCompanyAccount(HttpServletRequest request);

    /**
     * 根据id查询用户信息
     * @param user_id
     * @return
     */
    JsonResult<Object> findUserById(String user_id);

    /**
     * 根据id修改用户信息
     * @param user_id
     * @return
     */
    JsonResult<Object> updateUserById(HttpServletRequest request,String user_id,String ipAddr);

    /**
     * 根据id删除用户信息
     * @param user_id
     * @return
     */
    JsonResult<Object> deleteUserById(String user_id);
}
