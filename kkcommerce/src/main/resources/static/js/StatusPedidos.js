$(document).ready(function () {

    $('.comboStatus').change(function (e) {
        var carrinhoID = $(this).attr('carrinhoid');
        var status = $(this).val();
        debugger;
        $.ajax({
            url: "/kk-admin/AlterarStatusCarrinho",
            type: "POST",
            async: false,
            data: {
                carrinho_id: carrinhoID,
                status_id: status
            },
            success: function (response) {
                alert('Alterado com Sucesso!');
                location.href = '/kk-admin/status-pedidos';
            },
            error: function (xhr, status, error) {
                console.log(error);
            }
        });

    });
});
