package com.test.ReqPayloads;

import org.json.simple.JSONObject;

import java.util.LinkedHashMap;

public class WhatsappApp {

    public static JSONObject ReturnAddPetRequestPayload(String phoneNumber) {

        JSONObject obj =  new JSONObject();

        obj.put("messaging_product", "whatsapp");
        obj.put("to", "+919553227776");
        obj.put("type", "template");

        LinkedHashMap template = new LinkedHashMap();

        template.put("name","hello_world");

        LinkedHashMap language = new LinkedHashMap();
        language.put("code","en_US");
        template.put("language", language);
        obj.put("template",template);
        return obj;
    }


    }
