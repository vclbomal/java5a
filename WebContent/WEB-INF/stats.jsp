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
        </nav>

        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Statistics</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1">
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-body" id="statistics">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div>
                                        <div class="dropdown pull-right selectbtn">
                                            <a class="dropdown-toggle btn btn-primary btn-lg" data-toggle="dropdown" href="#">
                                                <i class="fa fa-gear fa-fw"></i> Select month <i class="fa fa-caret-down"></i>
                                            </a>
                                            <ul class="dropdown-menu dropdown-user">
                                                <c:forEach var="moodStat" begin="0" end="9" items="${moodStat}" >
									            <li><a href="stats?month=${moodStat[0]}&year=${moodStat[1]}" id="choix" >${moodStat[0]} ${moodStat[1]} </a></li>
									            </c:forEach>									            
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="container-fluid" id="dashboard">
                                        <div class="half">
                                            <div class="month">
                                                <p class="title">${monthget} ${yearget}</p>
                                                <p class="subtitle">MOOD OF THE MONTH</p>
                                            </div>

                                            <div class="details">
                                                <div class="mood">
                                                    <div class="img-container">
                                                        <img src="img/1.png" alt="super"/>
                                                    </div>
                                                    <div class="progress-bar-container">
                                                        <span class="desc">Vote count: ${mood1CountStat}</span>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${mood1PourcStat}"
                                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood1PourcStat}%">
                                                                <span class="">${mood1PourcStat}%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="mood">
                                                    <div class="img-container">
                                                        <img src="img/2.png" alt="super"/>
                                                    </div>
                                                    <div class="progress-bar-container">
                                                        <span class="desc">Vote count:${mood2CountStat}</span>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${mood2PourcStat}"
                                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood2PourcStat}%">
                                                                <span class="">${mood2PourcStat}%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="mood">
                                                    <div class="img-container">
                                                        <img src="img/3.png" alt="super"/>
                                                    </div>
                                                    <div class="progress-bar-container">
                                                        <span class="desc">Vote count: ${mood3CountStat}</span>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-bar-neutral" role="progressbar" aria-valuenow="${mood3PourcStat}"
                                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood3PourcStat}%">
                                                                <span class="">${mood3PourcStat}%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="mood">
                                                    <div class="img-container">
                                                        <img src="img/4.png" alt="super"/>
                                                    </div>
                                                    <div class="progress-bar-container">
                                                        <span class="desc">Vote count: ${mood4CountStat}</span>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-bar-midsuccess" role="progressbar" aria-valuenow="${mood4PourcStat}"
                                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood4PourcStat}%">
                                                                <span class="">${mood4PourcStat}%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="mood">
                                                    <div class="img-container">
                                                        <img src="img/5.png" alt="super"/>
                                                    </div>
                                                    <div class="progress-bar-container">
                                                        <span class="desc">Vote count: ${mood5CountStat}</span>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${mood5PourcStat}"
                                                                 aria-valuemin="0" aria-valuemax="100" style="width:${mood5PourcStat}%">
                                                                <span class="">${mood5PourcStat}%</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="half-2">
                                            <div class="global">
                                                <div class="global-mood">
                                                    <div class="img-container">
                                                    <%  double avg = (double)getServletContext().getAttribute("moodAVGStat");  
										                int avgImg= (int)(avg+0.5);
										            %>
                                                        <img class="mood" src="img/<%= avgImg%>.png" alt=""/>
                                                    </div>
                                                    <div class="notation">
                                                        <p class="title">GLOBAL MOOD</p>
                                                        <span class="note">${moodAVGStat}</span>
                                                        <span class="note-on">/5</span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="comments">
                                                <h2 class="title">Comments</h2>
                                                <c:forEach var="moodCommentStat" begin="0" end="4" items="${moodCommentStat}" >
									            <div class="comment-container">
									                <div class="note">
									                    <img class="mood" src="img/${moodCommentStat.mood}.png" alt=""/>
									                </div>
													    <div class="comment">
													    ${moodCommentStat.comment} 
										                </div>
									            </div>
									            </c:forEach>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
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

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- CKEditor -->
    <script src="https://cdn.ckeditor.com/4.6.2/basic/ckeditor.js"></script>
    <script>
        CKEDITOR.replace('content');
    </script>

</body>

</html>
