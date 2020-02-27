<%-- 
Document   : newjsp
Created on : Jan 2, 2019, 2:26:52 PM
Author     : user
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Departments | Kiaalap - Kiaalap Admin Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- favicon
                    ============================================ -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
        <!-- Google Fonts
                    ============================================ -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
        <!-- Bootstrap CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Bootstrap CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- owl.carousel CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/owl.theme.css">
        <link rel="stylesheet" href="css/owl.transitions.css">
        <!-- animate CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- normalize CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- meanmenu icon CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/meanmenu.min.css">
        <!-- main CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/main.css">
        <!-- educate icon CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/educate-custon-icon.css">
        <!-- morrisjs CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/morrisjs/morris.css">
        <!-- mCustomScrollbar CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
        <!-- metisMenu CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
        <link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
        <!-- calendar CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
        <link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
        <!-- style CSS
                    ============================================ -->
        <link rel="stylesheet" href="style.css">
        <!-- responsive CSS
                    ============================================ -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- modernizr JS
                    ============================================ -->
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    </head>

    <body >
        <!--[if lt IE 8]>
                    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
        <!-- Start Left menu area -->
       <div class="left-sidebar-pro">
            <nav id="sidebar" class="">
                <div class="sidebar-header">
                    <a href="index"><img  style="max-height: 200px;max-width: 200px"  class="main-logo" src="img/logo/logo2.png" alt="" /></a>
                    <strong><a href="index"><img src="img/logo/logosn.png" alt="" /></a></strong>
                </div>
                <div class="left-custom-menu-adp-wrap comment-scrollbar">
                    <nav class="sidebar-nav left-sidebar-menu-pro">
                        <ul class="metismenu" id="menu1">





                            <li class="active">
                                <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class=" "></span> <span class="mini-click-non">Employees</span></a>
                                <ul class="submenu-angle" aria-expanded="false">
                                    <li><a title="Employees List" href="list_employees"><span class="mini-sub-pro">Employees List</span></a></li>
                                    <li><a title="Add Employee" href="add_employee_form"><span class="mini-sub-pro">Add Employees</span></a></li>
                                </ul>
                            </li>

                            <li >
                                <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class=" "></span> <span class="mini-click-non">Departments</span></a>
                                <ul class="submenu-angle" aria-expanded="false">
                                    <li><a title="Departments List" href="list_department"><span class="mini-sub-pro">Departments List</span></a></li>
                                    <li><a title="Add Departments" href="add_department_form"><span class="mini-sub-pro">Add Departments</span></a></li>
                                </ul>
                            </li>
                            
                               <li >
                                <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class=" "></span> <span class="mini-click-non">User</span></a>
                                <ul class="submenu-angle" aria-expanded="false">
                                    <li><a title="Departments List" href="list_user"><span class="mini-sub-pro">User List</span></a></li>
                                    <li><a title="Add Departments" href="add_user_form"><span class="mini-sub-pro">Add User</span></a></li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
        <!-- End Left menu area -->
        <!-- Start Welcome area -->
        <div class="all-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div  class="logo-pro">
                            <a href="index"><img class="main-logo" src="img/logo/logo.png" alt="" /></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-advance-area">
                <div class="header-top-area">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="header-top-wraper">
                                    <div class="row">
                                        <div style="text-align: center" class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                                            <span style="color: white;font-size: 25px;font-weight: 800">
                                                EMPLOYEE MANAGEMENT
                                            </span>
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                                            <div class="header-right-info">
                                                <ul class="nav navbar-nav mai-top-nav header-right-menu">


                                                    <li class="nav-item">
                                                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
                                                            <!--<img src="img/product/pro4.jpg" alt="" />-->
                                                            <span class="admin-name">${pageContext.request.remoteUser}</span>
                                                            <i class="fa fa-angle-down edu-icon edu-down-arrow"></i>
                                                        </a>
                                                        <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated zoomIn">

                                                        

                                                            <li><a href="logout"><span class="edu-icon edu-locked author-log-ic"></span>Log Out</a>
                                                            </li>
                                                        </ul>
                                                    </li>

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

<!--                <div class="breadcome-area">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="breadcome-list single-page-breadcome">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <div class="breadcome-heading">
                                                <form role="search" class="sr-input-func">
                                                    <input type="text" placeholder="Search..." class="search-int form-control">
                                                    <a href="#"><i class="fa fa-search"></i></a>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                            <ul class="breadcome-menu">
                                                <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                                </li>
                                                <li><span class="bread-blod">Departments</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
            </div>
              <div class="product-status mg-b-15">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="product-status-wrap drp-lst">
                                <h4>Employee List</h4> <span><a class="pd-setting-ed" href="reports?ReportName=employee_list.rptdesign&ReportFormat=pdf">download</a></span>
                                <div class="add-product">
                                    <a href="add_employee_form">Add Employee</a>
                                </div>
                                <div class="asset-inner">                          
                                    <table>
                                      
                                        <tr>
                                            <th>Id</th>
                                            <th>Employee Id</th>
                                            <th>Name</th>
                                            <th>Salary</th>
                                            <th>Address</th>                                        
                                            <th>Department Name</th>                                        
                                            <th>Setting</th>
                                            <th>download</th>
                                        </tr>                                 
                                        <c:forEach var="emp" items="${list}">   
                                            <tr> 
                                                 <td>${emp.id}</td>  
                                                <td>${emp.employeeId}</td>  
                                                <td>${emp.employeeName}</td>  
                                                <td>${emp.salary}</td>  
                                                <td>${emp.address}</td>  
                                                <td>${emp.department.departmentName}</td>  
                                                <td>
                                                    <a href="edit_employee_form?id=${emp.id}" data-toggle="tooltip" title="Edit" class="pd-setting-ed"    ><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a> &nbsp;
                                                    <a href="delete_employee?id=${emp.id}" data-toggle="tooltip" title="Trash" class="pd-setting-ed"  onclick="return confirm('Are you sure you want to delete?')"><i class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a>
                                              
                                                
                                                  
                                                    
                                                </td>
                                                
                                                <td>
                                                    
                                                     <span><a class="pd-setting-ed" href="reports?ReportName=employee_details.rptdesign&ReportFormat=pdf&NewParameter=${emp.id}">download</a></span>
                                                
                                                
                                                
                                                </td> 
                                              
                                                
                                                
                                            </tr>  
                                        </c:forEach> 
                                    </table>
                                </div>
                                <div class="custom-pagination">
                                    <nav aria-label="Page navigation example">
                                      <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                            <li class="page-item"><a class="page-link" href="list_employees?pageID=0">1</a></li>
                                            <li class="page-item"><a class="page-link" href="list_employees?pageID=10">2</a></li>
                                            <li class="page-item"><a class="page-link" href="list_employees?pageID=20">3</a></li>
                                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                       <div class="footer-copyright-area" 
                 style=" position: fixed;
                 width: 100%;
                 bottom: 0;
                  height: 10px"
                 >
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="footer-copy-right">
                                <p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- jquery
                    ============================================ -->
        <script src="js/vendor/jquery-1.12.4.min.js"></script>
        <!-- bootstrap JS
                    ============================================ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- wow JS
                    ============================================ -->
        <script src="js/wow.min.js"></script>
        <!-- price-slider JS
                    ============================================ -->
        <script src="js/jquery-price-slider.js"></script>
        <!-- meanmenu JS
                    ============================================ -->
        <script src="js/jquery.meanmenu.js"></script>
        <!-- owl.carousel JS
                    ============================================ -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- sticky JS
                    ============================================ -->
        <script src="js/jquery.sticky.js"></script>
        <!-- scrollUp JS
                    ============================================ -->
        <script src="js/jquery.scrollUp.min.js"></script>
        <!-- mCustomScrollbar JS
                    ============================================ -->
        <script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/scrollbar/mCustomScrollbar-active.js"></script>
        <!-- metisMenu JS
                    ============================================ -->
        <script src="js/metisMenu/metisMenu.min.js"></script>
        <script src="js/metisMenu/metisMenu-active.js"></script>
        <!-- morrisjs JS
                    ============================================ -->
        <script src="js/sparkline/jquery.sparkline.min.js"></script>
        <script src="js/sparkline/jquery.charts-sparkline.js"></script>
        <!-- calendar JS
                    ============================================ -->
        <script src="js/calendar/moment.min.js"></script>
        <script src="js/calendar/fullcalendar.min.js"></script>
        <script src="js/calendar/fullcalendar-active.js"></script>
        <!-- plugins JS
                    ============================================ -->
        <script src="js/plugins.js"></script>
        <!-- main JS
                    ============================================ -->
        <script src="js/main.js"></script>
        <!-- tawk chat JS
                    ============================================ -->
        <!--<script src="js/tawk-chat.js"></script>-->
    </body>

</html>