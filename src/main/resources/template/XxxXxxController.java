package cn.stylefeng.guns.modular.business.%1$s.controller;

import cn.stylefeng.guns.modular.business.%1$s.entity.%2$s;
import cn.stylefeng.guns.modular.business.%1$s.api.request.%2$sRequest;
import cn.stylefeng.guns.modular.business.%1$s.service.%2$sService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.annotation.BusinessLog;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@ApiResource(name = "")
public class %2$sController {

    @Resource
    private %2$sService %3$sService;

    @GetResource(
            name = "查询题目列表（带分页）",
            path = {"/%3$s/page"}
    )
    public ResponseData<PageResult<%2$s>> findPage(%2$sRequest %3$sRequest) {
        PageResult<%2$s> pageResult = this.%3$sService.findPage(%3$sRequest);
        return new SuccessResponseData(pageResult);
    }

    @PostResource(
            name = "新增面试题",
            path = {"/%3$s/add"}
    )
    @BusinessLog
    public ResponseData<?> add(@RequestBody @Validated({BaseRequest.add.class}) %2$sRequest %3$sRequest) {
        this.%3$sService.add(%3$sRequest);
        return new SuccessResponseData();
    }

    @PostResource(
            name = "删除数据源",
            path = {"/%3$s/delete"}
    )
    @BusinessLog
    public ResponseData<?> del(@RequestBody @Validated({BaseRequest.delete.class}) %2$sRequest %3$sRequest) {
        this.%3$sService.deleteBy%2$sId(%3$sRequest.getId());
        return new SuccessResponseData();
    }



}
