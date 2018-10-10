package cn.ywj.eurekaconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-provider")// 指定要访问的服务提供者
public interface FeignTest {

    @RequestMapping(method = RequestMethod.GET, value = "/t")// 服务提供的请求地址
    public String t();

    @RequestMapping(method = RequestMethod.GET, value = "/t2")
    public User t2(User user);

    @RequestMapping(method = RequestMethod.GET, value = "/t3")
    public User t3(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping(method = RequestMethod.POST, value = "/t5")
    public User t5(User user);
}
