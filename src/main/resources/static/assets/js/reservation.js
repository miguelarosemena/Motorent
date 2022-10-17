$(document).ready(function(){
    getAllReservations();
});

function getAllReservations(){
    $.ajax({
        url : "api/Reservations/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#resultsReservations").empty();
            for(i=0;i<p.length;i++){
                let k=`<div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${p[i].name}</h5>
                                    <p class="card-text">${p[i].description}</p>
                                </div>
                                <div class="card-footer">
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getReservationsById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteById(${p[i].id})'>Borrar!</button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                $("#resultsReservations").append(k);
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
function getReservationsData(){
    let res={
        id:$("#idReservas").val(),
        name:$("#nombreReservas").val(),
        description:$("#descripcionReservas").val()
    }
    return res;
}
function cleanData(){
    $("#idReservas").val("");
    $("#nombreReservas").val("");
    $("#descripcionReservas").val("");
}
function saveReservations(){

    let data=getReservationsData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Reservations/save",
        type : 'POST',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllReservations();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getReservationsById(idRes){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Reservations/"+idRes,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idReservas").val(p.id);
            $("#nombreReservas").val(p.name);
            $("#descripcionReservas").val(p.description);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function  cancelUpdateReservations(){
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateReservations(){

    let data=getReservationsData();
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Reservations/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cancelUpdateReservations();
            getAllReservations();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteById(idRes){
    $.ajax({
        url : "api/Reservations/"+idRes,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllReservations();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

