package cn.stylefeng.guns.modular.business.%1$s.service;

%1$s.api.%2$sApi;
%1$s.entity.%2$s;
import cn.stylefeng.guns.modular.business.%1$s.api.request.%2$sRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


public interface %2$sService extends IService<%2$s>, %2$sApi {

    PageResult<%2$s> findPage(%2$sRequest %3$sRequest);

}