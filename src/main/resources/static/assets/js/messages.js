$(document).ready(function(){
    getAllMessages();
});

function getAllMessages(){
    $.ajax({
        url : "api/Messages/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#resultsMessages").empty();
            for(i=0;i<p.length;i++){
                let k=`<div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${p[i].id}</h5>
                                    <p class="card-text">${p[i].messageText}</p>
                                </div>
                                <div class="card-footer">
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getMessagesById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteById(${p[i].id})'>Borrar!</button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                $("#resultsMessages").append(k);
            }
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getMessagesData(){
    let Mes={
        id:$("#idMensajes").val(),
        messageText:$("#textoMensajes").val()
    }
    return Mes;
}
function cleanData(){
    $("#idMensajes").val("");
    $("#textoMensajes").val("");
}
function saveMessages(){

    let data=getMessagesData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Messages/save",
        type : 'POST',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllMessages();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getMessagesById(idMes){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Messages/"+idMes,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idMensajes").val(p.id);
            $("#textoMensajes").val(p.messageText);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function  cancelUpdateMessages(){
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateMessages(){

    let data=getMessagesData();
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Messages/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cancelUpdateMessages();
            getAllMessages();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteById(idMes){
    $.ajax({
        url : "api/Messages/"+idMes,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllMessages();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

