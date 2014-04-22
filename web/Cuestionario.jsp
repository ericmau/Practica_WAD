<%-- 
    Document   : Cuestionario
    Created on : 20-abr-2014, 16:44:52
    Author     : eric
--%>

<%@page import="com.ipn.modelo.Beans.Materia"%>
<%@page import="com.ipn.modelo.Beans.Preguntas"%>
<%@page import="com.ipn.modelo.Beans.Respuestas"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.Session.ManejadorSesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ESCOM</title>

    <!-- Core CSS - Include with every page -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="css/plugins/timeline/timeline.css" rel="stylesheet">

    <!-- SB Admin CSS - Include with every page -->
    <link href="css/sb-admin.css" rel="stylesheet">

</head>

<body>

    <div id="wrapper">

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Evaluaciones Online</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

        </nav>
        <!-- /.navbar-static-top -->

        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="ServletWAD?accion=inicio"><i class="fa fa-dashboard fa-fw"></i> Inicio</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Materias<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="ServletWAD?accion=materias">Lista de Materias</a>
                            </li>
                            <li>
                                <a href="morris.html">Evaluar</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-table fa-fw"></i> Reporte</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-edit fa-fw"></i> About</a>
                    </li>
                </ul>
                <!-- /#side-menu -->
            </div>
            <!-- /.sidebar-collapse -->
        </nav>
        <!-- /.navbar-static-side -->
        <%
            ManejadorSesiones sesion=new ManejadorSesiones();
            String nombre=sesion.returnName(request, response)
;
        %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Bienvenido <%=nombre%></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
                
            <!--<div id="page-wrapper">-->
            <div class="row">
                <div class="col-lg-12">
                    <%
                        Materia M=(Materia)request.getAttribute("mm");
                        String nombreMateria=M.getNombre();
                        int idMat=M.getIdMateria();
                    %>
                    <h1 class="page-header">Cuestionario <%=nombreMateria%> </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Conteste las siguientes preguntas para su evaluacion:
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form action="ServletWAD?accion=finalizado&mat=<%=idMat%>" method="POST">
                                        <%
                                            List<Preguntas> preguntas=(List<Preguntas>)request.getAttribute("preguntas");
                                            int cont=1;
                                            for(Preguntas p: preguntas)
                                                {
                                                    String PREG=p.getPregunta();
                                                    String R1=p.getRespuesta().getRespuestaA();
                                                    String R2=p.getRespuesta().getRespuestaB();
                                                    String R3=p.getRespuesta().getRespuestaC();
                                        %>
                                        <div class="form-group">
                                            <label><%=PREG%></label>
                                            <select name="seleccion<%=cont%>" id="seleccion" class="form-control">
                                                <option value="a"><%=R1%></option>
                                                <option value="b"><%=R2%></option>
                                                <option value="c"><%=R3%></option>
                                            </select>
                                        </div>
                                        <% cont++;}  %>
                                        <center>
                                        <button type="submit" class="btn btn-default">Finalizar</button>
                                        </center>
                                    </form>
                                </div>
                                
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        <!--</div>-->
        <!-- /#page-wrapper -->
            
               
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->

    <!-- Core Scripts - Include with every page -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Page-Level Plugin Scripts - Dashboard -->
    <script src="js/plugins/morris/raphael-2.1.0.min.js"></script>
    <script src="js/plugins/morris/morris.js"></script>

    <!-- SB Admin Scripts - Include with every page -->
    <script src="js/sb-admin.js"></script>

    <!-- Page-Level Demo Scripts - Dashboard - Use for reference -->
    <script src="js/demo/dashboard-demo.js"></script>

</body>

</html>
