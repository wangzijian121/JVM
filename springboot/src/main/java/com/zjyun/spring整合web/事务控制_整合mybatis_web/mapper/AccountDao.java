package com.zjyun.spring整合web.事务控制_整合mybatis_web.mapper;

import com.zjyun.spring整合web.事务控制_整合mybatis_web.model.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/6/18
 */
public interface AccountDao {

    @Update("update  account set balance=#{account.balance} WHERE id = #{account.id}")
    void updateAccount(@Param("account") Account account);

    @Select("select * from   account  where id=#{id}")
    Account getAccountById(@Param("id") Integer id);
}
