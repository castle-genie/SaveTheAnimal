<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>Insert title here</title>
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<link rel="stylesheet" type="text/css" href="/resources/include/css/application/applicationForm.css" />
		
	</head>
	<body>
		<div class="container">
		    <form id="volunteerForm">
		      <h2>����Ȱ�� ��û</h2>
		      <!-- ���̵� �Է¶�(�鿣�忡�� ó��) -->
		      <!-- ������� ���̵�(�˾� �߰��� ��ư ���� �������� volunteerId) -->
		      <input type="hidden" id="volunteerId" name="volunteerId" value="���⿡_�������_���̵�_�Է�">
		      <!-- �α��� ������ ���� ȸ�� ���̵�(�鿣�忡�� ó��) -->
		      <input type="hidden" id="userId" name="userId" value="���⿡_ȸ��_���̵�_�Է�">
		      <div class="form-group">
		        <!-- ���� ���� �Է¶� -->
		        <label for="promise">���� ����</label>
		        <textarea id="promise" name="promise" rows="4" required></textarea>
		      </div>
		      <button type="submit" id="applicationBtn">��û�ϱ�</button>
		    </form>
		  </div>
	</body>
</html>