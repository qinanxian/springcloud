package com.lih.userserver.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.lih.userserver.entity.User;
import com.lih.userserver.mapper.UserMapper;
import com.lih.userserver.service.UserService;
import com.lih.userserver.util.CommonUtil;
import com.lih.userserver.util.JsonUtil;
import com.lih.userserver.util.ReturnResult;
import com.lih.userserver.util.VerifyUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param jsonNode 参数
     * @return 返回值
     * @throws Exception 异常
     */
    @Override
    public JsonNode loginUser(JsonNode jsonNode) throws Exception {
        ReturnResult returnResult = new ReturnResult();
        String phone = JsonUtil.getJsonStringValue(jsonNode, "phone");
        String accountPassword = JsonUtil.getJsonStringValue(jsonNode, "accountPassword");
        User user = userMapper.getPhone(phone);
        //如果对象不等于null则说明改手机号已被注册 则校验密码
        if(user!=null){
            if(accountPassword.equals(user.getAccountPassword())){
                returnResult.success("登录成功");
            }else{
                returnResult.fail("用户密码错误，请重新输入");
            }
        }else{
            returnResult.fail("手机号未注册，请先注册后登录。");
        }
        return returnResult.toJson();
    }
    /**
     * 用户注册
     * @param jsonNode 参数
     * @return 返回值
     * @throws Exception 异常
     */
    @Override
    public JsonNode insertUser(JsonNode jsonNode) throws Exception {
        ReturnResult returnResult = new ReturnResult();
        User userJSON = JsonUtil.getJavaFromJson(jsonNode, User.class);
        try{
            boolean verify = getVerify(userJSON,returnResult);
            if(!verify){
                return returnResult.toJson();
            }
            String phone = userJSON.getPhone();
            User user = userMapper.getPhone(phone);
            if(user==null){
                String uuid = CommonUtil.getUUID();
                userJSON.setId(uuid);
                int insert = userMapper.insert(userJSON);
                if(insert>0){
                    returnResult.success("注册成功");
                }
            }else{
                returnResult.fail("当前手机号已被注册，不可重复注册!");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnResult.fail();
        }
        return returnResult.toJson();
    }
    //校验入参是否正确
    public boolean getVerify(User user,ReturnResult returnResult){
        if(StringUtils.isBlank(user.getName())){
            returnResult.fail("姓名不可为空");
            return false;
        }

        if(StringUtils.isNotBlank(user.getPhone())){
            boolean phone = VerifyUtil.isPhone(user.getPhone());
            if(!phone){
                returnResult.fail("手机号格式错误，请仔细检查！");
                return false;
            }
        }else{
                returnResult.fail("手机号不可为空");
                return false;
        }
        if(StringUtils.isNotBlank(user.getAccountPassword())){
            if(user.getAccountPassword().length()!=6){
                returnResult.fail("密码长度不能少于6位!");
                return false;
            }
        }else{
            returnResult.fail("密码不可为空");
            return false;
        }
        return true;
    }
}
