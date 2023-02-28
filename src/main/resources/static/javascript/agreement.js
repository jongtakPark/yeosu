// 약관동의서에 input 체크를 하지 않을경우 alert 창 띄우기

$('#com').click(function(){
	checkTerms();
});

function checkTerms(){
	if($('#chbox1').is(':checked') == false ||
		$('#chbox2').is(':checked') == false){
			alert("약관 동의에 체크해주세요")
		} else {
			location.href="/signup/company";
		}};
		
$('#per').click(function(){
	checkTerms1();
});

function checkTerms1(){
	if($('#chbox1').is(':checked') == false ||
		$('#chbox2').is(':checked') == false){
			alert("약관 동의에 체크해주세요")
		} else {
			location.href="/signup/personal";
		}};
		
