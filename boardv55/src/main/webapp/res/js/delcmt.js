function delCmt(iboard, icmt){
	console.log('iboard : %d,icmt : %d',iboard,icmt);
	if(confirm('삭제하시겠습니까')){
		location.href = `/board/regcmt?icmt=${icmt}&iboard=${iboard}`;
	}
}