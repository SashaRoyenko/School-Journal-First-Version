import React from 'react';
import AdminPage from "./components/admin/AdminPage"
import SignIn from "./components/SignIn"
import StudentPage from "./components/student/StudentPage"
import { Route, Switch, BrowserRouter} from 'react-router-dom'


const App = () => {

    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={SignIn}/>
          <Route path="/admin" component={AdminPage}/>
          <Route path="/student" component={StudentPage}/>
        </Switch>
      </BrowserRouter>
    );

}

export default App;