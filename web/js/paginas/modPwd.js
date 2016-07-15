/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    alert("caca");
    $('#mod_pwd_frm').bootstrapValidator({
        // message: 'Este valor no es permitido',
        fields: {
            old_pwd: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su contraseña actual'
                    },
                    stringLength: {
                        max: 60,
                        message: "Su contraseña no puede tener más de 60 caracteres."
                    }
                }
            },
            new_pwd: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su nueva contraseña'
                    },
                    stringLength: {
                        max: 60,
                        message: "Su nueva contraseña no puede tener más de 60 caracteres."
                    }
                }
            },
            new_pwd_rpt: {
                message: "Por favor, repita su contraseña para validarla",
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrede de nuevo su contraseña'
                    },
                    identical: {
                        field: "new_pwd",
                        message: "Las contraseñas no coinciden"
                    }
                }
            }
        }
    });
});
