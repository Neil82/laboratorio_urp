/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var $jb = jQuery.noConflict();
/*var urlW = "http://localhost:8080";*/
var urlW = "http://adratech.myddns.me:8085";

$jb(function() {
	 
    $jb(document).on('click', '.divEliminarAula', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Aula?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarAula.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroAula.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    $jb(document).on('click', '.divEliminarDocente', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Docente?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarDocente.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroDocente.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    
    
    $jb(document).on('click', '.divEliminarEquipo', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Equipo?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarEquipo.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroEquipo.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    
    
    
    $jb(document).on('click', '.divEliminarAnio', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el A\u00F1o?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarAnio.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroAnio.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    
    
    
    $jb(document).on('click', '.divEliminarCurso', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Curso?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarCurso.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroCurso.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    
    
    
    $jb(document).on('click', '.divEliminarCursoSemestre', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Registro?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarCursoSemestre.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroCursoSemestre.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    $jb(document).on('click', '.divEliminarMarcacion', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de dar por culminada la Marcación?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/finalizarMarcacion.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroSalidaManual.htm?id="+id);
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
    
    
    $jb(document).on('click', '.divEliminarUsuario', function () {

        var id = $jb(this).attr('title');

        bootbox.confirm({
                message: "\u00BFSeguro de Eliminar el Usuario?",
                buttons: {
                        confirm: {
                                label: 'Si, Eliminar',
                                className: 'btn-success'
                        },
                        cancel: {
                                label: 'No, Cancelar',
                                className: 'btn-danger'
                        }
                },
                callback: function (result) {
                    console.log('This was logged in the callback: ' + result);

                    if (result === null) {

                    } else{
                        if (result){
                            
                            var dialog = bootbox.dialog({
                                message: '<p class="text-center">Procesando...</p>',
                                closeButton: false
                            });


                           $jb.ajax({
                                type: "GET",
                                url: urlW+"/urpControlLaboratorio/eliminarUsuario.htm?idusuario="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace(urlW+"/urpControlLaboratorio/maestroUsuario.htm");
                                        
                                },
                                error:function(){
                                    alert("ajax failed" +uname);
                                }
                            });    

                        }
                    }

                }
        });

    });
})

function showCursoSemestre() {
    var selAnio = $jb("#selAnio").val();
    var selSemestre = $jb("#selSemestre").val();

    if(selAnio!="-1" && selSemestre!="-1"){

        $jb('#txtHint').html("Procesando...");

        $jb.ajax({
            url : urlW+'/urpControlLaboratorio/maestroCursoSemestreAccion.htm?selAnio='+selAnio+"&selSemestre="+selSemestre,
            success : function(data) {
                $jb('#txtHint').html(data);
            }
        });

    }
}

function showHorario() {
    var selAnio = $jb("#selAnio").val();
    var selSemestre = $jb("#selSemestre").val();
    var selAula = $jb("#selAula").val();

    if(selAnio!="-1" && selSemestre!="-1" && selAula!="-1"){

        $jb('#txtHint').html("Procesando...");

        $jb.ajax({
            url : urlW+'/urpControlLaboratorio/maestroHorarioAccion.htm?selAnio='+selAnio+"&selSemestre="+selSemestre+"&selAula="+selAula,
            success : function(data) {
                $jb('#txtHint').html(data);
            }
        });

    }
}

function showMarcaciones() {
  
    var selDocente = $jb("#id_docente").val();

    if(selDocente!=""){

        $jb('#txtHint').html("Procesando...");

        $jb.ajax({
            url : urlW+'/urpControlLaboratorio/maestroSalidaManual_Accion.htm?selUsuarioDocente='+selDocente,
            success : function(data) {
                $jb('#txtHint').html(data);
            }
        });

    }
}