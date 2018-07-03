package com.sound.haolei.facade;

import redis.clients.jedis.ShardedJedis;

public interface RedisDataSource {
	
	//	 取得redis的客户端，可以执行命令了。
	public abstract ShardedJedis getRedisClient();
	
	//	 将资源返还给pool
	public void returnResource(ShardedJedis shardedJedis);
	
}
