import React, {Fragment} from "react";
import {Row, Col} from "react-bootstrap";
import * as actions from '../action/GuestActions';
import ErrorMessageWell from "./ErrorMessageWell";
class GuestRecordingForm extends React.Component{
    /*
        React konstruktorokat általában kétféle okból használjuk:
            - Inicializálni a helyi állapotot egy objektum this.state-hez rendelésével.
            - Hozzákötni eseménykezelő metódusokat egy komponenspéldányhoz.
     */
    constructor(props) {
        super(props);
        this.state = {
            getGuestId: 0,
            deleteGuestId: 0,
            useSlideGuestId: 0
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render(){
        return(
            <Fragment>
                <ErrorMessageWell/> {/* Szükség van rá a hibaüzenetek megjelenítésére /}
                <Row className={"w-100"}>
                {/ List all Guests */}
                <Col xs={12} md={6} className={"my-2"}>
                    <button className="btn btn-primary btn-lg btn-block" onClick={()=> actions.fetchGuest()}>List all Guests</button>
                </Col>
            </Fragment>
        )
    }
}

export default GuestRecordingForm