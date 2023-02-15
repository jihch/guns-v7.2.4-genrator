package cn.stylefeng.guns.modular.business.%1$s.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.%1$s.entity.%2$s;
%1$s.mapper.%2$sMapper;
%1$s.api.request.%2$sRequest;
%1$s.service.%2$sService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class %2$sServiceImpl extends ServiceImpl<%2$sMapper, %2$s> implements %2$sService {

    @Override
    public PageResult<%2$s> findPage(%2$sRequest %3$sRequest) {
        LambdaQueryWrapper<%2$s> queryWrapper = this.createWrapper(%3$sRequest);
        Page<%2$s> result = (Page)this.page(PageFactory.defaultPage(), queryWrapper);
        return PageResultFactory.createPageResult(result);
    }

    private LambdaQueryWrapper<%2$s> createWrapper(%2$sRequest %3$sRequest) {
        LambdaQueryWrapper<%2$s> queryWrapper = new LambdaQueryWrapper();
        if (ObjectUtil.isEmpty(%3$sRequest)) {
            return queryWrapper;
        } else {
            return queryWrapper;
        }
    }

    @Override
    public void add(%2$sRequest %3$sRequest) {
        %2$s entity = new %2$s();
        BeanUtil.copyProperties(%3$sRequest, entity, new String[0]);
        this.save(entity);
    }

    @Override
    public void deleteBy%2$sId(Long %3$sId) {
        LambdaQueryWrapper<%2$s> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ObjectUtil.isNotEmpty(%3$sId), %2$s::getId, %3$sId);
        this.remove(queryWrapper);
    }

}
