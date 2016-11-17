/* global RUTA */

var dialogFileUploader = new BootstrapDialog({
    title: 'Subir Archivos',
    cssClass: 'best-position',
    message: function (dialog) {
        var $message = $('<div></div>');
        var pageToLoad = dialog.getData('pageToLoad');
        $message.load(pageToLoad);
        return $message;
    },
    buttons: [{
            label: 'Cerrar',
            action: function (dialogRef) {
                dialogRef.close();
            }
        }],
    data: {
        'pageToLoad': 'addFilesPlugin'
    }, onhide: function () {
        $tableFiles.bootstrapTable('refresh');
    }
});

var dialogWait = new BootstrapDialog({
    title: 'Ejecutando acción...',
    message: 'Por favor, espere...',
    closable: false,
    buttons: [{
            cssClass: 'btn-primary',
            autospin: true
        }]

});


var $tableFiles = $('#tabla'),
        $removeFiles = $('#remove'),
        $zipFiles = $('#zipMe');

$(document).ready(function () {
    cargando();
    $tableFiles.bootstrapTable({
        height: getHeight(),
        method: 'GET',
        queryParams: function (params) {
            params["path"] = RUTA;
            return params;
        },
        formatSearch: function () {
            return "Buscar...";
        },
        formatRecordsPerPage: function (pageNumber) {
            return pageNumber + " registros por página";
        },
        formatShowingRows: function (pageFrom, pageTo, totalRows) {
            return "Mostrando " + pageFrom + " a " + pageTo + " de " + totalRows + " registros";
        },
        formatNoMatches: function () {
            return "¡Esto se ve muy vacío! Agrega nuevos archivos o actualiza tus filtros";
        },
        formatLoadingMessage: function () {
            return "Cargando archivos, por favor espere...";
        },
        formatRefresh: function () {
            return "Actualizar archivos";
        },
        formatColumns: function ()
        {
            return "Columnas";
        },
        columns: [
            {
                checkbox: true,
                align: 'center'
            }, {
                title: 'Nombre',
                field: 'name',
                align: 'center',
                sortable: true,
                editable: {
                    type: 'text',
                    placeholder: 'Nuevo nombre...',
                    title: 'Renombrar archivo',
                    url: function (params) {
                        var data = $tableFiles.bootstrapTable('getData'),
                                index = $(this).parents('tr').data('index');
                        console.log(data[index].type);
                        var typeRow = data[index].type;
                        var extension = typeRow.substring(typeRow.indexOf("(") + 1, typeRow.indexOf(")"));
                        var data = JSON.stringify({
                            fileToRename: params.pk.toString() + extension,
                            newName: params.value.toString() + extension,
                            path: RUTA
                        });
                        $.ajax({
                            url: "filesJSON/renameFiles",
                            data: data,
                            dataType: 'json',
                            contentType: 'application/json',
                            type: 'POST',
                            success: function (json) {
                                showAlert(json.status, json.message);
                            }
                        });
                    },
                    mode: "popup",
                    validate: function (value) {
                        if (!value) {
                            return 'El archivo no puede estar sin nombre';
                        }
                        if (!/^[^\\/:\*\?"<>\|]+$/.test(value)) {
                            return 'Los nombres de archivos no pueden contener los siguientes caracteres: \\ / : * ? < > | ';
                        }
                    }
                }
            },
            {
                field: 'size',
                title: 'Tamaño',
                sortable: true,
                align: 'center'
            }, {
                field: 'type',
                title: 'Tipo de Archivo',
                sortable: true,
                align: 'center'
            }
//            , {
//                field: 'operate',
//                title: 'Operaciones a archivo',
//                align: 'center',
//                formatter: operateFormatter
//            }
        ]
    });

    $removeFiles.click(function () {
        var idElementsArray = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            return row.name + row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        });
        var idRemove = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            return row.name;
        });
        if (idElementsArray.length > 0)
            BootstrapDialog.show({
                title: 'Confirmar acción',
                message: '¿Eliminar <strong>' + idElementsArray.length + '</strong> archivo(s) seleccionado(s)?',
                type: BootstrapDialog.TYPE_WARNING,
                buttons: [{
                        label: 'Confirmar',
                        cssClass: 'btn-warning',
                        autospin: true,
                        action: function (dialogRef) {
                            dialogRef.enableButtons(false);
                            dialogRef.setClosable(false);
                            dialogRef.getModalBody().html('Eliminando archivos...');
                            var data = JSON.stringify({
                                listFilesToDelete: idElementsArray,
                                path: RUTA
                            });
                            console.log(idElementsArray);
                            $.ajax({
                                url: "filesJSON/deleteFiles",
                                data: data,
                                dataType: 'json',
                                contentType: 'application/json',
                                type: 'POST',
                                success: function (json) {
                                    $tableFiles.bootstrapTable('remove', {
                                        field: 'name',
                                        values: idRemove
                                    });
                                    dialogRef.close();
                                    showAlert(json.status, json.message);
                                }
                            }).fail(function () {
                                dialogRef.close();
                                showAlert(false, "Hubo un error al procesar su petición. Por favor, avise a los administradores.");
                            });
                        }
                    }, {
                        label: 'Cancelar',
                        action: function (dialogRef) {
                            dialogRef.close();
                        }
                    }]
            });
    });

    $zipFiles.click(function () {
        var idElementsArray = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            return row.name + row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        });

        if (idElementsArray.length > 0)
        {
            dialogWait.open();
            $.ajax({
                url: "zipFiles/zipMe",
                data: $.param({path: RUTA}),
                type: 'POST',
                success: function (){
                    dialogWait.cloe();
                }
            }).fail(function () {
                dialogRef.close();
                showAlert(false, "Hubo un error al procesar su petición. Por favor, avise a los administradores.");
            });
        }
    });

    dialogFileUploader.realize();
    dialogWait.realize();
    finalizar();
});
function getHeight() {
    var columnas = $("#tabla tr").length;
    var y = $('.fixed-table-container');
    if (columnas > 11) {
        return $(window).height() - ($('.fixed-table-toolbar').outerHeight(true) + $("#contenedor1").outerHeight(true) + $("#button-group").outerHeight(true) + 14) * 2.7;
        //return (($(window).height() * 3) / 4);// - $("#contenedor1").outerHeight(true);
    } else {
        return y.outerHeight(true);
    }
}

function operateFormatter(value, row, index) {
    return [
        '<a class="removeFile" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}
window.operateEvents = {
    'click .removeFile': function (e, value, row, index) {
        var extension = row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        BootstrapDialog.show({
            title: 'Confirmar acción',
            type: BootstrapDialog.TYPE_WARNING,
            message: '¿Estas seguro de eliminar el archivo: <strong>' + row.name + extension + '</strong> ?',
            buttons: [{
                    icon: 'glyphicon glyphicon-send',
                    label: 'Eliminar archivo',
                    cssClass: 'btn-warning',
                    autospin: true,
                    action: function (dialogRef) {
                        dialogRef.enableButtons(false);
                        dialogRef.setClosable(false);
                        dialogRef.getModalBody().html('Eliminando archivo...');
                        var data = JSON.stringify({
                            listFilesToDelete: [row.name + extension],
                            path: RUTA
                        });
                        console.log(row.name + extension);
                        $.ajax({
                            url: "filesJSON/deleteFiles",
                            data: data,
                            dataType: 'json',
                            contentType: 'application/json',
                            type: 'POST',
                            success: function (json) {
                                $tableFiles.bootstrapTable('removeByUniqueId', row.name);
                                dialogRef.close();
                                showAlert(json.status, json.message);
                            }
                        }).fail(function () {
                            dialogRef.close();
                            showAlert(false, "Hubo un error al procesar su petición. Por favor, avise a los administradores.");
                        });
                    }
                }, {
                    label: 'Cancelar',
                    action: function (dialogRef) {
                        dialogRef.close();
                    }
                }]
        });
    }
};

function showAlert(status, message) {
    if (status) {
        bootstrap_alert.success("#alert_placeholder", message);
    } else {
        bootstrap_alert.danger("#alert_placeholder", message);
    }
}

bootstrap_alert = function () {};
bootstrap_alert.danger = function (id, message) {
    $(id).html('<div class="alert alert-danger fade in">\n' +
            '                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>\n' +
            '                <p> <strong> Error: </strong>' + message + ' </p>\n' +
            '            </div>');
};
bootstrap_alert.success = function (id, message) {
    $(id).html('<div class="alert alert-success fade in">\n' +
            '                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>\n' +
            '                <p> <strong> Éxito: </strong>' + message + ' </p>\n' +
            '            </div>');
};
