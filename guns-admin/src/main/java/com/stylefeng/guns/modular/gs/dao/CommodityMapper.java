package com.stylefeng.guns.modular.gs.dao;

import com.stylefeng.guns.modular.gs.model.Commodity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2023-12-23
 */
public interface CommodityMapper extends BaseMapper<Commodity> {
    Commodity checkRepeat(@Param("commodity") Commodity code);
}
