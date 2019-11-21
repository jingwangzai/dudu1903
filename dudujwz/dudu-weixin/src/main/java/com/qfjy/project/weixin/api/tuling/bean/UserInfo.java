package com.qfjy.project.weixin.api.tuling.bean;

import lombok.Data;

@Data
public class UserInfo {
    /** 机器人标识 **/
    private String apiKey;
    /** 用户唯一标识 **/
    private String userId;
}
