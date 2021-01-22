package in.flyspark.restfulstub.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties
public class AppProperties {

	private int minDelay;

	private int maxDelay;

	private String delimiter;
}
