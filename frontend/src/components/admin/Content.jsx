import React from 'react';
import classes from './Content.module.css'
import MyTable from './MyTable.jsx'
import AddTeacher from './AddTeacher';

const Content = () => {
    return (
        <article class={`${classes.box} ${classes.content}`}>
            {/*<MyTable />*/}
            <AddTeacher/>
            
        </article>

    );
}

export default Content;