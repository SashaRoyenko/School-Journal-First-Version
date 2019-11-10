import React from 'react';
import AdminPage from "./components/AdminPage"
import SignIn from "./components/SignIn"
import { Route, Switch, BrowserRouter} from 'react-router-dom'


const App = () => {

    return (
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={SignIn}/>
          <Route path="/admin" component={AdminPage}/>
        </Switch>
      </BrowserRouter>
    );

}

export default App;