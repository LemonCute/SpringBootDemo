package com.lcke.demo.utils.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class JsonUtils {
	/**
	 * 递归将key-value写入一个jsonobject
	 * @param objJson
	 * @param dataMap
	 * @return
	 */
	public static JSONObject analysisJson(Object objJson, JSONObject dataMap) {
        // 如果obj为json数组
        if (objJson instanceof JSONArray) {
            //将接收到的对象转换为JSONArray数组
            JSONArray objArray = (JSONArray) objJson;
            //对JSONArray数组进行循环遍历
            for (int i = 0; i < objArray.size(); i++) {
                //调用回调方法
                analysisJson(objArray.get(i), dataMap);
            }
            // 如果为json对象
        } else if (objJson instanceof JSONObject) {
            //将Object对象转换为JSONObject对象
            JSONObject jsonObject = JSONObject.parseObject(objJson.toString());
            //迭代多有的Key值
            Set<String> set = jsonObject.keySet();
            Iterator it = set.iterator();
            //遍历每个Key值
            while (it.hasNext()) {
                //将key值转换为字符串
                String key = it.next().toString();
                //根据key获取对象
                Object object = jsonObject.get(key);
                // 如果得到的是数组
                if (object instanceof JSONArray) {
                    //将Object对象转换为JSONObject对象
                    JSONArray objArray = (JSONArray) object;
                    //调用回调方法
                    analysisJson(objArray, dataMap);
                }
                // 如果key中是一个json对象
                else if (object instanceof JSONObject) {
                    //调用回调方法
                    analysisJson((JSONObject) object, dataMap);
                } else {
                    dataMap.put(key, object.toString());
                }
            }
        }
        return dataMap;
    }
}
