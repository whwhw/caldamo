package com.stylefeng.guns.modular.gs.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.modular.gs.model.Commodity;
import com.stylefeng.guns.modular.gs.dao.CommodityMapper;
import com.stylefeng.guns.modular.gs.service.ICommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.modular.system.model.LoginLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2023-12-23
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Override
    public Boolean checkRepeat(Commodity code) {
        this.baseMapper.selectCount(new Wrapper<Commodity>() {
            @Override
            public String getSqlSegment() {
                return null;
            }
        });
        return  true;

    }
}
