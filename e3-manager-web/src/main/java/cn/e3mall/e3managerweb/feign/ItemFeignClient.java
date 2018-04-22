package cn.e3mall.e3managerweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
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
    @GetMapping("/item/list")
    EasyUIDataGridResult getByPage(@RequestParam("page") int page,@RequestParam("rows") int rows);

    // 分类查询 查询某个分类下面的所有子分类
    @GetMapping("/item/cat/list")
    List<EasyUITreeNode> getItemCatList(@RequestParam(value = "parentId",defaultValue = "0") long parentId);

}
