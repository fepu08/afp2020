import React, {Fragment} from "react";
import * as actions from '../../action/SlideActions';
import ErrorMessageWell from "../ErrorMessageWell";
import CreateSlideForm from "./CreateSlideForm";
import {Row, Col} from "react-bootstrap";
import {fetchSlide} from "../../action/SlideActions";

class SldieRecordingForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            getGuestId: 0,
            deleteSlideId: 0
        };
        this.formOnChange = this.formOnChange.bind(this);
        actions.fetchSlide();
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <Fragment>
                <ErrorMessageWell/>
                <Row className="w-100 my-2">
                    <Col xs="12" className="my-2">
                        <button className="btn btn-primary btn-lg btn-block" onClick={()=> actions.fetchSlide()}>List all Slides</button>
                    </Col>

                    <Col xs={"12"} lg={"6"}>
                        <div className={"card"}>
                            <div className={"card-header bg-primary text-light"}>
                                Search Slide by ID
                            </div>
                            <div className={"card-body"}>
                                <div className={"form-group d-inline-block w-75 pr-2"}>
                                    <label htmlFor={"getGuestId"} >Slide ID</label>
                                    <input className={"form-control"} type={"number"} id={"getGuestId"} name={"getGuestId"} value={this.state.getGuestId} onChange={this.formOnChange}/>
                                </div>
                                <button className={"btn btn-primary w-25"} onClick={()=> actions.getSlideById(this.state.getGuestId)}>Submit</button>
                            </div>
                        </div>
                    </Col>

                    <Col lg={"6"}>
                        <div className={"card"}>
                            <div className={"card-header bg-danger text-light"}>
                                Delete Slide by ID
                            </div>
                            <div className={"card-body"}>
                                <div className={"form-group d-inline-block w-75 pr-2"}>
                                    <label htmlFor={"deleteSlideId"} >Slide ID</label>
                                    <input className={"form-control"} type={"number"} id={"deleteSlideId"} name={"deleteSlideId"} value={this.state.deleteSlideId} onChange={this.formOnChange}/>
                                </div>
                                <button className={"btn btn-danger w-25"} onClick={()=> actions.deleteSlideById(this.state.deleteSlideId)}>Delete</button>
                            </div>
                        </div>
                    </Col>

                    <CreateSlideForm/>


                </Row>
            </Fragment>
        );
    }
}

export default SldieRecordingForm
