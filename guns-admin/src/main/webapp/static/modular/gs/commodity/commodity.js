/**
 * 管理初始化
 */
var Commodity = {
    id: "CommodityTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Commodity.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '人物', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'notes', visible: true, align: 'center', valign: 'middle'},
            {title: '限制条件id', field: 'condition', visible: true, align: 'center', valign: 'middle'},
            {title: '金额', field: 'money', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Commodity.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Commodity.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Commodity.openAddCommodity = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gs_commodity_mgr/commodity_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Commodity.openCommodityDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/gs_commodity_mgr/commodity_update/' + Commodity.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Commodity.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/gs_commodity_mgr/delete", function (data) {
            Feng.success("删除成功!");
            Commodity.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("commodityId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Commodity.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Commodity.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Commodity.initColumn();
    var table = new BSTable(Commodity.id, "/gs_commodity_mgr/list", defaultColunms);
    table.setPaginationType("client");
    Commodity.table = table.init();
});
