<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="add-div">
	<div>添加用户</div>
	<div>
		<label for="add-name">姓名：</label>
		<div style="display:inline-block;"><input type="text" id="add-name" class="add-param" /></div>
		<span class="tooltip">?</span>
	</div>
	
	<div>
		<label for="add-age">年龄：</label>
		<div style="display:inline-block;"><input type="text" id="add-age" class="add-param"/></div>
		<span class="tooltip">?</span>
	</div>
	<div>
		<div id="add-btn" class="qaudc add">保存</div>
		<div id="add-clear-btn" class="qaudc clear">清空</div>
		<div id="add-cancel-btn" class="qaudc cancel">取消</div>
	</div>
</div>

<div id="auc" class="mask opacity"></div>
