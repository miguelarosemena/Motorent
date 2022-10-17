$(document).ready(function(){
    getAllMotorbike();
});

function getAllMotorbike(){
    $.ajax({
        url : "api/Motorbike/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#resultsMotorbike").empty();
            for(i=0;i<p.length;i++){
                let k=`<div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${p[i].name}</h5>
                                    <p class="card-text">${p[i].description}</p>
                                </div>
                                <div class="card-footer">
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getMotorbikeById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteById(${p[i].id})'>Borrar!</button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                $("#resultsMotorbike").append(k);
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
function getMotorbikeData(){
    let mot={
        id:$("#idMotocicleta").val(),
        name:$("#nombreMotocicleta").val(),
        description:$("#descripcionMotocicleta").val()
    }
    return mot;
}
function cleanData(){
    $("#idMotocicleta").val("");
    $("#nombreMotocicleta").val("");
    $("#descripcionMotocicleta").val("");
}
function saveMotorbike(){

    let data=getMotorbikeData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Motorbike/save",
        type : 'POST',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllMotorbike();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getMotorbikeById(idMot){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Motorbike/"+idMot,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idMotocicleta").val(p.id);
            $("#nombreMotocicleta").val(p.name);
            $("#descripcionMotocicleta").val(p.description);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function  cancelUpdateMotorbike(){
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateMotorbike(){

    let data=getMotorbikeData();
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Motorbike/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cancelUpdateMotorbike();
            getAllMotorbike();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteById(idMot){
    $.ajax({
        url : "api/Motorbike/"+idMot,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllMotorbike();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

