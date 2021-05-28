var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');
var cmtModModalElem = document.querySelector('#modal');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;

	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};
	regajax(param);
}
function regajax(param) {

	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};

	fetch('cmtInsSel', init)
		.then(function(res) { return res.json(); })
		.then(function(myJson) {
			console.log(myJson);

			switch (myJson.result) {
				case 0:
					alert('등록 실패');
					break;
				case 1:
					cmtFrmElem.cmt.value = '';
					getListAjax();

					break;
			}
		});
}
//서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;

	fetch('cmtInsSel?iboard=' + iboard)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson)

			makeCmtElemList(myJson);
		});

}
function makeCmtElemList(date) {

	cmtListElem.innerHTML = '';

	var tableElem = document.createElement('table');  /*<table></table>*/
	var trElemTitle = document.createElement('tr'); /*<tr></tr>*/
	var thElemCtnt = document.createElement('th'); /*<th></th>*/
	var thElemWriter = document.createElement('th'); /*<th></th>*/
	var thElemRegdt = document.createElement('th'); /*<th></th>*/
	var thElemBigo = document.createElement('th'); /*<th></th>*/

	thElemCtnt.innerText = '내용'; /*<th>내용</th>*/
	thElemWriter.innerText = '작성자'; /*<th>작성자</th>*/
	thElemRegdt.innerText = '작성일'; /*<th>작성일</th>*/
	thElemBigo.innerText = '비고'; /*<th>비고</th>*/

	/*append 순서를 바꾸면 보여지는 순서도 바뀜
	append 한 Elem 뒤에 붙음*/
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdt);
	trElemTitle.append(thElemBigo);

	/*<tr>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>비고</th>
	</tr>*/

	tableElem.append(trElemTitle);

	/*
	<table>
		<tr>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>비고</th>
		</tr>
	</table>	
	*/

	cmtListElem.append(tableElem);
	/*
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
		</table>	
	<div> 
	*/
	var loginUserPk = cmtListElem.dataset.login_user_pk;

	date.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');

		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdt);
		if (parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');

			delBtn.addEventListener('click', function() {
				if (confirm('삭제하시겠습니까')) {
					delAjax(item.icmt);
					//icmt값은 다 달라서 jsp에서 불러오는값(고정값)으로 못불러옴
					//item 으러 foreach이미 보내놨으므로 접근만 하면댐
				}

			});

			modBtn.addEventListener('click', function() {
				//댓글 수정 모달창 띄우기.
				openModModal(item);
			})


			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';

			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}



		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);

		tableElem.append(trElemCtnt);

	});/*배열에 들어있는 아이템 수만큼*/

}
function delAjax(icmt) {
	fetch('cmtDelUpd?icmt=' + icmt)
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {
			console.log(data);

			switch (data.result) {
				case 0:
					alert('댓글 삭제를 실패 하였습니다.');
					break;
				case 1:
					getListAjax();//서버에게 댓글 리스트 요청 메소드
					//makeCmtElemList 까지 호출됨
					break;

			}
		});
}

function modAjax() {
	var cmtModFrmElem = document.querySelector('#cmtModFrm');

	var param = {
		icmt: cmtModFrmElem.icmt.value,
		cmt: cmtModFrmElem.cmt.value
	}
	
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};
//param 객체를 init객체 바디에 담아서 보낸다.
	fetch('cmtDelUpd', init)
		.then(function(res) { return res.json(); })
		.then(function(myJson) {
			console.log(myJson);

			switch (myJson.result) {
				case 0:
					alert('등록 실패');
					break;
				case 1:
					getListAjax();
					closeModModal();
					break;
			}
		});
}

function openModModal({ icmt, cmt }) {
	//꿀팁: 주소값을 보내면 받는쪽에서 객체 속성값을 입력하면 그것만 온다
	console.log('icmt :' + icmt);
	console.log(' cmt :' + cmt);

	var cmtModFrmElem = document.querySelector('#cmtModFrm');

	cmtModModalElem.className = '';
	cmtModFrmElem.icmt.value = icmt;
	cmtModFrmElem.cmt.value = cmt;
}
function closeModModal() {
	cmtModModalElem.className = 'displayNone';
}


getListAjax(); //이파일이 임포트 되면 함수 1회 호출!

