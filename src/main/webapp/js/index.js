/** JavaScript 函数*/
$(function(){
	/**	next 下一页，绑定点击事件。*/
	$("#next").click(function(){
		// 将 pages 值(文本类型)，通过parseInt强转为数值类型。
		// 总页数。（最后一页）
		var pages = parseInt($("#pages").html());
		// 将 currentPage 值(文本类型)，通过parseInt强转为数值类型。
		// 当前页号。
		var page = parseInt($("#currentPage").html());
		// 设置页数上限。当到最后一页时，无法继续，直接逗留本页面。
		if(page == pages){
			return;
		}
		// page初始化是=1的。
		page++;
		location.href = "/reader/findAllBook/"+page;
	})

	/**	previous 上一页，绑定点击事件。*/
	$("#previous").click(function () {
		var page = parseInt($("#currentPage").html());
		// 当回到第一页时，无法继续，直接逗留本页面。
		if(page == 1){
			return;
		}
		page--;
		location.href = "/reader/findAllBook/"+page;
	})

	/** first 首页，绑定点击事件。*/
	$("#first").click(function () {
		// 回到第一页。
		location.href = "/reader/findAllBook/1";
	})

	/** last 最后一页，绑定点击事件。*/
	$("#last").click(function(){
		// 总页数。（最后一页）
		var pages = parseInt($("#pages").html());
		// 回到最后一页。（用参数pages总页数也就是最后一页。）
		location.href = "/reader/findAllBook/"+pages;
	})
})

