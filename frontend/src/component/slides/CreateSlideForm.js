import React from "react";
import * as actions from '../../action/SlideActions';
import {Col} from "react-bootstrap";

class CreateSlideForm extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
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
                    <div className={"card-header bg-success text-light"}>
                        Create Slide
                    </div>
                    <div className={"card-body"}>
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
                        <button className={"btn btn-success btn-lg btn-block"}
                                onClick={() => actions.addSlide(this.state)}>Add Slide
                        </button>
                    </div>
                </div>
            </Col>
        );
    }
}

export default CreateSlideForm;