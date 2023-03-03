// 로그인에서 아이디/비밀번호 찾기 클릭 시 페이지 이동

$(document).ready(function(){

    $('#per').click(function(){
        $('#com_find_body').hide();
        $('#per_find_body_pw').hide();
        $('#per_find_body_id').show();
    })

    $('#com').click(function(){
        $('#per_find_body_id').hide();
        $('#per_find_body_pw').hide();
        $('#com_find_body').show();
    })

    
    $("input[name='ck']").change(function(){
        if($("input[name='ck']:checked").val() =='비밀번호찾기'){
            document.getElementById('per_find_body_pw').style.display = 'block';
            document.getElementById('per_find_body_id').style.display = 'none';
            $("input[name='ck1'][value='비밀번호찾기']").prop("checked",true);
        }
    })

    $("input[name='ck1']").change(function(){
        if($("input[name='ck1']:checked").val() =='아이디찾기'){
            document.getElementById('per_find_body_id').style.display = 'block';
            document.getElementById('per_find_body_pw').style.display = 'none';
            $("input[name='ck'][value='아이디찾기']").prop("checked",true);
        }
    })

})