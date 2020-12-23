package com.xianyu.yixian_client.Model.Tcp;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Tcp
 * @ClassName: DateToLongSerializer
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/24 4:42
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/24 4:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DateToLongSerializer {
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }
}
