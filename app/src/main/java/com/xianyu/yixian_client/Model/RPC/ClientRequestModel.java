package com.xianyu.yixian_client.Model.RPC;

import com.google.gson.annotations.Expose;

public class ClientRequestModel {
    @Expose
    public Object Result;
    public String JsonRpc;
    public String MethodId;
    public Object[] Params;
    public String Id;
    public String Service;


    public ClientRequestModel(String jsonRpc,String service, String methodId, Object[] params) {
        JsonRpc = jsonRpc;
        MethodId = methodId;
        Params = params;
        Service = service;
    }

    public void setResult(Object result) {
        Result = result;
        result.notifyAll();
    }

    public Object getResult() throws InterruptedException {
        while(Result == null){
            Result.wait();
        }
        return Result;
    }
}
