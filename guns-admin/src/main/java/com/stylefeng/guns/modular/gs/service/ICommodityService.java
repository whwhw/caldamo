package com.stylefeng.guns.modular.gs.service;

import com.stylefeng.guns.modular.gs.model.Commodity;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2023-12-23
 */
@Service
public interface ICommodityService extends IService<Commodity> {
    Boolean checkRepeat(@Param("commodity") Commodity code);
}
