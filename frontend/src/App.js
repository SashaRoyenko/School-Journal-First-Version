import React from 'react';
import './App.css';
import Header from './components/Header';
import Navbar from './components/admin/Navbar';
import Content from './components/admin/Content';
import Footer from './components/Footer';

const App = () => {
  return (
    <div className='wrapper'>
     <Header />
     <Navbar />
     <Content />
     <Footer />
    </div>
  );
}

export default App;
