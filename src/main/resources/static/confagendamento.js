(function(){
    $("#formagendamento").on("click",".js-confirm",function(){

        let botaoclicado = $(this)
        $("#btnsim").attr("data-id",botaoclicado.attr("data-id"))
        $("#modalagenda").modal("show")

        let input1 = document.getElementById("txtdata").value;
        let input2 = document.getElementById("txthora").value;
        let input3 = document.getElementById("txtdescricao").value;
        let input4 = document.getElementById("txtcliente").value;
        let input5 = document.getElementById("txtpet").value;
        let input6 = document.getElementById("txtfuncionario").value;
        let input7 = document.getElementById("txtservico").value;
    
        document.getElementById("modalbody").innerHTML = 
        "Data: " + input1 + "<br>" + 
        "Hora: " + input2 + "<br>" + 
        "Descrição: " + input3 + "<br>" + 
        "Cliente ID: " + input4 + "<br>" + 
        "Pet ID: " + input5 + "<br>" + 
        "Funcionário ID: " + input6 + "<br>" + 
        "Serviço: " + input7 + "<br>";
    })

    
})()