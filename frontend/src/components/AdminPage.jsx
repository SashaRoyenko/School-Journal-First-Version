import React from 'react';
import './AdminPage.css';
import Header from './Header';
import Navbar from './admin/Navbar';
import Footer from './Footer';
import TableTeacher from './admin/Teachers/TableTeacher'
import TableParents from './admin/Parents/TableParents'
import TableStudents from './admin/Students/TableStudents'
import AddTeacher from './admin/Teachers/AddTeacher'
import AddStudent from './admin/Students/AddStudent'
import AddParent from './admin/Parents/AddParent'
import { Route, BrowserRouter, Switch } from 'react-router-dom'

const AdminPage = () => {
    return (
        <BrowserRouter>
            <div className='wrapper'>
                <Header />
                <Navbar />
                <Switch>
                    <Route exact path='/admin' component={TableTeacher} />
                    <Route path='/admin/teachers' component={TableTeacher} />
                    <Route path='/admin/add_teacher' component={AddTeacher} />
                    <Route path='/admin/students' component={TableStudents} />
                    <Route path='/admin/add_student' component={AddStudent} />
                    <Route path='/admin/parents' component={TableParents} />
                    <Route path='/admin/add_parents' component={AddParent} />
                </Switch>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default AdminPage;