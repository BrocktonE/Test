 let welcome = document.getElementById('welcome');
 
 var userString = sessionStorage.getItem('currentUser');
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 var currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName + " , to the Employee Home Page";
	 }
 }
  function logout() {
	 
	 let xhr = new XMLHttpRequest();
	 xhr.open("POST", "http://localhost:8080/MoneyBack/logout");
	 xhr.send();
	 
	 sessionStorage.removeItem('currentUser');
	 window.location = "http://localhost:8080/MoneyBack/";
	 
 }
 
 
 
 function request() {
//1. get the XMLHttpRequest Object ie... let xhr =...
let xhr = new XMLHttpRequest();
//2. xhr.onreadystatechange
xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

        sessionStorage.setItem('currentUser', this.responseText)

        window.location= "http://localhost:8080/MoneyBack/request.html";

        console.log(sessionStorage.getItem('currentUser'));
    }
    if (this.readyState === 4 && this.status === 204) { //204 means no content found but connection made
            console.log("failed to find user")
    }

    let childDiv = document.getElementById(`warningText`);
    childDiv.textContent = "Failed to login! Username of Password is incorrect"


}

//3. xhr.open("POST, "wherever out login servlet is located, http:/localhost:8080/EmployeeDBServlets/url for the loginServlet")

xhr.open("POST", "http://localhost:8080/MoneyBack/request")

//4. xhr.send();
 xhr.send()
}