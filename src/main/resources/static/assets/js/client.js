$(document).ready(function(){
    getAllClient();
});

function getAllClient(){
    $.ajax({
        url : "api/Client/all",
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#resultsClient").empty();
            for(i=0;i<p.length;i++){
                let k=`<div class="col">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${p[i].name}</h5>
                                    <p class="card-text">${p[i].email}</p>
                                    <p class="card-number">${p[i].age}</p>
                                    
                                </div>
                                <div class="card-footer">
                                    <div class="btn-group" role="group">
                                        <button type="button" class="btn btn-outline-primary" onclick='getClientById(${p[i].id})'>Actualizar</button>
                                        <button type="button" class="btn btn-outline-primary" onclick='deleteById(${p[i].id})'>Borrar!</button>
                                    </div>
                                </div>
                            </div>
                        </div>`;
                $("#resultsClient").append(k);
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
function getClientData(){
    let cli={
        id:$("#idCliente").val(),
        name:$("#nombreCliente").val(),
        email:$("#emailCliente").val(),
        age:$("#edadCliente").val()
    }
    return cli;
}
function cleanData(){
    $("#idCliente").val("");
    $("#nombreCliente").val("");
    $("#emailCliente").val("");
    $("#edadCliente").val("");
}
function saveClient(){

    let data=getClientData();
    data.id=null;
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Client/save",
        type : 'POST',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllClient();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function getClientById(idCli){
    $(".saveButtonJL").hide();
    $(".updateButtonJL").show();
    $.ajax({
        url : "api/Client/"+idCli,
        type : 'GET',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            $("#idCliente").val(p.id);
            $("#nombreCliente").val(p.name);
            $("#emailCliente").val(p.email);
            $("#edadCliente").val(p.age);
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}
function  cancelUpdateClient(){
    cleanData();
    $(".saveButtonJL").show();
    $(".updateButtonJL").hide();
}
function updateClient(){

    let data=getClientData();
    let dataToSend=JSON.stringify(data);
    $.ajax({
        url : "api/Client/update",
        type : 'PUT',
        data:dataToSend,
        contentType : 'application/json',
        success : function(p) {
            console.log(p);
            cancelUpdateClient();
            getAllClient();

        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

function deleteById(idCli){
    $.ajax({
        url : "api/Client/"+idCli,
        type : 'DELETE',
        dataType : 'json',
        success : function(p) {
            console.log(p);
            cleanData();
            getAllClient();
        },
        error : function(xhr, status) {
            alert('ha sucedido un problema');
        },
        complete : function(xhr, status) {
            //  alert('Petición realizada');
        }
    });
}

