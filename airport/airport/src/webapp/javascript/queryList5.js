var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Purchases"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Purchases");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['flightNumber'] + '</td>' +
                '<td>' + item['supplierId'] + '</td>'+
                '<td>' + item['ticketOrderNumber'] + '</td></tr>'
                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

