layui.use(['table', 'admin', 'HttpRequest', 'func'], function () {
  var $ = layui.$;
  var table = layui.table;
  var HttpRequest = layui.HttpRequest;
  var admin = layui.admin;
  var func = layui.func;

  /**
   * 数据库信息表管理
   */
  var %1$s = {
    tableId: "%2$sTable"
  };

  /**
   * 初始化表格的列
   */
  %1$s.initColumn = function () {
    return [[
      {type: 'checkbox'},
      {field: 'id', hide: true, title: '主键id'},
      {align: 'center', toolbar: '#tableBar', title: '操作'}
    ]];
  };

  /**
   * 点击查询按钮
   */
  %1$s.search = function () {
    var queryData = {};
    table.reload(%1$s.tableId, {
      where: queryData, page: {curr: 1}
    });
  };

  /**
   * 弹出添加对话框
   */
  %1$s.openAddDlg = function () {
    func.open({
      title: '添加',
      content: Feng.ctxPath + '/view/%2$s/add',
      tableId: %1$s.tableId
    });
  };

  /**
   * 点击删除
   *
   * @param data 点击按钮时候的行数据
   */
  %1$s.onDeleteItem = function (data) {
    var operation = function () {
      var request = new HttpRequest(Feng.ctxPath + "/%2$s/delete", 'post', function (data) {
        Feng.success("删除成功!");
        table.reload(%1$s.tableId);
      }, function (data) {
        Feng.error("删除失败!" + data.message + "!");
      });
      request.set("id", data.id);
      request.start(true);
    };
    Feng.confirm("是否删除?", operation);
  };

  // 渲染表格
  var tableResult = table.render({
    elem: '#' + %1$s.tableId,
    url: Feng.ctxPath + '/%2$s/page',
    page: true,
    height: "full-158",
    cellMinWidth: 100,
    parseData: Feng.parseData,
    cols: %1$s.initColumn()
  });

  // 搜索按钮点击事件
  $('#btnSearch').click(function () {
    %1$s.search();
  });

  // 添加按钮点击事件
  $('#btnAdd').click(function () {
    %1$s.openAddDlg();
  });

  // 工具条点击事件
  table.on('tool(' + %1$s.tableId + ')', function (obj) {
    var data = obj.data;
    var layEvent = obj.event;

    if (layEvent === 'delete') {
      %1$s.onDeleteItem(data);
    }
  });
});
