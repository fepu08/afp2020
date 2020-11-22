import React, {Fragment} from 'react';

function Slips({slips}){
    return (
        <ul >
            {slips.map(({id, guestId, slide, timestamp}, index) => {
                return(
                    <Fragment key={index}>
                        <li key={id}>ID: {id}</li>
                        <li key={guestId}>Guest ID: {guestId}</li>
                        <li key={guestId + "+" + guestId}>Slide:</li>
                        <li key={timestamp}>Timestamp: {timestamp}</li>
                        <li key={slide}>Slide:</li>
                    </Fragment>
                );
            })}
        </ul>
    );
}

export default Slips;
