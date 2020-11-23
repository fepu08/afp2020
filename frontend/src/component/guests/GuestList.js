import React from 'react';
import {default as store} from '../../store/GuestStore';
import GuestListItem from "./GuestListItem";
import {Row, Col} from "react-bootstrap";

class GuestList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {guests : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({guests : store._guests});
    }

    render() {
        if(this.state.guests.length === 0){
            return(
                <Row className={"w-100"}>
                    <Col xs={"12"}>
                        <div className={"alert alert-warning"}>
                            No Guests in the list
                        </div>
                    </Col>
                </Row>
            );
        } else {
            return(
                <Row className={"w-100"}>
                    {this.state.guests.map(({arrivalDateTime, id, transactions, watch}, index)=>{
                        return(
                            <GuestListItem
                                key={index}
                                arrivalDateTime={arrivalDateTime}
                                id={id}
                                transactions={transactions}
                                watch={watch}
                            />
                        );
                    })}
                </Row>
            );
        }

    }

}

export default GuestList;
