import React from 'react';

function SlideListItemForGuestTransaction({id, price, slideName}){
    return (
        <ul>
            <li >ID: {id}</li>
            <li >Price: {price}</li>
            <li >Slide name: {slideName}</li>
        </ul>
    );
}

export default SlideListItemForGuestTransaction;
