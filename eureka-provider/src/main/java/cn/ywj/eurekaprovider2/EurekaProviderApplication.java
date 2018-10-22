package cn.ywj.eurekaprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {

	@GetMapping("/t")
	public String t(){
		return "msg from provider";
	}

	@GetMapping("/t2")
	public User t2(User user){
		return user;
	}

	@GetMapping("/t3")
	public User t3(@RequestParam("name") String name, @RequestParam("age") Integer age){
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@PostMapping("/t5")
	public User t5(@RequestBody User user){
		return user;
	}

	@GetMapping("/t6")
	public String t6() throws InterruptedException {
		Thread.sleep(3000L);
		return "t6 from eureka-provider";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}
}
