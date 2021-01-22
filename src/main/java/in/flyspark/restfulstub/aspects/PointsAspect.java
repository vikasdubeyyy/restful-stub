package in.flyspark.restfulstub.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.flyspark.restfulstub.utils.AppProperties;

@Aspect
@Component
public class PointsAspect {

	private static final Logger logger = LoggerFactory.getLogger(PointsAspect.class);

	@Autowired
	AppProperties app;

	@Around("@annotation(in.flyspark.restfulstub.annotations.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();

		final Object proceed = joinPoint.proceed();

		final long executionTime = System.currentTimeMillis() - start;

		logger.debug(joinPoint.getSignature().getName() + app.getDelimiter() + executionTime + " ms");

		return proceed;
	}

}