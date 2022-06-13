package com.sxg.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonCreateTest01 {
    public static void main(String[] args) {
        System.out.println(createJson());
    }

    public static JSONObject createJson(){
        JSONObject result = new JSONObject();
        result.put("success", true);
        result.put("totalCount", "30");

        JSONObject user1 = new JSONObject();
        user1.put("id", "12");
        user1.put("name", "张三");
        user1.put("createTime", "2017-11-16 12:12:12");

        JSONObject user2 = new JSONObject();
        user2.put("id", "13");
        user2.put("name", "李四");
        user2.put("createTime", "2017-11-16 12:12:15");

        JSONObject department = new JSONObject();
        department.put("id", 1);
        department.put("name","技术部");

        user1.put("department", department);
        user2.put("department", department);

        // 返回一个JSONArray对象
        JSONArray jsonArray = new JSONArray();

        jsonArray.add(0, user1);
        jsonArray.add(1, user2);
        result.put("data", jsonArray);

        return result;
    }
}
