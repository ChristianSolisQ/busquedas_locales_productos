
var local = [];

function init() {
    console.log("init()");
    setTimeout(actualizar, 1000);
    setTimeout(actualizar2, 1000);
}

function actualizar() {
    requestJSON(cargarTabla, "ServicioBuscarLocal");
    //setTimeout(addRowHandlers, 1000);
}
function actualizar2() {
    requestJSON(cargarTabla2, "ServicioBuscarProducto");
    //setTimeout(addRowHandlers, 1000);
}


function cargarTabla(datos) {
    var body = document.getElementById("datos");
    body.innerHTML = "";

    for (var i = 0; i < datos.Ventas.length; i++) {
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.id = "local_id";
        td.innerHTML = datos.Ventas[i].local_id;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "producto_codigo";
        td.innerHTML = datos.Ventas[i].producto_codigo;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "fecha";
        td.innerHTML = datos.Ventas[i].fecha;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "unidades_ventas";
        td.innerHTML = datos.Ventas[i].unidades_vendidas + "%";
        tr.appendChild(td);

        body.appendChild(tr);
    }
}
function cargarTabla2(datos2) {
    var body = document.getElementById("datos2");
    body.innerHTML = "";

    for (var i = 0; i < datos2.Ventas.length; i++) {
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.id = "local_id";
        td.innerHTML = datos2.Ventas[i].local_id;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "producto_codigo";
        td.innerHTML = datos2.Ventas[i].producto_codigo;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "fecha";
        td.innerHTML = datos2.Ventas[i].fecha;
        tr.appendChild(td);

        td = document.createElement("td");
        td.id = "unidades_ventas";
        td.innerHTML = datos2.Ventas[i].unidades_vendidas + "%";
        tr.appendChild(td);

        body.appendChild(tr);
    }
}
//function addRowHandlers() {
//    var table = document.getElementById("tablaRes");
//    var rows = table.getElementsByTagName("tr");
//    for (i = 1; i < rows.length; i++) {
//        var currentRow = table.rows[i];
//        currentRow.onclick = function () {
//            this.remove();
//        }
//
//    }
//}

function save() {
    console.log("Cerrando la aplicación..");

    var table = document.getElementById("tablaRes");
    var rows = table.getElementsByTagName("tr");
    for (i = 1; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var tmp = [];
        for (j = 0; j < currentRow.childElementCount; ++j) {
            tmp.push(currentRow.children[j].innerText);
        }
            var datos = {
            local_id: tmp[0],
            producto_codigo: tmp[1],
            fecha: tmp[2],
            unidades_vendidas: tmp[3]
        };
        local.push(datos);
    }

    console.log(JSON.stringify(local));
    console.log("Salir");
    // localStorage.clear();
    localStorage.setItem("datos", JSON.stringify(local));
    
}

function save2() {
    console.log("Cerrando la aplicación..");

    var table = document.getElementById("tablaRes2");
    var rows = table.getElementsByTagName("tr");
    for (i = 1; i < rows.length; i++) {
        var currentRow = table.rows[i];
        var tmp = [];
        for (j = 0; j < currentRow.childElementCount; ++j) {
            tmp.push(currentRow.children[j].innerText);
        }
            var datos = {
            local_id: tmp[0],
            producto_codigo: tmp[1],
            fecha: tmp[2],
            unidades_vendidas: tmp[3]
        };
        local.push(datos);
    }

    console.log(JSON.stringify(local));
    console.log("Salir");
    // localStorage.clear();
    localStorage.setItem("datos2", JSON.stringify(local));
    
}
function cargar() {
    
    var tabla = document.getElementById("tablaLoc");
    tabla.innerHTML = "";
    
    var ls = localStorage.getItem("datos");
    console.log(ls);
    
    
    if (ls!== undefined && ls!== null) {
        local = JSON.parse(ls);
    }
    
    for (let i = 0; i < local.length; i++) {
        var tr = document.createElement("tr");
        
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        var td4 = document.createElement("td");
        td1.innerHTML = local[i].local_id;
        td2.innerHTML = local[i].producto_codigo;
        td3.innerHTML = local[i].fecha;
        td4.innerHTML = local[i].unidades_vendidas;
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tabla = document.getElementById("tablaLoc");
        tabla.appendChild(tr);
    }
}
function cargar2() {
    
    var tabla = document.getElementById("tablaLoc2");
    tabla.innerHTML = "";
    
    var ls = localStorage.getItem("datos2");
    console.log(ls);
    
    
    if (ls!== undefined && ls!== null) {
        local = JSON.parse(ls);
    }
    
    for (let i = 0; i < local.length; i++) {
        var tr = document.createElement("tr");
        
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        var td4 = document.createElement("td");
        td1.innerHTML = local[i].local_id;
        td2.innerHTML = local[i].producto_codigo;
        td3.innerHTML = local[i].fecha;
        td4.innerHTML = local[i].unidades_vendidas;
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tabla = document.getElementById("tablaLoc2");
        tabla.appendChild(tr);
    }
}
function clear() {
    localStorage.clear();
}

function requestJSON(callback, jsonFile) {
    fetch(jsonFile).then(
            (result) => {
        return result.json();
    }
    ).then(
            (data) => {
        callback(data);
    }
    );
}

