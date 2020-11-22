import React from 'react';
import {Col} from "react-bootstrap";

function GuestListItem({id, arrivalDateTime, transactions, watch }){
    //TODO: GuestListItem: kiíratni a transactionokat
    return (
        <Col xs={12} className={"card my-3"}>
            <div className={"card-body"}>
                <ul >
                    <li >ID: {id}</li>
                    <li >Arrival: {arrivalDateTime}</li>
                    <li >
                        Transactions:
                        <ul>
                            <li>ID: {transactions.id}</li>
                            <li>Slips:
                            </li>
                        </ul>
                    </li>
                    <li >Watch ID: {watch.watchID}</li>
                </ul>
                <hr/>
            </div>
        </Col>
    );
}

export default GuestListItem;
