package com.sound.haolei.provider.dao;

import com.sound.haolei.model.HsAppointment;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HsAppointmentMapper extends IBaseMapper<HsAppointment>{

    /**
     * @Description
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> selectByAppointmentMobile( Map<String,Object> paramMap );

    /**
     * @Description  站根据id(带分站)
     * @author sushile
     * @date 20180309
     * @return
     */
    HsAppointment selectByIdWithSubId(@Param("id") String id,@Param("substationId") String substationId );
}