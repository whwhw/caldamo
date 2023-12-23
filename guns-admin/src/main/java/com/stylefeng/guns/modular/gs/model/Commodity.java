package com.stylefeng.guns.modular.gs.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author stylefeng
 * @since 2023-12-23
 */
@TableName("gs_commodity")
public class Commodity extends Model<Commodity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 人物
     */
    private String name;
    /**
     * 备注
     */
    private String notes;
    /**
     * 限制条件
     */
    private String condition;
    /**
     * 金额
     */
    private Integer money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Commodity{" +
        "id=" + id +
        ", name=" + name +
        ", notes=" + notes +
        ", condition=" + condition +
        ", money=" + money +
        "}";
    }
}
