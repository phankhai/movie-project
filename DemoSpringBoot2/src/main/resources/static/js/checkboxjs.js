$(document).ready(function() {

    //-------------CHECKBOX PHIM CHO RẠP
    //select all checkboxes
    $("#checkAll").change(function(){  //"select all" change
        var check_checkbox = $(this).prop("checked");
        // console.log(check_checkbox);
        $(".checkbox").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
    });

    //".checkbox" change
    $('.checkbox').change(function(){
        //uncheck "select all", if one of the listed checkbox item is unchecked
        if(false == $(this).prop("checked")){ //if this item is unchecked
            $("#checkAll").prop('checked', false); //change "select all" checked status to false
        }
        //check "select all" if all checkbox items are checked
        if ($('.checkbox:checked').length == $('.checkbox').length ){
            $("#checkAll").prop('checked', true);
        }
    });

    //select all checkboxes
    $("#checkAllRap").change(function(){  //"select all" change
        var check_checkbox = $(this).prop("checked");
        // console.log(check_checkbox);
        $(".checkboxrap").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
    });

    //".checkbox" change
    $('.checkboxrap').change(function(){
        //uncheck "select all", if one of the listed checkbox item is unchecked
        if(false == $(this).prop("checked")){ //if this item is unchecked
            $("#checkAllRap").prop('checked', false); //change "select all" checked status to false
        }
        //check "select all" if all checkbox items are checked
        if ($('.checkboxrap:checked').length == $('.checkboxrap').length ){
            $("#checkAllRap").prop('checked', true);
        }
    });
    //CHECKBOX PHIM CHO RẠP


    //---------------------CHECKBOX PHÒNG CHO RẠP
    //select all checkboxes
    $("#checkAllMovie").change(function(){  //"select all" change
        var check_checkbox = $(this).prop("checked");
        // console.log(check_checkbox);
        $(".checkmovie .checkbox-moviecinema").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
    });

    //".checkbox" change
    $('.checkmovie .checkbox-moviecinema').change(function(){
        //uncheck "select all", if one of the listed checkbox item is unchecked
        if(false == $(this).prop("checked")){ //if this item is unchecked
            $("#checkAllMovie").prop('checked', false); //change "select all" checked status to false
        }
        //check "select all" if all checkbox items are checked
        if ($('.checkmovie .checkbox-moviecinema:checked').length == $('.checkmovie .checkbox-moviecinema').length ){
            $("#checkAllMovie").prop('checked', true);
        }
    });

    //select all checkboxes
    $("#checkAllRoom").change(function(){  //"select all" change
        var check_checkbox = $(this).prop("checked");
        // console.log(check_checkbox);
        $(".checkroom .checkbox-room").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
    });

    //".checkbox" change
    $('.checkroom .checkbox-room').change(function(){
        //uncheck "select all", if one of the listed checkbox item is unchecked
        if(false == $(this).prop("checked")){ //if this item is unchecked
            $("#checkAllRoom").prop('checked', false); //change "select all" checked status to false
        }
        //check "select all" if all checkbox items are checked
        if ($('.checkroom .checkbox-room:checked').length == $('.checkroom .checkbox-room').length ){
            $("#checkAllRoom").prop('checked', true);
        }
    });

    //CHECKBOX PHÒNG CHO RẠP
})