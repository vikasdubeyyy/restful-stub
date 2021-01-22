package in.flyspark.restfulstub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.flyspark.restfulstub.annotations.LogExecutionTime;
import in.flyspark.restfulstub.entities.Ack;
import in.flyspark.restfulstub.entities.Customer;
import in.flyspark.restfulstub.utils.AppProperties;
import in.flyspark.restfulstub.utils.AppUtils;

@RestController
@RequestMapping(path = "/customers")
public class CustomerApi {
	private static final Logger logger = LoggerFactory.getLogger(CustomerApi.class);

	@Autowired
	AppProperties app;

	@Autowired
	AppUtils utils;

	@PostMapping(value = "/xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	@LogExecutionTime
	public ResponseEntity<?> getCustomerByXML(@RequestBody Customer cust) {
		Ack ack = new Ack();
		try {

			ack = new Ack(cust.getCustomerId(), 200, "Success");
			logger.debug(cust.getCustomerId() + app.getDelimiter() + cust.getFirstName() + app.getDelimiter() + cust.getLastName() + app.getDelimiter() + cust.getAge() + app.getDelimiter() + cust.getContactNo() + app.getDelimiter() + cust.getAddress());

			Thread.sleep(utils.getDelay() * 1000);

			return new ResponseEntity<>(ack, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception occurred while execution of getCustomer XML", ex);
			ack = new Ack(cust != null ? cust.getCustomerId() : "NA", 500, "Failed");
			return new ResponseEntity<>(ack, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@LogExecutionTime
	public ResponseEntity<?> getCustomerByJSON(@RequestBody Customer cust) {
		Ack ack = null;
		try {

			logger.debug(cust.getCustomerId() + app.getDelimiter() + cust.getFirstName() + app.getDelimiter() + cust.getLastName() + app.getDelimiter() + cust.getAge() + app.getDelimiter() + cust.getContactNo() + app.getDelimiter() + cust.getAddress());
			ack = new Ack(cust.getCustomerId(), 200, "Success");

			Thread.sleep(utils.getDelay() * 1000);

			return new ResponseEntity<>(ack, HttpStatus.OK);
		} catch (Exception ex) {

			logger.error("Exception occurred while execution of getCustomer JSON", ex);
			ack = new Ack(cust != null ? cust.getCustomerId() : "NA", 500, "Failed");
			return new ResponseEntity<>(ack, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
