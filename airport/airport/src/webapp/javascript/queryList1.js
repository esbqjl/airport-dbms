var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Airports"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);
resp=resp.result;

 $('#resultitle').after("Airports");
 $.each(resp,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>' +
                '<td>' + item['city'] + '</td>' +
                '<td>' + item['name'] + '</td></tr>' ;


$('#infotitle').after(html_resultinfo);//after方法:在每个匹配的元素之后插入内容。
    });
});

