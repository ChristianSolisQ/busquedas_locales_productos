<%-- 
    Document   : index
    Created on : 09/06/2019, 01:07:02 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablas.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
   
       
    <body onload="init();">
        <div id="wrapper">
            <header>
               
            </header>
            <div id="contents">
            <form name="buscarloc"  method="POST" action="ServicioActualizar">
                    <table  class="tablaBuscar">
                        <%-- 
     Fecha inicial <input type="date" name="fec_ini">
                        Fecha final <input type="date" name="fec_fin">
--%>
                       <tr>
                       
                            <td> Numero de local </td>
                            <td>
                                <input type="text" name="id_local"  id="id_local" placeholder="Numero de local" />
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td colspan="2" style="text-align: center;">
                                <button type="submit" class="btn">Buscar</button>
                            </td>
                        </tr>
                    </table>
                       
                </form>
                <table class="tablaResultado" id="tablaRes">
                    <caption>
                        Ventas
                    </caption>
                    <thead>
                        <tr>
                            <td>
                                Id local
                            </td>
                            <td>
                                Codigo de producto
                            </td>
                            <td>
                               Fecha
                            </td>
                            <td>
                                Unidades ventas
                            </td>
                        </tr>
                    </thead>
                    <tbody id="datos">
                    </tbody>
                </table> 
                <button onclick="save()">
                    Guardar Local Storage
                </button>
                <button onclick="cargar()">
                    Cargar Local Storage
                </button>
                <button onclick="clear()">
                    Clear Local Storage
                </button>
                <table class="tablaLocal" id="tablaLoc">

                </table>
            </div>
            <div id="contents">
                <form name="BuscarForm" action="ServicioActualizarProducto"
                      method="POST">
                    <table class="tablaBuscar">
                       <tr>
                       
                            <td> Codigo producto </td>
                            <td>
                                <input type="text" name="codigo"  id="codigo" placeholder="Codigo del producto" />
                            </td>
                        </tr>
                       
                           <tr>
                            <td colspan="2" style="text-align: center;">
                                <button type="submit" class="btn">Buscar</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <table class="tablaResultado2" id="tablaRes2">
                    <caption>
                        Ventas
                    </caption>
                    <thead>
                        <tr>
                            <td>
                                Id local
                            </td>
                            <td>
                                Codigo de producto
                            </td>
                            <td>
                               Fecha
                            </td>
                            <td>
                                Unidades ventas
                            </td>
                        </tr>
                    </thead>
                    <tbody id="datos2">
                    </tbody>
                </table> 
                <button onclick="save2()">
                    Guardar Local Storage
                </button>
                <button onclick="cargar2()">
                    Cargar Local Storage
                </button>
                <button onclick="clear()">
                    Clear Local Storage
                </button>
                <table class="tablaLocal2" id="tablaLoc2">

                </table>
            </div>
            
            <footer>

            </footer>
        </div>
    </body>
</html>
