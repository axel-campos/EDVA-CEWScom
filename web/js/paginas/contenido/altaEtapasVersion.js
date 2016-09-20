$(document).ready(function(){
    var form = "#frmTiempos";
    var action = "registraVersion";
    
    var fechaValidators = {
        validators: {
            notEmpty:{
                message: 'Ingresa la fecha de terminación'
            }
        }
    };
    $(form).bootstrapValidator({
        fields:{
            /*etapa: {
                validators:{
                    greaterThan: {
                        value: 2,
                        message: "Por favor, ingrese el token del grupo."
                    }
                }
            }*/
            temp: fechaValidators
        }
    }).on('success.form.fv', function(e){
        //Prevent form submission
        e.preventDefault();
        //Use Ajax to submit form data
        var datos = $(form).serialize();
        //BootstrapDialog.alert(datos);
        /*$.ajax({
            type: "POST",
            url: action,
            data: datos,
            success: function(data){
                /*var target = "#contenido";
                $(target).html(data);*
                if(data.toString() === "Exito"){
                    mostrarNotificacion("success",data);
                }else{
                    mostrarNotificacion("error","Error!");
                }
            }
        });*/       
    });
});


function cargarVersiones(etapa){
    var action = "cargaVersiones.action";
    var idContenido = $("#idContenido").val();
    if(etapa === "0"){//Selecciona etapa.
        $("#btnAgregar").hide();
        $("#btnCancelar").hide();
        $("#btnSubmit").hide();
    }else{
        $("#btnAgregar").show();
        $("#btnCancelar").hide();
        $("#btnSubmit").hide();
    }
    $.post(action, {"idContenido": idContenido, "etapa": etapa}).done(function(data) 
    {
        $("#tablaVersiones").html(data);
        if(data.toString() !== ""){//No error
            //$("#tb_grupo").html(data);
            //$("#correcto").show();
        }else{
            
        }
    });
}

function agregarVersion(){
    var numeroVersion = ($("#tablaVersiones tr").length);
    var fila = "<tr>"
        + "<td style='text-align: center'>" + numeroVersion + "<input type='hidden' value='" + numeroVersion + "' id='version' name='version'></td>"
        + "<td style='padding-left: 20%'><div class='form-group row-fluid'><input type='text' id='fecha' name='fecha' class='form-control' style='width: 55%'></div></td>"
        + "</tr>";
    $("#tablaVersiones tr:last").after(fila);//Agregamos la fila
    
    $("#fecha").datetimepicker({
        locale: 'es',
        format: 'YYYY-MM-DD H:mm'
    }).on('changeDate', function(event){
        alert("Para vivier");
        $("#frmTiempos").bootstrapValidator('revalidateField',$('#fecha').find('[name="fecha"]'))
    });
    $("#btnAgregar").hide();//Ocultamos esta opción.
    $("#btnCancelar").show();
    $("#btnSubmit").show();
    var fechaValidators = {
        validators: {
            notEmpty:{
                message: 'Ingresa la fecha de terminación'
            }
        }
    };
    $("#frmTiempos").bootstrapValidator('addField','fecha', fechaValidators)
}

function cancelarOperacion(){
    alert("No mames!!!");
}


