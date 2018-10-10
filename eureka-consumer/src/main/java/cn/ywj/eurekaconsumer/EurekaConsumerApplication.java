package cn.ywj.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "eureka-provider", configuration = RibbonConfiguration.class)// name是服务注册方
public class EurekaConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate () {// 注入一个RestTemplate
		return new RestTemplate() ;
	}

	@Autowired
	private RestTemplate restTemplate;


	//@Autowired
	//private EurekaClient eurekaClient;

	@RequestMapping("/t")
	public Object t(){

		//InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("EUREKA-PROVIDER", false);// 通过服务名可以拿到地址
		String str = restTemplate.getForObject("http://EUREKA-PROVIDER/t", String.class);// 直接用服务名请求
		return str;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
