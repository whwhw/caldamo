package com.stylefeng.guns.modular.gs.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.gs.model.Commodity;
import com.stylefeng.guns.modular.gs.service.ICommodityService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2023-12-23 14:33:31
 */
@Controller
@RequestMapping("/gs_commodity_mgr")
public class CommodityController extends BaseController {

    private String PREFIX = "/gs/commodity/";

    @Autowired
    private ICommodityService svc;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "commodity.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/commodity_add")
    public String commodityAdd() {
        return PREFIX + "commodity_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/commodity_update/{commodityId}")
    public String commodityUpdate(@PathVariable Integer commodityId, Model model) {
        Commodity commodity = svc.selectById(commodityId);
        model.addAttribute("item",commodity);
        LogObjectHolder.me().set(commodity);
        return PREFIX + "commodity_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return svc.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Commodity commodity) {
        // 先找一遍，没有就新增
//        if (svc.selectOne()==null){
//
//        }
        svc.insert(commodity);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer commodityId) {
        svc.deleteById(commodityId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Commodity commodity) {
        svc.updateById(commodity);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{commodityId}")
    @ResponseBody
    public Object detail(@PathVariable("commodityId") Integer commodityId) {
        return svc.selectById(commodityId);
    }
}
