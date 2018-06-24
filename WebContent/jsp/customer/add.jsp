<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE><s:property value="#customer==null?'添加':'修改'"/>客户</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css"
	type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		selectAjax("cust_level.dict_id","006","lever"<s:if test="#customer!=null">,<s:property value="#customer.cust_level.dict_id"/></s:if>);
		selectAjax("cust_industry.dict_id","001","industry"<s:if test="#customer!=null">,<s:property value="#customer.cust_industry.dict_id"/></s:if>);
		selectAjax("cust_source.dict_id","009","source"<s:if test="#customer!=null">,<s:property value="#customer.cust_source.dict_id"/></s:if>);
	})
	
	// 能够根据指定的name来创建名为name的select
	// 能够根据指定的键来查询数据字典中的内容
	// 指定该select放到哪个id为*的html标签里面
	// 根据比较来确定是否回显

	function selectAjax(selectName, key, htmlId, huixianId) {
		// 创建一个select
		var $select = $("<select name='" + selectName + "'></select>");
		// 为select添加一个默认的请选择option
		$select.append("<option value=''>---请选择---</option>")

		// 根据key到数据库中查询数据字典中的相应内容并且循环遍历添加到select，还有回显
		$.post("${pageContext.request.contextPath }/BaseDict", {"dict_type_code" : key},
			function(data) {
				$.each( data, function(i, n){
					$option = $("<option value='"+n["dict_id"]+"'>"+n["dict_item_name"]+"</option>");
					$select.append($option)
					if(huixianId==n["dict_id"]){
					 	$option.attr("selected","selected");
					}
				});
			}, "json");
		// 添加select到html的某个id中去
		$("#" + htmlId).append($select);
	}
</script>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/CustomerAction_add" method="post" enctype="multipart/form-data">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0>
						</TD>
						
				</TR>
			</TBODY>
		
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }
						/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; <s:property value="#customer==null?'添加':'修改'"/>客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<input type="hidden" name="cust_id" value="<s:property value="#customer.cust_id"/>"/>
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
								<td>客户名称：</td>
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="cust_name" value="<s:property value = "#customer.cust_name"/>"></td>
								<td>客户级别 ：</td>
								<td  id = "lever"> </td>
							</TR>

							<TR>
								<td>信息来源 ：</td>
								<td id="source"> </td>
								<td>客户行业：</td>
								<td id="industry"> </td>
							</TR>

							<TR>
								<td>固定电话 ：</td>
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="cust_phone"  value="<s:property value = "#customer.cust_phone"/>"></td>
								<td>移动电话 ：</td>
								<td><INPUT class=textbox id=sChannel2 style="WIDTH: 180px"
									maxLength=50 name="cust_mobile"  value="<s:property value = "#customer.cust_mobile"/>"></td>
							</TR>

							<TR>
								<td>图片上传 ：</td>
								<td>
									<input type="file"  name="file" />
								</td>
								 
							</TR>


							<tr>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value=" 保存 " name=sButton2></td>
							</tr>
						</TABLE>


					</TD>
					<TD width=15
						background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
