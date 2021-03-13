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



function populateTable() {

		var table = document.getElementById("myTable");

	
  let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

	   let myObj = JSON.parse(xhr.responseText)
	   console.log(myObj);
	   
	   
	myObj.forEach((obj) => {
	
	let tr = document.createElement("tr");
	table.appendChild(tr);
	
		let td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.id;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.amount;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.description;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.author;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.resolver;
		
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.status;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.type;
		
		let button = document.createElement("button");
		button.setType = "submit"
		button.innerHTML = "Approve"
		button.setAttribute("onclick", `approveR(${obj.id}, ${obj.status}, ${currentUser.id})`)
		tr.appendChild(button);
		
		let button1 = document.createElement("button");
		button1.innerHTML = "Deny"
		button1.setAttribute("onclick", `printId(${obj.id})`)
		tr.appendChild(button1);
		
		
		
		});

	  
		}
		
	}
	 xhr.open("GET", "http://localhost:8080/MoneyBack/reimbursementlist")
	       xhr.send();
	
	}
	

	

	function approveR(id, status, rId) {
	
	console.log(id);
	console.log(status);
	console.log(rId);
	
	let approve = {
	id : rId,
	status : 2,
	requestId : id
	
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



}


xhr.open("POST", "http://localhost:8080/MoneyBack/approverequest")


 xhr.send(JSON.stringify(approve))
 

 
 }
 
 function populateTableResolved() {

		var table = document.getElementById("myTable");

	
  let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

	   let myObj = JSON.parse(xhr.responseText)
	   console.log(myObj);
	   
	   
	myObj.forEach((obj) => {
	
	let tr = document.createElement("tr");
	table.appendChild(tr);
	
		let td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.id;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.amount;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.description;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.author;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.resolver;
		
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.status;
		
		 td = document.createElement("td");
		tr.appendChild(td);
		td.innerHTML = obj.type;
		
		});

	  
		}
		
	}
	 xhr.open("GET", "http://localhost:8080/MoneyBack/reimbursementlistr")
	       xhr.send();
	
	}
	
	
	
	
	
	
	