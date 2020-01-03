import React from 'react';
import './AdminPage.css';
import Header from './Header';
import Navbar from './Navbar';
import Footer from './Footer';
import TableTeacher from './Teachers/TableTeacher'
import TableParents from './Parents/TableParents'
import TableStudents from './Students/TableStudents'
import TableSchedule from './Schedule/TableSchedule'
import AddTeacher from './Teachers/AddTeacher'
import AddStudent from './Students/AddStudent'
import AddParent from './Parents/AddParent'
import TableGroups from './Groups/TableGroups'
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import TableLessons from './Lessons/TableLessons';

const AdminPage = () => {
    return (
        <BrowserRouter>
            <div className='wrapper'>
                <Header />
                <Navbar />
                <Switch>
                    <Route exact path='/admin' component={TableTeacher} />
                    <Route path='/admin/teachers' component={TableTeacher} />
                    <Route path='/admin/teachers/teacher' component={AddTeacher} />
                    <Route path='/admin/students' component={TableStudents} />
                    <Route path='/admin/students/student' component={AddStudent} />
                    <Route path='/admin/parents' component={TableParents} />
                    <Route path='/admin/parents/parent' component={AddParent} />
                    <Route path='/admin/groups' component={TableGroups} />
                    <Route path='/admin/lessons' component={TableLessons} />
                    <Route path='/admin/lessons' component={TableLessons} />
                    <Route path='/admin/schedule' component={TableSchedule} />
                </Switch>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default AdminPage;