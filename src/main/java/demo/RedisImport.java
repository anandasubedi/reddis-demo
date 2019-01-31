package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

public class RedisImport {

	public static void main(String[] args) {

		String csvFile = "/home/ananda/eclipse-workspace/reddis-demo/src/main/java/demo/uscities.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		RedisClient redisClient = new RedisClient(RedisURI.create("redis://127.0.0.1:6379"));
		RedisConnection<String, String> connection = redisClient.connect();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				String[] city = line.split(cvsSplitBy);
				connection.set(city[0].replace("\"", ""), city[8].replace("\"", ""));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		connection.close();
		redisClient.shutdown();

	}

}
