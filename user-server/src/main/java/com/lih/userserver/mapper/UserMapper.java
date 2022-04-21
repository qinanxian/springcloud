package com.lih.userserver.mapper;

import com.lih.userserver.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface UserMapper extends Mapper<User> {
    List<User> getUser();

    /**
     * 根据身份证号与手机号查询
     */
    User getPhone(@Param("phone") String phone);
}
