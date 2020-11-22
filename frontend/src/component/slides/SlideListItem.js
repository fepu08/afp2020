import React from 'react';
import {Col} from "react-bootstrap";

function SlideListItem({id, price, slideName}){
    //TODO: GuestListItem: kiíratni a transactionokat
    return (
        <Col xs={12} md={"6"} lg={4} className={"my-3"}>
            <ul className={"list-group"}>
                <li className="list-group-item">ID: {id}</li>
                <li className="list-group-item">Price: {price}</li>
                <li className="list-group-item">Slide name: {slideName}</li>
            </ul>
        </Col>
    );
}

export default SlideListItem;
