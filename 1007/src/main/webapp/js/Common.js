
// 내가 만든 js페이지

// 사용자 확인시 동작기능
function checkAlert(uri, text) {
	result = confirm(text);
	if (result == true) {
		location.href = uri;
	} else {
		return;
	}
}   
//=================================================== main.jsp===================================================

function insertBody(){ // 등록버튼 클릭시 등록폼이 보이게하는 기능

	$('#inBodyDiv').css('display','');
	$('#inBodyBtn').css('visibility','hidden');
}	 

function insertBodyCancle(){ // 취소버튼 클릭시 등록폼이 사라지게하는 기능

	$('#inBodyDiv').css('display','none');
	$('#inBodyBtn').css('visibility','');
}	 

function insertMainDiet(){ // 등록버튼 클릭시 등록폼이 보이게하는 기능

	$('#recentMainDietForm').addClass('displNone');
	$('#insertMainDietForm').removeClass('displNone');

}	 

function insertMainDietCancle(){ // 취소버튼 클릭시 등록폼이 사라지게하는 기능

	$('#recentMainDietForm').removeClass('displNone');
	$('#insertMainDietForm').addClass('displNone');

}	 

function updateMainDiet(){
	$('#updateDietMainForm').removeClass('displNone');
	$('#recentMainDietForm').addClass('displNone');
	
}

function updateMainDietCancle(){
	$('#updateDietMainForm').addClass('displNone');
	$('#recentMainDietForm').removeClass('displNone');
	
}

function dietEditFinish(){ 
	
	var dnum = $("#ufdn").val();
	var ddate = $("#ufdd").val();
	
	var breakfast = $("#ufb").val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	var lunch = $("#ufl").val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	var diner = $("#ufd").val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	var another = $("#ufa").val().replaceAll("??", "⁇").replaceAll("&","＆").replaceAll("%","％")
	.replaceAll("+","＋").replaceAll("\\", "￦");
	
	var bCalorie = $("#ufbc").val();
	var lCalorie = $("#uflc").val();
	var dCalorie = $("#ufdc").val();
	var aCalorie = $("#ufac").val();
	
	
	var params = "dnum="+dnum+"&ddate="+ddate+
	"&breakfast="+breakfast+"&lunch="+lunch+"&diner="+diner+"&another="+another+
	"&breakfastCalorie="+bCalorie+"&lunchCalorie="+lCalorie+"&dinerCalorie="+dCalorie+
	"&anotherCalorie="+aCalorie;
  //console.log(params);

	$.ajax({
		type:"post",
		url:"updateDietMain.do",
		data:params,
		dataType:"json",
		success:function(args){
			$('#updateDietMainForm').addClass('displNone');
			$('#recentMainDietForm').removeClass('displNone');			
			
			console.log(args[0].ddate);
			console.log(args[0].breakfastCalorie);
			console.log(args[0].lunchCalorie);
			console.log(args[0].dinerCalorie);
			console.log(args[0].anotherCalorie);
			console.log(args[0].dayCalorie);			
			
			$("#fdd").val(args[0].ddate);
			$("#fb").text(args[0].breakfast);
			$("#fbc").val(args[0].breakfastCalorie);
			$("#fl").text(args[0].lunch);
			$("#flc").val(args[0].lunchCalorie);
			$("#fd").text(args[0].diner);
			$("#fdc").val(args[0].dinerCalorie);
			$("#fa").text(args[0].another);
			$("#fac").val(args[0].anotherCalorie);
			$("#fAllC").val(args[0].dayCalorie);
		}
	})
}
// =================================================== BodyList.jsp=================================================== 

function bdEdit(index){ 
	//console.log("이태호 들어옴?? "+index);
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
		var params = "bnum="+bnum;
		console.log(index, bnum);
		$.ajax({
			type:"post",
			url:"deleteBody.do",
			data:params,
			dataType:"json",
			success:function(data){ 
				
				//var body = document.querySelector("#body"+index);
				//console.log("이태호"+body);
				
					//body.remove(); // 데이터 삭제
					$("#body"+index).remove();
				
			}
		});
	
	} else {
		return;
	}
}


//=================================================== myPage.jsp===================================================
function ChangeProfile(){
	window.open("ChangeProfile.jsp","프로필사진변경","width=800px,height=600px");
}

function updateBtn(id1,id2){ // 정보변경 버튼 클릭시 등록폼이 보이게하는 기능
	//console.log(id1+" : "+id2);
	$("#"+id1).addClass('displNone');
	$("#"+id2).removeClass('displNone');
	
}	 

function updateCancleBtn(id1,id2){ // 취소버튼 클릭시 등록폼이 사라지게하는 기능

	$("#"+id1).removeClass('displNone');
	$("#"+id2).addClass('displNone');
}	 


//=================================================== changeProfile.jsp===================================================


$(function() {		//사진미리보기 js
    $("#filename").on('change', function(){
        readURL(this);
    });
});
function readURL(input) {
    if (input.files && input.files[0]) {
       var reader = new FileReader();
       reader.filename = input.files[0].name;
       reader.onload = function (e) {
    	   console.log(e.target.filename);
    	   $('#uploadfilename').attr('value', e.target.filename); 
    	   $('#preImage').attr('src', e.target.result);
       }
       reader.readAsDataURL(input.files[0]);
    }
}
