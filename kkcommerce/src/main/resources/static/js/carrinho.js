function FinalizarCompras() {
    var arr = [];
    $("#body-carrinho tr").each(function () {
        var linha = $(this);
        var qtd = linha.find('.quantidade').val();
        var produtoID = linha.attr('produtoid');

        arr.push({id: produtoID, quantidade: qtd});
    });

    $.ajax({
        url: '/loja/finalizar-compra',
        type: 'post',
        data: {strCarrinho: JSON.stringify(arr)},
        success: function (result) {
            debugger;
            location.href = '/loja/protocolo?protocoloID=' + result;
        },
        error: function (xhr, status, error) {
            console.log(error);
        }
    });

}

$(document).ready(function () {
    $('#finalizar').click(function (e) {
        FinalizarCompras();
    });
});
