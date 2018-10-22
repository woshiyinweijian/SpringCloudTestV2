package cn.ywj.eurekaconsumerfeign;

import org.springframework.stereotype.Component;

@Component
public class FeiginHystrixTest implements  FeignTest{
    @Override
    public String t() {
        return null;
    }

    @Override
    public User t2(User user) {
        return null;
    }

    @Override
    public User t3(String name, Integer age) {
        return null;
    }

    @Override
    public User t5(User user) {
        return null;
    }

    @Override
    public String t6() {// 回退方法
        return "msg from FeiginHystrixTest";
    }
}
