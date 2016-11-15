<%-- 
    Document   : fileUploader
    Created on : 14/11/2016, 02:43:11 AM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FileUploader</title>
    </head>
    <body>
        <div >
            <div class="container-fluid">
                <!-- D&D Zone-->
                <div id="drag-and-drop-zone" class="uploader">
                    <div>Arrastra tus archivos multimedia</div>
                    <div class="or">-o-</div>
                    <div class="browser">
                        <label>
                            <span>Da clic aquí para abrir el explorador de archivos</span>
                            <input type="file" name="files" multiple="multiple" title='Clic para añadir archivos'>
                        </label>
                    </div>
                </div>
                <div id="drag-and-drop-info-alert" class="alert alert-warning">
                    <p class="text-center">
                        Los archivos no deben exceder de <strong>25MB </strong>. Los archivos deben ser <strong>imágenes, videos, audios, pdfs o documentos word</strong>. Los archivos con el mismo nombre serán <strong>sobrescritos</strong>.
                    </p>
                </div>
                <!-- /D&D Zone -->

                <!-- Debug box -->
                <div class="panel panel-default" style="display: none;" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Debug</h3>
                    </div>
                    <div class="panel-body demo-panel-debug">
                        <ul id="demo-debug">
                        </ul>
                    </div>
                </div>
                <!-- /Debug box -->

                <div class="panel panel-default" id="drag-and-drop-progress" style="display: none;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Archivos cargados</h3>
                    </div>
                    <div class="panel-body demo-panel-files" id='demo-files'>
                        <span class="demo-note">Ningun archivo ha sido seleccionado/soltado todavía...</span>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $('#drag-and-drop-zone').dmUploader({
                url: 'files/doUpload',
                fileName: "files",
//                maxFiles: 10,
                maxFileSize: 26214400, //25mb per file
                dataType: 'json',
                allowedTypes: '((image|audio|video)/*|application/pdf|application/msword|application/vnd.openxmlformats-officedocument.wordprocessingml.document|text/plain)',
//                textFilter: 'jpg;png;gif',
//                onInit: function () {
//                 $.danidemo.addLog('#demo-debug', 'default', 'Plugin initialized correctly');
//                 },
                onFallbackMode: function (message) {
                    $.danidemo.addLog('#demo-debug', 'info', 'El navegador no soporta esta tecnología: ' + message);
                },
                onNewFile: function (id, file) {
                    $.danidemo.addFile('#demo-files', id, file);
                },
                onBeforeUpload: function (id) {
                    dialogFileUploader.setClosable(false);
                    $("#drag-and-drop-zone").hide();
                    $("#drag-and-drop-info-alert").hide();
                    $("#drag-and-drop-progress").show();
                    dialogFileUploader.setClosable(false);
                    dialogFileUploader.enableButtons(false);

                    $.danidemo.addLog('#demo-debug', 'default', 'Empezando la subida de #' + id);

                    $.danidemo.updateFileStatus(id, 'default', 'Subiendo archivo...');
                },
                onComplete: function () {
                    $.danidemo.addLog('#demo-debug', 'default', 'Todos las trasferencias pendientes completas.');
                    dialogFileUploader.setClosable(true);
                    dialogFileUploader.enableButtons(true);
                    showAlert(true, "Archivo subidos con éxito");
                },
                onUploadProgress: function (id, percent) {
                    var percentStr = percent + '%';

                    $.danidemo.updateFileProgress(id, percentStr);
                },
                onUploadSuccess: function (id, data) {
                    $.danidemo.addLog('#demo-debug', 'success', 'Archivo #' + id + ' subido correctamente.');

                    $.danidemo.addLog('#demo-debug', 'info', 'Respuesta del servidor para archivo #' + id + ': ' + JSON.stringify(data));

                    $.danidemo.updateFileStatus(id, 'success', 'Archivo subido');

                    $.danidemo.updateFileProgress(id, '100%');
                },
                onUploadError: function (id, message) {
                    $.danidemo.updateFileStatus(id, 'error', message);

                    $.danidemo.addLog('#demo-debug', 'error', 'Fallo al subir el archivo #' + id + ': ' + message);
                },
                onFileTypeError: function (file) {
                    $.danidemo.addLog('#demo-debug', 'error', 'El archivo \'' + file.name + '\' no pudo ser subido: debe ser imagen, video, audio, pdf, o documento word.');
                },
                onFileSizeError: function (file) {
                    $.danidemo.addLog('#demo-debug', 'error', 'El archivo \'' + file.name + '\' no pudo ser subido: Excede de 25 MB.');
                },
                /*onFileExtError: function(file){
                 $.danidemo.addLog('#demo-debug', 'error', 'File \'' + file.name + '\' has a Not Allowed Extension');
                 },*/
//                onFilesMaxError: function (file) {
//                    $.danidemo.addLog('#demo-debug', 'error', 'El archivo  \'' + file.name + '\' no pudo ser subido: Máximo 10 archivos.');
//                }
            });
        </script>
    </body>
</html>
