package cn.ywj.eurekaprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaProvider2Application {

	@GetMapping("/t")
	public String t(){
		return "msg from provider-2";// 后面加个2，方便对比
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
		System.out.println("---user:"+(user == null ? "null" : user.getName()));
		return user;
	}

	@GetMapping("/t6")
	public String t6(){
		return "t6 from eureka-provider-2";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaProvider2Application.class, args);
	}
}
