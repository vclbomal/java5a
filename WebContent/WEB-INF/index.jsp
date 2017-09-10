<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mood of the month</title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top container-fluid" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Mood of the month</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle navlink" data-toggle="dropdown" href="#">
                        <i class="fa fa-gear fa-fw"></i> Manage MOTMs <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="add_member"><i class="fa fa-user fa-fw"></i> Add member</a>
                        </li>
                        <li><a href="edit_motm"><i class="fa fa-calendar fa-fw"></i> Change MOTM Template</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Administration Panel</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">
                                    ${memberCount}
                                    </div>
                                    <div class="huge-label">Registered members</div>
                                </div>
                            </div>
                        </div>
                        <a href="add_member">
                            <div class="panel-footer">
                                <span class="pull-left">Add member</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-smile-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">
                                    ${motmCount}
                                    </div>
                                    <div class="huge-label">Moods Closed</div>
                                </div>
                            </div>
                        </div>
                        <a href="edit_motm">
                            <div class="panel-footer">
                                <span class="pull-left">Edit MOTM content</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="panel panel-blue">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tachometer fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Dashboard</div>
                                    <div class="huge-label">View & Export</div>
                                </div>
                            </div>
                        </div>
                        <a href="dashboard">
                            <div class="panel-footer">
                                <span class="pull-left">Show dashboard</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-user fa-fw"></i> Manage Members
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <c:forEach var="mood" items="${mood}" >
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/${mood.mood}.png" alt=""/>
                </div>
				    <div class="comment">
				    ${mood.comment} 
	                </div>
            </div>
            </c:forEach>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Birthdate</th>
                                                    <th class="text-right">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="member" items="${member}">
	                                            <form action="${pageContext.request.contextPath}/index" method="post">
	        										<tr>
	           											 </br><td >${member.name}</td>
	           											 <td>${member.mail}</td>
	           											 <td>${member.birth}</td>
	           											 <td  class="text-right">
	                                                       <a href="#" class="btn btn-sm btn-warning"><i class="fa fa-pencil"></i> Edit</a>
	                                                       <button type="submit" name="button1" value="${member.mail}">Button 1</button>
	                                                       
	                                                       <a href="index" type="submit" value="button1" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Remove</a>
	                                                   </td>
	     										    </tr>
	     										</form>
  										    </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="text-center">
                                            <ul class="pagination">
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-tachometer fa-fw"></i> Stats
                        </div>
                        <div class="panel-body" id="stats">

                            <div class="note">
                                ${moodAVGEver}<small>/5</small>
                                <p>Avg Mood</p>
                            </div>

                            <div class="details">
                                <div class="mood">
                                    <div class="img-container">
                                        <img src="img/1.png" alt="super"/>
                                    </div>
                                    <div class="progress-bar-container">
                                        <span class="desc">Vote count: ${mood1CountEver}</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${mood1PourcEver}"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood1PourcEver}%">
                                                <span class="">${mood1PourcEver}%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mood">
                                    <div class="img-container">
                                        <img src="img/2.png" alt="super"/>
                                    </div>
                                    <div class="progress-bar-container">
                                        <span class="desc">Vote count: ${mood2CountEver}</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${mood2PourcEver}"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood2PourcEver}%">
                                                <span class="">${mood2PourcEver}%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mood">
                                    <div class="img-container">
                                        <img src="img/3.png" alt="super"/>
                                    </div>
                                    <div class="progress-bar-container">
                                        <span class="desc">Vote count: ${mood3CountEver}</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-neutral" role="progressbar" aria-valuenow="${mood3PourcEver}"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood3PourcEver}%">
                                                <span class="">${mood3PourcEver}%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mood">
                                    <div class="img-container">
                                        <img src="img/4.png" alt="super"/>
                                    </div>
                                    <div class="progress-bar-container">
                                        <span class="desc">Vote count: ${mood4CountEver}</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-midsuccess" role="progressbar" aria-valuenow="${mood4PourcEver}"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood4PourcEver}%">
                                                <span class="">${mood4PourcEver}%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mood">
                                    <div class="img-container">
                                        <img src="img/5.png" alt="super"/>
                                    </div>
                                    <div class="progress-bar-container">
                                        <span class="desc">Vote count: ${mood5CountEver}</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${mood5PourcEver}"
                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood5PourcEver}%">
                                                <span class="">${mood5PourcEver}%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
							<%@ page import="java.time.LocalDate"%>
							 <%@  page import="java.time.Month"%>
							   <%   LocalDate date = LocalDate.now();
                            		Month month = date.getMonth();
                            		int year= date.getYear();%>
                            <a href="stats?month=<%=month%>&year=<%=year%>" class="btn btn-default btn-block">View more reports</a>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-cog fa-fw"></i> Settings
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table settings">
                                <tbody>
                                    <tr>
                                        <td>Mailing Date</td>
                                        <td>Last friday of each month</td>
                                    </tr>
                                    <tr>
                                        <td>Time </td>
                                        <td>10:00</td>
                                    </tr>
                                </tbody>
                            </table>
                            <table class="table editsettings hidden">
                                <tbody>
                                <tr>
                                    <td>Mailing Date</td>
                                    <td>
                                        <select name="date" class="form-control" id="senddate">
                                            <option value="1">Last friday of each month</option>
                                            <option value="2">Last office-day of each month</option>
                                            <option value="3">First monday of each month</option>
                                            <option value="4">First office-day of each month</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Time </td>
                                    <td><input type="text" class="form-control"></td>
                                </tr>
                                <tr><td colspan="2" align="right"><input type="submit" class="btn btn-sm btn-primary"></td></tr>
                                </tbody>
                            </table>

                            <!-- /.list-group -->
                            <a class="btn btn-default btn-block edit">Change Settings</a>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <footer class="footer">
        <div class="container">
            <div class="row text-center">
                Resourcepool &bullet; 2017
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery-3.1.1.min.js"></script>

    <!-- togggle.js -->
    <script src="js/toggle.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
