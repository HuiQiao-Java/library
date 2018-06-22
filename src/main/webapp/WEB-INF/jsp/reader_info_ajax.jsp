<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%-- <c:if test="${!empty succ}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${succ}
    </div>
</c:if>
<c:if test="${!empty error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${error}
    </div>
</c:if> --%>
<div class="col-xs-5 col-md-offset-3">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">我的信息</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<tbody>
					<tr class="tr reader_id">
						<th width="25%">读者证号</th>
						<td></td>
					</tr>
					<tr class="tr reader_name">
						<th>姓名</th>
						<td></td>
					</tr>
					<tr class="tr reader_sex">
						<th>性别</th>
						<td></td>
					</tr>
					<tr class="tr reader_birthday">
						<th>生日</th>
						<td></td>
					</tr>
					<tr class="tr reader_adress">
						<th>地址</th>
						<td></td>
					</tr>
					<tr class="tr reader_phone">
						<th>电话</th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<a class="btn btn-success btn-sm" style="margin:20px 200px" href="#" role="button">修改</a>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">信息修改</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<form action="reader_edit_do_r.html" method="post" id="edit">

					<div class="input-group">
						<span class="input-group-addon">读者证号</span> <input type="text"
							readonly="readonly" class="form-control" name="readerId"
							id="readerId">
					</div>
					<div class="input-group">
						<span class="input-group-addon">姓名</span> <input type="text"
							class="form-control" name="name" id="name"
							>
					</div>
					<div class="input-group">
						<span class="input-group-addon">性别</span> <input type="text"
							class="form-control" name="sex" id="sex"
							>
					</div>
					<div class="input-group">
						<span class="input-group-addon">生日</span> <input type="text"
							class="form-control" name="birth" id="birth"
							>
					</div>
					<div class="input-group">
						<span class="input-group-addon">地址</span> <input type="text"
							class="form-control" name="address" id="address"
							>
					</div>
					<div class="input-group">
						<span class="input-group-addon">电话</span> <input type="text"
							class="form-control" name="telcode" id="telcode"
							>
					</div>
                        <%-- 对信息的校验，注释掉 --%>
		<%-- 			<script>
						function mySubmit(flag) {
							return flag;
						}
						$(".btn-primary").submit(
								function() {
									if ($("#name").val() == ''
											|| $("#sex").val() == ''
											|| $("#birth").val() == ''
											|| $("#address").val() == ''
											|| $("#telcode").val() == '') {
										alert("请填入完整图书信息！");
										return mySubmit(false);
									}
								})
					</script> --%>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary">保存</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		// alert("开始获取数据")
        // 获取数据 
		doGetObjects();
		$(".panel-default").on('click', '.btn-sm', doUpdateUser);
        //为modal框的确认和取消绑定事件
        $(".modal-footer").on('click', '.btn-secondary', doCloseModal)
                            .on('click', '.btn-primary', doSaveReaderInfo);        
	})

    function doCloseModal () {
        //把modal框中绑定的数据取消掉
        console.log($('#myModal').data('data'));
        $('#myModal').removeData();
        console.log($('#myModal').data('data'));
    }

    //保存更改之后的modal数据
    function doSaveReaderInfo () {

        //数据校验，这里只是简单的数据校验，可以优化的
        if ($("#name").val() == ''
            || $("#sex").val() == ''
            || $("#birth").val() == ''
            || $("#address").val() == ''
            || $("#telcode").val() == '') {
                 alert("请填入完整图书信息！");
                 return;
            }
        //检验通过之后，获取modal框中的参数
        var params = doGetParams();
        // console.log(params);
        var url = "user/updateUserInfo.do"
        $.post(url,params,function (result) {
            // console.log(result);
            if (result.statue==1) {
                alert(result.message);
            }else{
                alert(result.message);
            }
        });

        $('#myModal').modal('hide');
        // $('#myModal').removeData();
        doGetObjects();
        
    }
    //获得模态框中修改后的参数,返回json格式的数据
    function doGetParams () {

        var params = {
            readerId:$("#readerId").val(),
            name : $("#name").val(),
            sex : $("#sex").val(),
            birth : $("#birth").val(),
            address:$("#address").val(),
            telcode:$("#telcode").val()
        }
		
        return params;
    }   

    //点击更改之后，打开modal框，把数据显示上去
	function doUpdateUser() {
        //打开modal框
		$('#myModal').modal('toggle');
        // console.log($('#myModal').data('data'));
        //回显数据
        $('#readerId').val($('#myModal').data('data').readerId);
        $('#name').val($('#myModal').data('data').name);
        $('#sex').val($('#myModal').data('data').sex);
        $('#birth').val($('#myModal').data('data').birth);
        $('#address').val($('#myModal').data('data').address);
        $('#telcode').val($('#myModal').data('data').telcode);
	}
	function doGetObjects() {
		//先把数据写死进行测试，之后在动态获取readerid
		var params = {
			readerid : 1501014102
		}

		var url = "user/readerinfo.do"
		// $.post(url,
		//       params,
		//         function(result) {
		// 		    alert("已经获取到数据")
		//             console.log(result);
		//             setResult(result);
		// });
		$.ajax({
			url : url,
			data : params,
			success : function(result) {
				// alert("已经成功获取数据");
				// console.log(result);
				// console.log(result.statue);
                //获得数据之后就会把数据绑定在modal框上
                $("#myModal").data('data', result.data);
				//对结果进行判断
				if (result.statue == 1) {
					//数据成功获取，对数据进行回显
					setResult(result.data);
				} else {
					//数据没有成功获取
					alert(result.message);
				}
			}
		})
	}

	function setResult(data) {
		$(".reader_id td").html(data.readerId);
		$(".reader_name td").html(data.name);
		$(".reader_sex td").html(data.sex);
		$(".reader_birthday td").html(data.birth);
		$(".reader_adress td").html(data.address);
		$(".reader_phone td").html(data.telcode);
	}
</script>