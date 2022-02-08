var resp;

$(document).ready(function(){
$.ajax({
        url:getUrl("Workers"),
        type:"GET",
        async:false,
        success:function(ret){
            resp=ret;

        }


    });
console.log(resp);

 $('#resultitle').after("Workers");
 $.each(resp.result,function(i,item){

var html_resultinfo;
        html_resultinfo +=
                '<tr><td>' + item['id'] + '</td>' +
                '<td>' + item['airportName'] + '</td>'+
                '<td>' + item['name'] + '</td>' +
                '<td>' + item['age'] + '</td>' +
                '<td>' + item['storeName'] + '</td>' +
                '<td>' + item['job'] + '</td>' +
                '<td>' + item['salary'] + '</td></tr>'

                ;


$('#infotitle').after(html_resultinfo);//after method: insert each elements after above match.
    });
});

