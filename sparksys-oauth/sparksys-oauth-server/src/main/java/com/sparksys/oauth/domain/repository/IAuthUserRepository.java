package com.sparksys.oauth.domain.repository;

import com.github.pagehelper.PageInfo;
import com.sparksys.oauth.domain.bo.AuthUserBO;
import com.sparksys.oauth.infrastructure.entity.AuthUser;
import com.sparksys.oauth.interfaces.dto.user.AuthUserDTO;

import java.util.List;

/**
 * description: 用户仓储层
 *
 * @author zhouxinlei
 * @date 2020-06-05 20:39:15
 */
public interface IAuthUserRepository {


    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    AuthUser selectById(Long id);

    /**
     * 根据账户查询用户信息
     *
     * @param account
     * @return
     */
    AuthUser selectByAccount(String account);

    /**
     * 根据条件页查询用户信息
     *
     * @param pageNum    当前页
     * @param pageSize   分页大小
     * @param authUserBO authUserBO对象
     * @return PageInfo<AuthUser>
     */
    PageInfo<AuthUser> findAuthUserList(int pageNum, int pageSize, AuthUserBO authUserBO);

    /**
     * 密码输错自增
     *
     * @param id id
     */
    void incrPasswordErrorNumById(Long id);

    /**
     * 获取用户权限集
     *
     * @param id id
     * @return Set<String>
     */
    List<String> getAuthUserPermissions(Long id);

    /**
     * 密码输错自增
     *
     * @param account 账户
     */
    void incrPasswordErrorNumByAccount(String account);
}
