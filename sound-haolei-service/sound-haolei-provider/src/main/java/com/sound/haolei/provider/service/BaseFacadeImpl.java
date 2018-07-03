package com.sound.haolei.provider.service;

import com.sound.haolei.constants.ConstantsSubstation;
import com.sound.haolei.constants.ServiceCodeConstants;
import com.sound.haolei.exception.HttpClientException;
import com.sound.haolei.facade.BaseFacade;
import com.sound.haolei.model.HlSubstation;
import com.sound.haolei.provider.dao.HlSubstationMapper;
import com.sound.haolei.provider.dao.IBaseMapper;
import com.sound.haolei.utils.ThreadLocalUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装一个基类，用来实现公用的一些方法
 * 
 * @author tianyunyun
 *
 * @param <T>
 * @param <D>
 */
public abstract class BaseFacadeImpl<T extends Object, D extends IBaseMapper<T>> implements BaseFacade<T> {
	final static Logger logger = LoggerFactory.getLogger(BaseFacadeImpl.class);
	// 分页map中传的当前页的key
	final String grid_page = "page";
	// 分页map中传的size的key值
	final String grid_rows = "size";
	// xml中传入的当前页key
	final String curRow = "curRow";
	// xml中limit第二个参数key
	final String limitSize = "limitSize";
	// 默认当前页
	final int defaultPage = 1;
	// 默认每页size
	final String defaultRows = "20";

	public abstract D getMapper() throws Exception;



	@Autowired
    private RedisClientTemplate redisClientTemplate;

	@Autowired
	private HlSubstationMapper hlSubstationMapper;

	/**
	 * 查询总数
	 */
	@Override
	public Long queryCount(Map<String, Object> map) throws Exception {
		return this.getMapper().queryCount(map);
	}

	/**
	 * 分页查询
	 */
	@Override
	public Map<String, Object> queryPageResult(Map<String, Object> map) throws Exception {

		return null;
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<T> selectAll() throws Exception {
		return null;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public T selectById(Integer id) throws Exception {

		return null;
	}

	/**
	 * 更新
	 */
	@Override
	public void update(T obj) throws Exception {

	}

	/**
	 * 保存
	 */
	@Override
	public void save(T obj) throws Exception {

	}

	/**
	 * 批量删除
	 */
	@Override
	public void batchDelete(List<Integer> ids) throws Exception {
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<T> selectByCondition(Map<String, Object> map) throws Exception {
		return this.getMapper().selectByCondition(map);
	}

	/**
	 * 获取失败的返回内容
	 *
	 * @param msg
	 * @author chenrui
	 * @return
	 */
	protected Map<String, Object> getFailRtn(String msg) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", ServiceCodeConstants.FAIL_RTN);
		rtn.put("msg", msg);
		rtn.put("data", null);
		return rtn;
	}


    /**
     * 获取失败的返回内容
     *
     * @param msg
     * @author chenrui
     * @return
     */
    protected Map<String, Object> getFailRtn(String msg,Object data) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        rtn.put("code", ServiceCodeConstants.FAIL_RTN);
        rtn.put("msg", msg);
        rtn.put("data", data);
        return rtn;
    }

	/**
	 * 获取成功的返回内容
	 *
	 * @param data
	 * @author chenrui
	 * @return
	 */
	protected Map<String, Object> getSussRtn(Object data) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", ServiceCodeConstants.SUCCESS_RTN);
		rtn.put("msg", "");
		rtn.put("data", data);
		return rtn;
	}

	/**
	 * 获取成功的返回内容
	 *
	 * @param data
	 * @author chenrui
	 * @return
	 */
	protected Map<String, Object> getSussRtn(String msg,Object data) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", ServiceCodeConstants.SUCCESS_RTN);
		rtn.put("msg", msg);
		rtn.put("data", data);
		return rtn;
	}

	/**
	 * 具体业务状态码返回体封装方法
	 *
	 * @return
	 * @date 2016年12月2日
	 * @author tianyunyn
	 */
	protected Map<String, Object> getRtnCode(Object data, String msg, Integer code) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", code);
		rtn.put("msg", msg);
		rtn.put("data", data);
		return rtn;
	}

	/**
	 * 具体业务状态码返回体封装方法
	 *
	 * @return
	 * @date 2016年12月2日
	 * @author tianyunyn
	 */
	protected Map<String, Object> getRtnCode(String msg, Integer code) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("code", code);
		rtn.put("msg", msg);
		rtn.put("data", null);
		return rtn;
	}

	/**
	 *
	 * @Title: replaceKey
	 * @Description: 替换方法
	 * @param key
	 *            字符串
	 * @param regex
	 *            要替换的表达式
	 * @param value
	 *            要替换字符串
	 * @return 设定文件 String 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年4月26日 上午10:27:34
	 */
	public String replaceKey(String key, String regex, String value) {
		return key.replaceAll(regex, value == null ? "" : value);
	}

	/**
	 *
	 * @Title: cloudRequest
	 * @Description:云平台同步数据请求方法
	 * @param url
	 * @param headers
	 * @param obj
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 *             设定文件 boolean 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年5月11日 下午3:38:14
	 */
	public boolean cloudRequest(String url, Map<String, String> headers, JSONObject obj)
			throws IOException, HttpClientException {
//		JSONObject result = HttpClientUtil.doJsonPost(url, headers, obj);
//		logger.info("云平台请求返回为======================================" + result);
//		if (null != result) {
//			if (null != result && (result.getInt("code") == 200 || result.getInt("code") == 201)) {
//				return true;
//			}
//		}
		return false;
	}

	/**
	 *
	 * @Title: getMapDateTimeLongStr
	 * @Description: 转换map中的时间为long的字符串
	 * @param map
	 *            设定文件 void 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年5月12日 下午4:19:04
	 */
	public void getMapDateTimeLongStr(Map<String, Object> map) {
		if (null != map && !map.isEmpty()) {
			for (String key : map.keySet()) {
				if (null != key && (key.indexOf("time") > -1 || key.indexOf("Time") > -1)) {
					if (null != map.get(key)) {
						Date date = (Date) map.get(key);
						map.put(key, String.valueOf(date.getTime()));
					}
				}
			}
		}
	}

	/**
	 *
	 * @Title: setThreadLocal
	 * @Description: 设置threadlocal变量
	 * @param key
	 * @param value
	 *            设定文件 void 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年6月29日 上午11:21:20
	 */
	public void setThreadLocal(String key, String value) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		ThreadLocalUtil.set(map);
	}

	/**
	 *
	 * @Title: getThreadLocal
	 * @Description:获取threadlocal变量
	 * @param key
	 * @return 设定文件 Object 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年6月29日 上午11:22:57
	 */
	public Object getThreadLocal(String key) {
		Map map = ThreadLocalUtil.get();
		return map.get(key);
	}



	/**
	 *
	 * @Title: validSubstationBySubId
	 * @Description: 校验分站是否开通，否则返回默认分站
	 * @param subId 分站Id
	 * @return    设定文件
	 * @return Integer    返回类型     默认分站Id
	 * @throws
	 * @author wangzhanguo
	 * @date 2017年8月4日 下午3:37:06
	 */
	public Integer validSubstationBySubId(Integer subId){
		try {
			HlSubstation substation = hlSubstationMapper.selectByPrimaryKey(subId,"");
			if(null != substation && substation.getStatus() == 1){
				return subId;

			}
			//未开通，返回默认分站
			return ConstantsSubstation.SUBSTATION_DEFAULT_SUBSTATION_ID;
		} catch (Exception e) {
			return ConstantsSubstation.SUBSTATION_DEFAULT_SUBSTATION_ID;
		}

	}



}


