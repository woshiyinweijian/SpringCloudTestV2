package cn.ywj.eurekaconsumerfeign;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
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

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerFeignApplication.class, args);
	}
}
