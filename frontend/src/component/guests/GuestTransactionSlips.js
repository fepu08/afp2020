import React, {Fragment} from 'react';
import SlideListItemForGuestTransaction from "../slides/SlideListItemForGuestTransaction";

function GuestTransactionSlips({slips}){
    return (
        <ul >
            {slips.map(({id, guestId, slide, timestamp}, index) => {
                return(
                    <Fragment key={index}>
                        {console.log(index)}
                        <hr/>
                        <li key={id}>ID: {id}</li>
                        <li key={guestId}>Guest ID: {guestId}</li>
                        <li key={guestId + "+" + guestId}>Slide:
                            <SlideListItemForGuestTransaction id={slide.id} price={slide.price} slideName={slide.slideName}/>
                        </li>
                        <li key={timestamp}>Timestamp: {timestamp}</li>
                        {(index === (slips.length -1 ))&& <hr/>}
                    </Fragment>
                );
            })}
        </ul>
    );
}

export default GuestTransactionSlips;
