/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var $jb = jQuery.noConflict();

$jb(function() {
	 
    $jb(document).on('click', '.divEliminarAula', function () {

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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarAula.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroAula.htm");
                                        
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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarDocente.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroDocente.htm");
                                        
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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarEquipo.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroEquipo.htm");
                                        
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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarAnio.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroAnio.htm");
                                        
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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarCurso.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroCurso.htm");
                                        
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
                                url: "http://localhost:8080/urpControlLaboratorio/eliminarCursoSemestre.htm?id="+id,
                                success: function(msg){

                                    dialog.modal('hide');
                                    window.location.replace("http://localhost:8080/urpControlLaboratorio/maestroCursoSemestre.htm");
                                        
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
            url : 'http://localhost:8080/urpControlLaboratorio/maestroCursoSemestreAccion.htm?selAnio='+selAnio+"&selSemestre="+selSemestre,
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
            url : 'http://localhost:8080/urpControlLaboratorio/maestroHorarioAccion.htm?selAnio='+selAnio+"&selSemestre="+selSemestre+"&selAula="+selAula,
            success : function(data) {
                $jb('#txtHint').html(data);
            }
        });

    }
}