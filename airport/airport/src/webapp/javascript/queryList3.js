var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Flights"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Flights");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>'+
                '<td>' + item['flightNumber'] + '</td>' +
                '<td>' + item['departureTime'] + '</td>' +
                '<td>' + item['arrivalTime'] + '</td>' +
                '<td>' + item['departureAirport'] + '</td>' +
                '<td>' + item['arrivalAirport'] + '</td></tr>'


                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

