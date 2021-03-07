function sendLogin() {
// save some variables here

let uName = document.getElementById('uName').value;

let pWord = document.getElementById('pWord').value;

console.log(`Username: ${uName}`);
console.log(`Password: ${pWord}`);

//building an obj literal with the user credentials
let loginTemplate = {
    username: uName,
    password: pWord
}


//begin some AJAX Workflow

//1. get the XMLHttpRequest Object ie... let xhr =...
let xhr = new XMLHttpRequest();
//2. xhr.onreadystatechange
xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

        sessionStorage.setItem('currentUser', this.responseText)

        window.location= "http://localhost:8080/MoneyBack/employee.html";

        console.log(sessionStorage.getItem('currentUser'));
    }
    if (this.readyState === 4 && this.status === 204) { //204 means no content found but connection made
            console.log("failed to find user")
    }

    let childDiv = document.getElementById(`warningText`);
    childDiv.textContent = "Failed to login! Username of Password is incorrect"


}

//3. xhr.open("POST, "wherever out login servlet is located, http:/localhost:8080/EmployeeDBServlets/url for the loginServlet")

xhr.open("POST", "http://localhost:8080/MoneyBack/login")

//4. xhr.send();
 xhr.send(JSON.stringify(loginTemplate))
}

   function manager() {
	
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/MoneyBack/manager");
	xhr.send();
	window.location = "http://localhost:8080/MoneyBack/manager.html";
	
	
	
}

function sendLogin2() {

let uName = document.getElementById('uName').value;

let pWord = document.getElementById('pWord').value;

console.log(`Username: ${uName}`);
console.log(`Password: ${pWord}`);

let loginTemplate = {
    username: uName,
    password: pWord
}
let xhr = new XMLHttpRequest();

xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

        sessionStorage.setItem('currentUser', this.responseText);

        window.location= "http://localhost:8080/MoneyBack/managerhome.html";

        console.log(sessionStorage.getItem('currentUser'));
    }
    if (this.readyState === 4 && this.status === 204) { //204 means no content found but connection made
            console.log("failed to find user")
    }

    let childDiv = document.getElementById(`warningText`);
    childDiv.textContent = "Failed to login! Username of Password is incorrect"


}

xhr.open("POST", "http://localhost:8080/MoneyBack/login2")
 xhr.send(JSON.stringify(loginTemplate))
}
 function logout() {
	 
	 let xhr = new XMLHttpRequest();
	 xhr.open("POST", "http://localhost:8080/MoneyBack/logout");
	 xhr.send();
	 
	 sessionStorage.removeItem('currentUser');
	 window.location = "http://localhost:8080/MoneyBack/";
	 
 }
 

	 

 

 
 












