/**
 * 회원정보 수정을 위해 비밀번호를 다시 입력받아 확인하는 코드
 */

$(function(){
	$('#submitBtn').on('click', validation);
	
});

// 비밀번호가 입력되었는지 확인 + 서버로 전송하는 코드
function validation(){
	let userPwd = $('#userPwd').val();
	if(userPwd.trim().length < 3 || userPwd.trim().length > 5){
		alert("비밀번호는 3~5자 사이로 입력해 주세요");
		$('#userPwd').select();
	}	
	
	let pwdForm = $('#pwdForm');
	pwdForm.submit();
	
};