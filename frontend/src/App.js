import React from 'react';
import './App.css';
import Header from './components/Header';
import Navbar from './components/admin/Navbar';
import Footer from './components/Footer';
import TableTeacher from './components/admin/TableTeacher'
import TableParents from './components/admin/TableParents'
import TableStudents from './components/admin/TableStudents'
import AddTeacher from './components/admin/AddTeacher'
import { Route, BrowserRouter } from 'react-router-dom'

const App = () => {
  return (
    <BrowserRouter>
      <div className='wrapper'>
        <Header />
        <Navbar />
        <Route path='/teachers' component={TableTeacher}/>
        <Route path='/add_teacher'component={AddTeacher}/>
        <Route path='/students' component={TableStudents}/>
        <Route path='/parents' component={TableParents}/>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
