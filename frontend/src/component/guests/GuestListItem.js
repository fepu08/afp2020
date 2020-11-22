import React from 'react';
import {Col} from "react-bootstrap";
import GuestTransactionSlips from "./GuestTransactionSlips";
import GuestUseSlide from "./GuestUseSlide";

function GuestListItem({id, arrivalDateTime, transactions, watch }){
    return (
        <Col xs={"12"} className={"my-3"}>
            <div className={"card"}>
                <div className={"card-body"}>
                    <ul >
                        <li >ID: {id}</li>
                        <li >Arrival: {arrivalDateTime}</li>
                        <li >
                            Transactions:
                            <ul>
                                <li>ID: {transactions.id}</li>
                                <li>Slips:
                                    <GuestTransactionSlips slips={transactions.slips}/>
                                </li>
                            </ul>
                        </li>
                        <li >Watch ID: {watch.watchID}</li>
                    </ul>
                    <hr/>
                    <GuestUseSlide watchId={watch.watchID}/>
                </div>
            </div>
        </Col>
    );
}

export default GuestListItem;
