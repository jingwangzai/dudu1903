package com.qfjy.project.weixin.api.tuling;


import com.qfjy.project.weixin.api.tuling.bean.InputText;
import com.qfjy.project.weixin.api.tuling.bean.Perception;
import com.qfjy.project.weixin.api.tuling.bean.TuLingBean;
import com.qfjy.project.weixin.api.tuling.bean.UserInfo;

import com.qfjy.project.weixin.util.WeixinUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TuLingUtil {
    private static final String TULING_API_URL="asdasdsadasd";
    private static List<String> apiKeys;
    public String SendMessage(String msg){
      JSONObject Object=sendJSONObject(msg,apiKeys.get(0));
      JSONObject object= WeixinUtil.httpRequest(TULING_API_URL,"POST",Object.toString());
        JSONArray array=(JSONArray)Object.get("results");

        JSONObject o = (JSONObject) array.get(0);
        JSONObject o1=(JSONObject) o.get("value");
        String result=(String) o1.get("text");
        if("请求次数超限制!".equals(result)){
            if(apiKeys.size()>=1){
                apiKeys.remove(0);
                result=SendMessage(msg);
            }
        }

        return result;
    }


    public JSONObject sendJSONObject(String msg,String apikey){
        InputText inputText=new InputText();
        inputText.setText(msg);
        Perception perception=new Perception();
        perception.setInputText(inputText);

        UserInfo userInfo = new UserInfo();
        userInfo.setApiKey(apikey);
        userInfo.setUserID("jingwangzai");

        TuLingBean tuLingBean = new TuLingBean();
        tuLingBean.setPerception(perception);
        tuLingBean.setUserInfo(userInfo);

        JSONObject jsonObject=JSONObject.fromObject(tuLingBean);
        return jsonObject;

    }
    @Scheduled(cron = "0 0 0 * * ?")
    public  void timeTask(){
        apiKeys.add("5a570ed43f424f71a679a4f1094e5ced");
        apiKeys.add("e8126b0de13a4e5082c437eaf17b9468");
        apiKeys.add("78fe98f4dcfc4be498be1173117932bd");
        apiKeys.add("526b9b77b6ce40e4bb2e90e0b45b4e55");
        apiKeys.add("7b90286edf0d4e9388f8e6f68e4917d1");
    }

    public static void main(String[] args) {
        apiKeys.add("5a570ed43f424f71a679a4f1094e5ced");
        apiKeys.add("e8126b0de13a4e5082c437eaf17b9468");
        apiKeys.add("78fe98f4dcfc4be498be1173117932bd");
        apiKeys.add("526b9b77b6ce40e4bb2e90e0b45b4e55");
        apiKeys.add("7b90286edf0d4e9388f8e6f68e4917d1");
    }


}
