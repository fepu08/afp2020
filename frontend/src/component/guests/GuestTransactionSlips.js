import React, {Fragment} from 'react';
import SlideListItemForGuestTransaction from "../slides/SlideListItemForGuestTransaction";

function GuestTransactionSlips({slips}){
    return (
        <ul >
            {slips.map(({id, guestId, slide, timestamp}, index) => {
                return(
                    <Fragment key={index}>
                        <li key={id}>ID: {id}</li>
                        <li key={guestId}>Guest ID: {guestId}</li>
                        <li key={guestId + "+" + guestId}>Slide: <SlideListItemForGuestTransaction slide={"slide"}/></li>
                        <li key={timestamp}>Timestamp: {timestamp}</li>
                    </Fragment>
                );
            })}
        </ul>
    );
}

export default GuestTransactionSlips;
