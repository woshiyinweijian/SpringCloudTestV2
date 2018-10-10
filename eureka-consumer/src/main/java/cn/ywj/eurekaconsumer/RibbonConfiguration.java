package cn.ywj.eurekaconsumer;

import com.netflix.loadbalancer.*;
import diy.ribbon.DiyRibbon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {

        //return new DiyRibbon();// 自定义

        return new RoundRobinRule();// 轮循算法


       /* 相关算法

        一、RoundRobinRule ：系统默认的规则，通过简单地轮询服务列表来选择服务器

        二、AvailabilityFilteringRule 该规则会忽略以下服务器

            1、无法连接的服务器 在默认情况下，如果 次连接失败，该服务器将会被置为“路”的状态，该状态将持续 30 秒；如果再次连接失败， “短路”状态的持续时间
            将会以几何级数增加。可以通过修改 niws.loadbalancer. <clientName>.connectionFailureCountThreshold
            属性，来配置连接失败的次数

            2、并发数过高的服务器：如果连接到该服务器的并发数过高，也会被这个规则忽略，可以通过修改＜ lientName> .ribbon.ActiveConnectionsLirnit 属性
            来设最高并发数

        三、WeightedResponseTimeRule ：为每个服务器赋予一个权重值 服务器的响应时间越长，该权重值就越少，这个规则会随机选择服务器，权重值有可能会决定服务器选择

        四、ZoneAvoidanceRule ：该规则以区域、可用服务器为基础进行服务器选择。使用 Zone对服务器进行分类，可以理解为机架或者机房

        五、BestAvailableRule ：忽略“短路”的服务器，并选择并发数较低的服务器。

        六、RandomRule ：顾名思义，随机选择可用的服务器。

        七、RerRule 含有重试的选择逻辑，如果使用 RoundRobinRule 选择的服务器无法连接，那么将会重新选择服务器。*/
    }

}
