<%@ tag language="java" pageEncoding="UTF-8"%>
<form method="post" action="ctrl.jsp" name="form1">
				<input type="hidden" name="action" value="login">
					<!-- Table -->
					
					<div class="table-wrapper">
						<table>

							<tbody>
								<tr>
									<td>아이디</td>
									<td><input type="text" name="id" required
										placeholder="아이디를 입력하세요"></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" name="pw" required
										placeholder="비밀번호를 입력하세요"></td>
								</tr>

							</tbody>
							<tfoot>
								<tr>									
									<td colspan="2" align="right"><input type="submit" value="로그인하기"></td>
								</tr>
							</tfoot>
						</table>
						
					</div>
				</form>