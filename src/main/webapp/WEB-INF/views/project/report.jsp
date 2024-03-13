<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal"
	data-bs-target="#reportModal">신고</button>

<!-- Modal -->
<div class="modal fade" id="reportModal" tabindex="-1" aria-labelledby="reportModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered ">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="reportModalLabel">신고하기</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				
				<form>
					<fieldset style="border:1 solid white;">
						<legend class="modal-title fs-6">신고 분류</legend>
						<ul style="list-style:none;">
							<li><input type="radio" name="reportSort" value="1"/> 욕설</li>
							<li><input type="radio" name="reportSort" value="2"/> 도배</li>
							<li><input type="radio" name="reportSort" value="3"/> 광고</li>
							<li><input type="radio" name="reportSort" value="4"/> 기타</li>
						</ul>
					</fieldset>
					<fieldset>
						<legend class="modal-title fs-6">신고 내용</legend>
						<textarea style="width: 100%; height: 10em; resize: none;" class="form-control" placeholder="신고 내용을 기입해 주세요" id="reportDetail" name="reportDetail"></textarea>
					</fieldset>
				</form>
				
				
				
				
				
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">신고하기</button>
			</div>
		</div>
	</div>
</div>



