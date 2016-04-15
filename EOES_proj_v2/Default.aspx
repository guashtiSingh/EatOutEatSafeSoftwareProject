<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

    <main class="bs-docs-masthead" id="content" role="main" tabindex="-1"> 
        <!-- search -->
        <div class="searchBar">

            <div class="form-horizontal">
                <div class="form-group">
                    <div class="input-group search">
                        <div class="input-group-addon">◎</div>
                        <%--<input type="text" class="form-control" id="search" placeholder="Search Menu or Restaurant" />--%>
                
                        <asp:TextBox ID="search" runat="server" class="form-control" placeholder="Search by Restaurant"></asp:TextBox>
                
                        <div class="input-group-addon" id="searchDiv" runat="server">
                            <img src="/images/search.png" class="search_ico" />
                        </div>
                    </div>
                </div>

                <div class="form-group checkbox-group">
                    <label class="checkbox-inline">
                        <input type="checkbox" id="search_location" value="location" /> Location
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="search_allergy" value="allergy" /> Allergy
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="search_food" value="food" /> Food
                    </label>
                </div>
            </div>

        </div>
    </main>

    <div class="bs-docs-featurette"> 
        <div class="container"> 
            <br />

            <!-- navtabs -->
			<div>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active re_tab"><a href="#pupular" aria-controls="pupular" role="tab" data-toggle="tab">Popular</a></li>
					<li role="presentation" class="re_tab"><a href="#allergies" aria-controls="allergies" role="tab" data-toggle="tab">Allergies</a></li>
					<li role="presentation" class="re_tab"><a href="#location" aria-controls="location" role="tab" data-toggle="tab">Location</a></li>
				</ul>

                <!-- Tab content -->
				<div class="tab-content">
                    <!-- Tab panel -->
					<div role="tabpanel" class="tab-pane fade in active" id="pupular">
						<div class="table-responsive content"> 


                            <!-- list title -->
                            <div class="row">
                                <div class="col-lg-12">

                                    <!-- list title -->
                                    <% if (searchStr == ""){ %>
                                                <h1 class="page-header">Top Restaurants
                                                    <small>check out best reviews!!</small>
                                                </h1>
                                    <% } else { %>
 
                                                <h1 class="page-header">Your Search Result
                                                    <small>find your best fits!!</small>
                                                </h1>
                                    <% } %>

                                </div>
                            </div>


                            <div class="row">

                                <!-- list content -->
                                <asp:Repeater ID="Repeater1" runat="server">
                                    <ItemTemplate>
                                        <div class="col-sm-3 col-lg-4 col-md-3">
                                            <div class="thumbnail">
                                                <img style="width:300px;height:200px;" src="<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>" />
                                                <div class="caption">
                                                    <h4 class="pull-right">*</h4>
                                                    <h4>
                                                        <a href="/restaurants/ResDetails.aspx?ResId=<%# Eval("Res_Id") %>">
                                                            <%# EOES_ClassLib.TextRender.HighlightKeyWords(Eval("Res_name").ToString(), searchStr, "yellow", true) %>
                                                        </a>
                                                    </h4>
                                                    <p>
                                                        <%# EOES_ClassLib.TextRender.HighlightKeyWords(EOES_ClassLib.TextRender.Truncate(Eval("Res_Description").ToString(),100), searchStr,"yellow", true) %>
                                                    </p>
                                                </div>
                                                <div class="ratings">
                                                    <p>
                                                        <%# EOES_ClassLib.TextRender.Stars(Eval("Rate").ToString())%>
                                                        <%# Eval("Total_review") %> reviews 
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </ItemTemplate>
                                </asp:Repeater>

                            </div>
                        </div>
                    </div><!-- Tab panel -->

                    <div role="tabpanel" class="tab-pane fade" id="allergies">
                        
                          <asp:Repeater ID="Repeater2" runat="server">
                            <ItemTemplate>
                                <%# !checkContentTitle(Eval("AC_Name").ToString()) ?
                                    "<div class='row categoryTitle'>" +
                                        "<div class='col-lg-12'>" +
                                            "<h1 class='page-header'>" + Eval("AC_Name") +
                                                " <small>find restaurants who have <span class='keyword'>" + Eval("AC_Name")  + "</span> menus</small>" +
                                            "</h1>" +
                                        "</div>" +
                                    "</div>"
                                    : ""
                                %>

                                <!-- list content -->
                                <div class="row">
                                    <div class="col-md-3">
                                        <a href="/restaurants/ResDetails.aspx?ResId=<%#  Eval("Res_Id") %>">
                                            <img class="img-responsive" src="<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>" alt="">
                                        </a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                    <div class="col-md-9">
                                        <div class="ratings pull-right">
                                            <%# EOES_ClassLib.TextRender.Stars(Eval("Rate").ToString())%>
                                            <%# Eval("Total_review") %> reviews
                                        </div><br />
                                        <h3><%# EOES_ClassLib.TextRender.HighlightKeyWords(Eval("Res_name").ToString(), searchStr, "yellow", true) %></h3>
                                        <p>
                                            <%# EOES_ClassLib.TextRender.HighlightKeyWords(EOES_ClassLib.TextRender.Truncate(Eval("Res_Description").ToString(),200), searchStr,"yellow", true) %>
                                        </p>
                                        <a href="/restaurants/ResDetails.aspx?ResId=<%# Eval("Res_Id") %>" class="btn btn-primary">More <span class="glyphicon glyphicon-chevron-right"></span></a>
                                    </div>
                                </div>
                                <hr>
                            </ItemTemplate>
                        </asp:Repeater>
                       
                    </div><!-- Tab panel -->

                    <div role="tabpanel" class="tab-pane fade" id="location">
                        
                         <!-- list content -->
                        <asp:Repeater ID="Repeater3" runat="server">
                            <ItemTemplate>
                                <%# !checkContentTitle(Eval("LC_Name").ToString()) ?
                                    "<div class='row categoryTitle'>" +
                                        "<div class='col-lg-12'>" +
                                            "<h1 class='page-header'>" + Eval("LC_Name") +
                                                " <small>find restaurants located in <span class='keyword'>" + Eval("LC_Name")  + "</span></small>" +
                                            "</h1>" +
                                        "</div>" +
                                    "</div>"
                                    : ""
                                %>

                                <div class="row">
                                    <div class="col-md-3">
                                        <a href="/restaurants/ResDetails.aspx?ResId=<%#  Eval("Res_Id") %>">
                                            <img class="img-responsive" src="<%# Eval("mainImg_path") %>\<%#  Eval("mainImg_name") %>" alt="">
                                        </a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                    <div class="col-md-9">
                                        <div class="ratings pull-right">
                                            <%# EOES_ClassLib.TextRender.Stars(Eval("Rate").ToString())%>
                                            <%# Eval("Total_review") %> reviews
                                        </div><br />
                                        <h3><%# EOES_ClassLib.TextRender.HighlightKeyWords(Eval("Res_name").ToString(), searchStr, "yellow", true) %></h3>
                                        <p>
                                            <%# EOES_ClassLib.TextRender.HighlightKeyWords(EOES_ClassLib.TextRender.Truncate(Eval("Res_Description").ToString(),200), searchStr,"yellow", true) %>
                                        </p>
                                        <a href="/restaurants/ResDetails.aspx?ResId=<%# Eval("Res_Id") %>" class="btn btn-primary" >More <span class="glyphicon glyphicon-chevron-right"></span></a>
                                    </div>
                                </div>
                                <hr>
                            </ItemTemplate>
                        </asp:Repeater>
                        
                    </div><!-- Tab panel -->


                </div><!-- Tab content -->

            </div> <!-- navtabs -->
      </div>
</div>
</asp:Content>

