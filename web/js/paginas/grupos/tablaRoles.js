function ModificarRoles(){
    var numRows = $("#numMiembros").val();
    $("#colEliminar").show();
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(0).disabled = false;
        document.getElementsByName("txt_result_" + x).item(1).disabled = false;
        $("#rowEliminar_" + x).show();
    }
    var modify_button = document.getElementById("modify_button");
    var new_coordinator_button = document.getElementById("new_coordinator_button");
    
    var submit_button = document.createElement("input");
    submit_button.id = "submit_button";
    submit_button.type = "submit";
    submit_button.value = "Guardar";
    submit_button.className = "btn btn-success";
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
}

function cancel_operation(){
    var numRows = $("#numMiembros").val();
    $("#colEliminar").hide();
    $("#colCoordinador").hide();
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(0).disabled = true;
        document.getElementsByName("txt_result_" + x).item(1).disabled = true;
        document.getElementsByName("txt_result_" + x).item(2).disabled = true;
        $("#rowEliminar_" + x).hide();
        $("#rowCoordinador_" + x).hide();
    }
}