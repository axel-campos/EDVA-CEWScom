$(document).ready(function(){
    var form = "#frmTiempos";
    var action = "registraVersion";
    $("#btnAgregar").on('click',function(event){
        event.preventDefault();
        //Aquí nos dedicamos a ingresar la nueva fila a la tabla.
        var numeroVersion = $(".version").size() + 1;
        var temporal = "<div class='form-group version'><label class='col-md-4 control-label'><p align='center'>" + numeroVersion + "</p>"
                    + "<input type='hidden' value='" + numeroVersion + "' id='version' name='version'></label>"
                    + "<div class='col-md-2'></div><div class='col-md-4'>"
                    + "<input type='text' id='fecha' name='fecha' class='form-control'/></div></div>";
        $(".form-group:last").after(temporal);
        
        $("#btnAgregar").hide();//Ocultamos esta opción.
        $("#btnCancelar").show();
        $("#btnSubmit").show();
        //Agregamos la validación
        $(form).bootstrapValidator('destroy')
                .bootstrapValidator({
                    autofocus: true,
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
                        var token = $("#token").val();
                        if(data.toString() === "Exito"){
                            //Refrecamos la ventana
                            $("#ventana").load("cargaEtapas",{"idContenido": idContenido, "etapa": etapa, "version": numeroVersion}, function(response, status, xhr){
                                if(status === "success"){
                                    //Cargamos las versiones de la etapa en la que se cargo el nuevo
                                    //cargarVersiones(etapa);
                                    //
                                    cambiarContenidos('ListarMiembrosAction?token='+token,'#contenido');
                                    /*var target = "#contenidoGrupo";
                                    cambiarContenidos('ListarMiembrosAction?token='+token,target);*/
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
        });
        ponerCalendario();
        
    });
    //Para lo de la edición
    $("#btnEditar").on('click',function(event){
        event.preventDefault();        
        //Aquí nos dedicamos a poner la fila
        var idContenido = $("#idContenido").val(), etapa = $("#etapa").val(), version = $("#version").val();
        $.post("cargaVersionEditar",{idContenido: idContenido, etapa:etapa, version:version}).done(function(data){
            //Removemos el último
            $(".form-group:last").remove();
            //Cargamos la etapa
            $(".form-group:last").after(data);       
            //Quitamos/Ponemos botones
            $("#btnEditar").hide();
            $("#CancelarEdicion").show();
            $("#SubmitEdicion").show();
            //Ponemos la validación
            $(form)/*.bootstrapValidator('destroy')*/
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
                var actionEditar = "modificaVersion";
                //mensajes(datos, TIPO_MENSAJE.SUCCESS);
                $.ajax({
                    type: "POST",
                    url: actionEditar,
                    data: datos,
                    success: function(data){
                        if(data.toString() !== ""){
                            var idContenido = $("#idContenido").val();
                            var etapa = $("#etapa").val();
                            var token = $("#token").val();
                            if(data.toString() === "Exito"){
                                //Refrecamos la ventana
                                $("#ventana").load("cargaEtapas",{"idContenido": idContenido, "etapa": etapa, "version": version}, function(response, status, xhr){
                                    if(status === "success"){
                                        cambiarContenidos('ListarMiembrosAction?token='+token,'#contenido');
                                    }

                                });
                            //Mostramos el mensaje
                            mensajes("Éxito al modificar el tiempo límite para trabajar en esta etapa", TIPO_MENSAJE.SUCCESS);
                            }else if(data.toString() === "Fecha"){
                                var mensajito = "No se pudo modificar el tiempo límite de modificación para esta versión debido a que se debe ingresar una fecha mayor a la que se tiene ahora.";
                                mensajes(mensajito,TIPO_MENSAJE.DANGER);
                            }

                        }else{
                            mensajes("Error. En este momento no podemos guardar la información de esta versión", TIPO_MENSAJE.DANGER);
                        }
                    }
                });
            });
            
            ponerCalendario();
        });
         
    });
    
    
    //Algo niu
    if($("#etapa").val() !== "0"){
        cargarVersiones($("#etapa").val());
    }
});

function cargarVersiones(etapa){
    var form = "#frmTiempos";
    var action = "cargaVersiones.action";
    var idContenido = $("#idContenido").val();
    $(form).bootstrapValidator('removeField',$("#fecha"));
    if(etapa === "0"){//Selecciona etapa.
        $("#btnAgregar").hide();
    }
    $("#btnCancelar").hide();
    $("#btnSubmit").hide();
    $.post(action, {"idContenido": idContenido, "etapa": etapa}).done(function(data) 
    {
        //$("#tablaVersiones").html(data);
        //Primero quitamos todo los divs anteriores
        $(".version").remove();
        $(".form-group:last").after(data);
        if(data.toString() !== ""){//No error
            var version = $("#version").val();
            if(version === ""){//Entonces pueden crear una nueva versión
                $("#btnAgregar").show();
            }else{//Lo único que pueden hacer es editar la etapa activa
                $("#btnAgregar").hide();
                var editar = $("#etapaActiva").val();
                if(editar === etapa){
                    $("#btnEditar").show();
                }else{
                    $("#btnEditar").hide();
                }
                /*$("#btnCancelar").show();
                $("#btnSubmit").show();*/
            }
        }else{
            
        }
    });
}

function ponerCalendario(){
    $("#fecha").datetimepicker({
        locale: 'es',
        format: 'YYYY-MM-DD HH:mm',
        minDate: moment().add(1, 'days').format('YYYY-MM-DD'),
        defaultDate: moment().add(1, 'days').format('YYYY-MM-DD'),
        tooltips: {
            today: 'Hoy',
            clear: 'Limpiar selección',
            close: 'Cerrar el calendario',
            selectMonth: 'Seleccionar mes',
            prevMonth: 'Mes previo',
            nextMonth: 'Próximo mes',
            selectYear: 'Selecciona año',
            prevYear: 'Año previo',
            nextYear: 'Próximo año',
            selectDecade: 'Selecciona década',
            prevDecade: 'Década previa',
            nextDecade: 'Próxima década',
            prevCentury: 'Siglo previo',
            nextCentury: 'Próximo siglo'
        }
    }).show().on("dp.change",function(e){
        $("#frmTiempos").bootstrapValidator('revalidateField', $("#fecha"));//Revalidamos el campo cada vez que cambie
    });
}

function cancelarGuardar(){
    var form = "#frmTiempos";
    $(form).bootstrapValidator('removeField',$("#fecha"));
    //Quitamos la fila que habíamos agregado a la tabla
    $("div.version:last").remove();
    //Mostramos los botones
    $("#btnAgregar").show();
    //Quitamos los botones
    $("#btnCancelar").hide();
    $("#btnSubmit").hide();
}

function cancelarEditar(){
    var form = "#frmTiempos";
    var etapa = $("#etapa").val();
    //Quitamos la validación
    $(form).bootstrapValidator('removeField',$("#fecha"));
    //Quitamos la fila que habíamos agregado a la tabla
    cargarVersiones(etapa);
    //Quitamos los botones
    $("#CancelarEdicion").hide();
    $("#SubmitEdicion").hide();
}
