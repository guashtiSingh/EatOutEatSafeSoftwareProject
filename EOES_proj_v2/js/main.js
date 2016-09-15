$(document).ready(function () {
    $("#search_location").change(function () {

        if ($("#search_location").is(':checked')) {
            //$(".form-control").fadeOut(500);
            var text = $(".form-control").attr("placeholder");
            text = text + " Or Location";
            $(".form-control").attr("placeholder", text);
            //$(".form-control").fadeIn(500);

        } else {
            var text = $(".form-control").attr("placeholder");
            text = text.replace(" Or Location", "");
            $(".form-control").attr("placeholder", text);
        }
    });

    $("#search_allergy").change(function () {

        if ($("#search_allergy").is(':checked')) {
            //$(".form-control").fadeOut(500);
            var text = $(".form-control").attr("placeholder");
            text = text + " Or Allergy";
            $(".form-control").attr("placeholder", text);
            //$(".form-control").fadeIn(500);

        } else {
            var text = $(".form-control").attr("placeholder");
            text = text.replace(" Or Allergy", "");
            $(".form-control").attr("placeholder", text);
        }
    });

    $("#search_food").change(function () {

        if ($("#search_food").is(':checked')) {
            //$(".form-control").fadeOut(500);
            var text = $(".form-control").attr("placeholder");
            text = text + " Or Food";
            $(".form-control").attr("placeholder", text);
            //$(".form-control").fadeIn(500);

        } else {
            var text = $(".form-control").attr("placeholder");
            text = text.replace(" Or Food", "");
            $(".form-control").attr("placeholder", text);
        }
    });

    $("#moreBtn").click(function () {

    });

});