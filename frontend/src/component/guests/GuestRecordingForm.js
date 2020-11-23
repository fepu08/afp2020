import React, {Fragment} from "react";
import {Row, Col} from "react-bootstrap";
import * as actions from '../../action/GuestActions';
import ErrorMessageWell from "../ErrorMessageWell";
class GuestRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            getGuestId: 0,
            deleteGuestId: 0,
            useSlideGuestId: 0
        };
        this.formOnChange = this.formOnChange.bind(this);
        actions.fetchGuest();
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render(){
        return(
            <Fragment>
                <Row className={"w-100"}>
                    {/* List all Guests */}
                    <Col xs={"12"} md={"6"} className={"my-2"}>
                        <button className="btn btn-primary btn-lg btn-block" onClick={()=> actions.fetchGuest()}>List all Guests</button>
                    </Col>
                    {/* Create new Guest */}
                    <Col xs={"12"} md={"6"} className={"my-2"}>
                        <button className="btn btn-success btn-lg btn-block" onClick={()=> actions.checkInGuest()}>Create New Guest</button>
                    </Col>
                </Row>

                <Row className={"w-100"}>
                    <Col xs={"12"} md={"6"} className={"my-2"}>
                        <div className={"card"}>
                            <div className={"card-header bg-primary text-light"}>
                                Search Guest by ID
                            </div>
                            <div className={"card-body"}>
                                <Col xs={12} className={"form-group"}>
                                    <label htmlFor={"getGuestId"} >Guest ID</label>
                                    <input className={"form-control"} type={"number"} id={"getGuestId"} name={"getGuestId"} value={this.state.getGuestId} onChange={this.formOnChange}/>
                                </Col>
                                <Col xs={12}>
                                    <button className={"btn btn-primary btn-block"} onClick={()=> actions.getGuestById(this.state.getGuestId)}>Submit</button>
                                </Col>
                            </div>
                        </div>
                    </Col>
                    <Col xs={"12"} md={"6"} className={"my-2"}>
                        <div className={"card"}>
                            <div className={"card-header bg-danger text-light"}>
                                Delete Guest by ID
                            </div>
                            <div className={"card-body"}>
                                <Col xs={"12"} className={"form-group"}>
                                    <label htmlFor={"deleteGuestId"} >Guest ID</label>
                                    <input className={"form-control"} type={"number"} id={"deleteGuestId"} name={"deleteGuestId"} value={this.state.deleteGuestId} onChange={this.formOnChange}/>
                                </Col>
                                <Col xs={"12"}>
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