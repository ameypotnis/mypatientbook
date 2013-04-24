$(function(){

    //attach autocomplete
    $("#name").autocomplete({

        //define callback to format results
        source: function(req, add){

            //pass request to server
            $.getJSON("http://localhost:8090/services/api/patients/Kunal", req, function(data) {

                //create array for response objects
                var suggestions = [];

                //process response
                $.each(data, function(i, val){
                    suggestions.push(val.firstname);
                });

                //pass array name callback
                add(suggestions);
            });
        },

        //define select handler
        select: function(e, ui) {

            //create formatted patient
            var patient = ui.item.value,
                span = $("<span>").text(patient),
                a = $("<a>").addClass("remove").attr({
                    href: "javascript:",
                    title: "Remove " + patient
                }).text("x").appendTo(span);

            //add patient to patient div
            span.insertBefore("#name");
        },

        //define select handler
        change: function() {

            //prevent 'name' field being updated and correct position
            $("#name").val("").css("top", 2);
        }
    });

    //add click handler to patients div
    $("#patients").click(function(){

        //focus 'to' field
        $("#name").focus();
    });

    //add live handler for clicks on remove links
    $(".remove", document.getElementById("patients")).live("click", function(){

        //remove current patient
        $(this).parent().remove();

        //correct 'name' field position
        if($("#patients span").length === 0) {
            $("#name").css("top", 0);
        }
    });
});