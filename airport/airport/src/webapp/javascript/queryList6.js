var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Stores"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Stores");
 $.each(resp.result,function(i,item){
var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['name'] + '</td>' +
                '<td>' + item['airportName'] + '</td>'+
                '<td>' + item['productType'] + '</td>'+
                '<td>' + item['type'] + '</td>'+
                '<td>' + item['place'] + '</td></tr>'
                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

