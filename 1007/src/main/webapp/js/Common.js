
// 사용자 확인시 동작기능
function checkAlert(uri, text) {
	result = confirm(text);
	if (result == true) {
		location.href = uri;
	} else {
		return;
	}
}    

function insertBody(){ // 등록버튼 클릭시 등록폼이 보이게하는 기능

	$('#inBodyDiv').css('display','');
	$('#inBodyBtn').css('visibility','hidden');
}	 

function insertBodyCancle(){ // 취소버튼 클릭시 등록폼이 사라지게하는 기능

	$('#inBodyDiv').css('display','none');
	$('#inBodyBtn').css('visibility','');
}	 


function bdEdit(index){ 
	console.log("이태호 들어옴?? "+index);
	$('#bdEditBtn'+index).css('visibility','hidden');
	$('#bdDeleteBtn'+index).css('visibility','hidden');
	$('#bodyWeight'+index).attr('type','text');
	$('#bodyHeight'+index).attr('type','text');
	$('#bdinsertBtn'+index).css('visibility','');
	$('#bdCancleBtn'+index).css('visibility','');
	$('#pBodyWeight'+index).css('display','none');
	$('#pBodyHeight'+index).css('display','none');
	
}	 

function bdEditCancle(index){ 

	$('#bdEditBtn'+index).css('visibility','');
	$('#bdDeleteBtn'+index).css('visibility','');
	$('#bodyWeight'+index).attr('type','hidden');
	$('#bodyHeight'+index).attr('type','hidden');
	$('#bdinsertBtn'+index).css('visibility','hidden');
	$('#bdCancleBtn'+index).css('visibility','hidden');
	$('#pBodyWeight'+index).css('display','');
	$('#pBodyHeight'+index).css('display','');
}	 

function bdEditFinish(index){ 
	
	var weight = $("#bodyWeight"+index).val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	var height = $("#bodyHeight"+index).val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	
	var params = "weight="+$("#bodyWeight"+index).val()+"&b_user="+$("#b_user"+index).val()+
	"&height="+$("#bodyHeight"+index).val()+"&bnum="+$("#bnum"+index).val()+"&bdate="+$("#bdate"+index).val();
  //console.log(params);

	$.ajax({
		type:"post",
		url:"updateBody.do",
		data:params,
		dataType:"json",
		success:function(args){
			$('#bdEditBtn'+index).css('visibility','');
			$('#bdDeleteBtn'+index).css('visibility','');
			$('#bodyWeight'+index).attr('type','hidden');
			$('#bodyHeight'+index).attr('type','hidden');
			$('#bdinsertBtn'+index).css('visibility','hidden');
			$('#bdCancleBtn'+index).css('visibility','hidden');
			$('#pBodyWeight'+index).css('display','');
			$('#pBodyHeight'+index).css('display','');
			
			console.log("index: " + index);
			$("#pBodyWeight"+index).text(args[0].weight);
			$("#pBodyHeight"+index).text(args[0].height);
			
		}
	})
}

function bdDelete(index, bnum){ 
	result = confirm("해당 기록을 삭제하시겠어요?");
	if (result == true) {
		var params = "bnum="+bnum+"&index="+index;
		console.log(index, bnum);
		$.ajax({
			type:"post",
			url:"deleteBody.do",
			data:params,
			dataType:"json",
			success:function(data){ 
				
				var body = document.querySelector("#body"+index);
				console.log("이태호"+body);
				
					body.remove(); // 데이터 삭제
					
				
			}
		});
	
	} else {
		return;
	}
}
