import React, { Component, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import edit from './edit.PNG';
import add from './add.PNG';


class App extends Component {
  constructor(props) {
      super(props);
      this.state = {
	    firstName: '',
        lastName: '',
        email: '',
        empId: '',
        isLoading: true,
        emplist: []
      };
     this.handleChange = this.handleChange.bind(this);
     this.handleSubmit = this.handleSubmit.bind(this);
     this.handleCreate = this.handleCreate.bind(this);
     
  }

  async componentDidMount() {
    this.getEmployees()
  }

 async getEmployees(){
    const response = await fetch('/Employee/getAll');
    const body = await response.json();
    this.setState({ emplist: body, isLoading: false});
      
  }

  renderAddData() {
    return (
     <form name="AddEmployee"  onSubmit={(e) => this.handleCreate(e)}>
       <th key="headerButton"> FIRSTNAME  </th>
        
        <td><input type = 'text' name = 'firstName' onChange={(e) => this.state.firstName = e.target.value}></input></td>
        <th key="headerButton"> LASTNAME  </th>
        <td><input type = 'text' name = 'lastName' onChange={(e) => this.state.lastName = e.target.value}></input></td>
        
        <th key="headerButton"> EMAIL  </th>
        <td><input type = 'text' name = 'email' onChange={(e) => this.state.email = e.target.value}></input></td>
        
        <button>
					<img src={add} className="Edit-logo" alt="editImg" />
					</button>
        


     </form>
    )
  }
  


  renderTableData() {
      return this.state.emplist.map((emp,index) => {
      const { empId, firstName, lastName, email } = emp;
       return (	    	    
            <tr key={empId}>
                {console.log("Here Q" +  JSON.stringify(empId) ) }
               
               <td><div name="empId" id={empId}>{empId}</div></td>
	       <td><input type="text" name="firstName" defaultValue={firstName} onChange={(e) => this.handleChange(e, index)} /></td>
               <td><input type="text" name="lastName" defaultValue={lastName} onChange={(e) => this.handleChange(e, index)} /></td>
               <td><input type="text" name="email" defaultValue={email} onChange={(e) => this.handleChange(e, index)} /></td>
	       	   <td> 
					<button  onClick={(e) => this.handleSubmit(e, index)}>
					<img src={edit} className="Edit-logo" alt="editImg" onClick={(e) => this.handleSubmit(e, index)} />
					</button>
					
	       		
				</td>
	      		
            </tr>
         )
      })
      
   }    

  handleChange = (event, index) => { 
          const name = event.target.name;
          const value = event.target.value;
          let tempList = [...this.state.emplist];
          let tempEmployee = tempList[index];
          if("firstName" == name)
            tempEmployee.firstName = value;
          if("lastName" == name)
            tempEmployee.lastName = value;
          if("email" == name)
            tempEmployee.email = value;

          this.setState({tempList});  
          console.log('Your username is:' + tempEmployee.firstName); 
          console.log('Your list is:' + JSON.stringify(this.state.emplist)); 
  }

  handleSubmit = (event, index) => {  
	  
          event.preventDefault();
          let empObj = this.state.emplist[index];
          
            fetch("/Employee/updateId/" + empObj.empId, {"method": "PUT" ,
              "headers": {
                  "content-type": "application/json",
                  "accept": "application/json"
              },
              "body": JSON.stringify ({
                  empId: empObj.empId,
                  firstName: empObj.firstName,
                  lastName: empObj.lastName,
                  email: empObj.email,
              })
              })
              .then(response => { console.log(response)});
       
  }


  handleCreate = ( event) => {
      event.preventDefault();
  	  let size = this.state.emplist.length;
  	  console.log(size);
  	  let idObj = this.state.emplist[size-1];
  	  let id = parseInt(idObj.empId) + 1;
  	  
      console.log('new empId=' + id);
      console.log('new firstName=' + this.state.firstName);
      console.log('new empId=' + this.state.lastName);
      console.log('new empId=' + this.state.email);
      
  	  fetch("/Employee/addEmployees", {"method": "POST" ,
  	  	  "headers": {
  	  	  	"content-type": "application/json",
  	  	  	"accept": "application/json"
  	  	  },
  	  	  "body": JSON.stringify ([{
	        empId: String(id),
	        firstName: this.state.firstName,
	        lastName: this.state.lastName,
	        email: this.state.email,
  	  				}])})
  	  	.then(res => {
        	if (res.ok) this.getEmployees(); 
      }) 
  }

 


  renderTableHeader() {
      let header = Object.keys(this.state.emplist[0])
      return header.map((key, empId) => {
         return <th key={empId}>{key.toUpperCase()}</th>
     })
   }

      render() {
    const {emplist, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          
	  <h1><img src={logo} className="App-logo" alt="logo" />Sprint InfoTech</h1>
    </header>
 	    
       <table id="main-table" > 
         <tr>
           <td>
           <h4>EmployeeList</h4>
              <table id = 'EmployeeList' table-bordered>
              <tbody>
                <tr>{this.renderTableHeader()}
                  <th key="headerButton"> ACTION  </th>
                </tr>
                  {this.renderTableData()}		   
                        </tbody>
              </table>
            </td>
            
            <h4> Add New Employee</h4>
              <table id= 'AddEmployee' table-bordered>
                
                  <td>{this.renderAddData()}  </td>
                  
                
            
              </table>
            
          </tr>
        </table>
      </div>
    );
  }
}

export default App;

