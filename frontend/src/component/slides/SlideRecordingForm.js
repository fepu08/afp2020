import React, {Fragment} from "react";
import * as actions from '../../action/SlideActions';
import ErrorMessageWell from "../ErrorMessageWell";
import CreateSlideForm from "./CreateSlideForm";
import {Row, Col} from "react-bootstrap";

class SldieRecordingForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {};
        this.formOnChange = this.formOnChange.bind(this);
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
                    <Col xs="col-12" className="my-2">
                        <button className="btn btn-primary btn-lg btn-block" onClick={()=> actions.fetchSlide()}>List all Slides</button>
                    </Col>

                    <CreateSlideForm/>
                </Row>
            </Fragment>
        );
    }
}

export default SldieRecordingForm
