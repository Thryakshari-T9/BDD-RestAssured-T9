package com.test.ReqPayloads;

import org.json.simple.JSONObject;

public class ReqResRequestPayload {

    public static JSONObject returReqresRequestPayload(){

        JSONObject obj = new JSONObject();
        obj.put("name","Suresh");
        obj.put("job","Software Assocoate");

        return obj;


    }
}
