package demo;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

public class RedisDemo {

	public static void main(String[] args) {
		RedisClient redisClient = new RedisClient(RedisURI.create("redis://127.0.0.1:6379"));
		RedisConnection<String, String> connection = redisClient.connect();
		connection.set("foo", "bar");

		System.out.println("Connected to Redis: " + connection.ping());
		System.out.println("Washtucna : " + connection.get("Washtucna")); // 195
		System.out.println("Kahlotus : " + connection.get("Kahlotus")); // 189
		connection.close();
		redisClient.shutdown();
	}
}
