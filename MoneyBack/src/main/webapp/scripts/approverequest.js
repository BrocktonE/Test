 let welcome = document.getElementById('welcome');
 
 var userString = sessionStorage.getItem('currentUser');
console.log("test");
console.log(userString);
 
 if (userString === null) {
	 window.location = "http://localhost:8080/EmployeeServlets/";
 } else {
	 var currentUser = JSON.parse(userString);
	 console.log(currentUser);
	 
	 if (currentUser != null) {
		 welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName + " , to the Employee Home Page";
	 }
 }
 
 function sendApprove() {
 
 let requestId = document.getElementById('requestId').value;
 let status = document.getElementById('approve').value;
 
 console.log(requestId);
 console.log(status);
 
 let approve = { 
 	id :currentUser.id,
 	status : status,
 	requestId : requestId
 	}
 	
 console.log(approve);
 
 let xhr = new XMLHttpRequest();
 xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

     

    }
    if (this.readyState === 4 && this.status === 204) { //204 means no content found but connection made
            console.log("failed to find user")
    }

    let childDiv = document.getElementById(`warningText`);
    childDiv.textContent = "Failed to login! Username of Password is incorrect"


}

xhr.open("POST", "http://localhost:8080/MoneyBack/approverequest")


 xhr.send(JSON.stringify(approve))
 
 
 
 }
 
 