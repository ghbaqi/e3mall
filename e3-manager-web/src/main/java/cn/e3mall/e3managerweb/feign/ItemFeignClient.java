package cn.e3mall.e3managerweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.e3managerpojo.pojo.TbItem;

/**
 * 如何使用 feign
 * http://www.itmuch.com/spring-cloud-sum-feign/
 * <p>
 * FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 */
@FeignClient(value = "MANAGER-SERVICE")
public interface ItemFeignClient {

    @GetMapping("/item/getById/{id}")
    TbItem getById(@PathVariable("id") Long id);

    // 分页查询
    @GetMapping("/item/getByPage")
    EasyUIDataGridResult getByPage(@RequestParam("page") int page,@RequestParam("rows") int rows);

}
