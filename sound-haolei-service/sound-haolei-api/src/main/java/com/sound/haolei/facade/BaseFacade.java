package com.sound.haolei.facade;

import java.util.List;
import java.util.Map;

public interface BaseFacade<T extends Object>{

	/**
	 * 翻页查询总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Long queryCount(Map<String, Object> map) throws Exception;

	/**
	 * 翻页查询结果
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryPageResult(Map<String, Object> map) throws Exception;

	/**
	 * 查询所有列表
	 * @return
	 * @throws Exception
	 */
	public List<T> selectAll() throws Exception;

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T selectById(Integer id) throws Exception;

	/**
	 * 修改
	 * @param obj
	 * @throws Exception
	 */
	public void update(T obj) throws Exception;

	/**
	 * 保存
	 * @param obj
	 * @throws Exception
	 */
	public void save(T obj) throws Exception;

	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDelete(List<Integer> ids) throws Exception;

	/**
	 * 根据条件查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<T> selectByCondition(Map<String, Object> map) throws Exception;

}
