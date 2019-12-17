import React from 'react';
import './StudentPage.css';
import Header from './Header';
import Navbar from './Navbar';
import Footer from './Footer';
import StudentProfile from './StudentProfile';
import Journal from './Journal';

import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Hometask from './Hometask';

const StudentPage = () => {
    return (
        <BrowserRouter>
            <div className='wrapper'>
                <Header />
                <Navbar />
                <Switch >
                    <Route exact path='/student' component={StudentProfile} />
                    <Route path='/student/profile' component={StudentProfile} />
                    <Route path='/student/journal' component={Journal} />
                    <Route path='/student/hometasks' component={Hometask} />
                </Switch>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default StudentPage;