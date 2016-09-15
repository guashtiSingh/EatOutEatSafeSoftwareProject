$(document).ready(function () {

    $('#loginModal').on('hidden.bs.modal', function (e) {
        window.location.reload();
    });

    $('#btnLogin').click(function() {

        $.ajax({
            type: "POST",
            url: "/login/Login.aspx",
            data: { "userId": $('#userId').val(), "pwd": $('#pwd').val() },
            dataType: "json",
            success: function (result) {
                $('#loginModal').modal('hide');

            },
            error: function (result) {
                alert(result.responseText);
                $('#loginModal').modal('hide');
            }

        });
        
    });

});