package cn.ywj.gatewayzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 参考:http://www.spring4all.com/article/303
 * 参考：https://www.cnblogs.com/qdhxhz/p/9601170.html
 */
@Component
public class MyFilter extends ZuulFilter {

    private static String FILTER_TYPE = "pre";

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String url = request.getRequestURI();
        // 这里可以放开登录之类的请求，return false
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 想怎么搞都行
        String p = request.getParameter("p");
        if(!"ywj".equalsIgnoreCase(p)){

            // 权限不对之类的就设置下面信息就不会再访问下去了

            // 过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //返回错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            // 返回的描述信息
            requestContext.setResponseBody("{\"result\":\"fk\"}");
        }
        // 一切没问题，ok，放开访问
        return null;
    }
}
