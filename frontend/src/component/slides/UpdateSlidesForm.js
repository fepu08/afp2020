import React from "react";
import * as actions from '../../action/SlideActions';
import {Col} from "react-bootstrap";
import ErrorMessageWell from "../ErrorMessageWell";

class UpdateSlidesForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            price: 0,
            slideName: ''
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }
    render() {
        return (
            <Col xs={"12"} className={"my-3"}>
                <div className={"card"}>
                    <div className={"card-header bg-warning text-light"}>
                        Update Slide
                    </div>

                    <Col>
                        <ErrorMessageWell/>
                    </Col>

                    <div className={"card-body"}>
                        <div className={"form-group"}>
                            <label htmlFor={"id"}>ID</label>
                            <input className={"form-control"} type={"number"} id={"id"} name={"id"}
                                   value={this.state.id} onChange={this.formOnChange}/>
                        </div>
                        <div className={"form-group"}>
                            <label htmlFor={"price"}>Price</label>
                            <input className={"form-control"} type={"number"} id={"price"} name={"price"}
                                   value={this.state.price} onChange={this.formOnChange}/>
                        </div>
                        <div className={"form-group"}>
                            <label htmlFor={"slideName"}>Name</label>
                            <input className={"form-control"} type={"text"} placeholder={"Write slide name here"}
                                   id={"slideName"} name={"slideName"} value={this.state.slideName}
                                   onChange={this.formOnChange}/>
                        </div>
                        <button className={"btn btn-warning btn-lg btn-block text-light"}
                                onClick={() => actions.updateSlide(this.state)}>Update Slide
                        </button>
                    </div>
                </div>
            </Col>
        );
    }
}

export default UpdateSlidesForm;