package com.qfjy.project.weixin.api.hitokoto;

import com.qfjy.project.weixin.util.WeixinUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Hitokotoutil {

    private static final String HITOKOTO_API_URL="https://v1.hitokoto.cn/";

   public String SendMessage(){
       JSONObject jsonObject= WeixinUtil.httpRequest(HITOKOTO_API_URL,"GET",null);
       String result= jsonObject.get("hitokoto").toString();
       System.out.println(result);
       return result;
   }
}
