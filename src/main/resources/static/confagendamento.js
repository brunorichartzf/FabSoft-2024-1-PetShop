(function(){
    $("#formcliente").on("click",".js-confirm",function(){

        let botaoclicado = $(this)
        $("#btnsim").attr("data-id",botaoclicado.attr("data-id"))
        $("#modalcliente").modal("show")

        let input1 = document.getElementById("txtdia").value;
        let input2 = document.getElementById("txthora").value;
        let input3 = document.getElementById("txtnome").value;
        let input4 = document.getElementById("txtpet").value;
        let input5 = document.getElementById("txtservico").value;
        document.getElementById("modalbody").innerHTML = 
        "Dia: " + input1 + "<br>" + 
        "Hora: " + input2 + "<br>" + 
        "Cliente: " + input3 + "<br>" + 
        "Pet: " + input4 + "<br>" + 
        "Serviço: " + input5;
    })

    
})()