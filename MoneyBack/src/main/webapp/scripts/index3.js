 let welcome = document.getElementById('welcome');
 
 let userString = sessionStorage.getItem('currentUser');
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 let currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName + " , to the Manager Home Page";
	 }
 }
 
 function approve() {
 
  window.location= "http://localhost:8080/MoneyBack/approverequest.html";
 
 }
 
 function reimbursementpage() {
 window.location= "http://localhost:8080/MoneyBack/reimbursementlist.html";
 
 }