function habilitarEdicion() {
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = false;
    }
    
    var modify_button = document.getElementById("modify_button");
    var pwd_modify_button = document.getElementById("pwd_modify_button");
    
    //Incorporar el boton de submit
    var submit_button = document.createElement("input");
    submit_button.id = "submit_button";
    submit_button.type = "submit";
    submit_button.value = "Aceptar";
    submit_button.action = "modUsuario";
    submit_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(submit_button,modify_button);
    
    //Incorporar el boton de cancelar
    var cancel_button = document.createElement("input");
    cancel_button.id = "cancel_button";
    cancel_button.type = "button";
    cancel_button.onclick = cancelOperation;
    cancel_button.value = "Cancelar";
    cancel_button.className = "btn btn-danger";
    document.getElementById("button-group").replaceChild(cancel_button, pwd_modify_button);
    
}

function cancelOperation()
{   
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = true;
    }
    
    var submit_button = document.getElementById("submit_button");
    var cancel_button = document.getElementById("cancel_button");
       
    var modify_button = document.createElement("input");
    modify_button.id = "modify_button";
    modify_button.onclick = habilitarEdicion;
    modify_button.type = "button";
    modify_button.action = "modUsuario";
    modify_button.value = "Modificar";
    modify_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(modify_button, submit_button);   
    
    var pwd_modify_button = document.createElement("input");
    pwd_modify_button.id = "pwd_modify_button";
    pwd_modify_button.onclick = modificarContrasenia;
    pwd_modify_button.type = "button";
    pwd_modify_button.value = "Cambiar Contraseña";
    pwd_modify_button.className = "btn btn-primary";
    document.getElementById("button-group").replaceChild(pwd_modify_button, cancel_button);
    
    document.getElementById("modificarfrm").reset();
      
}
function modificarContrasenia()
{
    BootstrapDialog.show({
    title: 'Modificar contraseña',
    message: '<form role="form" id="mod_pwd_frm" method="POST" class="form-group" action="modPwd"> <div class="form-group"> <label for="recipient-name" class="control-label">Contraseña actual</label>                       <input type="password" class="form-control" id="old_pwd">                                                            <label for="recipient-name" class="control-label">Contraseña nueva</label>                      <input type="password" class="form-control" id="old_pwd">                                                                <label for="recipient-name" class="control-label">Repetir su Contraseña</label>                        <input type="password" class="form-control" id="old_pwd">                    </div>                  </form>',
    buttons: [{
        id: 'btn-ok',         
        label: 'Aceptar',
        cssClass: 'btn-primary', 
        autospin: false,
        action: function(dialogRef){    
            dialogRef.close();
                }
            }]
    });
}