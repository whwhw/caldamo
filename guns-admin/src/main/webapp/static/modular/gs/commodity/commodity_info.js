/**
 * 初始化详情对话框
 */
var CommodityInfoDlg = {
    commodityInfoData : {},
    itemTemplate: $("#itemTemplate").html()
};

/**
 * 清除数据
 */
CommodityInfoDlg.clearData = function() {
    this.commodityInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommodityInfoDlg.set = function(key, val) {
    this.commodityInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommodityInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CommodityInfoDlg.close = function() {
    parent.layer.close(window.parent.Commodity.layerIndex);
}

/**
 * 收集数据
 */
CommodityInfoDlg.collectData = function() {
    this.clearData()
    var mutiString = "";
    $("[name='dictItem']").each(function(){
        var code = $(this).find("[name='itemCode']").val();
        var name = $(this).find("[name='itemName']").val();
        mutiString = mutiString + (code + ":" + name +";");
    });
    this
    .set('id')
    .set('name')
    .set('notes')
    .set('condition',mutiString)
    .set('money');
}

/**
 * 提交添加
 */
CommodityInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/gs_commodity_mgr/add", function(data){
        Feng.success("添加成功!");
        window.parent.Commodity.table.refresh();
        CommodityInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commodityInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CommodityInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/commodity/update", function(data){
        Feng.success("修改成功!");
        window.parent.Commodity.table.refresh();
        CommodityInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commodityInfoData);
    ajax.start();
}

/**
 * item获取新的id
 */
CommodityInfoDlg.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "dictItem" + this.count;
};
/**
 * 删除item
 */
CommodityInfoDlg.deleteItem = function (event) {
    var obj = Feng.eventParseObject(event);
    obj = obj.is('button') ? obj : obj.parent();
    obj.parent().parent().remove();
};
/**
 * 添加条目
 */
CommodityInfoDlg.addItem = function () {
    $("#itemsArea").append(this.itemTemplate);
    $("#dictItem").attr("id", this.newId());
};
$(function() {

});
