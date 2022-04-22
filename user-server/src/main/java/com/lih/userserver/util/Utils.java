package com.lih.userserver.util;

import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    /**
     * 传入对象转map
     * @param object
     * @return
     */
    public static Map<String, Object> objectToMap(Object object){
        HashMap<String, Object> map = new HashMap<>();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try{
                //值为true是取消java语言访问检查 为false时不可读取对象的私有属性
                field.setAccessible(true);
                map.put(field.getName(),field.get(object));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return map;
    }

    /**
     * 使用map转对象 暂时先转json 然后转对象
     * @param map
     * @param objClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static  <T> T MapToObject(Map<Object,Object> map,Class<T> objClass) throws Exception {

        JsonNode jsonFromJava = JsonUtil.getJsonFromJava(map);
        T   javaFromJson = JsonUtil.getJavaFromJson(jsonFromJava, objClass);

        return javaFromJson;
    }

}
