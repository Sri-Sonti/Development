import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    emplist: []
  };

  async componentDidMount() {
    const response = await fetch('/Employee/getAll');
    const body = await response.json();
    this.setState({ emplist: body, isLoading: false });
  }

 
			


  renderTableData() {
      return this.state.emplist.map((emp, index) => {
         const { empId, firstName, lastName, email } = emp;
         return (
            <tr key={empId}>
               <td><div id={empId}>{empId}</div></td>
               <td><input type="text" value={firstName} /></td>
               <td><input type="text" value={lastName}/></td>
               <td><input type="text" value={email}/></td>
	       <td><input type="button" value="Update Employee"/></td>
            </tr>
         )
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
          <img src={logo} className="App-logo" alt="logo" />
	  <h1 id='title'>Sprint InfoTech</h1>
	    <table id = 'EmployeeList' table-bordered>
		<tbody>
		   <tr>{this.renderTableHeader()}
		   <th key="headerButton"> Action </th>
		   </tr>
		   {this.renderTableData()}		   
                </tbody>
          </table>
	  <input type="button" value="Add Employee"/>
        </header>
      </div>
    );
  }
}

export default App;