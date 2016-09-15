<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Signup.aspx.cs" Inherits="users_Signup" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <link rel="stylesheet" href="/css/jumbotron-narrow.css" />
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
     <br /><br />
 <div class="bs-docs-featurette"> 
     <div class="container"> 


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Sing up
                        <small>Eat out, Eat Safe</small>
                    </h1>
                </div>
            </div>

             <div class="jumbotron">
        
                <div class="panel-body align-left">
	           	        <div class="form-group align-left">
                            <span class="form-inline"> User ID
                                <asp:TextBox ID="txtUId" runat="server" class="form-control" placeholder="User ID" required></asp:TextBox>
                            </span>
	           	        </div>
	           	        <div class="form-group">
                            <span class="form-inline"> First Name
                               <asp:TextBox ID="txtFname" runat="server" class="form-control" placeholder="First Name" required></asp:TextBox>
                            </span>
	           	        </div>
                        <div class="form-group">
                            <span class="form-inline"> Last Name
                                <asp:TextBox ID="txtLname" class="form-control" runat="server" placeholder="Last Name" required></asp:TextBox>
                            </span>
	           	        </div>
	           	        <div class="form-group">
                            <span class="form-inline"> Password
                               <asp:TextBox ID="txtPwd" class="form-control" runat="server" placeholder="Password" required></asp:TextBox>
                            </span>
	           	        </div>
	           	        <div class="form-group">
                            <span class="form-inline"> Email
                               <asp:TextBox ID="txtEmail" runat="server" class="form-control" placeholder="Email"></asp:TextBox>
                            </span>
	           	        </div>
                        
                        <asp:Button ID="btnSubmit" class="btn btn-default" runat="server" Text="Sign Up" OnClick="btnSubmit_Click" />
				        <a class="btn btn-info" href="/Default.aspx" role="button">Back to Home</a>
	
	             </div>

            </div>


    </div>
</div>
</asp:Content>

