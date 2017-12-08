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

function checkCart() {
    var item = $('#body-carrinho tr');
    if (item.length > 0) {
        $('#if-cart-empty').hide();
        $('#finalizar').prop("disabled", false)
    } else {
        $('#if-cart-empty').show();
        $('#finalizar').prop("disabled", true)
    }
}

function creditCard() {
    $('.radio a[name=formaPagamento]').click(function () {
        if ($(this).attr('id') == 'cc') {
            $('#opcoes').show();
            $('#finalizar').prop("disabled", true)
            $("#opcoes :input").keyup(function () {
                if ($("#nomeImpresso").val() !== ""
                        && $("#numeroCartao").val() !== ""
                        && $("#codVerif").val() !== ""
                        && $("#dtVenc").val() !== "") {
                    $('#finalizar').prop("disabled", false)
                    checkCart();
                } else {
                    $('#finalizar').prop("disabled", true)
                }
            });
        } else if ($(this).attr('id') == 'boleto'){
            $('#opcoes').hide();
            $("#nomeImpresso").val("");
            $("#numeroCartao").val("");
            $("#codVerif").val("");
            $("#dtVenc").val("");
            $('#finalizar').prop("disabled", false)
            checkCart();
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
        var totalCompra = 0;
        
        if (valorDesconto == undefined) {
            subTotal.text('R$ ' + (valorNormal * qtd).toFixed(2));
        } else {
            subTotal.text('R$ ' + (valorDesconto * qtd).toFixed(2));
        }


        $('#tabela-carrinho > tbody  > tr').each(function () {
            var subTotal = $(this).find(".sub-total p.vlSubTotal").text();
            var total = 
            subTotal = subTotal.substring(3);
            subTotal = subTotal.replace(",", ".");
            debugger;
            totalCompra = (parseFloat(totalCompra) + parseFloat(subTotal));
            
            $('h3').html('Valor Total: R$ '+totalCompra);


        });


    });

    $('#codVerif').inputmask({"alias": "integer", mask: "9{3,3}"});
    $('#dtVenc').inputmask({"alias": "datetime", mask: "1/2/y", placeholder: "dd/mm/yyyy"});
    $('#numeroCartao').inputmask({"alias": "integer", mask: "9999 9999 9999 9999", placeholder: "____-____-____-____"});

    checkCart();
    creditCard();
});