package com.bonc.caseDeclare.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *	用户管理数据源
 * @author qiushi.liu
 * @date 2018年10月19日
 *
 */
@Mapper
public interface UserManageMapper {

    /**
     * 获取用户信息
     * @return
     */
    public List<Map<String, Object>> getAllUser(Map<String, Object> map);

    /**
     * 根据账号注册时间查询该年所有的单位账号信息
     * @param map
     * @return
     */
    List<Map<String,Object>> allDeclareCompanyAccount(Map<String,Object> map);

    /**
     * 查询该年所有的注册单位账号信息
     * @param map
     * @return
     */
    Integer selectCount(Map<String,Object> map);

    /**
     * 根据id查询账户信息
     * @param user_id
     * @return
     */
    Map<String,Object> findUserById(@Param("user_id") String user_id);

    /**
     * 删除用户
     * @param user_id
     * @return
     */
    boolean deleteUserById(@Param("user_id") String user_id);
}
