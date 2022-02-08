var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Tickets"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Tickets");
 $.each(resp.result,function(i,item){

var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['orderNumber'] + '</td>' +
                '<td>' + item['passengerName'] + '</td>'+
                '<td>' + item['flightNumber'] + '</td>' +
                '<td>' + item['flightCompany'] + '</td>' +
                '<td>' + item['seatClass'] + '</td>' +
                '<td>' + item['price'] + '</td></tr>'
                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

