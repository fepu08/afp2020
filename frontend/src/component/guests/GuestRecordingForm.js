import React, {Fragment} from "react";
import {Row, Col} from "react-bootstrap";
import * as actions from '../../action/GuestActions';
import ErrorMessageWell from "../ErrorMessageWell";
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
                <ErrorMessageWell/> {/* Szükség van rá a hibaüzenetek megjelenítésére */}
                <Row className={"w-100"}>
                    {/ List all Guests */}
                    <Col xs={12} md={6} className={"my-2"}>
                        <button className="btn btn-primary btn-lg btn-block" onClick={()=> actions.fetchGuest()}>List all Guests</button>
                    </Col>
                    {/* Create new Guest */}
                    <Col xs={12} md={6} className={"my-2"}>
                        <button className="btn btn-success btn-lg btn-block" onClick={()=> actions.checkInGuest()}>Create New Guest</button>
                    </Col>
                </Row>

                <Row>
                    <Col xs={12} md={6} className={"my-2"}>
                        <div className={"card"}>
                            <div className={"card-header bg-danger text-light"}>
                                Delete Guest by ID
                            </div>
                            <div className={"card-body"}>
                                <Col xs={12} className={"form-group"}>
                                    <label htmlFor={"deleteGuestId"} >Guest ID</label>
                                    <input className={"form-control"} type={"number"} id={"deleteGuestId"} name={"deleteGuestId"} value={this.state.deleteGuestId} onChange={this.formOnChange}/>
                                </Col>
                                <Col xs={12}>
                                    <button className={"btn btn-danger btn-block"} onClick={()=> actions.deleteGuest(this.state.deleteGuestId)}>Delete</button>
                                </Col>
                            </div>
                        </div>
                    </Col>
                </Row>
            </Fragment>
        )
    }
}

export default GuestRecordingForm