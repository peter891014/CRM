// 格式化分配状态
function formatState(value,row,index) {
	if (value == null) {
		return "未知";
	}else if (value == 0) {
		return "未分配";
	} else {
		return "已分配";
	}
}


function openSaleChanceAddDialog() {
	$("#dlg").dialog('open').dialog('setTitle', "添加营销机会");
}

function closeSaleChanceDialog(){
	resetValue();

	$("#dlg").dialog("close");
}

function saveSaleChance(){
	
/*	var customerName=  $("#customerId").combobox('getText');
	console.log(customerName);    
	var id = $("#id").val();
	console.log(id);
	var url = "update";
	if (id == null) {
		url = "add";
		if(customerName==null|| $.trim(customerName).length == 0){
			alert("请选择要编辑的客户");
			return ;
		}
		
	}*/
	var customerName = $("#customerId").combobox('getText');
	if (customerName == null || $.trim(customerName).length == 0) {
		alert("请选择客户");
		return;
	}
	$("#customerName").val(customerName);
	var id = $("#id").val();
	var url = "add";
	if (id != null) {
		url = "update";
	}
	
	
	
	//var cgjl=$("#cgjl").val();
	/*if(cgjl==null||cgjl<0){
	alert("请输入客户机会概率");
		return ;
	}*/
	$("#fm").form('submit', {
		url: url, // 相对路径访问
		onSubmit: function () {
			
			return $(this).form('validate');
		},
		success: function (data) {
			data = JSON.parse(data); // 转化为json对象 弱对象
			if (data.resultCode == 1) { // 成功
				// 先打印成功
				$.messager.alert('提示', data.result);
				// 置空
				resetValue();
				// 刷新 关闭窗体
				$('#dlg').dialog('close');
				$('#dg').datagrid('reload');
			} else { // 失败
				alert(data.resultMessage);
				//resetValue()
			}
		}
	})
}




//重置
function resetValue(){
	$("#customerId").combobox("setValue","");
    $("#customerName").val("");
    $("#chanceSource").val("");
    $("#linkMan").val("");
    $("#linkPhone").val("");
    $("#cgjl").numberbox('setValue',"");
    $("#overview").val("");
    $("#description").val("");
    $("#assignMan").combobox("setValue","");
}

function openSaleChanceModifyDialog() {
	var selections =$("#dg").datagrid('getSelections');
	if(selections.length!=1){
		$.messager.alert("提示","请选择一条记录记录");
		return;
	}
	
	var row=selections[0];
	console.log(JSON.stringify(row));
	$("#fm").form("load",row);
	
	var createMan = $.cookie('userName');
	$("#createMan").val(createMan);
	$("#dlg").dialog('open').dialog('setTitle', "修改销机会");
}

function openSaleChanceModifyDialog1() {
	// 必须选中一条记录
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert("提示", "请选择一行进行修改");
		return;
	}
	// 选中行的数据复制给form
	var row = selectedRows[0];
	console.log(JSON.stringify(row));
	var createMan = $.cookie('userName');
	$("#createMan").val(createMan);
	$("#fm").form('load', row);
	console.log(createMan);
	$("#dlg").dialog('open').dialog('setTitle', '修改营销机会');
}

