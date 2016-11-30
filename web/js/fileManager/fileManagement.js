/* global RUTA, BootstrapDialog */

var dialogWait = new BootstrapDialog({
    title: 'Realizando acción',
    message: 'Por favor, espere...',
    closable: false
});

window.operateEvents = {
    'click .removeFile': function (e, value, row, index) {
        var extension = row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        BootstrapDialog.show({
            title: 'Confirmar acción',
            type: BootstrapDialog.TYPE_WARNING,
            message: '¿Estas seguro de eliminar el recurso: <strong>' + row.name + extension + '</strong> ?',
            buttons: [{
                    icon: 'glyphicon glyphicon-send',
                    label: 'Eliminar archivo',
                    cssClass: 'btn-warning',
                    autospin: true,
                    action: function (dialogRef) {
                        dialogRef.enableButtons(false);
                        dialogRef.setClosable(false);
                        dialogRef.getModalBody().html('Eliminando archivo...');
                        var tipo = 1;
                        if ($.trim(row.type) == "Referencia")
                            tipo = 0;
                        var data = JSON.stringify({
                            listFilesToDelete: [row.name + extension],
                            types: [tipo],
                            path: RUTA
                        });
                        console.log(data);
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
    },
    'click .downloadFile': function (e, value, row, index) {
        if ($.trim(row.type) == "Referencia")
        {
            window.open(row.name);
            return;
        }
        dialogWait.open();
        var extension = row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        var data = JSON.stringify({
            fileName: row.name + extension,
            path: RUTA
        });
        $.ajax({
            url: "filesJSON/downloadFile",
            data: data,
            dataType: 'json',
            contentType: 'application/json',
            type: 'POST',
            success: function (json) {
                window.open(json.filePreview);
                dialogWait.close();
            }
        }).fail(function () {
            showAlert(false, "Hubo un error al procesar su petición. Por favor, avise a los administradores.");
            dialogWait.close();
        });
    }
};

var dialogFileUploader = new BootstrapDialog({
    title: 'Subir archivos',
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

var dialogResourceUploader = new BootstrapDialog({
    title: 'Subir recurso',
    message: 'Ingrese el link: <input type="text" class="form-control">',
    onhide: function (dialogRef) {
        var resourceInput = dialogRef.getModalBody().find('input').val();
//        if ($.trim(resourceInput.toLowerCase()) !== 'banana') {
//            alert('Need banana!');
//            return false;
//        }
        $tableFiles.bootstrapTable('refresh');
    },
    buttons: [
        {
            label: 'Cerrar',
            action: function (dialogRef) {
                dialogRef.close();
            }
        }, {
            label: 'Subir',
            cssClass: 'btn-primary',
            autospin: true,
            action: function (dialogRef) {
                var resourceInput = dialogRef.getModalBody().find('input').val();
                dialogRef.enableButtons(false);
                dialogRef.setClosable(false);
                dialogRef.getModalBody().html('Subiendo recurso...');
                var data = JSON.stringify({
                    resourceToUpload: $.trim(resourceInput),
                    path: RUTA
                });
                $.ajax({
                    url: "filesJSON/resourceUploader",
                    data: data,
                    dataType: 'json',
                    contentType: 'application/json',
                    type: 'POST',
                    success: function (json) {
                        dialogRef.close();
                        showAlert(json.status, json.message);
                    }
                }).fail(function () {
                    dialogRef.close();
                    showAlert(false, "Hubo un error al procesar su petición. Por favor, avise a los administradores.");
                });
            }
        }
    ]
});

var $tableFiles = $('#tabla'),
        $removeFiles = $('#remove'),
        $zipFiles = $('#zipMe'),
        editOldValue;

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
            return pageNumber + " archivos por página";
        },
        formatShowingRows: function (pageFrom, pageTo, totalRows) {
            return "Mostrando " + pageFrom + " a " + pageTo + " de " + totalRows + " archivos";
        },
        formatNoMatches: function () {
            return "¡Esto se ve muy vacío! Actualiza tus filtros o agrega nuevos archivos";
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
        onLoadError: function (status, res) {
            showAlert(false, "Fallo al hacer conexión con servidor. Intenté mas tarde");
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
                    title: 'Renombrar recurso',
                    url: function (params) {
                        var data = $tableFiles.bootstrapTable('getData'),
                                index = $(this).parents('tr').data('index');
                        console.log(data[index].type);
                        var typeRow = data[index].type;
                        var tipoRecurso = 0, extension = ""; //0 is for links
                        if ($.trim(typeRow) != "Referencia")
                        {
                            tipoRecurso = 1;
                            extension = typeRow.substring(typeRow.indexOf("(") + 1, typeRow.indexOf(")"));
                        }

                        console.log(params.pk.toString() + extension);
                        console.log(params.value.toString() + extension);
                        var data = JSON.stringify({
                            fileToRename: params.pk.toString() + extension,
                            newName: params.value.toString() + extension,
                            type: tipoRecurso,
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
                                $tableFiles.bootstrapTable('refresh');
                            }
                        });
                    },
                    mode: "popup",
                    validate: function (value) {
                        if ($.trim(value) == '') {
                            return 'El recurso no puede estar sin nombre';
                        }
                        if ($.trim(editOldValue.type) == "Referencia")
                        {
                            //var urlRegex = /\(?(?:(http|https|ftp):\/\/)?(?:((?:[^\W\s]|\.|-|[:]{1})+)@{1})?((?:www.)?(?:[^\W\s]|\.|-)+[\.][^\W\s]{2,4}|localhost(?=\/)|\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})(?::(\d*))?([\/]?[^\s\?]*[\/]{1})*(?:\/?([^\s\n\?\[\]\{\}\#]*(?:(?=\.)){1}|[^\s\n\?\[\]\{\}\.\#]*)?([\.]{1}[^\s\?\#]*)?)?(?:\?{1}([^\s\n\#\[\]]*))?([\#][^\s\n]*)?\)?/gi;
                            //var urlRegex = /(https?|ftp):\/\/(-\.)?([^\s/?\.#-]+\.?)+(\/[^\s]*)?$@iS/;
                            var re_weburl = new RegExp(
                                    "^" +
                                    // protocol identifier
                                    "(?:(?:https?|ftp)://)" +
                                    // user:pass authentication
                                    "(?:\\S+(?::\\S*)?@)?" +
                                    "(?:" +
                                    // IP address exclusion
                                    // private & local networks
                                    "(?!(?:10|127)(?:\\.\\d{1,3}){3})" +
                                    "(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})" +
                                    "(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})" +
                                    // IP address dotted notation octets
                                    // excludes loopback network 0.0.0.0
                                    // excludes reserved space >= 224.0.0.0
                                    // excludes network & broacast addresses
                                    // (first & last IP address of each class)
                                    "(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])" +
                                    "(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}" +
                                    "(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))" +
                                    "|" +
                                    // host name
                                    "(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)" +
                                    // domain name
                                    "(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*" +
                                    // TLD identifier
                                    "(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))" +
                                    // TLD may end with dot
                                    "\\.?" +
                                    ")" +
                                    // port number
                                    "(?::\\d{2,5})?" +
                                    // resource path
                                    "(?:[/?#]\\S*)?" +
                                    "$", "i"
                                    );
                            if (!value.match(re_weburl)) {
                                return 'El recurso ingresado no es un link';
                            }
                        } else
                        {
                            if (!/^[^\\/:\*\?"<>\|]+$/.test(value)) {
                                return 'Los nombres de archivos no pueden contener los siguientes caracteres: \\ / : * ? < > | ';
                            }
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
                title: 'Tipo de recursos',
                sortable: true,
                align: 'center'
            }, {
                field: 'operate',
                title: 'Operaciones de recursos',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }
        ]
    }).on('editable-shown.bs.table', function (field, row, $el, editable) {
        editOldValue = $el;
    });

    $removeFiles.click(function () {
        var idElementsArray = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            return row.name + row.type.substring(row.type.indexOf("(") + 1, row.type.indexOf(")"));
        });
        var fileTypesArray = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            if ($.trim(row.type) == "Referencia")
                return 0;
            return 1;
        });
        var idRemove = $.map($tableFiles.bootstrapTable('getSelections'), function (row) {
            return row.name;
        });
        if (idElementsArray.length > 0)
            BootstrapDialog.show({
                title: 'Confirmar acción',
                message: '¿Eliminar <strong>' + idElementsArray.length + '</strong> recurso(s) seleccionado(s)?',
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
                                types: fileTypesArray,
                                path: RUTA
                            });
                            console.log(data);
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

    $zipFiles.click(function (e) {
        e.preventDefault();
        var idElementsArray = JSON.stringify($tableFiles.bootstrapTable('getData'));
        if (idElementsArray.length > 0)
        {
            window.location.href = 'zipFiles/zipMe?path=' + RUTA;
        }
    });

    dialogFileUploader.realize();
    dialogWait.realize();
    finalizar();
});

// -----------------------------------------------------------------------
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
        '<a class="removeFile" href="javascript:void(0)" title="Eliminar">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>  ',
        '<a class="downloadFile" href="javascript:void(0)" title="Vista Previa">',
        '<i class="glyphicon glyphicon-eye-open"></i>',
        '</a>'
    ].join('');
}

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
