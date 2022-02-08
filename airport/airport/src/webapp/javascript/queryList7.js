var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Suppliers"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Suppliers");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>' +
                '<td>' + item['type'] + '</td></tr>'
                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

