$(document).ready(function () {
    $("#txtPesquisa").on("keyup", function () {
        var value = $(this).val().toLowerCase();

       $("#lista-produtos .produto").filter(function () {

            $(this).parent().toggle($(this).text().toLowerCase().indexOf(value) > -1)

        });
    });

});