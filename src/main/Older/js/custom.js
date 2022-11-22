let getUrlParameter = function getUrlParameter(sParam) {
    let sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
};

let errorRequiredFields = getUrlParameter('errorRequiredFields');

$(function(){
    $(".remove-btn").each(function () {
        $(this).on('click', function(e){
            e.preventDefault();
            e.stopImmediatePropagation();
            let removeLink = $(this).attr("href");
            if (confirm("Sei sicuro di voler rimuovere questo elemento?")) {
                location.href = removeLink;
            }
        });
    });

    $(".submit-form-buy").each(function(){
        $(this).on('click', function(e){
            e.preventDefault();
            e.stopImmediatePropagation();
            if (confirm("Sicuro di voler effettuare l'acquisto?")) {
                let formToSubmitSelector = $(this).attr("data-form-selector");
                $(formToSubmitSelector).submit();
            }
        });
    });

    // Controllo se ci sono errori nei campi obbligatori
    if (typeof errorRequiredFields != "undefined" && errorRequiredFields == "true") {
        alert("Attenzione! I campi Nome utente, Password, Nome, Cognome, Email sono obbligatori!");
    }

    $("#selectFilter").on('change',function(){
        $("#productOffersFilter").submit();
    });

    $("#remove-user").on('click', function(e){
        if (confirm('Sei sicuro? Eliminandoti come utente rimuoverai tutti i tuoi dati. Vuoi davvero continuare=')) {
            location.href = $(this).attr("href");
        }
    });
});

