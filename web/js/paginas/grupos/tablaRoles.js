function ModificarRoles(){
    var numRows = $("#numMiembros").val();
    $("#colEliminar").show();
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(1).disabled = false;
        document.getElementsByName("txt_result_" + x).item(2).disabled = false;
        $("#rowEliminar_" + x).show();
    }
    var modify_button = document.getElementById("modify_button");
    var new_coordinator_button = document.getElementById("new_coordinator_button");
    
    var submit_button = document.createElement("input");
    submit_button.id = "submit_button";
    submit_button.type = "button";
    submit_button.value = "Guardar";
    submit_button.className = "btn btn-success";
    submit_button.onclick = guardarCambiosRoles;
    document.getElementById("button-group").replaceChild(submit_button, modify_button);
    
    var cancelar_button = document.createElement("input");
    cancelar_button.id = "cancelar_button";
    cancelar_button.type = "button";
    cancelar_button.value = "Cancelar";
    cancelar_button.className = "btn btn-danger";
    cancelar_button.onclick = cancel_operation;
    document.getElementById("button-group").replaceChild(cancelar_button, new_coordinator_button);
}

function NuevoCoordinador(){
    var numRows = $("#numMiembros").val();
    $("#colCoordinador").show();
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(0).disabled = false;
        $("#rowCoordinador_" + x).show();
    }
    var modify_button = document.getElementById("modify_button");
    var new_coordinator_button = document.getElementById("new_coordinator_button");
    
    var coordinador_button = document.createElement("input");
    coordinador_button.id = "submit_button";
    coordinador_button.type = "button";
    coordinador_button.value = "Guardar";
    coordinador_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(coordinador_button, modify_button);
    
    var cancelar_button = document.createElement("input");
    cancelar_button.id = "cancelar_button";
    cancelar_button.type = "button";
    cancelar_button.value = "Cancelar";
    cancelar_button.className = "btn btn-danger";
    cancelar_button.onclick = cancel_operation;
    document.getElementById("button-group").replaceChild(cancelar_button, new_coordinator_button);
}

function cancel_operation(){
    /*Desaparecer columnas*/
    var numRows = $("#numMiembros").val();
    $("#colEliminar").hide();
    $("#colCoordinador").hide();
    for(x = 0; x < numRows; x++){
        var radiobutton1 = document.getElementsByName("txt_result_" + x).item(0);
        var radiobutton2 = document.getElementsByName("txt_result_" + x).item(1);
        var radiobutton3 = document.getElementsByName("txt_result_" + x).item(2);
        radiobutton1.disabled = true;
        radiobutton2.disabled = true;
        radiobutton3.disabled = true;
        if(radiobutton1.checked){
            radiobutton1.checked = false;
        }else if(radiobutton2.checked){
            radiobutton2.checked = false;
        }else if(radiobutton3.checked){
            radiobutton3.checked = false;
        }
        $("#rowEliminar_" + x).hide();
        $("#rowCoordinador_" + x).hide();
    }
    /*Reset al formulario*/
    document.getElementById("frmRoles").reset();
    
    /*Botones*/
    var submit_button = document.getElementById("submit_button");
    var cancelar_button = document.getElementById("cancelar_button");
    
    var modify_button = document.createElement("input");
    modify_button.id = "modify_button";
    modify_button.type = "button";
    modify_button.value = "Modificar Roles";
    modify_button.className = "btn btn-success";
    modify_button.onclick = ModificarRoles;
    document.getElementById("button-group").replaceChild(modify_button, submit_button);
    
    var new_coordinator_button = document.createElement("input");
    new_coordinator_button.id = "new_coordinator_button";
    new_coordinator_button.type = "button";
    new_coordinator_button.value = "Nuevo Coordinador";
    new_coordinator_button.className = "btn btn-primary";
    new_coordinator_button.onclick = NuevoCoordinador;
    document.getElementById("button-group").replaceChild(new_coordinator_button, cancelar_button);
}

function guardarCambiosRoles(){
    //Mandamos datos por ajax
    var form = "#frmRoles";
    var action = "modifyRoles";
    
    var datos = $(form).serialize();
    $.ajax({
        type: "POST",
        url: action,
        data: datos,
        success: function(data){
            $("#contenido").html(data);
        }
    });
}