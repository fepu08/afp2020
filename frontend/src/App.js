import React, {Fragment} from 'react';
import './App.scss';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ErrorMessageWell from "./component/ErrorMessageWell";
import NavbarComponent from "./component/layout/NavbarComponent";
import GuestRecordingForm from "./component/guests/GuestRecordingForm";
import GuestList from "./component/guests/GuestList";
import SlideRecordingForm from "./component/slides/SlideRecordingForm";
import SlideList from "./component/slides/SlideList";

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
                                    <GuestRecordingForm/>
                                    <GuestList/>
                               </Fragment>
                           )
                       }/>

                       <Route exact path={"/Slides"} render={
                           () => (
                               <Fragment>
                                   <SlideRecordingForm/>
                                   <SlideList/>
                               </Fragment>
                           )
                       }/>
                   </Switch>
               </div>
           </Router>
        </div>
    );
}

export default App;
