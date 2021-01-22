package in.flyspark.restfulstub.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

	@Autowired
	AppProperties app;

	public long getDelay() {
		Random random = new Random();
		int delay = random.nextInt(app.getMaxDelay() - app.getMinDelay()) + app.getMinDelay();
		logger.debug("delay : {}", delay);
		return delay;
	}

}
