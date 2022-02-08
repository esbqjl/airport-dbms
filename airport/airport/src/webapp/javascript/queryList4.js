var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("FlightCompanies"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Flight Company Name");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>' +
                '<td>' + item['flightCompanyName'] + '</td></tr>'
                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

