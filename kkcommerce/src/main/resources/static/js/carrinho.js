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

    $(document.body).on('click', '.quantidade', function () {
        var qtd = $(this).val();
        var tr = $(this).parent().parent().parent();
        var valorDesconto = tr.find("p.vlDesconto").attr("valorDesconto");
        var valorNormal = tr.find("p.vlNormal").attr("valorNormal");
        var subTotal = tr.find(".sub-total p");

        if (valorDesconto == undefined) {
            subTotal.text('R$ '+(valorNormal * qtd).toFixed(2));
        } else {
            subTotal.text('R$ '+(valorDesconto * qtd).toFixed(2));
        }

    });
});
