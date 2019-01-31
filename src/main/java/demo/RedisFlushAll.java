package demo;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

public class RedisFlushAll {

	public static void main(String[] args) {
		RedisClient redisClient = new RedisClient(RedisURI.create("redis://127.0.0.1:6379"));
		RedisConnection<String, String> connection = redisClient.connect();
		connection.flushall();
		connection.close();
		redisClient.shutdown();

	}

}
