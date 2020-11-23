import React, {Fragment} from 'react';
import './App.scss';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ErrorMessageWell from "./component/ErrorMessageWell";
import NavbarComponent from "./component/layout/NavbarComponent";
import GuestRecordingForm from "./component/guests/GuestRecordingForm";
import GuestList from "./component/guests/GuestList";
import SlideRecordingForm from "./component/slides/SlideRecordingForm";
import SlideList from "./component/slides/SlideList";
import {Row, Col} from "react-bootstrap";
import FooterComponent from "./component/layout/FooterComponent";

function App() {
    return (
        <div className={"App"}>
           <Router>
               <NavbarComponent/> {/* NEM lehet a Routeren kívülre helyezni*/}
               <div className={"container"} style={{minHeight: "83vh"}}>
                   <ErrorMessageWell/>
                   <Switch>g
                       <Route exact path={"/"} render={
                           () => (
                               <Row>
                                   <Col xs={"12"}>
                                       <h3 className={"mx-auto my-5"}>This is our group project for <span className={"text-primary"}> Application Developement Project Lab</span></h3>
                                       <h5>The project base created by &nbsp;
                                           <a href="https://github.com/ZsoltToth">Zsolt Tóth</a>: &nbsp;
                                           <a href={"https://github.com/ZsoltToth/project-templates-spring-react"}
                                              className="text-danger">https://github.com/ZsoltToth/project-templates-spring-react
                                           </a>
                                       </h5>

                                       <h5> You can find our project at: <a href={"https://github.com/fepu08/afp2020"}>https://github.com/fepu08/afp2020</a></h5>
                                   </Col>

                                   <Col xs={"12"} md={"8"} className={"mx-auto my-5"}>
                                       <ul className="list-group">
                                           <li className="list-group-item active pl-5"><strong>The group members are:</strong></li>
                                           <li className="list-group-item text-center">
                                               <a href={"https://github.com/somogyidavid"}>Dávid Somogyi</a>
                                           </li>
                                           <li className="list-group-item text-center">
                                               <a href={"https://github.com/DAdam97"}>Ádám Deák</a>
                                           </li>
                                           <li className="list-group-item text-center">
                                               <a href={"https://github.com/fepu08"}>Ferenc Besenyei</a>
                                           </li>
                                           <li className="list-group-item text-center">
                                               <a href={"https://github.com/gergof2"}>Gergő Kerepesi</a>
                                           </li>
                                           <li className="list-group-item text-center">
                                               <a href={"https://github.com/Soosistvan"}>István Soós</a>
                                           </li>
                                       </ul>
                                   </Col>
                               </Row>
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
               <FooterComponent/>
           </Router>
        </div>
    );
}

export default App;
