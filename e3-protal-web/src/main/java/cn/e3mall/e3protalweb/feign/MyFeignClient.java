package cn.e3mall.e3protalweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import cn.e3mall.e3managerpojo.pojo.TbContent;

/**
 * 如何使用 feign
 * http://www.itmuch.com/spring-cloud-sum-feign/
 * <p>
 * FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 */
@FeignClient(value = "MANAGER-SERVICE")
public interface MyFeignClient {

    /**
     * 轮播图展示
     */
    @RequestMapping(value = "/content/showLunBo")
    List<TbContent> showLunBo(@RequestParam(name = "cid") long cid);
}
