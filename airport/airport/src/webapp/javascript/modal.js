
var modal = document.getElementById("myModal");

var span = document.getElementsByClassName("close")[0];
function showModal(){
    var obj = document.elementFromPoint(event.clientX,event.clientY);
    modal.style.display="block";
}
span.onclick = function(){
    modal.style.display="none"
}
window.onclick = function(event){
    if(event.target == modal){
        modal.style.display ="none"
    }
}
$('#subModal').on('show.bs.modal', function (event) {

  var button = $(event.relatedTarget); // Button that triggered the modal
  var control = button.data('here'); // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var data = button.data('there');
  var modal = $(this);
  if (data=="query"){
  var labelList=modal.find(".modal-body label");
      var inputList=modal.find(".modal-body input");
      for(let i=0;i<labelList.length;i++){

          labelList[i].style.display="none";
          inputList[i].style.display="none";
      }
      document.getElementById("modalForm").reset();
    modal.find(".modal-body label")[0].style.display="block";
    modal.find(".modal-body input")[0].style.display="block";
    if(control=="Store"){
        modal.find(".modal-body label")[0].innerText="storeName";
      modal.find(".modal-body label")[1].innerText="airportName";
      modal.find(".modal-body label")[1].style.display="block";
      modal.find(".modal-body input")[1].style.display="block"; }
  modal.find('.modal-title').text('Database: ' + control);
  var input1=modal.find('.modal-body input')[0];
  var input2 =modal.find('.modal-body input')[1];
  var submit = document.getElementById("submit");
  submit.onclick=function(){
  var resp;
    $.ajax({
            url:getUrl(control+"/"+input1.value+"/"+input2.value),
            type:"GET",
            async:false,
            success:function(ret){
                resp=ret;

            }
        });
        console.log(resp);
        status=resp.status;
        resp=resp.result;
        var str="";
        $.each(resp,function(i,value){
            str+=i+" : "+value+"\n";
            console.log(i+":"+value);

        });
        if(status=="OK"&&resp!=null){
            alert(str);
        }else{
            alert("wrong text provided or connection problem");
        }

        $('#subModal').modal('hide');


  }
  }
  else if (data=="add"){
    var labelList=modal.find(".modal-body label");
    var inputList=modal.find(".modal-body input");
    for(let i=0;i<labelList.length;i++){

        labelList[i].style.display="none";
        inputList[i].style.display="none";
    }
    document.getElementById("modalForm").reset();
    var name=button.data('name');
    if(name=="add1"){
      var label1 =modal.find(".modal-body label")[0];
      label1.innerText="Id";
      label1.style.display="block";
      var input1= modal.find(".modal-body input")[0];
      input1.style.display="block";

      var label2 =modal.find(".modal-body label")[1];
      label2.innerText="City";
      label2.style.display="block";
      var input2= modal.find(".modal-body input")[1];
      input2.style.display="block";

      var label3 =modal.find(".modal-body label")[2];
      label3.innerText="Name";
      label3.style.display="block";
      var input3= modal.find(".modal-body input")[2];
      input3.style.display="block";

      var submit = document.getElementById("submit");
      submit.onclick=function(){
      var id = label1.innerText
      var city=label2.innerText;
      var name=label3.innerText;

      var data={
        id : input1.value,
        city : input2.value,
        name : input3.value


      };

            console.log(JSON.stringify(data));
      var resp;
      $.ajax({
          url:getUrl(control),
          type:"POST",
          data:JSON.stringify(data),
          contentType:"application/json",
          async:false,
          success:function(ret){
              resp=ret;

          }

      });
      console.log(resp);
      if(resp["status"]=="OK"){
                  alert("Finish");
                  document.getElementById("modalForm").reset();
              }else{
                  alert("wrong text provided or connection problem");
                  document.getElementById("modalForm").reset();
              }

              $('#subModal').modal('hide');
    }
    }
    else if(name=="add2"){
                var label1 =modal.find(".modal-body label")[0];
                label1.innerText="id";
                label1.style.display="block";
                var input1= modal.find(".modal-body input")[0];
                input1.style.display="block";

                var label2 =modal.find(".modal-body label")[1];
                label2.innerText="bookingCompanyName";
                label2.style.display="block";
                var input2= modal.find(".modal-body input")[1];
                input2.style.display="block";

                var label3 =modal.find(".modal-body label")[2];
                label3.innerText="agentName";
                label3.style.display="block";
                var input3= modal.find(".modal-body input")[2];
                input3.style.display="block";

                var submit = document.getElementById("submit");
                submit.onclick=function(){
                var id = label1.innerText
                var bookingCompanyName=label2.innerText;
                var agentName=label3.innerText;

                var data={
                  id : input1.value,
                  bookingCompanyName : input2.value,
                  agentName : input3.value


                };

                      console.log(JSON.stringify(data));
                var resp;
                $.ajax({
                    url:getUrl(control),
                    type:"POST",
                    data:JSON.stringify(data),
                    contentType:"application/json",
                    async:false,
                    success:function(ret){
                        resp=ret;

                    }

                });
                console.log(resp);
                      if(resp["status"]=="OK"){
                                  alert("Finish");
                                  document.getElementById("modalForm").reset();
                              }else{
                                  alert("wrong text provided or connection problem");
                                  document.getElementById("modalForm").reset();
                              }

                              $('#subModal').modal('hide');
              }
              }
    else if(name=="add3"){
                                    var label1 =modal.find(".modal-body label")[0];
                                    label1.innerText="flightNumber";
                                    label1.style.display="block";
                                    var input1= modal.find(".modal-body input")[0];
                                    input1.style.display="block";

                                    var label2 =modal.find(".modal-body label")[1];
                                    label2.innerText="departureTime";
                                    label2.style.display="block";
                                    var input2= modal.find(".modal-body input")[1];
                                    input2.value= "Example:2013-04-01 13:51:50";
                                    input2.style.display="block";

                                    var label3 =modal.find(".modal-body label")[2];
                                    label3.innerText="arrivalTime";
                                    label3.style.display="block";
                                    var input3= modal.find(".modal-body input")[2];
                                    input3.value="Example:2013-04-01 13:51:52";
                                    input3.style.display="block";


                                    var label4 =modal.find(".modal-body label")[3];
                                    label4.innerText="departureAirport";
                                    label4.style.display="block";
                                    var input4= modal.find(".modal-body input")[3];
                                    input4.style.display="block";

                                    var label5 =modal.find(".modal-body label")[4];
                                    label5.innerText="arrivalAirport";
                                    label5.style.display="block";
                                    var input5= modal.find(".modal-body input")[4];
                                    input5.style.display="block";


                                    var submit = document.getElementById("submit");
                                    submit.onclick=function(){
                                    var flightNumber = label1.innerText
                                    var departureTime=label2.innerText;
                                    var arrivalTime=label3.innerText;
                                    var departureAirport=label4.innerText;
                                    var arrivalAirport=label5.innerText;

                                    var data={
                                      flightNumber : input1.value,
                                      departureTime : input2.value,
                                      arrivalTime : input3.value,
                                      departureAirport : input4.value,
                                      arrivalAirport : input5.value

                                    };

                                          console.log(JSON.stringify(data));
                                    var resp;
                                    $.ajax({
                                        url:getUrl(control),
                                        type:"POST",
                                        data:JSON.stringify(data),
                                        contentType:"application/json",
                                        async:false,
                                        success:function(ret){
                                            resp=ret;

                                        }

                                    });
                                    console.log(resp);
                                          if(resp["status"]=="OK"){
                                                      alert("Finish");
                                                      document.getElementById("modalForm").reset();
                                                  }else{
                                                      alert("wrong text provided or connection problem");
                                                      document.getElementById("modalForm").reset();
                                                  }

                                                  $('#subModal').modal('hide');
                                  }
              }
    else if(name=="add4"){
                                    var label1 =modal.find(".modal-body label")[0];
                                    label1.innerText="id";
                                    label1.style.display="block";
                                    var input1= modal.find(".modal-body input")[0];
                                    input1.style.display="block";

                                    var label2 =modal.find(".modal-body label")[1];
                                    label2.innerText="flightCompanyName";
                                    label2.style.display="block";
                                    var input2= modal.find(".modal-body input")[1];
                                    input2.style.display="block";

                                    var submit = document.getElementById("submit");
                                    submit.onclick=function(){
                                    var id = label1.innerText
                                    var flightCompanyName=label2.innerText;


                                    var data={
                                      id : input1.value,
                                      flightCompanyName : input2.value,



                                    };

                                          console.log(JSON.stringify(data));
                                    var resp;
                                    $.ajax({
                                        url:getUrl(control),
                                        type:"POST",
                                        data:JSON.stringify(data),
                                        contentType:"application/json",
                                        async:false,
                                        success:function(ret){
                                            resp=ret;

                                        }

                                    });
                                    console.log(resp);
                                          if(resp["status"]=="OK"){
                                                      alert("Finish");
                                                      document.getElementById("modalForm").reset();
                                                  }else{
                                                      alert("wrong text provided or connection problem, you might need to insert a id to supplier first");
                                                      document.getElementById("modalForm").reset();
                                                  }

                                                  $('#subModal').modal('hide');
                                  }
                    }
    else if(name=="add5"){
                          var label1 =modal.find(".modal-body label")[0];
                          label1.innerText="flightNumber";
                          label1.style.display="block";
                          var input1= modal.find(".modal-body input")[0];
                          input1.style.display="block";

                          var label2 =modal.find(".modal-body label")[1];
                          label2.innerText="supplierId";
                          label2.style.display="block";
                          var input2= modal.find(".modal-body input")[1];
                          input2.style.display="block";

                          var label3 =modal.find(".modal-body label")[2];
                          label3.innerText="ticket_order_number";
                          label3.style.display="block";
                          var input3= modal.find(".modal-body input")[2];
                          input3.style.display="block";

                          var submit = document.getElementById("submit");
                          submit.onclick=function(){
                          var flightNumber = label1.innerText
                          var supplierId=label2.innerText;
                          var ticketOrderNumber=label3.innerText;

                          var data={
                            flightNumber : input1.value,
                            supplierId : input2.value,
                            ticketOrderNumber : input3.value


                          };

                                console.log(JSON.stringify(data));
                          var resp;
                          $.ajax({
                              url:getUrl(control),
                              type:"POST",
                              data:JSON.stringify(data),
                              contentType:"application/json",
                              async:false,
                              success:function(ret){
                                  resp=ret;

                              }

                          });
                          console.log(resp);
                                if(resp["status"]=="OK"){
                                            alert("Finish");
                                            document.getElementById("modalForm").reset();
                                        }else{
                                            alert("wrong text provided or connection problem");
                                            document.getElementById("modalForm").reset();
                                        }

                                        $('#subModal').modal('hide');
                        }
}
    else if(name=="add6"){
          var label1 =modal.find(".modal-body label")[0];
          label1.innerText="name";
          label1.style.display="block";
          var input1= modal.find(".modal-body input")[0];
          input1.style.display="block";

          var label2 =modal.find(".modal-body label")[1];
          label2.innerText="airportName";
          label2.style.display="block";
          var input2= modal.find(".modal-body input")[1];
          input2.style.display="block";

          var label3 =modal.find(".modal-body label")[2];
          label3.innerText="productType";
          label3.style.display="block";
          var input3= modal.find(".modal-body input")[2];
          input3.style.display="block";


          var label4 =modal.find(".modal-body label")[3];
           label4.innerText="type";
           label4.style.display="block";
           var input4= modal.find(".modal-body input")[3];
           input4.style.display="block";



          var label5 =modal.find(".modal-body label")[4];
           label5.innerText="place";
           label5.style.display="block";
           var input5= modal.find(".modal-body input")[4];
           input5.style.display="block";






          var submit = document.getElementById("submit");
          submit.onclick=function(){
          var name = label1.innerText
          var airportName=label2.innerText;
          var productType=label3.innerText;
          var type=label4.innerText;
          var place=label5.innerText;
          var data={
            name : input1.value,
            airportName : input2.value,
            productType : input3.value,
            type : input4.value,
            place : input5.value


          };

                console.log(JSON.stringify(data));
          var resp;
          $.ajax({
              url:getUrl(control),
              type:"POST",
              data:JSON.stringify(data),
              contentType:"application/json",
              async:false,
              success:function(ret){
                  resp=ret;

              }

          });
          console.log(resp);
                if(resp["status"]=="OK"){
                            alert("Finish");
                            document.getElementById("modalForm").reset();
                        }else{
                            alert("wrong text provided or connection problem");
                            document.getElementById("modalForm").reset();
                        }

                        $('#subModal').modal('hide');
        }
        }
    else if(name=="add7"){
           var label1 =modal.find(".modal-body label")[0];
           label1.innerText="id";
           label1.style.display="block";
           var input1= modal.find(".modal-body input")[0];
           input1.style.display="block";

           var label2 =modal.find(".modal-body label")[1];
           label2.innerText="type";
           label2.style.display="block";
           var input2= modal.find(".modal-body input")[1];
           input2.style.display="block";

           var submit = document.getElementById("submit");
           submit.onclick=function(){
           var id = label1.innerText
           var type=label2.innerText;

           var data={
             id : input1.value,
             type : input2.value,



           };

                 console.log(JSON.stringify(data));
           var resp;
           $.ajax({
               url:getUrl(control),
               type:"POST",
               data:JSON.stringify(data),
               contentType:"application/json",
               async:false,
               success:function(ret){
                   resp=ret;

               }

           });
           console.log(resp);
                 if(resp["status"]=="OK"){
                             alert("Finish");
                             document.getElementById("modalForm").reset();
                         }else{
                             alert("wrong text provided or connection problem");
                             document.getElementById("modalForm").reset();
                         }

                         $('#subModal').modal('hide');
         }
         }
    else if(name=="add8"){


            var label1 =modal.find(".modal-body label")[0];
            label1.innerText="passengerName";
            label1.style.display="block";
            var input1= modal.find(".modal-body input")[0];
            input1.style.display="block";

            var label2 =modal.find(".modal-body label")[1];
            label2.innerText="flightNumber";
            label2.style.display="block";
            var input2= modal.find(".modal-body input")[1];
            input2.style.display="block";


            var label3 =modal.find(".modal-body label")[2];
             label3.innerText="flightCompany";
             label3.style.display="block";
             var input3= modal.find(".modal-body input")[2];
             input3.style.display="block";



            var label4 =modal.find(".modal-body label")[3];
             label4.innerText="seatClass";
             label4.style.display="block";
             var input4= modal.find(".modal-body input")[3];
             input4.style.display="block";



             var label5 =modal.find(".modal-body label")[4];
              label5.innerText="price";
              label5.style.display="block";
              var input5= modal.find(".modal-body input")[4];
              input5.style.display="block";






            var submit = document.getElementById("submit");
            submit.onclick=function(){

            var passengerName=label1.innerText;
            var flightNumber=label2.innerText;
            var flightCompany=label3.innerText;
            var seatClass=label4.innerText;
            var price=label5.innerText;
            var data={

              passengerName : input1.value,
              flightNumber : input2.value,
              flightCompany : input3.value,
              seatClass : input4.value,
              price : input5.value


            };

                  console.log(JSON.stringify(data));
            var resp;
            $.ajax({
                url:getUrl(control),
                type:"POST",
                data:JSON.stringify(data),
                contentType:"application/json",
                async:false,
                success:function(ret){
                    resp=ret;

                }

            });
            console.log(resp);
                  if(resp["status"]=="OK"){
                              alert("Finish");
                              document.getElementById("modalForm").reset();
                          }else{
                              alert("wrong text provided or connection problem");
                              document.getElementById("modalForm").reset();
                          }

                          $('#subModal').modal('hide');
          }
          }
    else if(name=="add9"){
           var label1 =modal.find(".modal-body label")[0];
           label1.innerText="airportName";
           label1.style.display="block";
           var input1= modal.find(".modal-body input")[0];
           input1.style.display="block";

           var label2 =modal.find(".modal-body label")[1];
           label2.innerText="name";
           label2.style.display="block";
           var input2= modal.find(".modal-body input")[1];
           input2.style.display="block";


           var label3 =modal.find(".modal-body label")[2];
            label3.innerText="age";
            label3.style.display="block";
            var input3= modal.find(".modal-body input")[2];
            input3.style.display="block";



           var label4 =modal.find(".modal-body label")[3];
            label4.innerText="storeName";
            label4.style.display="block";
            var input4= modal.find(".modal-body input")[3];
            input4.style.display="block";



            var label5 =modal.find(".modal-body label")[4];
             label5.innerText="job";
             label5.style.display="block";
             var input5= modal.find(".modal-body input")[4];
             input5.style.display="block";


             var label6 =modal.find(".modal-body label")[5];
              label6.innerText="salary";
              label6.style.display="block";
              var input6= modal.find(".modal-body input")[5];
              input6.style.display="block";





           var submit = document.getElementById("submit");
           submit.onclick=function(){

           var airportName=label1.innerText;
           var name=label2.innerText;
           var age=label3.innerText;
           var storeName=label4.innerText;
           var job=label5.innerText;
           var salary=label6.innerText;
           var data={

             airportName : input1.value,
             name : input2.value,
             age : input3.value,
             storeName : input4.value,
             job : input5.value,
             salary : input6.value


           };

                 console.log(JSON.stringify(data));
           var resp;
           $.ajax({
               url:getUrl(control),
               type:"POST",
               data:JSON.stringify(data),
               contentType:"application/json",
               async:false,
               success:function(ret){
                   resp=ret;

               }

           });
           console.log(resp);
                 if(resp["status"]=="OK"){
                             alert("Finish");
                             document.getElementById("modalForm").reset();
                         }else{
                             alert("wrong text provided or connection problem");
                             document.getElementById("modalForm").reset();
                         }

                         $('#subModal').modal('hide');
         }
         }
  }
  else if (data=="delete") {
    var labelList=modal.find(".modal-body label");
        var inputList=modal.find(".modal-body input");
        for(let i=0;i<labelList.length;i++){

            labelList[i].style.display="none";
            inputList[i].style.display="none";
        }
        document.getElementById("modalForm").reset();
        var name=button.data('name');
        if(name=="delete1"){
          var label1 =modal.find(".modal-body label")[0];
          label1.innerText="Id";
          label1.style.display="block";
          var input1= modal.find(".modal-body input")[0];
          input1.style.display="block";

          var submit = document.getElementById("submit");
          submit.onclick=function(){

          console.log(JSON.stringify(data));
          var resp;
          $.ajax({
              url:getUrl(control)+"/"+ input1.value,
              type:"DELETE",
              async:false,
              success:function(ret){
                  resp=ret;

              }

          });
          console.log(resp);
          if(resp["status"]=="OK"){
                      alert("Finish");
                      document.getElementById("modalForm").reset();
                  }else{
                      alert("wrong text provided or connection problem");
                      document.getElementById("modalForm").reset();
                  }

                  $('#subModal').modal('hide');
        }
        }
        else if(name=="delete2"){
                        var label1 =modal.find(".modal-body label")[0];
                        label1.innerText="Id";
                        label1.style.display="block";
                        var input1= modal.find(".modal-body input")[0];
                        input1.style.display="block";

                        var submit = document.getElementById("submit");
                        submit.onclick=function(){

                        console.log(JSON.stringify(data));
                        var resp;
                        $.ajax({
                            url:getUrl(control)+"/"+ input1.value,
                            type:"DELETE",
                            async:false,
                            success:function(ret){
                                resp=ret;

                            }

                        });
                        console.log(resp);
                        if(resp["status"]=="OK"){
                                    alert("Finish");
                                    document.getElementById("modalForm").reset();
                                }else{
                                    alert("wrong text provided or connection problem");
                                    document.getElementById("modalForm").reset();
                                }

                                $('#subModal').modal('hide');
                      }
                      }
        else if(name=="delete3"){
               var label1 =modal.find(".modal-body label")[0];
               label1.innerText="Id";
               label1.style.display="block";
               var input1= modal.find(".modal-body input")[0];
               input1.style.display="block";

               var submit = document.getElementById("submit");
               submit.onclick=function(){

               console.log(JSON.stringify(data));
               var resp;
               $.ajax({
                   url:getUrl(control)+"/"+ input1.value,
                   type:"DELETE",
                   async:false,
                   success:function(ret){
                       resp=ret;

                   }

               });
               console.log(resp);
               if(resp["status"]=="OK"){
                           alert("Finish");
                           document.getElementById("modalForm").reset();
                       }else{
                           alert("wrong text provided or connection problem");
                           document.getElementById("modalForm").reset();
                       }

                       $('#subModal').modal('hide');
             }
             }
             else if(name=="delete4"){
                            var label1 =modal.find(".modal-body label")[0];
                            label1.innerText="Id";
                            label1.style.display="block";
                            var input1= modal.find(".modal-body input")[0];
                            input1.style.display="block";

                            var submit = document.getElementById("submit");
                            submit.onclick=function(){

                            console.log(JSON.stringify(data));
                            var resp;
                            $.ajax({
                                url:getUrl(control)+"/"+ input1.value,
                                type:"DELETE",
                                async:false,
                                success:function(ret){
                                    resp=ret;

                                }

                            });
                            console.log(resp);
                            if(resp["status"]=="OK"){
                                        alert("Finish");
                                        document.getElementById("modalForm").reset();
                                    }else{
                                        alert("wrong text provided or connection problem");
                                        document.getElementById("modalForm").reset();
                                    }

                                    $('#subModal').modal('hide');
                          }
                          }
             else if(name=="delete5"){
                 var label1 =modal.find(".modal-body label")[0];
                 label1.innerText="ticketOrderNumber";
                 label1.style.display="block";
                 var input1= modal.find(".modal-body input")[0];
                 input1.style.display="block";

                 var submit = document.getElementById("submit");
                 submit.onclick=function(){

                 console.log(JSON.stringify(data));
                 var resp;
                 $.ajax({
                     url:getUrl(control)+"/"+ input1.value,
                     type:"DELETE",
                     async:false,
                     success:function(ret){
                         resp=ret;

                     }

                 });
                 console.log(resp);
                 if(resp["status"]=="OK"){
                             alert("Finish");
                             document.getElementById("modalForm").reset();
                         }else{
                             alert("wrong text provided or connection problem");
                             document.getElementById("modalForm").reset();
                         }

                         $('#subModal').modal('hide');
               }
                                       }
             else if(name=="delete6"){
                              var label1 =modal.find(".modal-body label")[0];
                              label1.innerText="storeName";
                              label1.style.display="block";
                              var input1= modal.find(".modal-body input")[0];
                              input1.style.display="block";


                              var label2 =modal.find(".modal-body label")[1];
                                label2.innerText="airportName";
                                label2.style.display="block";
                                var input2= modal.find(".modal-body input")[1];
                                input2.style.display="block";

                              var submit = document.getElementById("submit");
                              submit.onclick=function(){

                              console.log(JSON.stringify(data));
                              var resp;
                              $.ajax({
                                  url:getUrl(control)+"/"+ input1.value+"/"+input2.value,
                                  type:"DELETE",
                                  async:false,
                                  success:function(ret){
                                      resp=ret;

                                  }

                              });
                              console.log(resp);
                              if(resp["status"]=="OK"){
                                          alert("Finish");
                                          document.getElementById("modalForm").reset();
                                      }else{
                                          alert("wrong text provided or connection problem");
                                          document.getElementById("modalForm").reset();
                                      }

                                      $('#subModal').modal('hide');
                            }
                                                    }
             else if(name=="delete7"){
              var label1 =modal.find(".modal-body label")[0];
              label1.innerText="ID";
              label1.style.display="block";
              var input1= modal.find(".modal-body input")[0];
              input1.style.display="block";
              var submit = document.getElementById("submit");
              submit.onclick=function(){

              console.log(JSON.stringify(data));
              var resp;
              $.ajax({
                  url:getUrl(control)+"/"+ input1.value,
                  type:"DELETE",
                  async:false,
                  success:function(ret){
                      resp=ret;

                  }

              });
              console.log(resp);
              if(resp["status"]=="OK"){
                          alert("Finish");
                          document.getElementById("modalForm").reset();
                      }else{
                          alert("wrong text provided or connection problem");
                          document.getElementById("modalForm").reset();
                      }

                      $('#subModal').modal('hide');
            }
                                    }
             else if(name=="delete8"){
                          var label1 =modal.find(".modal-body label")[0];
                          label1.innerText="Order Number";
                          label1.style.display="block";
                          var input1= modal.find(".modal-body input")[0];
                          input1.style.display="block";
                          var submit = document.getElementById("submit");
                          submit.onclick=function(){

                          console.log(JSON.stringify(data));
                          var resp;
                          $.ajax({
                              url:getUrl(control)+"/"+ input1.value,
                              type:"DELETE",
                              async:false,
                              success:function(ret){
                                  resp=ret;

                              }

                          });
                          console.log(resp);
                          if(resp["status"]=="OK"){
                                      alert("Finish");
                                      document.getElementById("modalForm").reset();
                                  }else{
                                      alert("wrong text provided or connection problem");
                                      document.getElementById("modalForm").reset();
                                  }

                                  $('#subModal').modal('hide');
                        }
                                                }
             else if(name=="delete9"){
               var label1 =modal.find(".modal-body label")[0];
               label1.innerText="ID";
               label1.style.display="block";
               var input1= modal.find(".modal-body input")[0];
               input1.style.display="block";
               var submit = document.getElementById("submit");
               submit.onclick=function(){

               console.log(JSON.stringify(data));
               var resp;
               $.ajax({
                   url:getUrl(control)+"/"+ input1.value,
                   type:"DELETE",
                   async:false,
                   success:function(ret){
                       resp=ret;

                   }

               });
               console.log(resp);
               if(resp["status"]=="OK"){
                           alert("Finish");
                           document.getElementById("modalForm").reset();
                       }else{
                           alert("wrong text provided or connection problem");
                           document.getElementById("modalForm").reset();
                       }

                       $('#subModal').modal('hide');
             }
                                     }

  }
  else if(data=="update"){
      var name=button.data('name');
      var labelList=modal.find(".modal-body label");
          var inputList=modal.find(".modal-body input");
          for(let i=0;i<labelList.length;i++){

              labelList[i].style.display="none";
              inputList[i].style.display="none";
          }
          document.getElementById("modalForm").reset();
     if(name=="add"){
       var label1 =modal.find(".modal-body label")[0];
       label1.innerText="airportName";
       label1.style.display="block";
       var input1= modal.find(".modal-body input")[0];
       input1.style.display="block";

       var label2 =modal.find(".modal-body label")[1];
       label2.innerText="name";
       label2.style.display="block";
       var input2= modal.find(".modal-body input")[1];
       input2.style.display="block";


       var label3 =modal.find(".modal-body label")[2];
        label3.innerText="age";
        label3.style.display="block";
        var input3= modal.find(".modal-body input")[2];
        input3.style.display="block";



       var label4 =modal.find(".modal-body label")[3];
        label4.innerText="storeName";
        label4.style.display="block";
        var input4= modal.find(".modal-body input")[3];
        input4.style.display="block";



        var label5 =modal.find(".modal-body label")[4];
         label5.innerText="job";
         label5.style.display="block";
         var input5= modal.find(".modal-body input")[4];
         input5.style.display="block";


         var label6 =modal.find(".modal-body label")[5];
          label6.innerText="salary";
          label6.style.display="block";
          var input6= modal.find(".modal-body input")[5];
          input6.style.display="block";





       var submit = document.getElementById("submit");
       submit.onclick=function(){

       var airportName=label1.innerText;
       var name=label2.innerText;
       var age=label3.innerText;
       var storeName=label4.innerText;
       var job=label5.innerText;
       var salary=label6.innerText;
       var data={

         airportName : input1.value,
         name : input2.value,
         age : input3.value,
         storeName : input4.value,
         job : input5.value,
         salary : input6.value


       };

             console.log(JSON.stringify(data));
       var resp;
       $.ajax({
           url:getUrl(control),
           type:"POST",
           data:JSON.stringify(data),
           contentType:"application/json",
           async:false,
           success:function(ret){
               resp=ret;

           }

       });
       console.log(resp);
             if(resp["status"]=="OK"){
                         alert("Finish");
                         document.getElementById("modalForm").reset();
                     }else{
                         alert("wrong text provided or connection problem");
                         document.getElementById("modalForm").reset();
                     }

                     $('#subModal').modal('hide');
     }
     }
     if(name=="update1"){

             var label1 =modal.find(".modal-body label")[7];
             label1.innerText="id(id you are looking for)";
             label1.style.display="block";
             var input1= modal.find(".modal-body input")[7];
             input1.style.display="block";

             var label2 =modal.find(".modal-body label")[1];
             label2.innerText="city";
             label2.style.display="block";
             var input2= modal.find(".modal-body input")[1];
             input2.style.display="block";


             var label3 =modal.find(".modal-body label")[2];
              label3.innerText="name";
              label3.style.display="block";
              var input3= modal.find(".modal-body input")[2];
              input3.style.display="block";

             var submit = document.getElementById("submit");
             submit.onclick=function(){

             var city=label2.innerText;
             var name=label3.innerText;
             var data={

               city : input2.value,
               name : input3.value,



             };

                   console.log(JSON.stringify(data));
             var resp;
             $.ajax({
                 url:getUrl(control)+"/"+input1.value,
                 type:"PUT",
                 data:JSON.stringify(data),
                 contentType:"application/json",
                 async:false,
                 success:function(ret){
                     resp=ret;

                 }

             });
             console.log(resp);
                   if(resp["status"]=="OK"){
                               alert("Finish");
                               document.getElementById("modalForm").reset();
                           }else{
                               alert("wrong text provided or connection problem");
                               document.getElementById("modalForm").reset();
                           }

                           $('#subModal').modal('hide');
           }
           }
     else if(name=="update2"){

                              var label1 =modal.find(".modal-body label")[7];
                              label1.innerText="id(id you are looking for)";
                              label1.style.display="block";
                              var input1= modal.find(".modal-body input")[7];
                              input1.style.display="block";

                              var label2 =modal.find(".modal-body label")[1];
                              label2.innerText="booking_company_name";
                              label2.style.display="block";
                              var input2= modal.find(".modal-body input")[1];
                              input2.style.display="block";


                              var label3 =modal.find(".modal-body label")[2];
                               label3.innerText="agent_name";
                               label3.style.display="block";
                               var input3= modal.find(".modal-body input")[2];
                               input3.style.display="block";

                              var submit = document.getElementById("submit");
                              submit.onclick=function(){
                              var data={

                                bookingCompanyName : input2.value,
                                agentName : input3.value,



                              };

                                    console.log(JSON.stringify(data));
                              var resp;
                              $.ajax({
                                  url:getUrl(control)+"/"+input1.value,
                                  type:"PUT",
                                  data:JSON.stringify(data),
                                  contentType:"application/json",
                                  async:false,
                                  success:function(ret){
                                      resp=ret;

                                  }

                              });
                              console.log(resp);
                                    if(resp["status"]=="OK"){
                                                alert("Finish");
                                                document.getElementById("modalForm").reset();
                                            }else{
                                                alert("wrong text provided or connection problem");
                                                document.getElementById("modalForm").reset();
                                            }

                                            $('#subModal').modal('hide');
                            }
                            }
     else if(name=="update3"){
                                         var label1 =modal.find(".modal-body label")[0];
                                         label1.innerText="flightNumber";
                                         label1.style.display="block";
                                         var input1= modal.find(".modal-body input")[0];
                                         input1.style.display="block";

                                         var label2 =modal.find(".modal-body label")[1];
                                         label2.innerText="departureTime";
                                         label2.style.display="block";
                                         var input2= modal.find(".modal-body input")[1];
                                         input2.value= "Example:2013-04-01 13:51:50";
                                         input2.style.display="block";

                                         var label3 =modal.find(".modal-body label")[2];
                                         label3.innerText="arrivalTime";
                                         label3.style.display="block";
                                         var input3= modal.find(".modal-body input")[2];
                                         input3.value="Example:2013-04-01 13:51:52";
                                         input3.style.display="block";


                                         var label4 =modal.find(".modal-body label")[3];
                                         label4.innerText="departureAirport";
                                         label4.style.display="block";
                                         var input4= modal.find(".modal-body input")[3];
                                         input4.style.display="block";

                                         var label5 =modal.find(".modal-body label")[4];
                                         label5.innerText="arrivalAirport";
                                         label5.style.display="block";
                                         var input5= modal.find(".modal-body input")[4];
                                         input5.style.display="block";


                                         var label6 =modal.find(".modal-body label")[5];
                                          label6.innerText="id you want to change";
                                          label6.style.display="block";
                                          var input6= modal.find(".modal-body input")[5];
                                          input6.style.display="block";


                                         var submit = document.getElementById("submit");
                                         submit.onclick=function(){


                                         var data={
                                           flightNumber : input1.value,
                                           departureTime : input2.value,
                                           arrivalTime : input3.value,
                                           departureAirport : input4.value,
                                           arrivalAirport : input5.value

                                         };

                                               console.log(JSON.stringify(data));
                                         var resp;
                                         $.ajax({
                                             url:getUrl(control)+"/"+input6.value,
                                             type:"PUT",
                                             data:JSON.stringify(data),
                                             contentType:"application/json",
                                             async:false,
                                             success:function(ret){
                                                 resp=ret;

                                             }

                                         });
                                         console.log(resp);
                                               if(resp["status"]=="OK"){
                                                           alert("Finish");
                                                           document.getElementById("modalForm").reset();
                                                       }else{
                                                           alert("wrong text provided or connection problem");
                                                           document.getElementById("modalForm").reset();
                                                       }

                                                       $('#subModal').modal('hide');
                                       }
                   }
      else if(name=="update4"){
                                         var label1 =modal.find(".modal-body label")[0];
                                         label1.innerText="id you want to modify";
                                         label1.style.display="block";
                                         var input1= modal.find(".modal-body input")[0];
                                         input1.style.display="block";

                                         var label2 =modal.find(".modal-body label")[1];
                                         label2.innerText="flightCompanyName";
                                         label2.style.display="block";
                                         var input2= modal.find(".modal-body input")[1];
                                         input2.style.display="block";

                                         var submit = document.getElementById("submit");
                                         submit.onclick=function(){



                                         var data={

                                           flightCompanyName : input2.value



                                         };

                                               console.log(JSON.stringify(data));
                                         var resp;
                                         $.ajax({
                                             url:getUrl(control)+"/"+input1.value,
                                             type:"PUT",
                                             data:JSON.stringify(data),
                                             contentType:"application/json",
                                             async:false,
                                             success:function(ret){
                                                 resp=ret;

                                             }

                                         });
                                         console.log(resp);
                                               if(resp["status"]=="OK"){
                                                           alert("Finish");
                                                           document.getElementById("modalForm").reset();
                                                       }else{
                                                           alert("wrong text provided or connection problem, you might need to insert a id to supplier first");
                                                           document.getElementById("modalForm").reset();
                                                       }

                                                       $('#subModal').modal('hide');
                                       }
                         }
      else if(name=="update5"){
                                var label1 =modal.find(".modal-body label")[0];
                                label1.innerText="flightNumber";
                                label1.style.display="block";
                                var input1= modal.find(".modal-body input")[0];
                                input1.style.display="block";

                                var label2 =modal.find(".modal-body label")[1];
                                label2.innerText="supplierId";
                                label2.style.display="block";
                                var input2= modal.find(".modal-body input")[1];
                                input2.style.display="block";

                                var label3 =modal.find(".modal-body label")[2];
                                label3.innerText="ticket_order_number you want to modify";
                                label3.style.display="block";
                                var input3= modal.find(".modal-body input")[2];
                                input3.style.display="block";

                                var submit = document.getElementById("submit");
                                submit.onclick=function(){

                                var data={
                                  flightNumber : input1.value,
                                  supplierId : input2.value,
                                  ticketOrderNumber : input3.value


                                };

                                      console.log(JSON.stringify(data));
                                var resp;
                                $.ajax({
                                    url:getUrl(control)+"/"+input3.value,
                                    type:"PUT",
                                    data:JSON.stringify(data),
                                    contentType:"application/json",
                                    async:false,
                                    success:function(ret){
                                        resp=ret;

                                    }

                                });
                                console.log(resp);
                                      if(resp["status"]=="OK"){
                                                  alert("Finish");
                                                  document.getElementById("modalForm").reset();
                                              }else{
                                                  alert("wrong text provided or connection problem");
                                                  document.getElementById("modalForm").reset();
                                              }

                                              $('#subModal').modal('hide');
                              }
      }
      else if(name=="update6"){
                var label1 =modal.find(".modal-body label")[0];
                label1.innerText="Store name";
                label1.style.display="block";
                var input1= modal.find(".modal-body input")[0];
                input1.style.display="block";

                var label2 =modal.find(".modal-body label")[1];
                label2.innerText="airportName";
                label2.style.display="block";
                var input2= modal.find(".modal-body input")[1];
                input2.style.display="block";

                var label3 =modal.find(".modal-body label")[2];
                label3.innerText="productType";
                label3.style.display="block";
                var input3= modal.find(".modal-body input")[2];
                input3.style.display="block";


                var label4 =modal.find(".modal-body label")[3];
                 label4.innerText="type";
                 label4.style.display="block";
                 var input4= modal.find(".modal-body input")[3];
                 input4.style.display="block";



                var label5 =modal.find(".modal-body label")[4];
                 label5.innerText="place";
                 label5.style.display="block";
                 var input5= modal.find(".modal-body input")[4];
                 input5.style.display="block";

                  var label6 =modal.find(".modal-body label")[5];
                 label6.innerText="Store name you want to change";
                 label6.style.display="block";
                 var input6= modal.find(".modal-body input")[5];
                 input6.style.display="block";


                  var label7 =modal.find(".modal-body label")[6];
                     label7.innerText="Airport Name you want to change";
                     label7.style.display="block";
                     var input7= modal.find(".modal-body input")[6];
                     input7.style.display="block";





                var submit = document.getElementById("submit");
                submit.onclick=function(){

                var data={
                  name : input1.value,
                  airportName : input2.value,
                  productType : input3.value,
                  type : input4.value,
                  place : input5.value


                };

                      console.log(JSON.stringify(data));
                var resp;
                $.ajax({
                    url:getUrl(control)+"/"+input6.value+"/"+input7.value,
                    type:"Put",
                    data:JSON.stringify(data),
                    contentType:"application/json",
                    async:false,
                    success:function(ret){
                        resp=ret;

                    }

                });
                console.log(resp);
                      if(resp["status"]=="OK"){
                                  alert("Finish");
                                  document.getElementById("modalForm").reset();
                              }else{
                                  alert("wrong text provided or connection problem");
                                  document.getElementById("modalForm").reset();
                              }

                              $('#subModal').modal('hide');
              }
              }
      else if(name=="update7"){
                 var label1 =modal.find(".modal-body label")[0];
                 label1.innerText="id you are looking for";
                 label1.style.display="block";
                 var input1= modal.find(".modal-body input")[0];
                 input1.style.display="block";

                 var label2 =modal.find(".modal-body label")[1];
                 label2.innerText="type";
                 label2.style.display="block";
                 var input2= modal.find(".modal-body input")[1];
                 input2.style.display="block";

                 var submit = document.getElementById("submit");
                 submit.onclick=function(){


                 var data={

                   type : input2.value



                 };

                       console.log(JSON.stringify(data));
                 var resp;
                 $.ajax({
                     url:getUrl(control)+"/"+input1.value,
                     type:"PUT",
                     data:JSON.stringify(data),
                     contentType:"application/json",
                     async:false,
                     success:function(ret){
                         resp=ret;

                     }

                 });
                 console.log(resp);
                       if(resp["status"]=="OK"){
                                   alert("Finish");
                                   document.getElementById("modalForm").reset();
                               }else{
                                   alert("wrong text provided or connection problem");
                                   document.getElementById("modalForm").reset();
                               }

                               $('#subModal').modal('hide');
               }
               }
       else if(name=="update8"){


                   var label1 =modal.find(".modal-body label")[0];
                   label1.innerText="passengerName";
                   label1.style.display="block";
                   var input1= modal.find(".modal-body input")[0];
                   input1.style.display="block";

                   var label2 =modal.find(".modal-body label")[1];
                   label2.innerText="flightNumber";
                   label2.style.display="block";
                   var input2= modal.find(".modal-body input")[1];
                   input2.style.display="block";


                   var label3 =modal.find(".modal-body label")[2];
                    label3.innerText="flightCompany";
                    label3.style.display="block";
                    var input3= modal.find(".modal-body input")[2];
                    input3.style.display="block";



                   var label4 =modal.find(".modal-body label")[3];
                    label4.innerText="seatClass";
                    label4.style.display="block";
                    var input4= modal.find(".modal-body input")[3];
                    input4.style.display="block";



                    var label5 =modal.find(".modal-body label")[4];
                     label5.innerText="price";
                     label5.style.display="block";
                     var input5= modal.find(".modal-body input")[4];
                     input5.style.display="block";


                     var label6 =modal.find(".modal-body label")[5];
                      label6.innerText="id which you want to change";
                      label6.style.display="block";
                      var input6= modal.find(".modal-body input")[5];
                      input6.style.display="block";






                   var submit = document.getElementById("submit");
                   submit.onclick=function(){

                   var data={

                     passengerName : input1.value,
                     flightNumber : input2.value,
                     flightCompany : input3.value,
                     seatClass : input4.value,
                     price : input5.value


                   };

                         console.log(JSON.stringify(data));
                   var resp;
                   $.ajax({
                       url:getUrl(control)+"/"+input6.value,
                       type:"PUT",
                       data:JSON.stringify(data),
                       contentType:"application/json",
                       async:false,
                       success:function(ret){
                           resp=ret;

                       }

                   });
                   console.log(resp);
                         if(resp["status"]=="OK"){
                                     alert("Finish");
                                     document.getElementById("modalForm").reset();
                                 }else{
                                     alert("wrong text provided or connection problem");
                                     document.getElementById("modalForm").reset();
                                 }

                                 $('#subModal').modal('hide');
                 }
                 }
      else if(name=="update9"){
                 var label1 =modal.find(".modal-body label")[0];
                 label1.innerText="airportName";
                 label1.style.display="block";
                 var input1= modal.find(".modal-body input")[0];
                 input1.style.display="block";

                 var label2 =modal.find(".modal-body label")[1];
                 label2.innerText="name";
                 label2.style.display="block";
                 var input2= modal.find(".modal-body input")[1];
                 input2.style.display="block";


                 var label3 =modal.find(".modal-body label")[2];
                  label3.innerText="age";
                  label3.style.display="block";
                  var input3= modal.find(".modal-body input")[2];
                  input3.style.display="block";



                 var label4 =modal.find(".modal-body label")[3];
                  label4.innerText="storeName";
                  label4.style.display="block";
                  var input4= modal.find(".modal-body input")[3];
                  input4.style.display="block";



                  var label5 =modal.find(".modal-body label")[4];
                   label5.innerText="job";
                   label5.style.display="block";
                   var input5= modal.find(".modal-body input")[4];
                   input5.style.display="block";


                   var label6 =modal.find(".modal-body label")[5];
                    label6.innerText="salary";
                    label6.style.display="block";
                    var input6= modal.find(".modal-body input")[5];
                    input6.style.display="block";


                    var label7 =modal.find(".modal-body label")[6];
                    label7.innerText="id you are looking for";
                    label7.style.display="block";
                    var input7= modal.find(".modal-body input")[6];
                    input7.style.display="block";





                 var submit = document.getElementById("submit");
                 submit.onclick=function(){


                 var data={

                   airportName : input1.value,
                   name : input2.value,
                   age : input3.value,
                   storeName : input4.value,
                   job : input5.value,
                   salary : input6.value


                 };

                       console.log(JSON.stringify(data));
                 var resp;
                 $.ajax({
                     url:getUrl(control)+"/"+input7.value,
                     type:"PUT",
                     data:JSON.stringify(data),
                     contentType:"application/json",
                     async:false,
                     success:function(ret){
                         resp=ret;

                     }

                 });
                 console.log(resp);
                       if(resp["status"]=="OK"){
                                   alert("Finish");
                                   document.getElementById("modalForm").reset();
                               }else{
                                   alert("wrong text provided or connection problem");
                                   document.getElementById("modalForm").reset();
                               }

                               $('#subModal').modal('hide');
               }
               }




  }
});
