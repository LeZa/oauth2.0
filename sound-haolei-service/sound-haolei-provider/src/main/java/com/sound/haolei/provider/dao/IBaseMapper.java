package com.sound.haolei.provider.dao;

import com.sound.haolei.constants.ConstantsSubstation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公用方法提取
 * @author tainyunyun
 *
 * @param <T>
 */
public interface IBaseMapper<T extends Object> { 

	int insert(Object obj);
	int insertSelective(Object obj);
    //根据条件查询
    List<T> selectByCondition(Map<String, Object> map);
    List<T> selectAll(@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String substationSpell);
    T selectByPrimaryKey(@Param("id")Integer id,@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String substationSpell);
    int updateByPrimaryKeySelective(Object obj);
    int deleteByPrimaryKey(@Param("id")int id,@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String substationSpell);
    //查询翻页总数
    Long queryCount(Map<String,Object> map);
    //查询翻页结果
    List<T> queryPageResult(Map<String,Object> map);
    int batchDelete(@Param("list")List<Integer> ids,@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String substationSpell);
    int batchInsert(@Param("list")List<T> objs,@Param(ConstantsSubstation.SUBSTATION_NAME_SPELL) String substationSpell);
}
