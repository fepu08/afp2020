import React from "react";
import * as actions from '../../action/GuestActions';
import { Row, Col } from 'react-bootstrap';
import ErrorMessageWell from "../ErrorMessageWell";

class GuestUseSlide extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            slideId: 0,
            watchId: this.props.watchId,
            buttonPushed: false
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
        this.setState({buttonPushed: false})
    }
    render() {
        return (
            <Row className={"form-group px-2"}>
                {
                    (this.state.slideId !== 0 && this.state.buttonPushed) &&
                    <Col xs={"12"} className={"mb-3"}>
                        {/* azért így kell, hogy ne jelenjen meg minden vendégnél a listában a hiba*/}
                        <ErrorMessageWell/>
                    </Col>
                }


                <Col sm={4} lg={"2"}>
                    <label htmlFor={"slideId"} className={"col-form-label"}>Slide ID</label>
                </Col>
                <Col sm={8} lg={"10"}>
                    <input type="number" name="slideId" className={"form-control"} placeholder={"Insert Slide ID"} id={"slideId"} onChange={this.formOnChange}/>
                </Col>
                <button className={"btn btn-info btn-block mt-3"} onClick={() => {
                    actions.useSlide(this.state);
                    this.setState({buttonPushed: true});
                }}><strong>Slide!</strong></button>
            </Row>
        );
    }
}

export default GuestUseSlide;