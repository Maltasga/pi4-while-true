function AlterarStatus() {

//    var arr = [];
//    $("#body-carrinho tr").each(function () {
//        var linha = $(this);
//        var qtd = linha.find('.quantidade').val();
//        var produtoID = linha.attr('produtoid');
//
//        arr.push({id: produtoID, quantidade: qtd});
//    });
//
//    $.ajax({
//        url: '/loja/finalizar-compra',
//        type: 'post',
//        data: {strCarrinho: JSON.stringify(arr)},
//        success: function (result) {
//            debugger;
//            location.href = '/protocolo?protocoloID='+result;
//        },
//        error: function (xhr, status, error) {
//            console.log(error);
//        }
//    });

}


//
//$("input[name='principal']").on("click", function () {
//                    var self = $(this);
//
//                    $.ajax({
//                        url: "/loja/set-principal-address",
//                        type: "POST",
//                        async: false,
//                        data: {
//                            id: self.attr("enderecoid"),
//                            clienteId: self.attr("clienteid")
//                        },
//                        success: function (response) {
//                            if (response === "ok") {
//                                var filtroNot = "[enderecoid='" + self.attr("enderecoid") + "']";
//                                $("input[name='principal']").not(filtroNot).prop("checked", false);
//                            }
//                        }
//                    });
//                });


$(document).ready(function () {
    $('#faturar').click(function (e) {
        var carrinhoID = $(this).attr('carrinhoid');
        
        debugger;
        $.ajax({
            url: "/kk-admin/AlterarStatusCarrinho",
            type: "POST",
            async: false,
            data: {
                carrinho_id: carrinhoID,
                status_id: 2
            },
            success: function (response) {
                debugger;
                alert('Faturdo com Sucesso!')
            },
            error: function (xhr, status, error) {
                debugger;
                console.log(error);
            }
        });

    });
    $('#despachar').click(function (e) {
        var self = $(this);

        $.ajax({
            url: "/kk-admin/AlterarStatusCarrinho",
            type: "POST",
            async: false,
            data: {
                id: self.attr("carrinhoid"),
                status_id: 3
            },
            success: function (response) {
                alert('Despachado com Sucesso!')
            },
            error: function (xhr, status, error) {
                debugger;
                console.log(error);
            }
        });
    });
});
