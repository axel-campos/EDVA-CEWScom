$(document).ready(function(){
    var form = "#frmTiempos";
    var action = "registraVersion";
    $("#btnAgregar").on('click',function(event){
        event.preventDefault();
       //Aquí nos dedicamos a ingresar la nueva fila a la tabla.
        var numeroVersion = ($("#tablaVersiones tr").length);
        var fila = "<tr>"
            + "<td style='text-align: center'>" + numeroVersion + "<input type='hidden' value='" + numeroVersion + "' id='version' name='version'></td>"
            + "<td style='padding-left: 26%'><div class='form-group row-fluid'><input type='text' placeholder='Ingresa fecha' id='fecha' name='fecha' class='form-control' style='width: 60%'></div></td>"
            + "</tr>";
        $("#tablaVersiones tr:last").after(fila);//Agregamos la fila

        $("#btnAgregar").hide();//Ocultamos esta opción.
        $("#btnCancelar").show();
        $("#btnSubmit").show();
        //Agregamos la validación
        $(form).bootstrapValidator('destroy')
                .bootstrapValidator({
                    fields:{
                        fecha:{
                            validators:{
                                notEmpty:{
                                    message: 'Ingrese fecha'
                                },
                                date:{
                                    format: 'YYYY-MM-DD h:m',
                                    message: 'Formato de fecha incorrecto'
                                }
                            }
                        }
                    }
        }).off('success.form.fv').off('submit').on('submit', function(event){
            event.preventDefault();
            var datos = $(form).serialize();
            //mensajes(datos, TIPO_MENSAJE.SUCCESS);
            $.ajax({
                type: "POST",
                url: action,
                data: datos,
                success: function(data){
                    if(data.toString() !== ""){
                        var idContenido = $("#idContenido").val();
                        var etapa = $("#etapa").val();
                        if(data.toString() === "Exito"){
                            //Refrecamos la ventana
                            $("#ventana").load("cargaEtapas",{"idContenido": idContenido, "etapa": etapa}, function(response, status, xhr){
                                if(status === "success"){
                                    //Cargamos las versiones de la etapa en la que se cargo el nuevo
                                    cargarVersiones(etapa);
                                }

                            });
                        //Mostramos el mensaje
                        mensajes("Éxito al registrar la versión de la etapa", TIPO_MENSAJE.SUCCESS);
                        }else if(data.toString() === "Fecha"){
                            var mensajito = "No se pudo establecer el tiempo límite de modificación para esta versión debido a que existe otra cuyo tiempo para modificar incluye a ésta.";
                            mensajes(mensajito,TIPO_MENSAJE.DANGER);
                        }
                        
                    }else{
                        mensajes("Error. En este momento no podemos guardar la información de esta versión", TIPO_MENSAJE.DANGER);
                    }
                }
            });
        }).on('click','#btnCancelar',function(){
            //Quitamos la validación
            $(form).bootstrapValidator('removeField',$("#fecha"));
            //Quitamos la fila que habíamos agregado a la tabla
            $("#tablaVersiones tr:last").remove();
            //Mostramos los botones
            $("#btnAgregar").show();
            //Quitamos los botones
            $("#btnCancelar").hide();
            $("#btnSubmit").hide();
        });
        
        
        
        $("#fecha").datetimepicker({
            locale: 'es',
            format: 'YYYY-MM-DD HH:mm',
            minDate: moment().add(1, 'days').format('YYYY-MM-DD'),
            defaultDate: moment().add(1, 'days').format('YYYY-MM-DD')
        }).show().on("dp.change",function(e){
            $("#frmTiempos").bootstrapValidator('revalidateField', $("#fecha"));//Revalidamos el campo cada vez que cambie
        }); 
    });
});

function cargarVersiones(etapa){
    var form = "#frmTiempos";
    var action = "cargaVersiones.action";
    var idContenido = $("#idContenido").val();
    $(form).bootstrapValidator('removeField',$("#fecha"));
    if(etapa === "0"){//Selecciona etapa.
        $("#btnAgregar").hide();
    }else{
        $("#btnAgregar").show();
    }
    $("#btnCancelar").hide();
    $("#btnSubmit").hide();
    $.post(action, {"idContenido": idContenido, "etapa": etapa}).done(function(data) 
    {
        $("#tablaVersiones").html(data);
        if(data.toString() !== ""){//No error
        }else{
            
        }
    });
}

