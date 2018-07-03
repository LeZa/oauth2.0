package com.sound.haolei.provider.util;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.common.json.JSON;
import com.sound.haolei.exception.HttpClientException;
import com.sound.haolei.utils.ProfileUtil;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Map.Entry;

/**
 * httpClient工具类<br/>
 * 提供post和get的接口调用
 * 
 * @author chenrui
 *
 */
public class HttpClientUtil {
	static Logger logger = LoggerFactory.getLogger("HttpClientUtil.class");
	private static final String PRO_FILE_PATH = "httpclient.properties";

	/**
	 * 超时时间,默认5000
	 */
	private static Integer timeout = 5000;
	/**
	 * 重试次数,默认3次
	 */
	private static Integer retryTimes = 3;

	/**
	 * 初始化超时时间和重试次数
	 */
	static {
		ProfileUtil profileUtil = ProfileUtil.getInstance();
		String _timeout = profileUtil.read(PRO_FILE_PATH, "client.timeout");
		String _retryTimes = profileUtil.read(PRO_FILE_PATH, "client.retry_times");
		if (!StringUtils.isEmpty(_timeout)) {
			timeout = Integer.parseInt(_timeout);
		}
		if (!StringUtils.isEmpty(_retryTimes)) {
			retryTimes = Integer.parseInt(_retryTimes);
		}
	}

	/**
	 * 创建httpClient,创建时设置超时时间和重试次数
	 * 
	 * @return
	 */
	private static CloseableHttpClient createClient() {
		HttpClientBuilder clientBuilder = HttpClients.custom();
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).build();
		// 设置重试次数
		clientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(retryTimes, true));
		// 设置超时时间
		clientBuilder.setDefaultRequestConfig(requestConfig);
		return clientBuilder.build();
	}

	/**
	 * 执行post请求,返回String类型的返回值
	 * @param url
	 * @param params <String,String>的Map类型参数
	 * @return
	 * @throws IOException
	 * @throws HttpClientException 
	 */
	public static String post(String url, Map<String, String> headers, Map<String, String> params) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();

		String body = null;

		logger.info("create httppost:" + url+params.toString());
		HttpPost post = postForm(url,headers, params);
		try {
			body = invoke(httpclient, post);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}

		return body;
	}
	
	/**
	 * 执行post请求,返回String类型的返回值
	 * @param url
	 * @param params <String,String>的Map类型参数
	 * @return
	 * @throws IOException
	 * @throws HttpClientException 
	 */
	public static String post(String url, Map<String, String> headers) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();
		
		String body = null;

		logger.info("create httppost:" + url);
		HttpPost httpost = new HttpPost(url);
		
		if (null != headers) {
			for (String key : headers.keySet()) {
				httpost.setHeader(key, headers.get(key));
			}
		}
		try {
			body = invoke(httpclient, httpost);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}
		return body;
	}
	
	/**
	 * 执行post请求,返回String类型的返回值 设置cookie
	 * @param url
	 * @param params <String,String>的Map类型参数
	 * @return
	 * @throws IOException
	 * @throws HttpClientException 
	 */
	public static String postAndCookie(String url, Map<String, String> headers,Map<String,String> cookieMap) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();
		String body = null;

		logger.info("create httppost:" + url);
		HttpPost httpost = new HttpPost(url);
		StringBuilder cookieStr = new StringBuilder(); 
		if(null != cookieMap){
			for(Entry<String, String> entry : cookieMap.entrySet()){
				String name = entry.getKey();
				String value = entry.getValue();
				cookieStr.append(name).append('=').append(value).append(';');  
			}
			cookieStr.deleteCharAt(cookieStr.length() - 1);
		}
		if (null != headers) {
			for (String key : headers.keySet()) {
				httpost.setHeader(key, headers.get(key));
				httpost.setHeader("Cookie", cookieStr.toString());
			}
		}
		
		try {
			body = invoke(httpclient, httpost);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}
		return body;
	}

	/**
	 * 执行get请求,返回String类型的请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	public static String get(String url) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();
		String body = null;
		logger.info("create httpget:" + url);
		HttpGet get = new HttpGet(url);
		try {
			body = invoke(httpclient, get);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}

		return body;
	}
	
	/**
	 * 执行get请求,返回String类型的请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	public static String getOfParams(String url,Map<String,String> params) throws IOException, HttpClientException {
		 if (params != null&&params.size() > 0) {
	            StringBuffer sb = new StringBuffer();
	            if (url.indexOf("?") == -1) {
	                url += "?";
	            } else {
	                url += "&";
	            }
	            for (Entry<String, String> entry : params.entrySet()) {
	                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
	            }
	            url += sb.substring(0, sb.length() - 1);
	        }
		 return get(url);
	}

	
	
	/**
	 * 执行get请求,返回String类型的请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	public static String get(String url,Map<String,String> headers) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();
		String body = null;
		logger.info("create httpget:" + url);
		HttpGet get = new HttpGet(url);
		if (null != headers) {
			for (String key : headers.keySet()) {
				get.setHeader(key, headers.get(key));
			}
		}
		try {
			body = invoke(httpclient, get);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}

		return body;
	}
	
	/**
	 * 执行get请求,返回String类型的请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	public static String getAndCookie(String url,Map<String,String> headers,Map<String,String> cookieMap) throws IOException, HttpClientException {
		CloseableHttpClient httpclient = createClient();
		
		String body = null;
		logger.info("create httpget:" + url);
		HttpGet get = new HttpGet(url);
		
		StringBuilder cookieStr = new StringBuilder(); 
		if(null != cookieMap){
			for(Entry<String, String> entry : cookieMap.entrySet()){
				String name = entry.getKey();
				String value = entry.getValue();
				cookieStr.append(name).append('=').append(value).append(';');  
			}
			cookieStr.deleteCharAt(cookieStr.length() - 1);
		}
		if (null != headers) {
			for (String key : headers.keySet()) {
				get.setHeader(key, headers.get(key));
				get.setHeader("Cookie", cookieStr.toString());
			}
		}
		try {
			body = invoke(httpclient, get);
		} catch (HttpClientException e) {
			throw e;
		} catch (UnknownHostException e) {
			throw new HttpClientException(404);
		} catch (Exception e) {
			throw e;
		} finally {
			httpclient.close();
		}

		return body;
	}

	/**
	 * 调用请求
	 * 
	 * @param httpclient
	 * @param httpost
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	private static String invoke(CloseableHttpClient httpclient, HttpUriRequest httpost)
			throws IOException, HttpClientException {
		// 发送请求
		CloseableHttpResponse response = sendRequest(httpclient, httpost);
		/*String body = null;
		try {
			// 解析返回
			body = paseResponse(response);
			response.close();
		} catch (HttpClientException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
		return body;*/
		
		return paseResponse(response);
	}

	/**
	 * 解析返回结果
	 * 
	 * @param response
	 * @return
	 * @throws IOException
	 * @throws HttpClientException
	 */
	private static String paseResponse(HttpResponse response) throws IOException, HttpClientException {
		logger.info("get response from http server..");
		String body = null;
		HttpEntity entity = response.getEntity();
		logger.info("response status: " + response.getStatusLine());
		// 获取状态码
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			body = EntityUtils.toString(entity,"utf-8");
			logger.info(body);
			EntityUtils.consume(entity);
		} else {
			throw new HttpClientException(statusCode);
		}
		return body;
	}

	/**
	 * 发送请求
	 * 
	 * @param httpclient
	 * @param httpost
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	private static CloseableHttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost) throws ClientProtocolException, IOException {

		CloseableHttpResponse response = httpclient.execute(httpost);
		return response;
	}

	/**
	 * 构建HttpPost
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private static HttpPost postForm(String url, Map<String, String> headers, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		if (null != headers) {
			for (String key : headers.keySet()) {
				httpost.setHeader(key, headers.get(key));
			}

		}

		try {

			logger.info("set utf-8 form entity to httppost");
			httpost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpost;
	}
	
	/**
	 * 
	 * @Title: doPost 
	 * @Description: json post提交
	 * @param url
	 * @param headers
	 * @param json
	 * @return    设定文件 
	 * JSONObject    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月11日 上午10:35:09
	 */
	public static JSONObject doJsonPost(String url,Map<String, String> headers,JSONObject json){
        
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        if (null != headers) {
			for (String key : headers.keySet()) {
				post.setHeader(key, headers.get(key));
			}

		}
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString(),"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType\
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = JSONObject.fromObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

	/**
	 * 
	 * @Title: doPost 
	 * @Description:  post提交
	 * @param url
	 * @param headers
	 * @param json
	 * @return    设定文件 
	 * JSONObject    返回类型 
	 * @throws 
	 * @author tianyunyun
	 * @date 2017年5月11日 上午10:35:09
	 */
	public static Map<String,Object> doPost(String url,Map<String, String> headers,String jsonStr){
        
        CloseableHttpClient httpclient = createClient();
        HttpPost post = new HttpPost(url);
        if (null != headers) {
			for (String key : headers.keySet()) {
				post.setHeader(key, headers.get(key));
			}

		}
        String result = null;
        Map<String,Object> resMap = null;
        try {
            StringEntity s = new StringEntity(jsonStr,"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/x-www-form-urlencoded");
            post.setEntity(s);
            logger.info("========================执行请求==========================");
            HttpResponse res = httpclient.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = EntityUtils.toString(res.getEntity());// 返回json格式：
            }
            if(result != null && result.length() > 0){
            	resMap = JSON.parse(result, Map.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resMap;
    }
	public static void main(String[] args) {
		String url = "http://localhost:8080/sound-haolei-android/house/selecthlhousetosyn";
		String a = "";
		Map<String,String> map = new HashMap<String,String>();
		map.put("lastSyntime", "2017-08-10%2009%3A23%3A51");
		try {
			a = post(url, map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
	}
}
