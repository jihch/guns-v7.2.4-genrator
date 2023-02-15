package cn.stylefeng.guns.modular.business.%1$s.api.request;

import cn.stylefeng.roses.kernel.rule.annotation.ChineseDescription;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.system.api.pojo.user.request.SysUserRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class %2$sRequest extends BaseRequest {

    @ChineseDescription("主键")
    private @NotNull(
            message = "id不能为空",
            groups = {BaseRequest.edit.class, BaseRequest.delete.class, BaseRequest.detail.class}
    ) Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
