$(document).ready(function () {
    $('.quantidade').click(function () {
        var valor = (parseFloat($(this).attr('valor')) * $(this).val()).toFixed(2);
        $('span[produtoID="' + $(this).attr('produtoID') + '"]').text(valor);
    });
});
