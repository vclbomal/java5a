<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
</head>

<body>

<div class="container-fluid" id="dashboard">

    <div class="half">
        <div class="month">
            <p class="title"> 
            ${CurrentMonth} ${CurrentYear}</p>
            <p class="subtitle">MOOD OF THE MONTH</p>
        </div>

        <div class="details">
            <div class="mood">
                <div class="img-container">
                    <img src="img/1.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${mood1Count}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${mood1Pourc}"
                             aria-valuemin="0" aria-valuemax="100" style="width:${mood1Pourc}%">
                            <span class="">${mood1Pourc}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/2.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${mood2Count}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${mood2Pourc}"
                             aria-valuemin="0" aria-valuemax="100" style="width:${mood2Pourc}%">
                            <span class="">${mood2Pourc}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/3.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${mood3Count}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-neutral" role="progressbar" aria-valuenow="${mood3Pourc}"
                             aria-valuemin="0" aria-valuemax="100" style="width:${mood3Pourc}%">
                            <span class="">${mood3Pourc}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/4.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${mood4Count}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-midsuccess" role="progressbar" aria-valuenow="${mood4Pourc}"
                             aria-valuemin="0" aria-valuemax="100" style="width:${mood4Pourc}%">
                            <span class="">${mood4Pourc}%</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mood">
                <div class="img-container">
                    <img src="img/5.png" alt="super"/>
                </div>
                <div class="progress-bar-container">
                    <span class="desc">Vote count: ${mood5Count}</span>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${mood5Pourc}"
                             aria-valuemin="0" aria-valuemax="100" style="width:${mood5Pourc}%">
                            <span class="">${mood5Pourc}%</span>
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
                <img class="mood" src="img/4.png" alt=""/>
              </div>
              <div class="notation">
                  <p class="title">GLOBAL MOOD</p>
                  <span class="note">${moodAVG}</span>
                  <span class="note-on">/5</span>
              </div>
            </div>
        </div>

        <div class="comments">
            <h2 class="title">Comments</h2>
            <c:forEach var="moodComment" begin="0" end="4" items="${moodComment}" >
            <div class="comment-container">
                <div class="note">
                    <img class="mood" src="img/${moodComment.mood}.png" alt=""/>
                </div>
				    <div class="comment">
				    ${moodComment.comment} 
	                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>

</html>
