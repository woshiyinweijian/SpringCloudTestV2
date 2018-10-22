package cn.ywj.eurekaconsumerfeign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableCircuitBreaker
public class EurekaConsumerFeignApplication {

	@Autowired
	private FeignTest feignTest;

	@RequestMapping("/t")
	public String t(){
		return feignTest.t();
	}

	@RequestMapping("/t2")
	public String t2(User user){
		User user1 = feignTest.t2(user);
		return user1 == null ? "null" : user1.getName()+":"+user1.getAge();
	}

	@RequestMapping("/t3")
	public String t3(User user){
		User user1 = feignTest.t3(user.getName(), user.getAge());
		return user1 == null ? "null" : user1.getName()+":"+user1.getAge();
	}

	@RequestMapping("/t5")
	public String t5(User user){
		User user1 = feignTest.t5(user);
		return user1 == null ? "null" : user1.getName()+":"+user1.getAge();
	}

	@RequestMapping("/t6")
	//@HystrixCommand(fallbackMethod = "fallbackMethod")//服务熔断后会调用fallbackMethod方法
	public String t6(){
		return feignTest.t6();
	}

	public String fallbackMethod(){
		return "t6 from fallbackMethod";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerFeignApplication.class, args);
	}
}
