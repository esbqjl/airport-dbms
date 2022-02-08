var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("BookingAgents"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Booking Agents");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>' +
                '<td>' + item['bookingCompanyName'] + '</td>' +
                '<td>' + item['agentName'] + '</td></tr>' ;


$('#infotitle').after(html_resultinfo);//after方法:在每个匹配的元素之后插入内容。
    });
});

