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
        var carrinhoID = $(this).attr('carrinhoid');

        debugger;
        $.ajax({
            url: "/kk-admin/AlterarStatusCarrinho",
            type: "POST",
            async: false,
            data: {
                carrinho_id: carrinhoID,
                status_id: 3
            },
            success: function (response) {
                debugger;
                alert('Despachado com Sucesso!')
            },
            error: function (xhr, status, error) {
                debugger;
                console.log(error);
            }
        });

    });
});
