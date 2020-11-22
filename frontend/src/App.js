import React, {Fragment} from 'react';
import './App.scss';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ErrorMessageWell from "./component/ErrorMessageWell";
import NavbarComponent from "./component/layout/NavbarComponent";
import GuestRecordingForm from "./component/guests/GuestRecordingForm";

function App() {
    return (
        <div className={"App"}>
           <Router>
               <NavbarComponent/> {/* NEM lehet a Routeren kívülre helyezni*/}
               <div className={"container"}>
                   <ErrorMessageWell/>
                   <Switch>
                       <Route exact path={"/"} render={
                           () => (
                               <p>This is the home page</p>
                           )
                       }/>

                       <Route exact path={"/Guests"} render={
                           () => (
                               <Fragment>
                                <p>This is the Guests page</p>
                                <GuestRecordingForm/>
                               </Fragment>
                           )
                       }/>

                       <Route exact path={"/Slides"} render={
                           () => (
                               <p>This is the Slides page</p>
                           )
                       }/>
                   </Switch>
               </div>
           </Router>
        </div>
    );
}

export default App;
