$(document).ready(function(){
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

$(document).ready(function(){
    var right = document.getElementById('right-display').clientHeight.toString();
    document.getElementById("left-display").style.height = right+"px";
    console.log(right);

});

