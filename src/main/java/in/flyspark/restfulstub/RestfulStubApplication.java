package in.flyspark.restfulstub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulStubApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(RestfulStubApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
