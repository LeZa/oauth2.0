package com.sound.haolei.facade;

import com.sound.haolei.model.HlUser;

import java.util.Map;

public interface HlUserFacade extends BaseFacade<HlUser>{
	
        HlUser selectById( String id);

    /**
     * 登陆注册
     * @param tel
     * @param phpUserId
     * @return
     */
    Map<String,Object> loginByTel(String tel, String openId,Integer sbustationId);


}
