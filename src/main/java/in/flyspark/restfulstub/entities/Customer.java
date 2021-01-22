package in.flyspark.restfulstub.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Customer {

	@XmlElement
	private String customerId;

	@XmlElement
	private String firstName;

	@XmlElement
	private String lastName;

	@XmlElement
	private int age;

	@XmlElement
	private String contactNo;

	@XmlElement
	private Address address;

}
