<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ResDetails.aspx.cs" Inherits="restaurants_ResDetails" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <link rel="stylesheet" href="/css/main.css" />
    <link rel="stylesheet" href="/css/bootstrap.css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <link href="/css/docs.min.css" rel="stylesheet"/>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <br />
 
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">

        <!-- MenuList - Modal -->
        <div id="menuModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Find menus of restaurant</h4>
                    </div>
                    <div class="modal-body">
                        <div>
				            <!-- Nav tabs -->
				            <ul class="nav nav-tabs" role="tablist">
					            <li role="presentation" class="active re_tab"><a href="#all" aria-controls="pupular" role="tab" data-toggle="tab">ALL</a></li>
					            <li role="presentation" class="re_tab"><a href="#special" aria-controls="allergies" role="tab" data-toggle="tab">SPECIAL</a></li>
				            </ul>
				            <!-- Tab panes -->
				            <div class="tab-content">
					            <div role="tabpanel" class="tab-pane fade in active" id="all">
						            <div class="table-responsive content"> 

                                        <!-- list title -->
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <h4 class="page-header">ALL Menus
                                                    <small>check out all menus!!</small>
                                                </h4>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <table class="table table-striped">
                                                <!-- list content -->
                                                <asp:Repeater ID="Repeater1" runat="server">
                                                    <ItemTemplate>
                                                        <!-- list content -->
                                                        <tr class="menuList">
                                                            <td>
                                                                <a data-toggle="tooltip" data-html="true" data-placement="<% if (menuListCount % 2 == 0) Response.Write("left"); else Response.Write("right"); %>" 
                                                                title="<img src='<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>' />"   
                                                                data-delay='{ "hide": 1000 }'> 
                                                                    <img class="img-responsive" src="<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>" alt="">
                                                                </a>
                                                            </td>
                                                            <td>
                                                                <h5><%# Eval("Menu_Name") %></h5>
                                                            </td>
                                                            <td>
                                                                $<%# Eval("Menu_Price") %></td>
                                                            <td>
                                                                <span class='keyword'><%# Eval("AC_Name") %></span>
                                                            </td>
                                                            <td>
                                                                <h6><%# Eval("Menu_Description") %></h6>
                                                            </td>
                                                        </tr>
                                                        <% menuListCount = menuListCount + 1; %>
                                                    </ItemTemplate>
                                                </asp:Repeater>
                                            </table>
                                        </div>
                                    </div>
					            </div>
					            <div role="tabpanel" class="tab-pane fade" id="special">
                                    <div class="table-responsive content"> 

                                        <!-- list title -->
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <h3 class="page-header">Special Menus
                                                    <small>check out special menus!!</small>
                                                </h3>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <table class="table table-striped">
                                                <!-- list content -->
                                                <asp:Repeater ID="Repeater2" runat="server">
                                                    <ItemTemplate>
                                                        <!-- list content -->
                                                        <tr class="menuList">
                                                            <td>
                                                                <a data-toggle="tooltip" data-html="true" data-placement="<% if (menuListCount % 2 == 0) Response.Write("left"); else Response.Write("right"); %>" 
                                                                title="<img src='<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>' />"   
                                                                data-delay='{ "hide": 1000 }'> 
                                                                    <img class="img-responsive" src="<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>" alt="">
                                                                </a>
                                                            </td>
                                                            <td>
                                                                <h5><%# Eval("Menu_Name") %></h5>
                                                            </td>
                                                            <td>
                                                                $<%# Eval("Menu_Price") %></td>
                                                            <td>
                                                                <span class='keyword'><%# Eval("AC_Name") %></span>
                                                            </td>
                                                            <td>
                                                                <h6><%# Eval("Menu_Description") %></h6>
                                                            </td>
                                                        </tr>
                                                        <% menuListCount = menuListCount + 1; %>
                                                    </ItemTemplate>
                                                </asp:Repeater>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

          <div class="row">
              <div class="col-xs-11 col-md-7">

                <!-- Restaruange detials -->
                <asp:FormView ID="resDeatilView" runat="server" Width="100%">
                    <ItemTemplate>
                        <h1><%# Eval("Res_Name") %></h1>
                        <p class="lead blog-description">Location: <%# Eval("LocationName") %>, <%# Eval("province") %> 
                            
                            <a data-toggle="tooltip" data-html="true" data-placement="right" 
                                title="<%# Eval("Location_Embed") %>"   
                                data-delay='{ "hide": 2000 }' class="mapTooltip"> 
                                <img src="/images/site_img/googleMap.png" class="ico"/>
                            </a>
                            
                        </p>
                        <p class="lead blog-description">Category: <%# Eval("ResCategory") %></p>
                        <br /><br />
                        <p><%# EOES_ClassLib.Utilities.RenderTextBr(Eval("Res_Description").ToString()) %></p>
                        <p><a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#menuModal">Check the Menu &raquo;</a>
                        </p>
                     </ItemTemplate>
                </asp:FormView>   

              </div>
              <div class="col-xs-7 col-md-5">
                  <br /><br />
                       <!-- Carousel Image slide
                            ================================================== -->
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">

                              <div class="carousel-inner" role="listbox">
                                   <asp:Repeater ID="imgListView" runat="server">
                                      <ItemTemplate>
                                          <div class="<%# GetDivClass(Convert.ToInt32(Eval("rowNo").ToString()),"div") %>">
                                              <img class="<%# GetDivClass(Convert.ToInt32(Eval("rowNo").ToString()),"img") %>-slide" src="<%# Eval("Img_Path") %>/<%# Eval("Img_Name") %>" alt="<%# GetDivClass(Convert.ToInt32(Eval("rowNo").ToString()),"div") %> slide">
                                           </div>
                                      </ItemTemplate>
                                  </asp:Repeater>
                              </div>
                              <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                            </div><!-- /.carousel -->

              </div>
          </div>
                
       </div> 
    </div>
    <div class="container">

        <div class="page-header">
            <h1>Customer Reviews</h1>
            <br />


            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <h4><a data-toggle="collapse" href="#collapse1">Share your experience at this place!</a></h4>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">


                        <asp:scriptmanager id="ScriptManager1" runat="server"></asp:scriptmanager>

                        <asp:updatepanel id="upnlForm" runat="server" UpdateMode="Conditional">
                            <ContentTemplate>
                                <div style="padding-left:20px;padding-right:20px">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label for="reviewTitle">Title</label> <asp:TextBox ID="reviewTitle" CssClass="form-control" placeholder="Review Title" runat="server" required></asp:TextBox>
                                        </div>
                                        <div class="form-group">
                                            <label for="reviewRate">Rate</label> &nbsp;&nbsp;&nbsp;
                                            <asp:DropDownList ID="reviewRate" runat="server" class="c-select" required>
                                                <asp:ListItem Value="5" Text="★★★★★"></asp:ListItem>
                                                <asp:ListItem Value="4" Text="★★★★☆"></asp:ListItem>
                                                <asp:ListItem Value="3" Text="★★★☆☆"></asp:ListItem>
                                                <asp:ListItem Value="2" Text="★★☆☆☆"></asp:ListItem>
                                                <asp:ListItem Value="1" Text="★☆☆☆☆"></asp:ListItem>
                                                <asp:ListItem Value="0" Text="☆☆☆☆☆"></asp:ListItem>
                                            </asp:DropDownList>
                                        </div>
                                        <div class="form-group">
                                            <label for="reviewContent">Content</label> <asp:TextBox ID="reviewContent" TextMode="MultiLine" rows="8" CssClass="form-control" placeholder="Review Content" runat="server" required></asp:TextBox>
                                        </div>
                                        <asp:Button ID="btnSubmit" class="btn btn-primary" runat="server" Text="Save" OnClick="btnSubmit_Click" />
                                        <!--<button type="button" class="btn btn-primary">Save</button>-->
                                    </div>
                                </div>
                            </ContentTemplate>
                        </asp:updatepanel>
                    </div>
                </div>
            </div>

        </div>

        <asp:UpdatePanel ID="upnelList" runat="server" UpdateMode="Conditional">
            <ContentTemplate>
                  <!-- Top 3 reviews -->
                  <div class="row">
                      <asp:Repeater ID="topReviews" runat="server">
                          <ItemTemplate>
                            <div class="col-md-4">
                                <blockquote>
                                    
                                    <h3><%# EOES_ClassLib.TextRender.Truncate(Eval("RV_Title").ToString(),100) %>
                                        &nbsp;&nbsp;&nbsp;<em><%# EOES_ClassLib.TextRender.Stars(Eval("Rate").ToString())%></em>
                                    </h3>
                                    <small>Written by <%# Eval("userFullName") %></small><br />
                                    <p><%# EOES_ClassLib.Utilities.RenderTextBr(EOES_ClassLib.TextRender.Truncate(Eval("RV_Content").ToString(),250)) %></p>
                              
                                </blockquote>
                             

                            </div>
                           </ItemTemplate>
                        </asp:Repeater>
                  </div><br />

                  <asp:Repeater ID="allReviews" runat="server">
                          <ItemTemplate>
                                <h4><mark><%# EOES_ClassLib.TextRender.Truncate(Eval("RV_Title").ToString(),100) %></mark>
                                   &nbsp;&nbsp;&nbsp;<em><%# EOES_ClassLib.TextRender.Stars(Eval("Rate").ToString())%></em>
                                   &nbsp;&nbsp;&nbsp; <small class="text-right">Written by <%# Eval("userFullName") %></small>
                                </h4>
                                
                                <p><%# EOES_ClassLib.Utilities.RenderTextBr(EOES_ClassLib.TextRender.Truncate(Eval("RV_Content").ToString(),250)) %></p>
                            <br /><br />
                           </ItemTemplate>
                  </asp:Repeater>              
            </ContentTemplate>
        </asp:UpdatePanel>

    </div> <!-- /container -->

   
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/jquery.min.js"><\/script>')</script>
    <script src="/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
    <script src"/js/validator.js"></script>
</asp:Content>

