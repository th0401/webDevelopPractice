<%@ tag language="java" pageEncoding="UTF-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
  
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="index.html">
              <i class="icon-box menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="insertDiet.jsp">
              <i class="icon-box menu-icon"></i>
              <span class="menu-title">식단작성</span>
            </a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
              <i class="icon-head menu-icon"></i>
              <span class="menu-title">User Pages</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="myPage.do"> MyPage </a></li>
                <li class="nav-item"> <a class="nav-link" href="bodyList.do"> 바디기록 </a></li>
                <li class="nav-item"> <a class="nav-link" href="dietList.do"> 식단기록 </a></li>
                <li class="nav-item"> <a class="nav-link" href="logout.do"> Logout </a></li>
                
              </ul>
            </div>
          </li>
          
        </ul>
      </nav>