function Employee() { 
  this.name = ''; 
  this.dept = 'general'; 
} 

function Worker() { 
  /*
  this.base = Worker; 
  this.base(name, 'engineering', projs);
  */
  // call alternative to the above
  Employee.call(this); 
  this.projects = []; 
} 
// Oppure unica riga: Worker.prototype = new Employee;
Worker.prototype = Object.create(Employee.prototype); 
Worker.prototype.constructor = Worker;

function Engineer() { 
  Worker.call(this); 
  this.dept = 'engineering'; 
  this.machine = ''; 
} 
Engineer.prototype = Object.create(Worker.prototype); 
Engineer.prototype.constructor = Engineer; // ?? senza ha come valore "f Employee(){.." invece che "ƒ Engineer(){..."

var John = new Employee; 
// You can leave the parentheses out if the 
// constructor Doesn’t take any arguments. 
// John.name is '' 
// John.dept is 'general' 
var Michael = new Worker; 
// Michael.name is '' 
// Michael.dept is 'general' 
// Michael.projects is [] 
var Julie = new Engineer; 
// Julie.name is '' 
// Julie.dept is 'engineering' 
// Julie.projects is [] 
// Julie.machine is ''

Object.prototype.test0="ProtoObject-0"
Employee.prototype.test1 = "ProtoEmployee-1"
Worker.prototype.test2="ProtoWorkerr-2"
Engineer.prototype.test3="ProtoEngineer-3"
jj = new Engineer()
jjj = new Worker()


function Manager() { 
  Employee.call(this); 
  this.reports = []; 
} 
Manager.prototype = Object.create(Employee.prototype); 
Manager.prototype.constructor = Manager; 

function Salesperson() { 
  Worker.call(this); 
  this.dept = 'sales'; 
  this.quota = 100; 
} 
Salesperson.prototype = Object.create(Worker.prototype); 
Salesperson.prototype.constructor = Salesperson; 




var Shelley = new Manager; 
// Shelley.name is '' 
// Shelley.dept is 'general' 
// Shelley.reports is [] 
var George = new Salesperson; 
// George.name is '' 
// George.dept is 'sales' 
// George.projects is [] 
// George.quota is 100 


