(function(){
    $("#formagendamento").on("click",".js-confirm",function(){

        let botaoclicado = $(this)
        $("#btnsim").attr("data-id",botaoclicado.attr("data-id"))
        $("#modalagenda").modal("show")

        let input1 = document.getElementById("txtdata").value;
        let input2 = document.getElementById("txthora").value;
        let input3 = document.getElementById("txtdescricao").value;
    
        document.getElementById("modalbody").innerHTML = 
        "Dia: " + input1 + "<br>" + 
        "Hora: " + input2 + "<br>" + 
        "Descrição: " + input3;
    })

    
})()