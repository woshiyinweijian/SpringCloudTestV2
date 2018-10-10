package diy.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 此类不能被@ComponentScan扫到
 */
public class DiyRibbon extends AbstractLoadBalancerRule {


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        List<Server> upList = lb.getReachableServers();
        System.out.println("--->"+upList.size());
        if(upList != null && upList.size() > 0){
            return upList.get(0);// 拿第一个
        }
        return null;
    }
}
