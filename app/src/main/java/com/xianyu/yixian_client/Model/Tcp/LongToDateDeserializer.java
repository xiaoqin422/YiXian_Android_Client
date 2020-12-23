package com.xianyu.yixian_client.Model.Tcp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @ProjectName: YiXian_Client
 * @Package: com.xianyu.yixian_client.Model.Tcp
 * @ClassName: LongToDateDeserializer
 * @Description: java类作用描述
 * @Author: Jianxian
 * @CreateDate: 2020/12/24 4:42
 * @UpdateUser: Jianxian
 * @UpdateDate: 2020/12/24 4:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LongToDateDeserializer {
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new java.util.Date(json.getAsJsonPrimitive().getAsLong());
    }
}
