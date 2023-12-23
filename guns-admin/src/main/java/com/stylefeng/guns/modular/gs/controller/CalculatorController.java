package com.stylefeng.guns.modular.gs.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.gs.model.Commodity;
import com.stylefeng.guns.modular.gs.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2023-12-23 14:33:31
 */
@Controller
@RequestMapping("/gs_calculator")
public class CalculatorController extends BaseController {

    private String PREFIX = "/gs/calculator/";


    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "calculator.html";
    }

    /**
     * 计算
     */
    @RequestMapping("/cal")
    public String commodityAdd() {
        return PREFIX + "calculator.html";
    }



}
