const $divFormUpdate = document.querySelector(".formulario-modificar");
const $divFormDelete = document.querySelector(".formulario-eliminar");


 function SeleccionarModificar() {

                let table = document.getElementById("mitabla");

                for(let i =1; i<table.rows.length; i++)
                {

                    table.rows[i].onclick = function()
                    {
                        document.getElementById("idActualizar").value = this.cells[0].innerHTML;
                        document.getElementById("nameActulaizar").value = this.cells[3].innerHTML;
                        document.getElementById("descriptionActualizar").value = this.cells[4].innerHTML;
                    };

                }

                 $divFormUpdate.style.setProperty("display","block");

}


function SeleccionarEliminar() {

    let table = document.getElementById("mitabla");

    for(let i =1; i<table.rows.length; i++)
    {

        table.rows[i].onclick = function()
        {
            document.getElementById("idEliminar").value = this.cells[0].innerHTML;
            document.getElementById("nameEliminar").value = this.cells[3].innerHTML;
            document.getElementById("descriptionEliminar").value = this.cells[4].innerHTML;
        };

    }

    $divFormDelete.style.setProperty("display","block");

}

 function cancerlarVistaModificar() {
      $divFormUpdate.style.setProperty("display","none");
}

 function cancerlarVistaEliminar() {
      $divFormDelete.style.setProperty("display","none");
}
