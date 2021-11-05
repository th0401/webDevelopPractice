<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<script src="js/Common.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
  <!-- Required meta tags --> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Main</title>
  
  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/feather/feather.css">
  <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css"/>
  <link rel="stylesheet" href="vendors/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="vendors/jquery-bar-rating/fontawesome-stars-o.css">
  <link rel="stylesheet" href="vendors/jquery-bar-rating/fontawesome-stars.css">
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
  <style type="text/css">
  .displNone{
  	display:none;
  }
  .dietInsBtn{
  float:right; 
  font-size:20px; 
  width: 150px; 
  height: 51px;
  }
  
  </style>
  <script type="text/javascript">
          
          const jbd=[
        	  <c:forEach var="jbd" items="${jbd}">
        	  	${jbd},
        	  </c:forEach>
          ];
          //console.log(jbd);
          </script>
</head>
<body>
  <div class="container-scroller">
    
    <!-- partial:partials/_navbar.html -->
    <c:if test="${uVO==null}">
    	<mytag:noneClientTopMenu/>
    </c:if>
    
    <c:if test="${uVO!=null}">
    	<mytag:clientTopMenu/>
    </c:if>
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <c:if test="${uVO==null}">
        <mytag:nonClientMenu />
        </c:if>
            <c:if test="${uVO!=null}">
             <mytag:clientMenu />
            </c:if>
            
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-sm-12 mb-4 mb-xl-0">
              <h4 class="font-weight-bold text-dark">Hi, welcome!</h4>
              <p class="font-weight-normal mb-2 text-muted">APRIL 1, 2019</p>
            </div>
          </div>
          
          <c:if test="${uVO==null}">
          <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">체중조절의 이유!</h4>
                  <p class="card-description">
                    Add class <code>.table-bordered</code>
                  </p>
                  <div class="table-responsive pt-3">
                    <p style="font-size: 20px; line-height: 30px;">다이어트는 남녀노소를 불문하고 공통적으로 관심을 받고 있는 분야입니다. 꼭 살을 빼야 하는 이유에 대해 말씀드립니다. 왜냐하면 과체중과 비만이 어떻게 저희 몸에 피해를 끼치며 얼마만큼 좋지 않은 결과를 야기하는지 알면 더욱 분명한 동기부여와 목표의식을 갖고 감량을 하실 수 있기 때문입니다. 살을 빼야 하는 이유는 크게 두 가지가 있습니다.<br>
                    첫 번째, 건강입니다.

비만은 암 발생 위험을 증가시킵니다. 실제로 허리둘레는 여성의 유방암이나 남성의 전립선암 같은 호르몬 관련 암 발생과 직접적인 관련이 있습니다. ​세계보건기구(WHO) 산하 국제 암 연구기구(IARC)는 체질량지수(BMI)가 높을수록 암 발생 위험이 높아지며 과체중이나 비만이 암의 주요 원인이라고 발표한 바 있습니다.<br>
또한 세계적 권위의 의학학술지 〈뉴잉글랜드 저널 오브 메디신〉의 2006년 8월 24일 실린 두 편의 논문을 보면 한국인 120만 명·미국인 52만 명을 10년 이상 추적 조사하며, 사망자의 원인을 분석해본 결과 암과 심혈관질환 등으로 말미암은 사망 위험도가 과체중 단계에서는 1.12~1.56배, ​비만할 때는 2~3배 기준치보다 높은 것으로 나타났습니다. ​정말로 ‘확실한’ 암 예방법 한 가지는 바로 ‘비만 탈출’ 인 것이지요.

비만하면 수면무호흡증 발생 위험도 증가합니다. 허리를 둘러싼 지방과 두꺼워지는 목둘레는 밀접한 관련이 있으며, 목 부위에 지방이 쌓이면 목 안의 공간과 기도가 좁아져서 호흡을 방해할 수 있습니다. ​수면무호흡증이 있으면 만성피로와 학습장애를 유발할 수 있습니다. 또한 수면무호흡증이 있는 사람들에게서 심장 및 호흡기계 합병증과 뇌혈관계 합병증이 발생하는 빈도도 높습니다.

관절질환 발병 위험 역시 증가시킵니다. 체중이 5kg이 늘었다면 걷는 동안 무릎 및 발목 관절이 받는 부담은 15kg이 증가합니다. ​심지어 계단을 오르게 되면 5kg의 체중증가는 무릎에 35kg의 부담을 줍니다. 무릎과 발목 뿐 아니라 허리뼈의 퇴행성 변화 역시 촉진시킵니다.

비만인 사람이 체중을 7.5% 감량하면 좋은 콜레스테롤(HDL)과 나쁜 콜레스테롤(LDL), 혈압, 혈당 수치가 20%나 개선됩니다.

​고혈압 약을 드시다가 체중감량을 원하여 오시는 분들이 많습니다. 체중감량을 성공하시면 기존의 강한 혈압 약으로 인해 저혈압이 와서 어지럽다 하시며 혈압약을 약하게 줄이시지요.

또한 비만(특히 내장지방이 많은 복부 미만)은 인슐린 기능에 이상을 가져와 혈당을 높이는 주요 원인이 되기 때문에 체중 감량을 통해 혈당을 정상화시킬 수 있습니다.

비만은 정신건강에도 많은 영향을 미칩니다. 외모에 대한 관심이 커지고 감성적으로도 예민한 청소년기에는 콤플렉스가 될 수 있으며 자신감을 상실하고 학습능률이 저하되며, 교우관계에도 어려움을 겪을 수 있습니다.<br>
두 번째, 미용입니다.

‘최고의 성형은 다이어트’라는 말이 있지요. 정상적인 건강체중으로 오게 되면 외모가 많이 달라집니다.

​여기서 말하는 정상적인 건강체중이란 패션 화보에 등장하는 모델이나 조각 같은 근육을 가진 배우들의 체중을 뜻하는 것이 아닙니다. 신체적으로나 감정적으로나 ‘참 건강하고 아름답다’라고 느껴지는 체중을 말합니다. ​다이어트를 통해 이목구비와 신체를 감싸고 있던 불필요한 살들이 제해지면 본래 가지고 있었던 인상과 곡선이 드러나며 신체적 매력이 상승하게 됩니다. ​추가적으로 운동과 관리를 통해 한 단계 더 노력한다면 보다 이상적인 외모에 도달할 수 있겠지요.

​현대사회에서는 외모는 자신을 표현하는 하나의 수단인 동시에 경쟁력이 되기도 합니다. 비만에서 벗어나게 되면 건강 뿐 아니라 성취감과 자신감 또한 얻으실 수 있습니다. ​비만이라는 편견의 굴레에 발목 잡혀 실제보다 능력이 평가 절하된다고 생각하면 참 억울하겠지요.

어떤 이는 '난 뚱뚱하지만 자신감을 상실하거나 불이익을 당한 일 없이 행복하게 잘 살고 있다!' 라고 반발할지 모릅니다. 그러나 분명한 것은 비만한 현재의 본인과 비만이 개선된 본인, 두 경우를 비교해 본다면 모든 면에서 너무나 큰 차이가 있음을 알게 됩니다.

그렇다면 왜 우리는 남들보다 살이 잘 찔까요? 비만의 원인은 잘못된 식습관, 운동부족, 질병과 약물후유증, 심리적 문제 등 여러 가지 요인이 있을 수 있으나 최근의 많은 연구결과를 보면 비만에는 키와 마찬가지로 유전적 요인이 크게 작용한다는 것을 알 수 있습니다.

​비만의 원인 중 유전적 원인이 차지하는 비율은 50%이상으로 알려져 있습니다. CART, NPY, 랩틴, 그렐린, 세로토닌, GABA 등 수많은 화학물질과 호르몬, 수용체, 지방세포의 크기, 유전자 등이 영향을 줍니다.

유전적, 체질적으로 완벽한 몸을 가진 사람은 없습니다. ​누구나 건강상 취약한 부분이 있고 그 취약성을 인지하였다면 의도적인 행위, ​즉 생활습관과 환경의 관리를 통해 더욱 강력하게 조절해야 합니다. 모두들 건강한 다이어트로 활력과 자신감 모두 얻으시길 바랍니다.

                    </p>
                  </div>
                </div>
              </div>
            </div>
          </c:if>
          
          <c:if test="${uVO!=null}">
          <c:if test="${empty bodyDatas}">
          	<form class="pt-3" method="post" action="insertBody.do">
          	<input type="hidden" name="b_user" value="${uVO.id}">
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" name="height" id="exampleInputEmail1" placeholder="키를 입력하세요" required>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" name="weight" id="exampleInputEmail1" placeholder="몸무게를 입력하세요" required>
                </div>
                <div class="mt-3">
                <button type="submit" class="btn btn-info btn-lg btn-block" >
                      <i class="mdi mdi-account"></i>                      
                      등록하기
                    </button>
                
                </div>
                
              </form>
          </c:if>
          
          <c:if test="${!empty bodyDatas}">
          
          <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">현재 체중</h4>
                  <p class="card-description">
                    Add class <code>${lastBodyVO.bdate}</code>
                  </p>
                  <div class="table-responsive pt-3">
                    <p style="font-size: 20px; line-height: 30px;">${lastBodyVO.weight} kg

                    </p>
                  </div>
                  <button type="button" class="btn btn-info" id="inBodyBtn" onclick="insertBody()">새로 등록하기!</button>
                </div>
              </div>              
            </div> 
            
            <div style="display: none;" id="inBodyDiv">
            <form class="pt-3" method="post" action="insertBody.do">
          	<input type="hidden" name="b_user" value="${uVO.id}">
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" name="height" id="exampleInputEmail1" placeholder="키를 입력하세요" value="${lastBodyVO.height}" required>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" name="weight" id="exampleInputEmail1" placeholder="몸무게를 입력하세요" required>
                </div>
                <div class="mt-3">
                <button type="submit" class="btn btn-info btn-lg btn-block" >
                      <i class="mdi mdi-account"></i>                      
                      등록하기
                    </button>
                <button type="button" class="btn btn-info btn-lg btn-block" onclick="insertBodyCancle()">
                      <i class="mdi mdi-account"></i>                      
                      취소하기
                    </button>
                </div>
                
              </form>
            </div>
         
            <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Area chart</h4>
                  <canvas id="areaChart" style="height:30vh; width:50vw"></canvas>
                </div>
              </div>
            </div>
           
          
          </c:if>
    <c:if test="${empty dietDatas}">
    	<!-- 식단보여주기,등록,수정 가능 -->
          <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">식단보기,작성</h4>
                  <p class="card-description">
                    Add class <code>식단</code>
                  </p>
                  <div class="table-responsive pt-3">
         
                    <form action="insertDiet.do" method="post">
                    <input type="hidden" name="d_user" value="${uVO.id}">
                    <table class="table table-bordered" style="text-align: center;">
                      <thead>                     
                        <tr>
                          <th style="width: 120px">#</th>
                          <th>식 단</th>                          
                          <th style="width: 160px">칼로리</th>                                                   
                        </tr>
                      </thead>
                      <tbody>
                       <tr class="table-info">
                          <td>날 짜</td>
                          <td colspan="3">
                           <input type="date" name="ddate" required > 
                          </td>
                          
                        </tr>     
                        <tr class="table-success">
                          <td>아 침</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="breakfast" required>-</textarea>
                          </td>
                          <td>
                            <input type="number" name="breakfastCalorie" value="0"required>
                          </td>
                        
                        </tr>
                        <tr class="table-warning">
                          <td>점 심</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="lunch" required>-</textarea>
                          </td>
                          <td>
                            <input type="number" name="lunchCalorie" value="0"required>
                          </td>
                          
                        </tr>
                        <tr class="table-danger">
                          <td>저 녁</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="diner" required>-</textarea>
                          </td>
                          
                          <td>
                            <input type="number" name="dinerCalorie" value="0" required>
                          </td>
                      
                        </tr>
                        <tr class="table-primary">
                          <td>그 외<br>(간식 음료 등)</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="another" required>-</textarea>
                          </td>
                          
                          <td>
                            <input type="number" name="anotherCalorie" value="0" required>
                          </td>
                          
                          <td>
                         <input type="submit" class="dietInsBtn btn btn-info" value="등록하기">
                        </td>
                        </tr>                                          
                      </tbody>
                    </table>
                    <br>
                    
                   
                    </form>                   
                  </div>
                </div>
              </div>
            </div>
    </c:if>
    <c:if test="${!empty dietDatas}">
          <!-- 식단보여주기,등록,수정 가능 -->
          <div class="col-lg-12 stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">식단보기,작성</h4>
                  <p class="card-description">
                    Add class <code>식단</code>
                  </p>
                  <div class="table-responsive pt-3">
         
                    <form action="insertDiet.do" method="post">
                    <input type="hidden" name="d_user" value="${uVO.id}">
                    <table class="table table-bordered" style="text-align: center;">
                      <thead>                     
                        <tr>
                          <th style="width: 120px">#</th>
                          <th>식 단</th>                          
                          <th style="width: 160px">칼로리</th>                                                   
                        </tr>
                      </thead>
                      <tbody>
                       <tr class="table-info">
                          <td>날 짜</td>
                          <td colspan="3">
                           <input type="date" name="ddate" id="currentDate" value="${lastDietVO.ddate}" readonly required> 
                          </td>
                          
                        </tr>     
                        <tr class="table-success">
                          <td>아 침</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="breakfast" readonly required>${lastDietVO.breakfast}</textarea>
                          </td>
                          <td>
                            <input type="number" name="breakfastCalorie"  value="${lastDietVO.breakfastCalorie}" readonly required>
                          </td>
                        
                        </tr>
                        <tr class="table-warning">
                          <td>점 심</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="lunch" readonly required>${lastDietVO.lunch}</textarea>
                          </td>
                          <td>
                            <input type="number" name="lunchCalorie" value="${lastDietVO.lunchCalorie}" readonly  required>
                          </td>
                          
                        </tr>
                        <tr class="table-danger">
                          <td>저 녁</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="diner" readonly required>${lastDietVO.diner}</textarea>
                          </td>
                          
                          <td>
                            <input type="number" name="dinerCalorie" value="${lastDietVO.dinerCalorie}" readonly required>
                          </td>
                      
                        </tr>
                        <tr class="table-primary">
                          <td>그 외<br>(간식 음료 등)</td>
                          <td>
                            <textarea class="form-control" id="exampleTextarea1" rows="4" name="another" readonly required>${lastDietVO.another}</textarea>
                          </td>
                          
                          <td>
                            <input type="number" name="anotherCalorie" value="${lastDietVO.anotherCalorie}" readonly required>
                          </td>
                         
                        </tr>                                          
                      </tbody>
                    </table>
                    <br>
                   <!-- <button type="submit" class="dietInsBtn btn btn-info" onclick="location.href='insertDiet.do'">등록하기</button> -->
                    
                    </form>                   
                  </div>
                </div>
              </div>
            </div>
           </c:if><!-- !empty dietDatas if닫는 테그 --> 
           </c:if><!-- 로그인 if닫는테그 -->
          
          
 			
 			
 			<!-- json 데이터를 위한 코드 -->
          <c:forEach var="jbd" items="${jbd}"></c:forEach>         
    
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap dashboard templates</a> from Bootstrapdash.com</span>
          </div>
          <span class="text-muted d-block text-center text-sm-left d-sm-inline-block mt-2">Distributed By: <a href="https://www.themewagon.com/" target="_blank">ThemeWagon</a></span> 
        </footer>
        
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
	
  <!-- base:js -->
  <script src="vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <!-- endinject -->
  <!-- plugin js for this page -->
   <script src="vendors/chart.js/Chart.min.js"></script> 
  <script src="vendors/jquery-bar-rating/jquery.barrating.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/dashboard.js"></script>
  <script src="js/chart.js"></script>
  <!-- End custom js for this page-->
</body>

</html>

