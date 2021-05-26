var frmElem = document.querySelector('#Frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkupwElem = frmElem.chkupw;
var umnElem = frmElem.unm;
var chkUidResultElem = frmElem.querySelector('#chkUidResult');

var btnChkIdElem = frmElem.querySelector('#btnChkId')
btnChkIdElem.addEventListener('click', function() {
	idChkAjax(uidElem.value);
});
function idChkAjax(uid) {
	console.log(uid);
	chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';

	fetch('/user/idChk?uid=' + uid)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);
			switch (myJson.result) {
				case 0:
					chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';
					break;

				case 1:
					chkUidResultElem.innerText = '이 아이디는 사용할 수 없습니다.';
					break;
			}
		})
}
function frmChk() {

	var uidval = uidElem.value; //2자 이하면 리턴
	if (uidval.length < 3) {

		if (uidval.length == 0) {
			alert('아이디를 적어주세요');
		} else {
			alert('아이디 글자수 확인');
		}

		return false;

	}
	var upwval = upwElem.value;
	var chkupwval = chkupwElem.value;
	if (upwval.length < 4) {
		if (upwval.length == 0) {
			alert('비밀번호를 입력');
		} else {
			alert('4자리 이상 비밀번호 입력');
		}
		return false;
	} else if (upwval !== chkupwval) {
		alert('비밀번호를 확인해 주세요');
		return false;
	} else { return ture; }

}