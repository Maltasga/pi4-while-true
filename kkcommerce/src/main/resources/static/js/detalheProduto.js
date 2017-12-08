$(document).ready(function () {
    $('#tamanho').change(function(){
        console.log($("#tamanho option:selected").attr("quant"));
        var quantidade = $("#tamanho option:selected").attr("quant");
        var inputQuant = $('input[name="qtde"]');
        inputQuant.prop('max', quantidade);
    });    
});


